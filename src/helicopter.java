

import java.util.Scanner;


public class helicopter extends CarteTresor {

    private Aventurier joueur;
    
    helicopter(){
        
    }
    
    public void déplacement() {
        boolean bool = false;
        while (bool = false){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir où se déplacer :");
        String str = sc.nextLine();
        System.out.println("Vous avez choisie : " + str);
        for(int i=0; i < Grille.tuiles.size() && tuile.nom != str; i++ ){
            
        }
        if ( tuile.getEtatTuile == "Normal" || "Inondée"){
            joueur.seDéplacer(tuile);
            bool = true;
        } else{
            System.out.println("Tuile non valide réésayez");
        }
    }
    }
    
}
