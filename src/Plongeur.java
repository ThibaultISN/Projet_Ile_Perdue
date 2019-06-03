import java.util.*;


public class Plongeur extends Aventurier {

        Collection<Carte> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        
        Plongeur(String nom){
            super(nom);
            setEnVie(true);
        }
	public void plonger() {
		// TODO - implement Plonguer.plonger
		throw new UnsupportedOperationException();
	}

}