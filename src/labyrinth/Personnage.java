package labyrinth;

import java.awt.Graphics;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Personnage {
    private double x, y;
    private int hp;

    Personnage(double x, double y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public void dessine(Graphics g, int x1, int y1, int x2, int y2) {
        // TODO
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
