
import java.util.*;

public class Controleur {

    Grille grille;
    ArrayList<Aventurier> joueurs = new ArrayList<>();
    ArrayList<CarteTresor> cartes = new ArrayList<>();
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
        getTresores().add(new Tresor("flamme"));
        getTresores().add(new Tresor("lune"));
        getTresores().add(new Tresor("lion"));
        getTresores().add(new Tresor("coupe"));
        initcart();

    }

    public boolean PossibleDon(Aventurier joueurRec, Aventurier joueurEnv, CarteTresor cartetrésor) {
        // TODO - implement Controleur.PossibleDon
        if (joueurEnv.getRole() == "Messager") {
            if (joueurEnv.cartes.contains(cartetrésor)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (joueurEnv.getEmplacement() == joueurRec.getEmplacement() && joueurEnv.cartes.contains(cartetrésor)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void donCarte(Aventurier joueurRec, Aventurier joueurEnv, CarteTresor cartetrésor) {
        if (PossibleDon(joueurRec, joueurEnv, cartetrésor)) {
            joueurRec.cartes.add(cartetrésor);
            joueurEnv.cartes.remove(cartetrésor);
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
        if (Possibleprisetrésor(joueur, trésor)) {
            joueur.addTresor(trésor);
        }

    }

    public boolean Possibleprisetrésor(Aventurier joueur, Tresor tresor) {
        // TODO - implement Controleur.Possibleprisetrésor
        int i = 0;
        boolean a = false;
        for (CarteTresor c : joueur.cartes) {
            if (c.getT() == tresor) {
                i = i + 1;
            }
        }
        if (i >= 4) {
            for (Tuile t : grille.TuileTresor(tresor)) {
                if (joueur.getEmplacement() == t && t.getEtatTuile() != EtatTuile.disparue) {
                    a = true;

                } else {
                    a = false;

                }
            }
        } else {
            a = false;

        }
        return a;

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

    public ArrayList<CarteTresor> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<CarteTresor> cartes) {
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
            getCartes().add(new CarteTresor("flamme"));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor("lune"));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor("lion"));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor("coupe"));
            i = i + 1;
        }

        getCartes().add(new CarteTresor("Helicopter"));
        getCartes().add(new CarteTresor("Helicopter"));
        getCartes().add(new CarteTresor("Helicopter"));

        getCartes().add(new CarteTresor("Sac de Sable"));
        getCartes().add(new CarteTresor("Sac de Sable"));

        getCartes().add(new CarteTresor("Monté des eaux"));
        getCartes().add(new CarteTresor("Monté des eaux"));
        getCartes().add(new CarteTresor("Monté des eaux"));

        Collections.shuffle(getCartes());
    }

    public void attributioncart() {
        ArrayList<Aventurier> li = getJoueurs();
        int j = 0;
        for (Aventurier i : getJoueurs()) {

            while (i.getCartes().size() < 5) {

                if (this.getCartes().get(j).getType() == "Monté des eaux") {
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

    public void affichegrille() {
        for (Tuile t : grille.tuiles) {
            t.affiche();
        }
    }

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

    public void affichecaseinonde() {
        for (Tuile t : this.caseinonde()) {
            t.affiche();
        }
    }

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

    public void affichetuilediag(Aventurier av) {
        for (Tuile t : this.tuilediag(av)) {
            t.affiche();
        }
    }

}
