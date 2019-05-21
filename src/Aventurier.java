import java.util.*;

public abstract class Aventurier {

	Collection<CarteTresor> carte;
	Tuile tuiles;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        private String test;

	/**
	 * 
	 * @param tuile
	 */
	public void seDeplacer(int tuile) {
		// TODO - implement Aventurier.seDeplacer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tuile
	 */
	public void assécher(int tuile) {
		// TODO - implement Aventurier.assécher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param carte
	 */
	public void doncarte(CarteTresor carte) {
		// TODO - implement Aventurier.doncarte
		throw new UnsupportedOperationException();
	}

	/**
	 * Mettre en parametre le trésor et ajouter le trésor dans la liste de trésor du joueur et l'enlever des trésors disponible
	 * @param trésor
	 */
	public void prendretrésor(Trésor trésor) {
		// TODO - implement Aventurier.prendretrésor
		throw new UnsupportedOperationException();
	}

}