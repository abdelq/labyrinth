package labyrinth;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Laby {
    private static int width, height;
    private static double density;
    private static int visibilityDuration;
    private static int healthPoints;

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Labyrinthe invisible graphique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanelLaby(new BorderLayout());
        panel.add(new AfficheurLaby(), BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("Nombre de paramètres incorrects.");
            System.out.println("Utilisation: java Laby <hauteur> <largeur> <densite> <duree visible> <nb vies>");
            System.out.println("Ex: java Laby 10 20 0.20 10 5");

            return;
        }

        height             = Integer.parseInt(args[0]);
        width              = Integer.parseInt(args[1]);
        density            = Double.parseDouble(args[2]);
        visibilityDuration = Integer.parseInt(args[3]);
        healthPoints       = Integer.parseInt(args[4]);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
