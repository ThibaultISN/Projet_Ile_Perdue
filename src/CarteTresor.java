import java.util.Collection;

public class CarteTresor {

    private Aventurier joueur;
    private Tresor t;
    private String type;

    public CarteTresor(Tresor t) {
        this.t = t;
        this.type=t.getNom();
        
    }
    
     public CarteTresor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getType();
    }

   
    
    
    

    /*public void Piocher() {
        // modif
        if (Controleur.cartes.size() == 0){
            Controleur.cartes = Controleur.cartesD;
            Collections.shuffle(Controleur.cartes);
        }
        for (int i = 0; i < Controleur.cartes.size(3); i++) {
            joueur.carte.add(Controleur.cartes.get(i));
            Controleur.cartes.remove(i);
            if (joueur.carte.size() > 5) {
                int c = joueur.carte.size() - 5;
                System.out.println("Trop de cartes, veuillez vous défaussez de :" + c + "cartes");
                Scanner sc = new Scanner(System.in);
                for (int i = 0; i < c; i++) {
                    System.out.println("Veuillez saisir carte à défausser :");
                    String str = sc.nextLine();
                    System.out.println("Vous avez choisie : " + str);
                    joueur.carte.remove(CarteTresor(str));
                    Controleur.carteD.add(joueur.carte(CarteTresor(str)));
                }
            }

        }

    } */
    
    public void Défausser(){
        
    }

    public Aventurier getJoueur() {
        return joueur;
    }

    public void setJoueur(Aventurier joueur) {
        this.joueur = joueur;
    }

    public Tresor getT() {
        return t;
    }

    public void setT(Tresor t) {
        this.t = t;
    }
    
    public void afficher(){
         System.out.println(this.type+" ");
    }
    
    
    
   
}