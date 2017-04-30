package labyrinth;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Laby {

    static JFrame frame;
    static JPanelLaby mainPanel;
    static JPanel rightPanel;
    static AfficheurLaby afficheur;
    static JLabel healthLabel;

    private static void createAndShowGUI() {
        frame = new JFrame("Labyrinthe invisible graphique");
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

        JButton restart = new JButton("Recommencer une partie");
        restart.addActionListener((ActionEvent e) -> {
            restartGame();
        });

        JButton ai = new JButton("Intelligence artificielle");
        ai.addActionListener((ActionEvent e) -> {
            mainPanel.setFocusable(false);

            int i = 1;
            for (Character direction : AI.findPath()) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Labyrinthe.deplace(direction);
                    }
                }, i * 500);

                i++;
            }
        });

        rightPanel.add(healthLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        rightPanel.add(showWalls);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(hideWalls);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(restart);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(ai);

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
            }, Labyrinthe.visDuration * 1000);
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

    static void restartGame() {
        Labyrinthe laby = new Labyrinthe(
            Labyrinthe.height,
            Labyrinthe.width,
            Labyrinthe.density,
            Labyrinthe.visDuration,
            Labyrinthe.healthPoints
        );

        healthLabel.setText("Vies restantes : " + Labyrinthe.healthPoints);

        mainPanel.setFocusable(false);
        afficheur.repaint();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Labyrinthe.walls.hideAll();
                afficheur.repaint();

                mainPanel.setFocusable(true);
                mainPanel.requestFocusInWindow();
            }
        }, Labyrinthe.visDuration * 1000);
    }

    static void endGame() {
        String[] options = {"Oui", "Non"};

        int answer = JOptionPane.showOptionDialog(frame, "Voulez-vous jouer une nouvelle partie ?",
                     "Rejouer une partie",
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     options,
                     options[0]);

        if (answer == 0) {
            restartGame();
        } else if (answer == 1) {
            System.exit(0);
        }
    }
}
