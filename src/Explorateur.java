
import java.util.ArrayList;

public class Explorateur extends Aventurier {
    
        private ArrayList<Carte> main;
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
	public void assecherDiag(int tuile) {
		
	}

	/**
	 * 
	 * @param tuile
	 */
	public void deplacerDiag(int tuile) {
		// TODO - implement Explotateur.deplacerDiag
	}

}