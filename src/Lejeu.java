
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

            switch (randomrole.get(j)) {
                case "Plongeur":
                    Plongeur plongeur = new Plongeur();
                    ArrayList<Tuile> l = g.getTuiles();
                    Tuile a = l.get(g.numTuile("La Porte de Fer"));
                    plongeur.setEmplacement(a);
                    System.out.println("Joueur n°" + numero + " Vous etes plongeur");
                    break;

                case "Messager":
                    Messager messager = new Messager();
                    l = g.getTuiles();
                    Tuile b = l.get(g.numTuile("La Porte d’Argent"));
                    messager.setEmplacement(b);
                    System.out.println("Joueur n°" + numero + " Vous etes messager");
                    break;
                    
                case "Navigateur":
                    Navigateur navigateur = new Navigateur();
                    l = g.getTuiles();
                    Tuile c = l.get(g.numTuile("La Porte d’Or"));
                    navigateur.setEmplacement(c);
                    System.out.println("Joueur n°" + numero + " Vous etes navigateur");
                    l = g.getTuiles();
                    break;
                    
                case "Ingenieur":
                    Ingenieur ingenieur = new Ingenieur();
                    l = g.getTuiles();
                    Tuile d = l.get(g.numTuile("La Porte de Bronze"));
                    ingenieur.setEmplacement(d);
                    System.out.println("Joueur n°" + numero + " Vous etes ingenieur");
                    break;

                case "Explorateur":
                    Explorateur explorateur = new Explorateur();
                    l = g.getTuiles();
                    Tuile e = l.get(g.numTuile("La Porte de Cuivre"));
                    explorateur.setEmplacement(e);
                    System.out.println("Joueur n°" + numero + " Vous etes explorateur");
                    break;

                case "Pilote":
                    Pilote pilote = new Pilote();
                    l = g.getTuiles();
                    Tuile f = l.get(g.numTuile("Heliport"));
                    pilote.setEmplacement(f);
                    System.out.println("Joueur n°" + numero + " Vous etes pilote");
                     break;

            }
            j = j + 1;

        }

        //---------------------------------------------
    }

}
