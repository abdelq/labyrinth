package labyrinth;

import java.awt.BasicStroke;
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
        // TODO Refactor
        int width = this.getWidth() * 75/100;
        int height = this.getHeight() * 75/100;

        int wallWidth = width / Labyrinthe.width;
        int wallHeight = height / Labyrinthe.height;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        
        g.drawLine(0, 0, width, 0);
        
        for (double i = 0; i < Labyrinthe.height; i += .5) {
            for (double j = 0; j < Labyrinthe.width; j += .5) {
                Muret horizontal = i % 1 == 0 ? walls.chercheMuret(new Muret((int) j, (int) i, true, true)) : null;
                Muret vertical = j % 1 == 0 ? walls.chercheMuret(new Muret((int) j, (int) i, false, true)) : null;
                
                if (player.getY() == i && player.getX() == j) {
                    g.drawOval((int)j * wallWidth, (int)i * wallHeight, wallWidth, wallHeight);
                } else if (horizontal != null && horizontal.isVisible()) {
                    g.drawLine((int)j * wallWidth, (int)i * wallHeight, (int)j * wallWidth + wallWidth, (int)i * wallHeight);
                } else if (vertical != null && vertical.isVisible()) {
                    g.drawLine((int)j * wallWidth, (int)i * wallHeight, (int)j * wallWidth, (int)i * wallHeight + wallHeight);
                }
            }
        }
        
        g.drawLine(0, height, width, height);
    }
}
