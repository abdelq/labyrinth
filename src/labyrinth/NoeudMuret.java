package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */

public class NoeudMuret{
    private Muret muret;
    private NoeudMuret suivant;

    protected NoeudMuret(Muret m, NoeudMuret nm){
        this.muret = m;
        this.suivant = nm;
    }
 }