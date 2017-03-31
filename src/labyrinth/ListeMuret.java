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
            temp.data.show();
            temp = temp.suivant;
        }
    }

    void hideAll() {
        NoeudMuret temp = first;

        while (temp != null) {
            temp.data.hide();
            temp = temp.suivant;
        }
    }

    Muret chercheMuret(Muret m) {
        NoeudMuret temp = first;

        while (temp != null) {
            if (temp.data.equals(m)) {
                return temp.data;
            }

            temp = temp.suivant;
        }

        return null;
    }
}
