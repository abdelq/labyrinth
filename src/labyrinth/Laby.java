package labyrinth;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Laby {
    static JPanelLaby mainPanel;
    static JPanel rightPanel;
    static AfficheurLaby afficheur;
    static JLabel healthLabel;

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Labyrinthe invisible graphique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanelLaby();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.addKeyListener(mainPanel);

        // Labyrinthe
        afficheur = new AfficheurLaby();
        mainPanel.add(afficheur, BorderLayout.CENTER);

        // Panneau droit
        rightPanel = new JPanel();
        healthLabel = new JLabel("Vies restantes : " + Labyrinthe.player.getHP());
        rightPanel.add(healthLabel);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        frame.setContentPane(mainPanel);
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

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Labyrinthe.walls.hideAll();
                    afficheur.repaint();
                    mainPanel.requestFocusInWindow();
                }
            }, Labyrinthe.visDuration);
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
