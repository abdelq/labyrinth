import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class JPanelLaby extends JPanel implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
        case KeyEvent.VK_UP:
            Labyrinthe.deplace('H');
            break;
        case KeyEvent.VK_A:
        case KeyEvent.VK_LEFT:
            Labyrinthe.deplace('G');
            break;
        case KeyEvent.VK_S:
        case KeyEvent.VK_DOWN:
            Labyrinthe.deplace('B');
            break;
        case KeyEvent.VK_D:
        case KeyEvent.VK_RIGHT:
            Labyrinthe.deplace('D');
            break;
        }
    }
}
