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
    JPanelLaby(BorderLayout borderLayout) {
        // super(borderLayout);
        setBackground(new Color(255, 255, 255));
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Deplace selon key pesée
    }
}
