package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Labyrinthe {
    private int width, height;
    private Personnage player;
    private ListMuret walls;
    // TODO Position de la sortie

    public Labyrinthe(int width, int height, double density, int visibilityDuration) {
        // TODO Ce constructeur devra notamment créer une liste de murets au hazard et décider au hazard de la position du personnage et de la sortie.
    }

    @Override
    public String toString() {
        // TODO qui retournera une String représentant un affichage textuel du labyrinthe avec son personnage  (pour fins de debug, ainsi vous pourrez l'afficher sur la console/temrinal avec System.out.println. Rappel: "\n" est le caractère de retour à la ligne).
    }

    public boolean deplace(char direction) {
        // TODO essayer de déplacer le personnage dans la direction précisée ('D' pour droite, 'G' pour gauche, 'H' pour haut, 'B' pour bas). Cette méthode devra vérifier si il n'y a pas de muret (ou de mur d'enceinte) empêchant le déplacement. Si il y en a un, ce muret devra être rendu visible, et le personnage devra perdre une vie et ne bougera pas, la méthode devra alors retourner false. Si rien n'empêche le déplacement, mettre à jour les coordonnées du personnage et retourner true.
    }
}
