import java.util.*;

public abstract class Aventurier {

	Collection<CarteTresor> cartes;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        private Tresor tresor;
        
        Aventurier(String nom){
            setNom(nom);
            setEnVie(enVie);
        }

	/**
	 * 
	 * @param tuile
	 */
	public void seDeplacer(Tuile tuile) {
		// TODO - implement Aventurier.seDeplacer
                if(emplacement.estCollee(tuile)){
                    setEmplacement(tuile);
                }
        }

	/**
	 * 
	 * @param tuile
	 */
	public void assécher(Tuile tuile) {
		// TODO - implement Aventurier.assécher
                if(emplacement.estCollee(tuile)){
                    tuile.setEtat("sec");
                }
        }

	/**
	 * 
	 * @param carte
	 */
	public void doncarte(CarteTresor carte, Aventurier joueur) {
		// TODO - implement Aventurier.doncarte
            if(joueur.emplacement.estCollee(emplacement)){
                joueur.addCarte(carte);
                cartes.remove(carte);
            }
        }

	/**
	 * Mettre en parametre le trésor et ajouter le trésor dans la liste de trésor du joueur et l'enlever des trésors disponible
	 * @param trésor
	 */
	public void prendretrésor(Tresor trésor) {
		// TODO - implement Aventurier.prendretrésor
                if((getEmplacement() == possede 4 cartetrésor){
                    cartes.remove(cartetresor)*4;
                    setTresor(trésor);
                    
        }
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
    
    public void addCarte(CarteTresor carte){
        
        if(cartes.size() > 5)
           
           cartes.add(carte);}

    /**
     * @return the tresor
     */
    public Tresor getTresor() {
        return tresor;
    }

    /**
     * @param tresor the tresor to set
     */
    public void setTresor(Tresor tresor) {
        this.tresor = tresor;
    }
    
    

    

}