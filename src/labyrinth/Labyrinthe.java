package labyrinth;

import java.io.IOException;
import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Labyrinthe {
    static int width, height, visDuration, exitPos;
    static Personnage player;
    static ListeMuret walls;

    Labyrinthe(int height, int width, double density, int visDuration, int healthPoints) throws IOException {
        Labyrinthe.width = width;
        Labyrinthe.height = height;
        Labyrinthe.visDuration = visDuration * 1000;

        Random rand = new Random();

        // Personnage
        player = new Personnage(0.5f, rand.nextInt(height) + 0.5f, healthPoints);

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

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));

        String horizontalBorder = "+" + new String(new char[width]).replace("\0", "--") + "+";

        sj.add(horizontalBorder);

        for (double i = 0; i < height; i += .5) {
            StringBuilder sb = new StringBuilder();

            sb.append("|");

            for (double j = 0; j < width; j += .5) {
                Muret horizontal = i % 1 == 0 ? walls.chercheMuret(new Muret((int)j, (int)i, true, true)) : null;
                Muret vertical = j % 1 == 0 ? walls.chercheMuret(new Muret((int)j, (int)i, false, true)) : null;

                if (horizontal != null && horizontal.getIsVisible()) {
                    sb.append("-");
                } else if (vertical != null && vertical.getIsVisible()) {
                    sb.append("|");
                } else if (player.getY() == i && player.getX() == j) {
                    sb.append("@");
                } else {
                    sb.append(" ");
                }
            }

            if ((int)i != exitPos) {
                sb.append("|");
            }

            sj.add(sb);
        }

        sj.add(horizontalBorder);

        return sj.toString();
    }

    static boolean deplace(char direction) {
        float posX = player.getX();
        float posY = player.getY();
        Muret wall = null;

        switch (direction) {
        case 'H':
            wall = walls.chercheMuret(new Muret((int)posX, (int)posY, true, true));
            posY -= 1;
            break;
        case 'G':
            wall = walls.chercheMuret(new Muret((int)posX, (int)posY, false, true));
            posX -= 1;
            break;
        case 'B':
            wall = walls.chercheMuret(new Muret((int)posX, (int)(posY + .5), true, true));
            posY += 1;
            break;
        case 'D':
            wall = walls.chercheMuret(new Muret((int)(posX + .5), (int)posY, false, true));
            posX += 1;
            break;
        }

        // Mur d'enceinte
        if (posX < 0 || posX > Labyrinthe.width ||
                posY < 0 || posY > Labyrinthe.height) {
            return false;
        }

        // Muret
        if (wall != null) {
            wall.show();
            Laby.afficheur.repaint();
            
            player.setHP(player.getHP() - 1);
            
            return false;
        }

        player.setX(posX);
        player.setY(posY);
        Laby.afficheur.repaint();

        return true;
    }
}
