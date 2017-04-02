package labyrinth;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        healthLabel = new JLabel("Vies restantes : " + Labyrinthe.player.getHP());
        
        JButton showWalls = new JButton("Afficher les murets");
        showWalls.addActionListener((ActionEvent e) -> {
            Labyrinthe.walls.showAll();
            afficheur.repaint();
            mainPanel.requestFocusInWindow();
        });

        JButton hideWalls = new JButton("Cacher les murets");
        hideWalls.addActionListener((ActionEvent e) -> {
            Labyrinthe.walls.hideAll();
            afficheur.repaint();
            mainPanel.requestFocusInWindow();
        });

        rightPanel.add(healthLabel);
        rightPanel.add(showWalls);
        rightPanel.add(hideWalls);
        rightPanel.add(new JButton("Recommencer une partie"));
        rightPanel.add(new JButton("Intelligence artificielle"));

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
                    mainPanel.setFocusable(true);
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
