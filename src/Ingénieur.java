
import java.util.*;

public class Ingénieur extends Aventurier {
    
        Collection<CarteTresor> carte;
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
	public void assecherT(int tuile) {
		// TODO - implement Ingénieur.assecherT
		throw new UnsupportedOperationException();
	}

}