


import java.util.Scanner;

public class sacSable extends CarteTresor {
    
    
    sacSable(){
        
    }
    
    public void assecher(){
        boolean bool = false;
        while (bool == false){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir où assécher :");
        String str = sc.nextLine();
        System.out.println("Vous avez choisie : " + str);
        for(int i=0; i < Grille.tuiles.size() && tuile.nom != str; i++ ){
            
        }
        if ( tuile.getEtatTuile == "Inondée"){
            joueur.assécher(tuile);
            bool = true;
        } else{
            System.out.println("Tuile non valide réésayez");
        }
    }
    
}
}