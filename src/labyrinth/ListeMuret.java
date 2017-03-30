package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */

 public class ListeMuret{

    public NoeudMuret premierMuret;

    //methodes de traitages

    protected ListeMuret(){
        this.premierMuret = null;
    }

    protected ListeMuret(NoeudMuret m){
        muret = new NoeudMuret(m, premierMuret);
        this.premierMuret = muret;
    }

    public void setVisible() {
        tempNode = new NoeudMuret(premierMuret.muret, premierMuret);
        while (tempNode != null) {
            tempNode.muret.show();
            tempNode = tempNode.suivant;
        }
    }

    public void setInvisible() {
        tempNode = new NoeudMuret(premierMuret.muret, premierMuret);
        while (tempNode != null) {
            tempNode.muret.hide();
            tempNode = tempNode.suivant;
        }
    }

    public Muret chercheMuret(Muret m) {
        tempNode = new NoeudMuret(premierMuret.muret, premierMuret);
        if (tempNode.muret.equals(m)) {
            return tempNode.muret;
        } else {
            tempNode = tempNode.suivant;
        }
    }



 }