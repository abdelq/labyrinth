package labyrinth;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Labyrinthe {
    private final int width, height;
    private final Personnage player;
    private final ListeMuret walls;
    private final int exitPos;

    Labyrinthe(int height, int width, double density, int visibilityDuration, int healthPoints) {
        this.width = width;
        this.height = height;

        Random rand = new Random();

        // Personnage
        player = new Personnage(0.5, rand.nextInt(height) + 0.5, healthPoints);

        // Sortie
        exitPos = rand.nextInt(height);

        // Murets
        walls = new ListeMuret();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (rand.nextDouble() < density) {
                    walls.addFirst(new Muret(i, j, rand.nextBoolean(), true));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));

        sj.add("+" + new String(new char[width]).replace("\0", "--") + "+");

        for (double i = 0; i < height; i += .5) {
            StringBuilder sb = new StringBuilder();

            sb.append("|");

            for (double j = 0; j < width; j += .5) {
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

        sj.add("+" + new String(new char[width]).replace("\0", "--") + "+");

        return sj.toString();
    }
}
