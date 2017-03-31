package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class NoeudMuret {
    Muret data;
    NoeudMuret suivant;

    NoeudMuret(Muret data, NoeudMuret suivant) {
        this.data = data;
        this.suivant = suivant;
    }
}
