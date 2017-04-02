package labyrinth;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Personnage {
    private float x, y;
    private int hp;
    private final BufferedImage avatar;

    Personnage(float x, float y, int hp) throws IOException {
        this.x = x;
        this.y = y;
        this.hp = hp;

        int avatarID = new Random().nextInt(3) + 1;
        avatar = ImageIO.read(new File("src/labyrinth/assets/player_0" + avatarID + ".png"));
    }

    void dessine(Graphics g, int x, int y, int width, int height) {
        g.drawImage(avatar, x, y, width, height, null);
    }

    float getX() {
        return x;
    }

    void setX(float x) {
        this.x = x;
    }

    float getY() {
        return y;
    }

    void setY(float y) {
        this.y = y;
    }

    int getHP() {
        return hp;
    }

    void setHP(int hp) {
        // TODO Check if dead
        this.hp = hp;
    }
}
