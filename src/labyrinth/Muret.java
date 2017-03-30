package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Muret {
    private int x, y;
    private boolean isHorizontal, isVisible;

    protected Muret(int x, int y, boolean isHorizontal, boolean isVisible) {
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

    public void show() {
        isVisible = true;
    }

    public void hide() {
        isVisible = false;
    }
}
