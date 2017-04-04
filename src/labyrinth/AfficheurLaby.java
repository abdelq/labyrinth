package labyrinth;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import static labyrinth.Labyrinthe.player;
import static labyrinth.Labyrinthe.walls;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class AfficheurLaby extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        int wallWidth = this.getWidth() / Labyrinthe.width;
        int wallHeight = this.getHeight() / Labyrinthe.height;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        // Personnage
        player.dessine(g, (int) player.getX() * wallWidth, (int) player.getY() * wallHeight, wallWidth, wallHeight);

        // Mur
        g.setColor(Color.RED);
        for (double i = 0; i < Labyrinthe.height; i += .5) {
            for (double j = 0; j < Labyrinthe.width; j += .5) {
                int posX = (int) j * wallWidth;
                int posY = (int) i * wallHeight;

                Muret horizontal = i % 1 == 0 ? walls.chercheMuret(new Muret((int) j, (int) i, true, true)) : null;
                Muret vertical = j % 1 == 0 ? walls.chercheMuret(new Muret((int) j, (int) i, false, true)) : null;

                if (horizontal != null && horizontal.getIsVisible()) {
                    horizontal.dessine(g, posX, posY, posX + wallWidth, posY);
                } else if (vertical != null && vertical.getIsVisible()) {
                    vertical.dessine(g, posX, posY, posX, posY + wallHeight);
                }
            }
        }

        // Sortie
        g.setColor(Color.GREEN);
        g.drawOval((Labyrinthe.width - 1) * wallWidth, Labyrinthe.exitPos * wallHeight, wallWidth, wallHeight);
    }
}
