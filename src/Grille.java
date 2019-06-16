
import java.util.*;

public class Grille {

    ArrayList<Tuile> tuiles = new ArrayList<Tuile>();

    Grille() {
        setTuiles(tuiles);

    }

    //faire une méthode est contigueu
    public ArrayList getTuiles() {
        return tuiles;
    }

    public void setTuiles(ArrayList tuiles) {
        this.tuiles = tuiles;
    }

//    public Position générateurpositionrandom() {
//        Position randompos = new Position();
//        int Min = 0;
//        int Max = 5;
//
//        ArrayList<Position> positionnul = new ArrayList<Position>(); //Liste des positions destiné a etre vide
//
//        positionnul.add(new Position(0, 0));
//        positionnul.add(new Position(0, 1));
//        positionnul.add(new Position(1, 0));
//
//        positionnul.add(new Position(4, 0));
//        positionnul.add(new Position(5, 1));
//        positionnul.add(new Position(5, 0));
//
//        positionnul.add(new Position(0, 4));
//        positionnul.add(new Position(0, 5));
//        positionnul.add(new Position(1, 5));
//
//        positionnul.add(new Position(5, 4));
//        positionnul.add(new Position(4, 5));
//        positionnul.add(new Position(5, 5));
//
//        randompos.setX(Min + (int) (Math.random() * ((Max - Min) + 1)));
//        randompos.setY(Min + (int) (Math.random() * ((Max - Min) + 1)));
//
//        while ( positionnul.contains(randompos)){
//            randompos.setX(Min + (int) (Math.random() * ((Max - Min) + 1)));
//            randompos.setY(Min + (int) (Math.random() * ((Max - Min) + 1)));
//            }
//
//
//        return randompos;
//
//
//
//    }
    public void générationgrille() {

        ArrayList<Tuile> nomtuiles = new ArrayList<Tuile>();
        tuiles.add(new Tuile("Le Pont des Abimes", new Position(3, 1)));
        tuiles.add(new Tuile("La Porte de Bronze", new Position(4, 1)));
        tuiles.add(new Tuile("La Caverne des Ombres", new Tresor("Flamme"), new Position(2, 2)));
        tuiles.add(new Tuile("La Porte de Fer", new Position(3, 2)));
        tuiles.add(new Tuile("La Porte d’Or", new Position(4, 2)));
        tuiles.add(new Tuile("Les Falaises de l’Oubli", new Position(5, 2)));
        tuiles.add(new Tuile("Le Palais de Corail", new Tresor("Coupe"), new Position(1, 3)));
        tuiles.add(new Tuile("La Porte d’Argent", new Position(2, 3)));
        tuiles.add(new Tuile("Les Dunes de l’Illusion", new Position(3, 3)));
        tuiles.add(new Tuile("Heliport", new Position(4, 3)));
        tuiles.add(new Tuile("La Porte de Cuivre", new Position(5, 3)));
        tuiles.add(new Tuile("Le Jardin des Hurlements", new Tresor("Lion"), new Position(6, 3)));
        tuiles.add(new Tuile("La Foret Pourpre", new Position(1, 4)));
        tuiles.add(new Tuile("Le Lagon Perdu", new Position(2, 4)));
        tuiles.add(new Tuile("Le Marais Brumeux", new Position(3, 4)));
        tuiles.add(new Tuile("Observatoire", new Position(4, 4)));
        tuiles.add(new Tuile("Le Rocher Fantome", new Position(5, 4)));
        tuiles.add(new Tuile("La Caverne du Brasier", new Tresor("Flamme"), new Position(6, 4)));
        tuiles.add(new Tuile("Le Temple du Soleil", new Tresor("Lune"), new Position(2, 5)));
        tuiles.add(new Tuile("Le Temple de La Lune", new Tresor("Lune"), new Position(3, 5)));
        tuiles.add(new Tuile("Le Palais des Marees", new Tresor("Coupe"), new Position(4, 5)));
        tuiles.add(new Tuile("Le Val du Crepuscule", new Position(5, 5)));
        tuiles.add(new Tuile("La Tour du Guet", new Position(3, 6)));
        tuiles.add(new Tuile("Le Jardin des Murmures", new Tresor("Lion"), new Position(4, 6)));

    }

    public ArrayList<Tuile> TuileTresor(Tresor trésor) {
        ArrayList<Tuile> list = new ArrayList<>();
        Boolean a;
        for (Tuile t : tuiles) {
            if (t.getTrésor() == trésor) {
                list.add(t);

            }

        }
        return list;
    }
    //marche pas 
    public int numTuile(String nom) {
        int i = 0;
        ArrayList<Tuile> liste = getTuiles();
        while (i < liste.size() && liste.get(i).getNom() != nom) {
            i = i + 1;
        }
        return i;
    }

    public ArrayList<Tuile> tuilenonvide() {
        ArrayList<Tuile> list = new ArrayList<>();
        for (Tuile t : tuiles) {
            if (t.getNom() != "Nul") {
                list.add(t);
            }
        }
        return list;
    }

    

}

/* // Ajoute les tuiles vides
        tuiles.add(new Position(0, 0));
        tuiles.add(new Position(0, 1));
        tuiles.add(new Position(1, 0));

        tuiles.add(new Position(4, 0));
        tuiles.add(new Position(5, 1));
        tuiles.add(new Position(5, 0));

        tuiles.add(new Position(0, 4));
        tuiles.add(new Position(0, 5));
        tuiles.add(new Position(1, 5));

        tuiles.add(new Position(5, 4));
        tuiles.add(new Position(4, 5));
        tuiles.add(new Position(5, 5)); 
        
         ArrayList<Position> positionnul = new ArrayList<Position>(); //Liste des positions destiné a etre vide

        positionnul.add(new Position(0, 0));
        positionnul.add(new Position(0, 1));
        positionnul.add(new Position(1, 0));

        positionnul.add(new Position(4, 0));
        positionnul.add(new Position(5, 1));
        positionnul.add(new Position(5, 0));

        positionnul.add(new Position(0, 4));
        positionnul.add(new Position(0, 5));
        positionnul.add(new Position(1, 5));

        positionnul.add(new Position(5, 4));
        positionnul.add(new Position(4, 5));
        positionnul.add(new Position(5, 5));
        
        for(Position i : positionnul){
            tuiles.add(new Tuile(i));
        }






        }
   
 */
