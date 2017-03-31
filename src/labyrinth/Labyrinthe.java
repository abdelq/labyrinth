package labyrinth;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Labyrinthe {
    public static int width, height;
    public static Personnage player;
    public static ListeMuret walls;
    public static int exitPos;

    Labyrinthe(int height, int width, double density, int visibilityDuration, int healthPoints) {
        Labyrinthe.width = width;
        Labyrinthe.height = height;

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
        // Labyrinthe kek = this;
        // System.out.println(new Labyrinthe(this));
        System.out.println(direction);
        return true;
        // TODO pour essayer de déplacer le personnage dans la direction précisée ('D' pour droite, 'G' pour gauche, 'H' pour haut, 'B' pour bas). Cette méthode devra vérifier si il n'y a pas de muret (ou de mur d'enceinte) empêchant le déplacement. Si il y en a un, ce muret devra être rendu visible, et le personnage devra perdre une vie et ne bougera pas, la méthode devra alors retourner false. Si rien n'empêche le déplacement, mettre à jour les coordonnées du personnage et retourner true.
    }
}
