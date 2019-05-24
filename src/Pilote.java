import java.util.*;


public class Pilote extends Aventurier {
        private String thibault;
        
        Collection<Carte> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Pilote(String nom){
            super(nom);
            setEnVie(true);
        }
	/**
	 * 
	 * @param tuile
	 */
	public void téléportation(int tuile) {
		// TODO - implement Pilote.téléportation
		throw new UnsupportedOperationException();
	}

}