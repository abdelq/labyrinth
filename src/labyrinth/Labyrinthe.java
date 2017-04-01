package labyrinth;

import java.util.Random;
import java.util.StringJoiner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Labyrinthe {
    public static int width, height;
    public static Personnage player;
    public static ListeMuret walls;
    public static int exitPos;
    public static int visDuration;

    Labyrinthe(int height, int width, double density, int visDuration, int healthPoints) {
        Labyrinthe.width = width;
        Labyrinthe.height = height;
        Labyrinthe.visDuration = visDuration;

        Random rand = new Random();

        // Personnage
        player = new Personnage(0.5, rand.nextInt(height) + 0.5, healthPoints);

        // Murets
        walls = new ListeMuret();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (rand.nextDouble() < density) {
                    walls.addFirst(new Muret(i, j, rand.nextBoolean(), true));
                }
            }
        }

        // Sortie
        exitPos = rand.nextInt(height);
    }
    
    /*public void hideWalls() {
    }*/

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));

        sj.add("+" + new String(new char[width]).replace("\0", "--") + "+");

        for (double i = 0; i < height; i += .5) {
            StringBuilder sb = new StringBuilder();

            sb.append("|");

            for (double j = 0; j < width; j += .5) {
                // TODO Optimize
                Muret horizontal = walls.chercheMuret(new Muret((int) j, (int) i, true, true));
                Muret vertical = walls.chercheMuret(new Muret((int) j, (int) i, false, true));

                if (player.getY() == i && player.getX() == j) {
                    sb.append("@");
                } else if (i % 1 == 0 && horizontal != null && horizontal.isVisible()) {
                    sb.append("-");
                } else if (j % 1 == 0 && vertical != null && vertical.isVisible()) {
                    sb.append("|");
                } else {
                    sb.append(" ");
                }
            }

            if ((int) i != exitPos) {
                sb.append("|");
            }

            sj.add(sb);
        }

        sj.add("+" + new String(new char[width]).replace("\0", "--") + "+"); // TODO DRY

        return sj.toString();
    }

    public static boolean deplace(char direction) {
        double newX = player.getX();
        double newY = player.getY();
        Muret wall = null;

        switch (direction) {
            case 'H':
                newY -= 1;
                wall = walls.chercheMuret(new Muret((int)newX, (int)(newY + .5), true, true));
                break;
            case 'G':
                newX -= 1;
                wall = walls.chercheMuret(new Muret((int)(newX + .5), (int)newY, false, true));
                break;
            case 'B':
                newY += 1;
                wall = walls.chercheMuret(new Muret((int)newX, (int)newY, true, true));
                break;
            case 'D':
                newX += 1;
                wall = walls.chercheMuret(new Muret((int)newX, (int)newY, false, true));
                break;
        }
        
        // Mur d'enceinte
        if (newX < 0 || newX > Labyrinthe.width ||
            newY < 0 || newY > Labyrinthe.height) {
            return false;
        }
        
        if (wall != null) {
            wall.show(); // TODO Repaint?
            player.setHP(player.getHP() - 1);
            return false;
        }
        
        player.setX(newX);
        player.setY(newY);
        return true;
    }
}
