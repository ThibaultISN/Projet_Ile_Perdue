
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author remulef
 */
public class testgénératiodestuiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grille g = new Grille();
        g.générationgrille();
        ArrayList<Tuile> l = g.getTuiles();
        
        
        for(Tuile t : l ){
            t.affiche();
        }
        
        
        
        
        
    }
    
}
