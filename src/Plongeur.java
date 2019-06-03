import java.util.*;


public class Plongeur extends Aventurier {

        Collection<CarteTresor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        
        Plongeur(String nom){
            super(nom);
            setEnVie(true);
        }
	public void plonger(Tuile tuile) {
		// TODO - implement Plonguer.plonger
                setEmplacement(tuile);
        }

}