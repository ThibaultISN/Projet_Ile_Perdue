import java.util.*;

public class Messager extends Aventurier {
        
        Collection<CarteTresor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Messager(String nom){
            super(nom);
            setEnVie(true);
        }
	/**
	 * 
	 * @param carte
	 */
	public void donnerCarte(CarteTresor carte, Aventurier joueur) {
		// TODO - implement Messager.donnerCarte
                joueur.addCarte(carte);
	}

}