
import java.util.*;


public class Pilote extends Aventurier {
        private String thibault;
        
        Collection<CarteTresor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Pilote(){
            super.setRole("Pilote");
        }
	/**
	 * 
	 * @param tuile
	 */
	public void téléportation(Tuile tuile) {
		// TODO - implement Pilote.téléportation
                setEmplacement(tuile);
        }

}