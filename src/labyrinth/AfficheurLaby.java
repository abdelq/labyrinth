package labyrinth;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class AfficheurLaby extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        /* for (double i = 0; i < height; i += .5) {
            for (double j = 0; j < width; j += .5) {
            }
        } */
        /*StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));

        sj.add("+" + new String(new char[width]).replace("\0", "--") + "+");

        for (double i = 0; i < height; i += .5) {
            StringBuilder sb = new StringBuilder();

            sb.append("|");

            for (double j = 0; j < width; j += .5) {
                Muret horizontal = walls.chercheMuret(new Muret((int) j, (int) i, true, true));
                Muret vertical = walls.chercheMuret(new Muret((int) j, (int) i, false, true));
                
                if (player.getY() == i && player.getX() == j) {
                    sb.append("@");
                } else if (i % 1 == 0 && horizontal != null && horizontal.isVisible()) {
                    sb.append("-");
                } else if (j % 1 == 0 && vertical != null && vertical.isVisible()) {
                    sb.append("|");
                } else {
                    sb.append(" ");
                }
            }

            if ((int) i != exitPos) {
                sb.append("|");
            }

            sj.add(sb);
        }

        sj.add("+" + new String(new char[width]).replace("\0", "--") + "+");

        return sj.toString();*/
        // g.drawLine(0, 0, 5, 5);
    }
}
