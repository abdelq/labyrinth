package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class Laby {
    private static int width, height;
    private static double density;
    private static int visibilityDuration;
    private static int healthPoints;

    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("Nombre de paramètres incorrects.");
            System.out.println("Utilisation: java Laby <hauteur> <largeur> <densite> <duree visible> <nb vies>");
            System.out.println("Ex: java Laby 10 20 0.20 10 5");

            return;
        }

        // TODO Exception handling for parameters
        height             = Integer.parseInt(args[0]);
        width              = Integer.parseInt(args[1]);
        density            = Double.parseDouble(args[2]);
        visibilityDuration = Integer.parseInt(args[3]);
        healthPoints       = Integer.parseInt(args[4]);
    }
}
