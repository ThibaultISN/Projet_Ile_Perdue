import java.util.ArrayList;

public class Explorateur extends Aventurier {
    
        private ArrayList<CarteTresor> main;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
       
        
        Explorateur(String Nom){
            super.setRole("Explorateur");
            super.setNom(Nom);
        }
        
       
	

}