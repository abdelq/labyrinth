package labyrinth;

import java.awt.Graphics;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Personnage {
    private double x, y;
    private int hp;

    protected Personnage(double x, double y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public void dessine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
