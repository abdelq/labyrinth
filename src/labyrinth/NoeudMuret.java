package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class NoeudMuret {
    private Muret data;
    private NoeudMuret suivant;

    public NoeudMuret(Muret data, NoeudMuret suivant) {
        this.data = data;
        this.suivant = suivant;
    }
}
