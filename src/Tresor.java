public class Tresor {
    
    private Aventurier joueur;
    private boolean estPossede;
    private String nom;

    public String getNom() {
        return nom;
    }
    
    Tresor(String nom){
        setNom(nom);
    }

    /**
     * @return the joueur
     */
    public Aventurier getJoueur() {
        return joueur;
    }

    /**
     * @param joueur the joueur to set
     */
    public void setJoueur(Aventurier joueur) {
        this.joueur = joueur;
    }

    /**
     * @return the estPossede
     */
    public boolean isEstPossede() {
        return estPossede;
    }

    /**
     * @param estPossede the estPossede to set
     */
    public void setEstPossede(boolean estPossede) {
        this.estPossede = estPossede;
    }

    private void setNom(String nom) {
        this.nom=nom;
    }
            
}