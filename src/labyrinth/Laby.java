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
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Labyrinthe invisible graphique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanelLaby();
        panel.add(new AfficheurLaby(), BorderLayout.CENTER);
        panel.add(new JPanel(), BorderLayout.EAST); // TODO
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            Labyrinthe laby = new Labyrinthe(
                    Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]),
                    Double.parseDouble(args[2]),
                    Integer.parseInt(args[3]),
                    Integer.parseInt(args[4])
            );
            
            SwingUtilities.invokeLater(Laby::createAndShowGUI);
            System.out.println(laby);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.err.println("Nombre de paramètres incorrects.");
            System.out.println("Utilisation: java Laby <hauteur> <largeur> <densite> <duree visible> <nb vies>");
            System.out.println("Ex: java Laby 10 20 0.20 10 5");

            System.exit(1);
        } catch (NumberFormatException e2) {
            System.err.println("Paramètre(s) incorrect(s).");
            System.out.println("Utilisation: java Laby <hauteur> <largeur> <densite> <duree visible> <nb vies>");
            System.out.println("Ex: java Laby 10 20 0.20 10 5");

            System.exit(1);
        }
    }
}
