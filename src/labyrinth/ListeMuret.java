package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class ListeMuret {
    public LinkedList<Muret> walls;

    public ListeMuret() {
        walls = new LinkedList<Muret>();
    }

    public void add(Muret wall) {
        walls.addFirst(wall);
    }

    public void show() {
        for (Muret wall : walls) {
            wall.show();
        }
    }

    public void hide() {
        for (Muret wall : walls) {
            wall.hide();
        }
    }

    public Muret chercheMuret(Muret m) {
        if (walls.contains(m)) {
            return walls.get(walls.indexOf(m));
        }
    }
}
