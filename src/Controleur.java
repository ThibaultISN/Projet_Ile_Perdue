
import java.util.*;

public class Controleur {

    Grille grille;
    ArrayList<Aventurier> joueurs = new ArrayList<>();

    ArrayList<Carte> cartes = new ArrayList<>();
    ArrayList<Carte> defosse = new ArrayList<>();
    ArrayList<CarteInondation> cartesinnond = new ArrayList<>();
    ArrayList<CarteInondation> defossecartinond = new ArrayList<>();
    Echelle echelle;
    ArrayList<Tresor> tresores = new ArrayList<>();

    ;

    /**
     *
     * @param nomjoueur
     * @param cartetrésor
     */

    public Controleur() {
        getTresores().add(new Tresor(Flamme));
        getTresores().add(new Tresor("lune"));
        getTresores().add(new Tresor("lion"));
        getTresores().add(new Tresor("coupe"));
        initcart();

         defosse = new ArrayList<>();
         defossecartinond = new ArrayList<>();


    }

    public boolean PossibleDon(Aventurier joueurRec, Aventurier joueurEnv, CarteTresor cartetrésor) {
        // TODO - implement Controleur.PossibleDon
        if (joueurEnv.getRole() == "Messager") {
            if (joueurEnv.getCartes().contains(cartetrésor)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (joueurEnv.getEmplacement() == joueurRec.getEmplacement() && joueurEnv.getCartes().contains(cartetrésor)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void donCarte(Aventurier joueurRec, Aventurier joueurEnv, CarteTresor cartetrésor) {
        if (PossibleDon(joueurRec, joueurEnv, cartetrésor)) {
            joueurRec.getCartes().add(cartetrésor);
            joueurEnv.getCartes().remove(cartetrésor);
        }
    }

    /**
     *
     * @param tuile
     * @param role
     */
    public boolean Possibleasseche(Tuile tuile, Aventurier x) {
        // TODO - implement Controleur.Possibleasseche
        Boolean a;
        if (x.getRole() == "Explorateur") {
            if ((tuile.estcontigue(x) || tuile.estdiagonal(x)) && tuile.getEtatTuile() == EtatTuile.inondé) {
                a = true;
            } else {
                a = false;
            }
        } else {
            if (tuile.estcontigue(x) && tuile.getEtatTuile() == EtatTuile.inondé) {
                a = true;

            } else {
                a = false;
            }
        }
        return a;
    }

    public void assecher(Tuile tuile, Aventurier x) {

        tuile.setEtatTuile(EtatTuile.seche);

    }

    public void prendretrésor(Aventurier joueur, Tresor trésor) {

        //V2
<<<<<<< OURS
        if (Possibleprisetrésor(joueur, tresor)) {
            joueur.addTresor(tresor);
            this.tresores.remove(tresor);
            for(CarteTresor a : joueur.getCartes()){
                if(a.getT()==tresor){
                    this.defosse.add(a);
                    joueur.getCartes().remove(a);
                }
            }
=======
        if (Possibleprisetrésor(joueur, trésor)) {
            joueur.addTresor(trésor);
>>>>>>> THEIRS
        }

    }

    public boolean prisetrésor(Aventurier joueur, Tresor tresor) {
        // TODO - implement Controleur.Possibleprisetrésor
//        int i = 0;
//        boolean a = false;
//        for (int j = 0; j < joueur.getCartes().size(); j++) {
//            if (joueur.getCartes().(j) instanceof CarteTresor ) {
//                i = i + 1;
//            }
//        }
//        if (i >= 4) {
//            for (Tuile t : grille.TuileTresor(tresor)) {
//                if (joueur.getEmplacement() == t && t.getEtatTuile() != EtatTuile.disparue) {
//                    a = true;
//
//                } else {
//                    a = false;
//
//                }
//            }
//        } else {
//            a = false;
//
//        }
//        return a;
        ArrayList<CarteTresor> tresors = new ArrayList<>();
        boolean prendre = false;
        for(int i = 0; i < joueur.getCartes().size() ; i++){
            if(joueur.getCartes(). instanceof CarteTresor){
                tresors.add(c);
            }
        }
        return prendre;
    }

    public ArrayList<String> randomrole() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Plongeur");
        roles.add("Messager");
        roles.add("Navigateur");
        roles.add("Pilote");
        roles.add("Ingénieur");
        roles.add("Explorateur");

        Collections.shuffle(roles);
        return roles;

    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Aventurier> joueurs) {
        this.joueurs = joueurs;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }

    public ArrayList<CarteInondation> getCartesinnond() {
        return cartesinnond;
    }

    public void setCartesinnond(ArrayList<CarteInondation> cartesinnond) {
        this.cartesinnond = cartesinnond;
    }

    public Echelle getEchelle() {
        return echelle;
    }

    public void setEchelle(Echelle echelle) {
        this.echelle = echelle;
    }

    public ArrayList<Tresor> getTresores() {
        return tresores;
    }

    public void setTresores(ArrayList<Tresor> tresores) {
        this.tresores = tresores;
    }

    //Initialise le paquet de carte et mélanger
    public void initcart() {

        int i = 0;
        /*for(Tresor tr : getTresores()){
            while(i<6){
                getCartes().add(new CarteTresor(tr));
                i=i+1;

            }
       } */
        while (i < 5) {
            getCartes().add(new CarteTresor(new Tresor("flamme")));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor(new Tresor("lune")));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor( new Tresor("lion")));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor(new Tresor("coupe")));
            i = i + 1;
        }

        getCartes().add(new Helicopter());
        getCartes().add(new Helicopter());
        getCartes().add(new Helicopter());

        getCartes().add(new SacDeSable());
        getCartes().add(new SacDeSable());

        getCartes().add(new MontéeEaux());
        getCartes().add(new MontéeEaux());
        getCartes().add(new MontéeEaux());

        Collections.shuffle(getCartes());
    }

    public void attributioncart() {
        ArrayList<Aventurier> li = getJoueurs();
        int j = 0;
        for (Aventurier i : getJoueurs()) {

            while (i.getCartes().size() < 5) {

                if (this.getCartes().get(j) instanceof MontéeEaux) {
                    j = j + 1;
                }
                i.getCartes().add(this.getCartes().get(j)); // à verfier si la pile se décalle
                this.getCartes().remove(j);
            }

        }

    }

    public ArrayList<CarteInondation> Carteterraingen() {
        ArrayList<Tuile> li = getGrille().getTuiles();
        ArrayList<CarteInondation> ret = new ArrayList<>();
        for (Tuile t : li) {
            if (t.getNom() != "Null") {
                ret.add(new CarteInondation(t));
            }
        }
        return ret;
    }

    public void initterrain() {
        ArrayList<CarteInondation> li = getCartesinnond();
        Collections.shuffle(li);
        int i = 0;
        for (CarteInondation t : li) {
            if (i <= 5) {
                t.getTuile().setEtatTuile(EtatTuile.inondé);
                getDefossecartinond().add(t);

                i = i + 1;
            }
        }
        // Enleve les cartes défosser dans le tas
        for (CarteInondation t : getDefossecartinond()) {
            getCartesinnond().remove(t);
        }
    }

    public ArrayList<CarteInondation> getDefossecartinond() {
        return defossecartinond;
    }

    public void setDefossecartinond(ArrayList<CarteInondation> defossecartinond) {
        this.defossecartinond = defossecartinond;
    }

    public ArrayList<Tuile> tuilepossibledep(Aventurier av) {
        ArrayList<Tuile> l = new ArrayList<>();
        ArrayList<Tuile> la = this.getGrille().getTuiles();

        for (Tuile t : la) {
            if (av.getRole() != "Explorateur" && av.getRole() != "Pilote") {
                if (t.estcontigue(av) && t.getNom() != "Null" && t.getEtatTuile() != EtatTuile.disparue) {
                    l.add(t);

                }
            } else if (av.getRole() == "Explorateur") {
                if ((t.estcontigue(av) || t.estdiagonal(av)) && t.getNom() != "Null" && t.getEtatTuile() != EtatTuile.disparue) {
                    l.add(t);

                } 
            }else if (av.getRole() == "Pilote") {
                 if ( t.getEtatTuile() != EtatTuile.disparue) {
                    l.add(t);

                }
                }
        }
        return l;
    }

    public void affichetuilepossibledep(Aventurier av) {
        int a = 1;
        for (Tuile t : tuilepossibledep(av)) {

            System.out.println(a);
            t.affiche();
            a = a + 1;
        }
    }

    public void afficherJoueur() {
        int a = 1;
        for (Aventurier av : getJoueurs()) {

            System.out.println(a + "- " + av.getNom() + " " + (av.getRole()) + " ");
            a = a + 1;
        }
    }

    public int numAventurier(String nom) {
        int i = 0;
        ArrayList<Aventurier> liste = getJoueurs();
        while (i < liste.size() && liste.get(i).getNom() != nom) {
            i = i + 1;
        }
        return i;
    }

    public ArrayList<Tuile> tuileassechable(Aventurier av) {
        ArrayList<Tuile> l = new ArrayList<>();
        ArrayList<Tuile> la = this.getGrille().getTuiles();
        for (Tuile t : la) {
            if (av.getRole() != "Explorateur") {
                if ((t.estcontigue(av)) && t.getEtatTuile() == EtatTuile.inondé) {

                    l.add(t);

                }

            } else {
                if ((t.estcontigue(av) || t.estdiagonal(av)) && t.getEtatTuile() == EtatTuile.inondé) {

                    l.add(t);

                }
            }
        }
        return l;

    }

    public void affichetuileassechable(Aventurier av) {
        for (Tuile t : tuileassechable(av)) {
            t.affiche();
        }
    }
    //Retourne chaque tuile de la maniere ( NOM TUILE + POSIITION +)
    public void affichegrille() {
        for (Tuile t : grille.tuiles) {
            t.affiche();
        }
    }

    //Retourne les tuiles inondé
    public ArrayList<Tuile> caseinonde() {
        ArrayList<Tuile> l = new ArrayList<>();
        ArrayList<Tuile> la = this.getGrille().getTuiles();
        for (Tuile t : la) {
            if (t.getEtatTuile() == EtatTuile.inondé) {
                l.add(t);
            }
        }
        return l;

    }
    //Affiche toutes les cases inondés
    public void affichecaseinonde() {
        for (Tuile t : this.caseinonde()) {
            t.affiche();
        }
    }
    //Retourne les tuiles se situant en estdiagonal du joueur en parametre
    public ArrayList<Tuile> tuilediag(Aventurier av) {
        ArrayList<Tuile> l = new ArrayList<>();
        ArrayList<Tuile> la = this.getGrille().getTuiles();
        for (Tuile t : la) {
            if (t.estdiagonal(av)) {
                l.add(t);
            }
        }
        return l;

    }
//Affiche les tuiles se situant en estdiagonal du joueur en parametre
    public void affichetuilediag(Aventurier av) {
        for (Tuile t : this.tuilediag(av)) {
            t.affiche();
        }
    }
<<<<<<< OURS
//Retourne une list de joueur possedeant une carte Helicopter
    public ArrayList<Aventurier> posssedeSdS() {
        ArrayList<Aventurier> l = new ArrayList<>();

        for (Aventurier o : this.getJoueurs()) {
            int a = 0;
            for( CarteTresor p : o.getCartes()){
                if (p.getType()=="Sac de Sable" && a==0){
                    l.add(o);
                    a=1;
                }
            }
        }
        return l;
    }
//Retourne une list de joueur possedeant une carte Helicopter
    public ArrayList<Aventurier> posssedeHelico() {
            ArrayList<Aventurier> l = new ArrayList<>();

            for (Aventurier o : this.getJoueurs()) {
                int a = 0;
                for (CarteTresor p : o.getCartes()) {
                    if (p.getType() == "Helicopter" && a == 0) {
                        l.add(o);
                        a = 1;
                    }
                }
            }
            return l;
        }
        //Retourne une list de joueur se situant sur la tuile en parametre
        public ArrayList<Aventurier> joueursurtuile(Tuile t){
        ArrayList<Aventurier> l = new ArrayList<>();
       for(Aventurier av : this.joueurs){
           if(av.getEmplacement()==t){
               l.add(av);
           }
       }
       return l;
   }
    //Affiche les joueurs qui possede une carte Sac de sable
     public void afficheposssedeSdS() {
         int a = 1;
        for (Aventurier t : this.posssedeSdS()) {
            System.out.println(a + "-" + t.getNom());
            a=a+1;
        }
    }

     public void supprimecarte(Aventurier av , CarteTresor t){
         av.getCartes().remove(t);
         this.defosse.add(t);
     }

     public void TirageCarteInondation(){
                int nivo = controleur.getEchelle().getGraduation();
                int indcourant =1;
                while(indcourant< nivo){
                  Tuile tempo = controleur.getCartesinnond().get(0).getTuile();
                  int tempot = controleur.grille.numTuile(tempo.getNom());
                  if( controleur.grille.tuiles.get(tempot).getEtatTuile()==EtatTuile.seche){
                  controleur.grille.tuiles.get(tempot).setEtatTuile(EtatTuile.inondé);
                  controleur.defossecartinond.add(controleur.getCartesinnond().get(0));
                  controleur.cartesinnond.remove(0);
                  } else if( controleur.grille.tuiles.get(tempot).getEtatTuile()==EtatTuile.inondé) {
                     controleur.grille.tuiles.get(tempot).setEtatTuile(EtatTuile.disparue);
                     controleur.cartesinnond.remove(0);
                  }
                  indcourant=indcourant +1;
     }



    }
}
