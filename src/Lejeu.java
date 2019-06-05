
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre de joeur ( entre 2 et 4 )");
        String str = sc.nextLine();
        //while (str !="2" || str!="3" || str!="4"){
        int nbj = Integer.parseInt(str);
        while (nbj > 4 || nbj < 2) {
            System.out.println("Valeur saisit incorrect \n");
            System.out.println("Veuillez saisir le nombre de joeur ( entre 2 et 4 )");
            str = sc.nextLine();
        }

        //for (int i = 0 ; i< nbj; i++){
        int j = 0;
        while (j < nbj) {
            ArrayList<String> randomrole = new ArrayList<>();
            randomrole = controleur.randomrole();
            int numero = j + 1;
            int h = 0;
            switch (randomrole.get(h)) {
                case "Plongeur":
                    Plongeur plongeur = new Plongeur();
                    controleur.getJoueurs().add(plongeur);
                    ArrayList<Tuile> l = g.getTuiles();
                    Tuile a = l.get(g.numTuile("La Porte de Fer"));
                    plongeur.setEmplacement(a);
                    System.out.println("Joueur n°" + numero + " Vous etes plongeur");
                    h = h + 1;
                    break;

                case "Messager":
                    Messager messager = new Messager();
                    l = g.getTuiles();
                    Tuile b = l.get(g.numTuile("La Porte d’Argent"));
                    messager.setEmplacement(b);
                    System.out.println("Joueur n°" + numero + " Vous etes messager");
                    controleur.getJoueurs().add(messager);
                    h = h + 1;
                    break;

                case "Navigateur":
                    Navigateur navigateur = new Navigateur();
                    l = g.getTuiles();
                    Tuile c = l.get(g.numTuile("La Porte d’Or"));
                    navigateur.setEmplacement(c);
                    System.out.println("Joueur n°" + numero + " Vous etes navigateur");
                    randomrole.remove(1);
                    controleur.getJoueurs().add(navigateur);
                    h = h + 1;
                    break;

                case "Ingénieur":
                    Ingenieur ingenieur = new Ingenieur();
                    l = g.getTuiles();
                    Tuile d = l.get(g.numTuile("La Porte de Bronze"));
                    ingenieur.setEmplacement(d);
                    System.out.println("Joueur n°" + numero + " Vous etes ingenieur");
                    controleur.getJoueurs().add(ingenieur);
                    h = h + 1;
                    break;

                case "Explorateur":
                    Explorateur explorateur = new Explorateur();
                    l = g.getTuiles();
                    Tuile e = l.get(g.numTuile("La Porte de Cuivre"));
                    explorateur.setEmplacement(e);
                    System.out.println("Joueur n°" + numero + " Vous etes explorateur");
                    controleur.getJoueurs().add(explorateur);
                    h = h + 1;
                    break;

                case "Pilote":
                    Pilote pilote = new Pilote();
                    l = g.getTuiles();
                    Tuile f = l.get(g.numTuile("Heliport"));
                    pilote.setEmplacement(f);
                    System.out.println("Joueur n°" + numero + " Vous etes pilote");
                    controleur.getJoueurs().add(pilote);
                    h = h + 1;
                    break;

            }
            j = j + 1;

        }
        controleur.attributioncart();

        controleur.Carteterraingen();
        controleur.initterrain();

        //Parametrage de la difficulté
        sc = new Scanner(System.in);
        System.out.println("Veuillez saisir difficulté désiré \n "
                + "1- Novice\n" + "2-Normal\n" + "3-Elite\n" + "4-Legendair\n");
        String dif = sc.nextLine();
        int difficulte = Integer.parseInt(dif);
        while (difficulte < 1 || difficulte > 4) {
            System.out.println("Valeur saisit incorrect \n");

            System.out.println("Veuillez saisir difficulté désiré \n "
                    + "1- Novice\n" + "2-Normal\n" + "3-Elite\n" + "4-Legendair\n");
            dif = sc.nextLine();
            difficulte = Integer.parseInt(dif);

        }

        switch (difficulte) {
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

        }

        System.out.println("LA PARTIE VA DEBUTE\n");
        System.out.println(controleur.getJoueurs().size());

        while (true) {

            for (Aventurier av : controleur.getJoueurs()) {
                int nbaction = 0;
                System.out.println("C'est au tour de " + av.getNom() + "\n");
                while (nbaction <= 3) {
                    sc = new Scanner(System.in);
                    System.out.println("\n Veuillez saisir votre action \n "
                            + "1- Voir mes cartes \n"
                            + "2-Me déplacer\n"
                            + "3-Donner une carte\n"
                            + "4-Assecher une tuile\n"
                            + "5-Utiliser carte helicoptere"
                            + "6- Utiliser une carte sac de sable");
                    String act = sc.nextLine();
                    int numact = Integer.parseInt(act);
                    while (numact < 1 || numact > 6) {
                        System.out.println("Valeur saisit incorrect \n");
                        System.out.println("Veuillez saisir votre action \n "
                                + "1- Voir mes cartes \n"
                                + "2-Me déplacer\n"
                                + "3-Donner une carte\n"
                                + "4-Assecher une tuile\n"
                                + "5-Utiliser carte helicoptere"
                                + "6- Utiliser une carte sac de sable");
                        act = sc.nextLine();
                        numact = Integer.parseInt(act);

                    }
                    
                    switch(numact){
                        case 1: av.afficherCarte(); break; 
                        case 2:
                             System.out.println("Vous pouvez aller sur ces cases");
                            //for(Tuile t : controleur.tuilepossibledep(av)){
                            //t.affiche();
                       // }   
                             controleur.affichetuilepossibledep(av);
                            sc = new Scanner(System.in);
                            System.out.println("Saisir le nom de la tuile destination (Bien saisir le nom de la tuile) ");
                            String tui = sc.nextLine();
                            int index = controleur.grille.numTuile(tui);
                            av.setEmplacement(controleur.grille.tuiles.get(index));
                            nbaction=nbaction+1;
                            break;
                        case 3:
                            sc = new Scanner(System.in);
                            System.out.println("A qui voulez vous donner la carte ? \n");
                            controleur.afficherJoueur();
                            String nomj = sc.nextLine();
                            int indexj = controleur.numAventurier(nomj);
                            Aventurier arec = controleur.getJoueurs().get(indexj);
                            System.out.println("Quel carte souhaitez vous donner \n");
                            av.afficherCarte();
                             String nomca = sc.nextLine();
                             int indexc = av.numcarte(nomca);
                             CarteTresor ct = av.cartes.get(indexc);
                            if (controleur.PossibleDon(arec,av,ct)){
                                controleur.donCarte(arec,av,ct);
                                nbaction=nbaction+1;
                            } 
                            else{
                                System.out.println("Impossible de faire le don");
                            }
                            break;
                        case 4 :
                             System.out.println("Vous pouvez assechez sur ces case");
                            for(Tuile t : controleur.tuileassechable(av)){
                            t.affiche();
                                    
                        }   
                            sc = new Scanner(System.in);
                            System.out.println("Saisir le nom de la tuile destination (Bien saisir le nom de la tuile ");
                             tui = sc.nextLine();
                             index = controleur.grille.numTuile(tui);
                             Tuile tuileass = controleur.grille.tuiles.get(index);
                            controleur.assecher(tuileass, av);
                            
                            if(av.getRole()=="Ingenieur"){
                                sc = new Scanner(System.in);
                            System.out.println("Saisir le nom de la tuile destination (Bien saisir le nom de la tuile ");
                             tui = sc.nextLine();
                             index = controleur.grille.numTuile(tui);
                              tuileass = controleur.grille.tuiles.get(index);
                            controleur.assecher(tuileass, av);
                            nbaction=nbaction+1;
                            }
                            else {
                                nbaction=nbaction+1;
                            }
                            
                            
                           
                            break;
                            
                            
                            
                        
                            
                            
                            
                    }

                }
            }
        }

    }

}
