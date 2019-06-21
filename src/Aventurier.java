import java.util.*;

public abstract class Aventurier {

	private ArrayList<Carte> cartes = new ArrayList<>();
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;
  private Collection<Tresor> tresor = new ArrayList<>();
  private String role;
  private String Capacité;
	//private Color couleur;

        Aventurier(String nom){
            setNom(nom);

        }

    /**
     * @return the cartes
     */
    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    /**
     * @param cartes the cartes to set
     */
    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
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
     * @return the tresor
     */
    public Collection<Tresor> getTresor() {
        return tresor;
    }

    /**
     * @param tresor the tresor to set
     */
    public void setTresor(Collection<Tresor> tresor) {
        this.tresor = tresor;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the Capacité
     */
    public String getCapacité() {
        return Capacité;
    }

    /**
     * @param Capacité the Capacité to set
     */
    public void setCapacité(String Capacité) {
        this.Capacité = Capacité;
    }




    public void addCarte(CarteTresor carte){

        if(getCartes().size() > 5){

           getCartes().add(carte);
        }
    }

    public void addTresor(Tresor tres){
        getTresor().add(tres);
    }

    public void afficherCarte(){
        int a = 1;

        for(Carte c : this.getCartes()){
          System.out.println(a + "-");c.afficher();
          a =a+1;
     }
    }

    public int numcarte(String nom){
        int i = 0;
        ArrayList<Carte> liste = getCartes();

        while( i < liste.size() && liste.get(i).getType()!= nom){
        i = i+1;
        }

        return i;
     }


     /*public boolean estcontigue(Tuile tuile) {
       Tuile tuilejoueur =this.getEmplacement();

       if(tuilejoueur.getPosition().isEqual

    }*/

//    public Tuile seDeplacer(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Entrez la case sur laquelle vous voulez vous rendre : ");
//        Tuile t = new Tuile("nv", sc.nextInt());
//    }

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

