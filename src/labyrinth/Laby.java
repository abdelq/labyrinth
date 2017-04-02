package labyrinth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Laby {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Labyrinthe invisible graphique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanelLaby mainPanel = new JPanelLaby();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        // mainPanel.setFocusable(true);
        // mainPanel.addKeyListener(mainPanel);

        // Labyrinthe
        mainPanel.add(new AfficheurLaby(), BorderLayout.CENTER);

        // Panneau droit
        JPanel rightPanel = new JPanel();
        mainPanel.add(rightPanel, BorderLayout.EAST);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        try {
            Labyrinthe laby = new Labyrinthe(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Double.parseDouble(args[2]),
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4])
            );

            SwingUtilities.invokeLater(Laby::createAndShowGUI);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.err.println("Nombre de paramètres incorrects.");
            System.out.println("Utilisation: java Laby <hauteur> <largeur> <densite> <duree visible> <nb vies>");
            System.out.println("Ex: java Laby 10 20 0.20 5 5");

            System.exit(1);
        } catch (NumberFormatException e2) {
            System.err.println("Paramètre(s) incorrect(s).");
            System.out.println("Utilisation: java Laby <hauteur> <largeur> <densite> <duree visible> <nb vies>");
            System.out.println("Ex: java Laby 10 20 0.20 5 5");

            System.exit(1);
        }
    }
}
