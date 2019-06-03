import java.util.*;

public class Navigateur extends Aventurier {
        
        Collection<CarteTresor> carte;
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
	public void deplacerJ(Tuile tuile, Aventurier joueur) {
		// TODO - implement Navigateur.deplacerJ
            joueur.setEmplacement(tuile);
        }

}

