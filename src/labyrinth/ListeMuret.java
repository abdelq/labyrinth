package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class ListeMuret {
    private NoeudMuret first;

    public void addFirst(Muret wall) {
        first = new NoeudMuret(wall, first);
    }

    public void showAll() {
        NoeudMuret temp = first;

        while (temp != null) {
            temp.data.show();
            temp = temp.suivant;
        }
    }

    public void hideAll() {
        NoeudMuret temp = first;

        while (temp != null) {
            temp.data.hide();
            temp = temp.suivant;
        }
    }

    public Muret chercheMuret(Muret m) {
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
