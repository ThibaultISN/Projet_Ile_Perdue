
import java.util.*;

public class Ingénieur extends Aventurier {
    
        Collection<CarteTrésor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Ingénieur(String nom){
            super(nom);
            setEnVie(true);
        }
	/**
	 * 
	 * @param tuile
	 */
	public void assecherT(Tuile tuile) {
		// TODO - implement Ingénieur.assecherT
                setEmplacement(tuile);
        }

}