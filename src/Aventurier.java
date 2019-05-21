import java.util.*;

public abstract class Aventurier {

	Collection<CarteTresor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        private String thibault;
        

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

    /**
     * @return the emplacement
     */
    public Tuile getEmplacement() {
        return emplacement;
    }

    /**
     * @param emplacement the emplacement to set
     */
    public void setEmplacement(Tuile emplacement) {
        this.emplacement = emplacement;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the nbAction
     */
    public int getNbAction() {
        return nbAction;
    }

    /**
     * @param nbAction the nbAction to set
     */
    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }

    /**
     * @return the enVie
     */
    public Boolean getEnVie() {
        return enVie;
    }

    /**
     * @param enVie the enVie to set
     */
    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }

    /**
     * @return the thibault
     */
    public String getThibault() {
        return thibault;
    }

    /**
     * @param thibault the thibault to set
     */
    public void setThibault(String thibault) {
        this.thibault = thibault;
    }

}
