import java.util.*;

public class Messager extends Aventurier {
        
        Collection<CarteTrésor> carte;
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
	public void donnerCarte(Carte carte, Aventurier joueur) {
		// TODO - implement Messager.donnerCarte
                joueur.addCarte(carte);
	}

}