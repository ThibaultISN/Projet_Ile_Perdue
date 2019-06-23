
import java.util.*;

public class Ingenieur extends Aventurier {
    
        Collection<CarteTresor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Ingenieur(String nom){
            super.setNom(nom);
             super.setRole("Ingénieur");
        }
        
         Ingenieur(){
             super.setRole("Ingénieur");
             
            
        }
	
}