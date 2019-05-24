import java.util.*;

public class Navigateur extends Aventurier {
        
        Collection<Carte> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Navigateur(String nom){
            super(nom);
            setEnVie(true);

        }
	/**
	 * 
	 * @param tuile
	 */
	public void deplacerJ(int tuile) {
		// TODO - implement Navigateur.deplacerJ
		throw new UnsupportedOperationException();
	}

}