package labyrinth;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */

 public class Muret{
     private int x;
     private int y;
     private boolean verticale;
     private boolean visible;


     public Muret(int x, int y, boolean verticale, boolean visible){
         this.x = x;
         this.y = y;
         this.verticale = verticale;
         this.visible = visible;
     }

     public void visibilite(boolean v){
         this.visible = v;
     }

     public boolean equals(Muret m){
        if(this.x == m.x && this.y == m.y && this.verticale == m.verticale){
            return true;
        } else {
            return false;
        }
     }
 }