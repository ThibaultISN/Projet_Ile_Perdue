import java.util.ArrayList;

public class Explorateur extends Aventurier {
    
        private ArrayList<CarteTresor> main;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        
        Explorateur(String nom){
            super(nom);
            setEnVie(true);

        }
	/**
	 * 
	 * @param tuile
	 */
	public void assecherDiag(Tuile tuile) {
		tuile.setEtatTuile(EtatTuile.seche);
	}

	/**
	 * 
	 * @param tuile
	 */
	public void deplacerDiag(Tuile tuile) {
		// TODO - implement Explotateur.deplacerDiag
                setEmplacement(tuile);
	}

}