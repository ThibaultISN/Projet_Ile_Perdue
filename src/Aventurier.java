import java.util.*;

public abstract class Aventurier {

	ArrayList<CarteTresor> cartes = new ArrayList<>();
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
        private Collection<Tresor> tresor = new ArrayList<>();
         private String role;
         private String Capacité;

    public String getCapacité() {
        return Capacité;
    }

    public void setCapacité(String Capacité) {
        this.Capacité = Capacité;
    }
        
        Aventurier(String nom){
            setNom(nom);
           
        }
        Aventurier(){
           
           
        }

    public Collection<Tresor> getTresor() {
        return tresor;
    }

    public void setTresor(Collection<Tresor> tresor) {
        this.tresor = tresor;
    }

    public Collection<CarteTresor> getCartes() {
        return cartes;
    }

    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    
     public void addTresor(Tresor tres){
        tresor.add(tres);
        


}
     public void afficherCarte(){
         int a = 1;
     for(CarteTresor c : this.cartes){
          System.out.println(a + "-");c.afficher();
          a =a+1;
     }   
    }
     
     public int numcarte(String nom){
        int i = 0;
        ArrayList<CarteTresor> liste = cartes;
        while( i < liste.size() && liste.get(i).getType()!= nom){
        i = i+1;
    }
            return i;
     }
     
     
     /*public boolean estcontigue(Tuile tuile) {
       Tuile tuilejoueur =this.getEmplacement();
       
       if(tuilejoueur.getPosition().isEqual

    }*/
     
      public boolean estdiagonal(Tuile tuile){
       
       Position pos = this.getEmplacement().getPosition();
        Position param = tuile.getPosition();

        int paramX = tuile.getPosition().getX();
        int paramY = tuile.getPosition().getY();

        ArrayList<Position> listconti = new ArrayList<>();
        
        listconti.add(new Position(paramX + 1, paramY + 1));
        listconti.add(new Position(paramX -1 , paramY + 1));
        listconti.add(new Position(paramX - 1, paramY +1));
        listconti.add(new Position(paramX +1, paramY - 1));


        return (listconti.contains(this.getEmplacement()));
        
    }
     
}