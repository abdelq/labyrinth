package labyrinth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class JPanelLaby extends JPanel implements KeyListener {
    JPanelLaby() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                Labyrinthe.deplace('H');
                break;
            case KeyEvent.VK_A:
                Labyrinthe.deplace('G');
                break;
            case KeyEvent.VK_S:
                Labyrinthe.deplace('B');
                break;
            case KeyEvent.VK_D:
                Labyrinthe.deplace('D');
                break;
        }
    }
}
