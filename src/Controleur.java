import java.util.*;

public class Controleur {

	Grille grille;
	Collection<Aventurier> joueurs;
	Collection<CarteTresor> cartes;
	Collection<CarteInondation> cartesinnond;
	Echelle echelle;

	/**
	 *
	 * @param nomjoueur
	 * @param cartetrésor
	 */
	public boolean PossibleDon(Aventurier nomjoueur, CarteTresor cartetrésor) {
		// TODO - implement Controleur.PossibleDon
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param tuile
	 * @param role
	 */
	public boolean Possibleasseche(Tuile tuile, Aventurier role) {
		// TODO - implement Controleur.Possibleasseche
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param parameter
	 */
	public boolean Possibletaketresor(int parameter) {
		// TODO - implement Controleur.Possibletaketresor
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param joueur
	 * @param tresor
	 */
	public boolean Possibleprisetrésor(Aventurier joueur, Trésor tresor) {
		// TODO - implement Controleur.Possibleprisetrésor
		throw new UnsupportedOperationException();
	}


        public void ChoixDifficultés(){
                                Scanner sc = new Scanner(System.in);

            System.out.println ("Quel difficulté voulez vous ? (Novice/Normal/Elite/Legendaire) \n");

            String str = sc.nextLine();

            while(              !"Novice".equals(str) ||!"Normal".equals(str) ||!"Elite".equals(str) ||!"Legendaire".equals(str)  ){
            System.out.println ("Veuillez saisir une difficulté proposer \n");
            System.out.println ("Quel difficulté voulez vous ? (Novice/Normal/Elite/Legendaire) \n");

             str = sc.nextLine();
        }

            Echelle ech = new Echelle(str);
            System.out.println("La difficulté a été initialisé à " + str +"`\n"
                    +" Niveau de l'eau :" + ech.getGraduation() + "\n");

        }
}
