package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Muret {
    private final int x, y;
    private final boolean isHorizontal;
    private boolean isVisible;

    Muret(int x, int y, boolean isHorizontal, boolean isVisible) {
        this.x = x;
        this.y = y;
        this.isHorizontal = isHorizontal;
        this.isVisible = isVisible;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Muret m = (Muret) obj;
        return x == m.x && y == m.y && isHorizontal == m.isHorizontal;
    }

    void show() {
        isVisible = true;
    }

    void hide() {
        isVisible = false;
    }

    boolean isVisible() {
        return isVisible;
    }
}
