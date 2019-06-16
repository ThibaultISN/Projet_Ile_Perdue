
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rabie
 */
public class Lejeu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Initialisation 
        Controleur controleur = new Controleur();
        Grille g = new Grille();
        g.générationgrille();
        controleur.setGrille(g);
        controleur.initterrain();

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre de joeur ( entre 2 et 4 )");
        String str = sc.nextLine();
        //while (str !="2" || str!="3" || str!="4"){
        int nbj = Integer.parseInt(str);
        while (nbj > 4 || nbj < 2) {
            System.out.println("Valeur saisit incorrect ");
            System.out.println("Veuillez saisir le nombre de joeur ( entre 2 et 4 )");
            str = sc.nextLine();
        }

        //for (int i = 0 ; i< nbj; i++){
        int j = 0;
        ArrayList<String> randomrole = new ArrayList<>();
        randomrole = controleur.randomrole();
        int h = 0;
        while (j < nbj) {

            int numero = j + 1;

            switch (randomrole.get(h)) {
                case "Plongeur":
                    Scanner nm = new Scanner(System.in);
                    System.out.println(" Veuillez saisir votre nom");
                    String nomj = sc.nextLine();

                    Plongeur plongeur = new Plongeur(nomj);
                    controleur.getJoueurs().add(plongeur);

                    ArrayList<Tuile> l = g.getTuiles();
                    Tuile a = l.get(g.numTuile("La Porte de Fer"));
                    plongeur.setEmplacement(a);

                    System.out.println(plongeur.getNom() + " Vous etes plongeur");

                    break;

                case "Messager":
                    nm = new Scanner(System.in);
                    System.out.println(" Veuillez saisir votre nom ");
                    nomj = sc.nextLine();

                    Messager messager = new Messager(nomj);
                    l = g.getTuiles();
                    Tuile b = l.get(g.numTuile("La Porte d’Argent"));
                    messager.setEmplacement(b);
                    System.out.println(messager.getNom() + " Vous etes messager");
                    controleur.getJoueurs().add(messager);

                    break;

                case "Navigateur":
                    nm = new Scanner(System.in);
                    System.out.println(" Veuillez saisir votre nom ");
                    nomj = sc.nextLine();

                    Navigateur navigateur = new Navigateur(nomj);
                    l = g.getTuiles();
                    Tuile c = l.get(g.numTuile("La Porte d’Or"));
                    navigateur.setEmplacement(c);
                    System.out.println(navigateur.getNom() + " Vous etes navigateur");
                    randomrole.remove(1);
                    controleur.getJoueurs().add(navigateur);

                    break;

                case "Ingénieur":
                    nm = new Scanner(System.in);
                    System.out.println("Veuillez saisir votre nom");
                    nomj = sc.nextLine();

                    Ingenieur ingenieur = new Ingenieur(nomj);
                    l = g.getTuiles();
                    Tuile d = l.get(g.numTuile("La Porte de Bronze"));
                    ingenieur.setEmplacement(d);
                    System.out.println(ingenieur.getNom() + " Vous etes ingenieur");
                    controleur.getJoueurs().add(ingenieur);

                    break;

                case "Explorateur":
                    nm = new Scanner(System.in);
                    System.out.println(" Veuillez saisir votre nom");
                    nomj = sc.nextLine();

                    Explorateur explorateur = new Explorateur(nomj);
                    l = g.getTuiles();
                    Tuile e = l.get(g.numTuile("La Porte de Cuivre"));
                    explorateur.setEmplacement(e);

                    System.out.println(explorateur.getNom() + " Vous etes explorateur");
                    controleur.getJoueurs().add(explorateur);

                    break;

                case "Pilote":
                    nm = new Scanner(System.in);
                    System.out.println(" Veuillez saisir votre nom");
                    nomj = sc.nextLine();

                    Pilote pilote = new Pilote(nomj);
                    l = g.getTuiles();
                    Tuile f = l.get(g.numTuile("Heliport"));
                    pilote.setEmplacement(f);
                    System.out.println(pilote.getNom() + " Vous etes pilote");
                    controleur.getJoueurs().add(pilote);

                    break;

            }
            j = j + 1;
            h = h + 1;

        }

        controleur.attributioncart();

        controleur.setCartesinnond(controleur.Carteterraingen());
        controleur.initterrain();

        /* verif  System.out.println("===================================");
        controleur.affichegrille();
         System.out.println("===================================");
         */
        //Parametrage de la difficulté
        sc = new Scanner(System.in);
        System.out.println("Veuillez saisir difficulté désiré \n "
                + "1- Novice\n" + "2-Normal\n" + "3-Elite\n" + "4-Legendair");
        String dif = sc.nextLine();
        int difficulte = Integer.parseInt(dif);
        while (difficulte < 1 || difficulte > 4) {
            System.out.println("Valeur saisit incorrect \n");

            System.out.println("Veuillez saisir difficulté désiré \n "
                    + "1- Novice\n" + "2-Normal\n" + "3-Elite\n" + "4-Legendair");
            dif = sc.nextLine();
            difficulte = Integer.parseInt(dif);

        }

        /*switch (difficulte) {
            case 1:
                controleur.setEchelle(new Echelle("Novice"));
                System.out.println("Vous avez choisit Novice\n");
                break;
            case 2:
                controleur.setEchelle(new Echelle("Normal"));
                System.out.println("Vous avez choisit Normal\n");
                break;
            case 3:
                controleur.setEchelle(new Echelle("Elite"));
                System.out.println("Vous avez choisit Elite\n");
                break;
            case 4:
                controleur.setEchelle(new Echelle("Legendaire"));
                System.out.println("Vous avez choisit Legendaire\n");
                break;

        }*/
        controleur.affichegrille();

        System.out.println("LA PARTIE VA DEBUTE");
        System.out.println(controleur.getJoueurs().size());

        while (true) {

            for (Aventurier av : controleur.getJoueurs()) {
                
              
                int nbaction = 0;
                System.out.println("==================================================");
                System.out.println("C'est au tour de " + av.getNom() + " role : " + av.getRole());
                while (nbaction < 3) {
                    int actionrestante= 3-nbaction;
                    System.out.println("il vous reste " + actionrestante + " action(s)"  );
                    sc = new Scanner(System.in);
                    System.out.println("\n Veuillez saisir votre action \n "
                            + "1- Voir mes cartes \n"
                            + "2-Me déplacer\n"
                            + "3-Donner une carte\n"
                            + "4-Assecher une tuile\n"
                            + "5-Utiliser carte helicoptere \n"
                            + "6- Utiliser une carte sac de sable \n");
                    String act = sc.nextLine();
                    int numact = Integer.parseInt(act);
                    while (numact < 1 || numact > 6) {
                        System.out.println("Valeur saisit incorrect \n");
                        System.out.println("Veuillez saisir votre action \n "
                                + "1- Voir mes cartes \n"
                                + "2-Me déplacer\n"
                                + "3-Donner une carte\n"
                                + "4-Assecher une tuile\n"
                                + "5-Utiliser carte helicoptere\n"
                                + "6- Utiliser une carte sac de sable\n"
                                + "7- Connaitr ma position \n");
                        act = sc.nextLine();
                        numact = Integer.parseInt(act);

                    }

                    switch (numact) {
                        case 1:
                            av.afficherCarte();
                            break;
                        case 2:

                            System.out.println("Vous etes positionné en ");
                            av.getEmplacement().affiche();

                            System.out.println("\n Vous pouvez aller sur ces cases : ");
                            //for(Tuile t : controleur.tuilepossibledep(av)){
                            //t.affiche();
                            // }   
                            controleur.affichetuilepossibledep(av);

                            sc = new Scanner(System.in);
                            System.out.println("\n Saisir le numéro de la case");
                            String bbb = sc.nextLine();
                            int tui = Integer.parseInt(bbb);
                            av.setEmplacement(controleur.tuilepossibledep(av).get(tui-1));
                            
                            

                            System.out.println("Vous etes positionné en ");
                            av.getEmplacement().affiche();

                            nbaction = nbaction + 1;
                            break;
                        case 3:
                            sc = new Scanner(System.in);
                            System.out.println("A qui voulez vous donner la carte ? (Saisir le numero)  \n");

                            controleur.afficherJoueur();

                            bbb = sc.nextLine();
                            tui = Integer.parseInt(bbb);
                            int indexarec = 0;
                            switch (tui) {
                                case 1:
                                    indexarec = 0;
                                    break;
                                case 2:
                                    indexarec = 1;
                                    break;
                                case 3:
                                    indexarec = 2;
                                    break;
                                case 4:
                                    indexarec = 3;
                                    break;
                            }

                            System.out.println("Quel carte souhaitez vous donner \n");
                            av.afficherCarte();
                            bbb = sc.nextLine();
                            tui = Integer.parseInt(bbb);
                            int indexcarte = 0;
                            switch (tui) {
                                case 1:
                                    indexcarte = 0;
                                    break;
                                case 2:
                                    indexcarte = 1;
                                    break;
                                case 3:
                                    indexcarte = 2;
                                    break;
                                case 4:
                                    indexcarte = 3;
                                    break;
                                case 5:
                                    indexcarte = 4;
                                    break;

                            }

                            if (controleur.PossibleDon(controleur.joueurs.get(indexarec), av, av.cartes.get(indexcarte))) {
                                controleur.donCarte(controleur.joueurs.get(indexarec), av, av.cartes.get(indexcarte));
                                System.out.println("Don effectué la carte " + av.cartes.get(indexcarte).getType() + " a étais envoyé à " + controleur.joueurs.get(indexarec).getNom());
                                nbaction = nbaction + 1;
                            } else {
                                System.out.println("Impossible de faire le don");
                            }
                            break;
                        case 4:
                            ArrayList<Tuile> zoizo = controleur.tuileassechable(av);
                            if (zoizo.isEmpty()) {
                                System.out.println("Aucune case à secher a proximité");
                            } else {
                                System.out.println("Vous etes positionné en ");av.getEmplacement().affiche();
                                System.out.println("Vous pouvez assechez ces case");

                                controleur.affichetuileassechable(av);
                                sc = new Scanner(System.in);
                                System.out.println("Saisir le numero de la tuile a secher ");

                                bbb = sc.nextLine();
                                tui = Integer.parseInt(bbb);
                                int indext = 0;
                                switch (tui) {
                                    case 1:
                                        indext = 0;
                                        break;
                                    case 2:
                                        indext = 1;
                                        break;
                                    case 3:
                                        indext = 2;
                                        break;
                                    case 4:
                                        indext = 3;
                                        break;
                                    case 5:
                                        indext = 4;
                                        break;
                                    case 6:
                                        indext = 5;
                                        break;
                                    case 7:
                                        indext = 6;
                                        break;
                                    case 8:
                                        indext = 7;
                                        break;
                                    case 9:
                                        indext = 8;
                                        break;

                                }

                                if (av.getRole() == "Ingenieur") {
                                    sc = new Scanner(System.in);

                                    int numtuile = controleur.grille.numTuile(controleur.tuileassechable(av).get(indext).getNom());

                                    controleur.grille.tuiles.get(numtuile).setEtatTuile(EtatTuile.seche);
                                    System.out.println("Update :");
                                    controleur.grille.tuiles.get(numtuile).affiche();
                                    if (!controleur.tuileassechable(av).isEmpty()) {

                                        System.out.println("2e assechement Vous pouvez assechez sur ces case");
                                        controleur.affichetuileassechable(av);
                                        sc = new Scanner(System.in);
                                        System.out.println("Saisir le numero de la tuile a secher ");

                                        bbb = sc.nextLine();
                                        tui = Integer.parseInt(bbb);

                                        switch (tui) {
                                            case 1:
                                                indext = 0;
                                                break;
                                            case 2:
                                                indext = 1;
                                                break;
                                            case 3:
                                                indext = 2;
                                                break;
                                            case 4:
                                                indext = 3;
                                                break;
                                            case 5:
                                                indext = 4;
                                                break;
                                            case 6:
                                                indext = 5;
                                                break;
                                            case 7:
                                                indext = 6;
                                                break;
                                            case 8:
                                                indext = 7;
                                                break;
                                            case 9:
                                                indext = 8;
                                                break;
                                        }
                                    }
                                    nbaction = nbaction + 1;
                                }
                                else {
                                    int numtuile = controleur.grille.numTuile(controleur.tuileassechable(av).get(indext).getNom());

                                    controleur.grille.tuiles.get(numtuile).setEtatTuile(EtatTuile.seche);
                                    System.out.println("Update :");
                                    controleur.grille.tuiles.get(numtuile).affiche();
                                    
                                    nbaction = nbaction + 1;
                                }
                            }

                            break;

                        case 5 : break;
                        case 6 : if(av.cartes.contains(new CarteTresor("Sac de Sable"))){
                                 controleur.affichecaseinonde();
                                  sc = new Scanner(System.in);
                                        System.out.println("Saisir le numero de la tuile a secher ");

                                        bbb = sc.nextLine();
                                        tui = Integer.parseInt(bbb);
                                        int indext = tui-1;
                                        int numtuile = controleur.grille.numTuile(controleur.tuileassechable(av).get(indext).getNom());

                                    controleur.grille.tuiles.get(numtuile).setEtatTuile(EtatTuile.seche);
                                    System.out.println("Update :");
                                    controleur.grille.tuiles.get(numtuile).affiche();
                                 
                        }else{
                           System.out.println("Vous n'avez pas de carte sac de Sable ");
                        }
                                
                                
                                break;
                    }

                }
            }
        }

    }

}
