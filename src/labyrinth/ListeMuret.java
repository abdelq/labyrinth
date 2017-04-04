package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class ListeMuret {

    private NoeudMuret first;

    void addFirst(Muret wall) {
        first = new NoeudMuret(wall, first);
    }

    void showAll() {
        NoeudMuret temp = first;

        while (temp != null) {
            temp.getData().show();
            temp = temp.getSuivant();
        }
    }

    void hideAll() {
        NoeudMuret temp = first;

        while (temp != null) {
            temp.getData().hide();
            temp = temp.getSuivant();
        }
    }

    Muret chercheMuret(Muret m) {
        NoeudMuret temp = first;

        while (temp != null) {
            if (temp.getData().equals(m)) {
                return temp.getData();
            }

            temp = temp.getSuivant();
        }

        return null;
    }
}
