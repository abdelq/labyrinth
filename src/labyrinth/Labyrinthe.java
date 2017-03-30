package labyrinth;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Labyrinthe {
    private final int width, height;
    private Personnage player;
    private ListeMuret walls;
    // TODO Position de la sortie

    public Labyrinthe(int height, int width, double density, int visibilityDuration, int healthPoints) {
        this.width = width;
        this.height = height;

        Random rand = new Random();

        walls = new ListeMuret();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (rand.nextDouble() < density) {
                    walls.addFirst(new Muret(i, j, rand.nextBoolean(), true));
                }
            }
        }

        player = new Personnage(healthPoints);

        do {
            player.x = rand.nextInt(width) + 0.5;
            player.y = rand.nextInt(height) + 0.5;
        } while (player.x > width || player.y > height);

        // TODO Position sortie aléatoire

        // System.out.println("width: " + width);
        // System.out.println("height: " + height);
        // System.out.println("walls: " + walls);
        // System.out.println("player: " + player.x + "x" + player.y);
    }

    @Override
    public String toString() {
        // TODO À améliorer
        StringJoiner sj = new StringJoiner("\n");

        sj.add("+" + new String(new char[width]).replace("\0", "-") + "+");

        for (int i = 0; i < height; i++) {
            StringJoiner sj2 = new StringJoiner("", "|", "|");

            for (int j = 0; j < width; j++) {
                if (walls.chercheMuret(new Muret(j, i, true, true)) != null) {
                    sj2.add("-");
                } else if (walls.chercheMuret(new Muret(j, i, false, true)) != null) {
                    sj2.add("|");
                } else {
                    sj2.add(" ");
                }
            }

            sj.add(sj2.toString());
            // sj.add("|" + new String(new char[width]).replace("\0", "   ") + "|");
            // sj.add("|" + new String(new char[width]).replace("\0", "   ") + "|");
            // sj.add("|" + new String(new char[width]).replace("\0", "   ") + "|");
        }

        /* for (Muret m : walls) {
            System.out.println(m);
        } */
        
        // TODO Personnage

        sj.add("+" + new String(new char[width]).replace("\0", "-") + "+");

        return sj.toString();
    }

    /* public boolean deplace(char direction) {
    // TODO essayer de déplacer le personnage dans la direction précisée ('D' pour droite, 'G' pour gauche, 'H' pour haut, 'B' pour bas). Cette méthode devra vérifier si il n'y a pas de muret (ou de mur d'enceinte) empêchant le déplacement. Si il y en a un, ce muret devra être rendu visible, et le personnage devra perdre une vie et ne bougera pas, la méthode devra alors retourner false. Si rien n'empêche le déplacement, mettre à jour les coordonnées du personnage et retourner true.
    } */
}
