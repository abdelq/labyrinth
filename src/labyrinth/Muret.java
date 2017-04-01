package labyrinth;

import java.awt.Graphics;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + x;
        hash = 79 * hash + y;
        hash = 79 * hash + (isHorizontal ? 1 : 0);
        return hash;
    }

    void show() {
        isVisible = true;
        // TODO Repaint
    }

    void hide() {
        isVisible = false;
    }
    
    void dessine(Graphics g, int x, int y, int width, int height) {
        // TODO
    }

    boolean getIsVisible() {
        return isVisible;
    }
}
