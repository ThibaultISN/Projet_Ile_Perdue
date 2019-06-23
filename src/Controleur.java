
import java.util.*;
import javax.swing.JOptionPane;

public class Controleur implements Observateur {

    Grille grille;
    ArrayList<Aventurier> joueurs = new ArrayList<>();
    ArrayList<CarteTresor> cartes = new ArrayList<>();
    ArrayList<CarteTresor> defosse = new ArrayList<>();

    ArrayList<CarteInondation> cartesinnond = new ArrayList<>();
    ArrayList<CarteInondation> defossecartinond = new ArrayList<>();
    Echelle echelle;
    ArrayList<Tresor> tresoresplateau = new ArrayList<>();
    ArrayList<Tresor> tresorjoueurs = new ArrayList<>();
      VueGrille vuegrille;
    ;

    private VueDemarrer ihmDem;
    private newVueAventurier ihmAv;
    private VueDeck ihmcarte;

    /**
     *
     * @param nomjoueur
     * @param cartetrésor
     */
    public Controleur() {
        getTresoresplateau().add(new Tresor("flamme"));
        getTresoresplateau().add(new Tresor("lune"));
        getTresoresplateau().add(new Tresor("lion"));
        getTresoresplateau().add(new Tresor("coupe"));
        initcart();
        defosse = new ArrayList<>();
        defossecartinond = new ArrayList<>();
        Grille g = new Grille();
        g.générationgrille();
        this.setGrille(g);
        this.initterrain();
        this.defosse = new ArrayList<>();
        this.defossecartinond = new ArrayList<>();

        this.setCartesinnond(this.Carteterraingen());
        this.initterrain();
        VueDemarrer ihmDem = new VueDemarrer();
        // ihmAv = new VueAventurier();

        this.setIhmDem(ihmDem);
        ihmDem.afficher();
        ihmDem.addObservateur(this);

    }

    public VueDemarrer getIhmDem() {
        return ihmDem;
    }

    public void setIhmDem(VueDemarrer ihmDem) {
        this.ihmDem = ihmDem;
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

    public void prendretresor(Aventurier joueur) {
        Tresor tresor = joueur.getEmplacement().getTrésor();
        //V2
        if (Possibleprisetrésor(joueur)) {
            this.tresorjoueurs.add(tresor);
            this.tresoresplateau.remove(tresor);
            for (CarteTresor a : joueur.cartes) {
                if (a.getT() == tresor) {
                    this.defosse.add(a);
                    joueur.cartes.remove(a);
                }
            }
        }

    }

    public boolean Possibleprisetrésor(Aventurier joueur) {
        // TODO - implement Controleur.Possibleprisetrésor
        int i = 0;
        boolean a = false;
        if (joueur.getEmplacement().getTrésor() != null) {
            Tresor tresor = joueur.getEmplacement().getTrésor();
            for (CarteTresor c : joueur.cartes) {
                if (c.getT() == tresor) {
                    i = i + 1;
                }
            }
            if (i >= 4) {
                a = true;

            } else {
                a = false;
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

    public ArrayList<Tresor> getTresoresplateau() {
        return tresoresplateau;
    }

    public void setTresoresplateau(ArrayList<Tresor> tresoresplateau) {
        this.tresoresplateau = tresoresplateau;
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
            getCartes().add(new CarteTresor("flamme", new Tresor("flamme")));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor("lune", new Tresor("lune")));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor("lion", new Tresor("lion")));
            i = i + 1;
        }
        i = 0;
        while (i < 5) {
            getCartes().add(new CarteTresor("coupe", new Tresor("coupe")));
            i = i + 1;
        }

        getCartes().add(new CarteTresor("Helicopter"));
        getCartes().add(new CarteTresor("Helicopter"));
        getCartes().add(new CarteTresor("Helicopter"));

        getCartes().add(new CarteTresor("Sac de Sable"));
        getCartes().add(new CarteTresor("Sac de Sable"));

        getCartes().add(new CarteTresor("Monté des eaux"));
        getCartes().add(new CarteTresor("Monté des eaux"));

        //getCartes().add(new CarteTresor("Monté des eaux"));
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
            } else if (av.getRole() == "Pilote") {
                if (t.getEtatTuile() != EtatTuile.disparue) {
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
        int a = 1;
        for (Tuile t : this.caseinonde()) {
            System.out.println(a);
            t.affiche();
            a = a + 1;
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

    public ArrayList<Aventurier> posssedeSdS() {
        ArrayList<Aventurier> l = new ArrayList<>();

        for (Aventurier o : this.getJoueurs()) {
            int a = 0;
            for (CarteTresor p : o.getCartes()) {
                if (p.getType() == "Sac de Sable" && a == 0) {
                    l.add(o);
                    a = 1;
                }
            }
        }
        return l;
    }

    public ArrayList<Aventurier> joueursurtuile(Tuile t) {
        ArrayList<Aventurier> l = new ArrayList<>();
        for (Aventurier av : this.joueurs) {
            if (av.getEmplacement() == t) {
                l.add(av);
            }
        }
        return l;
    }

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

    public void afficheposssedeSdS() {
        int a = 1;
        for (Aventurier t : this.posssedeSdS()) {
            System.out.println(a + "-" + t.getNom());
            a = a + 1;
        }
    }

    public Aventurier joueursuivant(Aventurier av) {
        Aventurier aven = null;
        System.out.println(joueurs);
        if (this.joueurs.indexOf(av) == this.joueurs.size() - 1) {
            aven = this.joueurs.get(0);

        } else if (this.joueurs.indexOf(av) < this.joueurs.size() - 1) {

            int numsuivant = this.joueurs.indexOf(av) + 1;
            aven = this.joueurs.get(numsuivant);
        }
        return aven;

    }

    public void supprimecarte(Aventurier av, CarteTresor t) {
        av.getCartes().remove(t);
        this.defosse.add(t);
    }

    public void TirageCarteInondation() {
        JOptionPane popup;
        int nivo = this.getEchelle().getGraduation();
        int indcourant = 1;
        while (indcourant < nivo) {
            Tuile tempo = this.getCartesinnond().get(0).getTuile();
            int tempot = this.grille.numTuile(tempo.getNom());
            if (this.grille.tuiles.get(tempot).getEtatTuile() == EtatTuile.seche) {
                this.grille.tuiles.get(tempot).setEtatTuile(EtatTuile.inondé);
                this.defossecartinond.add(this.getCartesinnond().get(0));
                popup = new JOptionPane();
                popup.showMessageDialog(null, "Vous avez pioché la carte inondation " + this.getCartesinnond().get(0).getTuile().getNom() + "\n Elle devient donc inondé ", "Attention", JOptionPane.WARNING_MESSAGE);
                this.cartesinnond.remove(0);

            } else if (this.grille.tuiles.get(tempot).getEtatTuile() == EtatTuile.inondé) {
                this.grille.tuiles.get(tempot).setEtatTuile(EtatTuile.disparue);
                popup = new JOptionPane();
                popup.showMessageDialog(null, "Vous avez pioché la carte inondation " + this.getCartesinnond().get(0).getTuile().getNom() + "\n Elle a donc disparue", "Attention", JOptionPane.WARNING_MESSAGE);
                this.cartesinnond.remove(0);
            }
            indcourant = indcourant + 1;
        }
    }

    public void traiterMessage(Message m) {
        String difficulte, joueur1, joueur2, joueur3, joueur4, action;

        switch (m.type) {
            case DEMARRER_PARTIE:
                difficulte = m.difficulte;
                if ("Novice".equals(difficulte)) {
                    setEchelle(new Echelle(1));
                }
                if ("Normal".equals(difficulte)) {
                    setEchelle(new Echelle(2));
                }
                if ("Elite".equals(difficulte)) {
                    setEchelle(new Echelle(3));
                }
                if ("Légendaire".equals(difficulte)) {
                    setEchelle(new Echelle(4));
                }

                int h = 0;

                ArrayList<String> randomrole = new ArrayList<>();
                randomrole = this.randomrole();

                for (String str : m.joueur) {

                    switch (randomrole.get(h)) {
                        case "Plongeur":

                            Plongeur plongeur = new Plongeur(str);

                            ArrayList<Tuile> l = this.grille.getTuiles();
                            Tuile a = l.get(this.grille.numTuile("La Porte de Fer"));
                            plongeur.setEmplacement(a);
                            this.joueurs.add(plongeur);

                            break;

                        case "Messager":

                            Messager messager = new Messager(str);
                            l = grille.getTuiles();
                            Tuile b = l.get(grille.numTuile("La Porte d’Argent"));
                            messager.setEmplacement(b);

                            this.joueurs.add(messager);

                            break;

                        case "Navigateur":

                            Navigateur navigateur = new Navigateur(str);
                            l = grille.getTuiles();
                            Tuile c = l.get(grille.numTuile("La Porte d’Or"));
                            navigateur.setEmplacement(c);

                            randomrole.remove(1);
                            this.joueurs.add(navigateur);

                            break;

                        case "Ingénieur":

                            Ingenieur ingenieur = new Ingenieur(str);
                            l = grille.getTuiles();
                            Tuile d = l.get(grille.numTuile("La Porte de Bronze"));
                            ingenieur.setEmplacement(d);

                            this.joueurs.add(ingenieur);

                            break;

                        case "Explorateur":

                            Explorateur explorateur = new Explorateur(str);
                            l = grille.getTuiles();
                            Tuile e = l.get(grille.numTuile("La Porte de Cuivre"));
                            explorateur.setEmplacement(e);

                            this.joueurs.add(explorateur);

                            break;

                        case "Pilote":

                            Pilote pilote = new Pilote(str);
                            l = grille.getTuiles();
                            Tuile f = l.get(grille.numTuile("Heliport"));
                            pilote.setEmplacement(f);

                            this.joueurs.add(pilote);

                            break;

                    }
                    h = h + 1;
                }

                System.out.println(joueurs);
                this.attributioncart();
                ihmDem.demarrerJeu();
                ihmDem.fermer();
                ihmAv = new newVueAventurier(joueurs.get(0), this);
                ihmAv.addObservateur(this);
                ihmAv.afficher();
                
                vuegrille = new VueGrille(this);
                vuegrille.afficher(); 
               // vuegrille.getWindow().setVisible(true);

                break;

            case JOUER_COUP:

                action = m.action;
                if ("seDeplacer".equals(action)) {
                    m.av.getEmplacement().affiche();
                    joueurs.get(numAventurier(m.av.getNom())).setEmplacement(m.tuile);

                    joueurs.get(numAventurier(m.av.getNom())).reduireNbAction();
                    m.av.getEmplacement().affiche();
                    ihmAv.fermer();
                    ihmAv.actualiser(this, m.av);
                    ihmAv.afficher();
                    vuegrille = new VueGrille(this);
                    vuegrille.afficher();
                    
                    if (m.av.getNbAction() == 0) {

                        joueurs.get(numAventurier(m.av.getNom())).rendrenbaciton();
                        ihmAv.fermer();

                        //Tirelescartesinondations
                        TirageCarteInondation();
                        //Mettre a jour la grille +
                        tirercartetresor(joueurs.get(numAventurier(m.av.getNom())));

                        this.ihmAv = new newVueAventurier(joueursuivant(m.av), this);
                        ihmAv.addObservateur(this);
                        ihmAv.afficher();
                    }
                }
                if ("voir".equals(action)) {
                    this.ihmcarte = new VueDeck(m.av, Boolean.FALSE);
                    ihmcarte.addObservateur(this);
                    ihmcarte.afficher();
                }
                if ("prendre".equals(action)) {
                    JOptionPane popup;
                    prendretresor(m.av);
                    ihmcarte.actualiser(m.av, Boolean.FALSE);
                    joueurs.get(numAventurier(m.av.getNom())).reduireNbAction();
                    popup = new JOptionPane();
                    popup.showMessageDialog(null, "Felicatation vous avez obtenue le tresor " + m.av.getEmplacement().getTrésor().getNom(), "Attention", JOptionPane.WARNING_MESSAGE);
                    ihmAv.fermer();
                    ihmAv.actualiser(this, m.av);
                    ihmAv.afficher();
                     vuegrille = new VueGrille(this);
                    vuegrille.afficher();

                    if (m.av.getNbAction() == 0) {

                        joueurs.get(numAventurier(m.av.getNom())).rendrenbaciton();
                        ihmAv.fermer();

                        //Tirelescartesinondations
                        TirageCarteInondation();
                        //Mettre a jour la grille +

                        //Tirercartestresor
                        tirercartetresor(joueurs.get(numAventurier(m.av.getNom())));

                        this.ihmAv = new newVueAventurier(joueursuivant(m.av), this);
                        ihmAv.addObservateur(this);
                        ihmAv.afficher();
                    }

                }
                if ("donner".equals(action)) {

                }
                if ("carteHeli".equals(action)) {

                }
                if ("carteSac".equals(action)) {
                    JOptionPane popup;
                    int numtuile = grille.numTuile(m.tuile.getNom());
                    this.grille.tuiles.get(numtuile).setEtatTuile(EtatTuile.seche);
                    popup = new JOptionPane();
                    popup.showMessageDialog(null, "Vous avez seché la tuile  " + m.tuile.getNom(), "Attention", JOptionPane.WARNING_MESSAGE);

                    supprimecarte(joueurs.get(numAventurier(m.av.getNom())), m.cartetresor);

                    ihmAv.fermer();
                    //Actualiser la grille
                    ihmAv.actualiser(this, m.av);
                    ihmAv.afficher();
                     vuegrille = new VueGrille(this);
                    vuegrille.afficher();

                    if (m.av.getNbAction() == 0) {

                        joueurs.get(numAventurier(m.av.getNom())).rendrenbaciton();
                        ihmAv.fermer();

                        //Tirelescartesinondations
                        TirageCarteInondation();
                        //Mettre a jour la grille +
                        tirercartetresor(joueurs.get(numAventurier(m.av.getNom())));

                        this.ihmAv = new newVueAventurier(joueursuivant(m.av), this);
                        ihmAv.addObservateur(this);
                        ihmAv.afficher();

                    }

                }
                if ("assecher".equals(action)) {
                    JOptionPane popup;
                    if (m.av.getRole() == "Ingénieur") {
                        int numtuile2 = grille.numTuile(m.tuile2.getNom());
                        this.grille.tuiles.get(numtuile2).setEtatTuile(EtatTuile.seche);
                        popup = new JOptionPane();
                        popup.showMessageDialog(null, "Vous avez seché la tuile  " + m.tuile2.getNom(), "Attention", JOptionPane.WARNING_MESSAGE);
                        //Actualiser la grille
                         vuegrille = new VueGrille(this);
                    vuegrille.afficher();

                    }
                    int numtuile = grille.numTuile(m.tuile.getNom());
                    this.grille.tuiles.get(numtuile).setEtatTuile(EtatTuile.seche);
                    popup = new JOptionPane();
                    popup.showMessageDialog(null, "Vous avez seché la tuile  " + m.tuile.getNom(), "Attention", JOptionPane.WARNING_MESSAGE);
                    joueurs.get(numAventurier(m.av.getNom())).reduireNbAction();
                    ihmAv.fermer();
                    //Actualiser la grille
                    ihmAv.actualiser(this, m.av);
                    ihmAv.afficher();

                    if (m.av.getNbAction() == 0) {

                        joueurs.get(numAventurier(m.av.getNom())).rendrenbaciton();
                        ihmAv.fermer();

                        //Tirelescartesinondations
                        TirageCarteInondation();
                        //Mettre a jour la grille +
                        tirercartetresor(joueurs.get(numAventurier(m.av.getNom())));

                        this.ihmAv = new newVueAventurier(joueursuivant(m.av), this);
                        ihmAv.addObservateur(this);
                        ihmAv.afficher();

                    }

                }
                if ("passerTour".equals(action)) {

                    ihmAv.fermer();

                    //Tirelescartesinondations
                    TirageCarteInondation();
                    //Mettre a jour la grille +
                    tirercartetresor(joueurs.get(numAventurier(m.av.getNom())));

                    this.ihmAv = new newVueAventurier(joueursuivant(m.av), this);
                    ihmAv.addObservateur(this);
                    ihmAv.afficher();
                }

                if ("defosser".equals(action)) {

                    supprimecarte(joueurs.get(numAventurier(m.av.getNom())), m.cartetresor);

                    ihmcarte.fermer();
                    ihmcarte = new VueDeck(this.joueurs.get(numAventurier(m.av.getNom())), Boolean.FALSE);

                    ihmcarte.afficher();

                }
                break;

        }
    }

    public void tirercartetresor(Aventurier av) {
        //si la liste est vide
        if(this.cartes.isEmpty()){
            this.cartes = (ArrayList<CarteTresor>) defosse.clone();
            Collections.shuffle(cartes);
        }

        int num = 0;
        if (this.getCartes().get(0).getType() == "Montée des eaux") {
            System.out.println("Vous avez pioché une carte monté des eaux");
            JOptionPane popup;
            popup = new JOptionPane();
            popup.showMessageDialog(null, "Vous avez pioché une cartes montée des eaux  le niveau d'eau est desormais de  " + this.echelle.getNiveau(), "Attention", JOptionPane.WARNING_MESSAGE);
            this.defosse.add(this.getCartes().get(0));
            this.cartes.remove(0);

            this.echelle.Monter();
        } else {

            av.cartes.add(this.getCartes().get(0));
            this.cartes.remove(0);

            if (av.getCartes().size() > 6) {
                System.out.println("Vous avez trop de carte veuillez défosser");
                this.ihmcarte = new VueDeck(av, Boolean.TRUE);
                JOptionPane popup;
                popup = new JOptionPane();
                popup.showMessageDialog(null, "Veuillez défossé une carte" , "Attention", JOptionPane.WARNING_MESSAGE);
                ihmcarte.afficher();
                ihmcarte.addObservateur(this);

            } else {
                JOptionPane popup;
                popup = new JOptionPane();
                popup.showMessageDialog(null, "Vous avez obtenu la carte" + this.getCartes().get(0), "Attention", JOptionPane.WARNING_MESSAGE);
            }

        }

    }

}
