package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class NoeudMuret {

    private Muret data;
    private NoeudMuret suivant;

    NoeudMuret(Muret data, NoeudMuret suivant) {
        this.data = data;
        this.suivant = suivant;
    }

    Muret getData() {
        return data;
    }

    void setData(Muret data) {
        this.data = data;
    }

    NoeudMuret getSuivant() {
        return suivant;
    }

    void setSuivant(NoeudMuret suivant) {
        this.suivant = suivant;
    }
}
