
import java.util.*;

public class Grille {

    ArrayList tuiles = new ArrayList<Tuile>();
    
    Grille(ArrayList tuiles) {
        setTuiles(tuiles);
        
            
    }

    //faire une méthode est contigueu 
    public ArrayList getTuiles() {
        return tuiles;
    }

    public void setTuiles(ArrayList tuiles) {
        this.tuiles = tuiles;
    }

    public Position générateurpositionrandom() {
        Position randompos = new Position();
        int Min = 0;
        int Max = 6;

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

        randompos.setX(Min + (int) (Math.random() * ((Max - Min) + 1)));
        randompos.setY(Min + (int) (Math.random() * ((Max - Min) + 1)));

        boolean a = positionnul.contains(randompos);

        while (a = true) {  // Tant que la position généré est une case destiné a etre vide généré aléatoire la position

            randompos.setX(Min + (int) (Math.random() * ((Max - Min) + 1)));
            randompos.setY(Min + (int) (Math.random() * ((Max - Min) + 1)));
            a = positionnul.contains(randompos);
        }

        return randompos;

    }

    public void générationgrille() { 

        ArrayList<String> nomtuiles = new ArrayList<String>();
        nomtuiles.add("Le Pont des Abimes");
        nomtuiles.add("La Porte de Bronze");
        nomtuiles.add("La Caverne des Ombres\"");
        nomtuiles.add("\"La Porte de Fer\"");
        nomtuiles.add("La Porte d’Or");
        nomtuiles.add("Les Falaises de l’Oubli");
        nomtuiles.add("Le Palais de Corail");
        nomtuiles.add("La Porte d’Argent");
        nomtuiles.add("Les Dunes de l’Illusion");
        nomtuiles.add("Heliport");
        nomtuiles.add("La Porte de Cuivre");
        nomtuiles.add("Le Jardin des Hurlements");
        nomtuiles.add("La Foret Pourpre");
        nomtuiles.add("Le Lagon Perdu");
        nomtuiles.add("Le Marais Brumeux");
        nomtuiles.add("Observatoire");
        nomtuiles.add("Le Rocher Fantome");
        nomtuiles.add("La Caverne du Brasier");
        nomtuiles.add("Le Temple du Soleil");
        nomtuiles.add("Le Temple de La Lune");
        nomtuiles.add("Le Palais des Marees");
        nomtuiles.add("Le Val du Crepuscule");
        nomtuiles.add("La Tour du Guet");
        nomtuiles.add("Le Jardin des Murmures");
        nomtuiles.add("Le Jardin des Murmures");

        for (String i : nomtuiles) {
            // while (i < nomtuiles.size()){

            ArrayList<Position> positionoccupé = new ArrayList<>(); //Liste des positions non disponible

            Position pos = générateurpositionrandom(); // génere une position aléatoire 
            boolean b = positionoccupé.contains(pos);

            while (b = true) {  // Tant que la position généré est une case non disponible  a etre vide généré aléatoire la position

                pos = générateurpositionrandom();
                b = positionoccupé.contains(pos);
            }

            Tuile x = new Tuile(i, pos); //
            positionoccupé.add(pos); //Cette position n'est désormais plus disponible
            tuiles.add(x);

        }
        
        azeazeazeaz
                
                aze
                a
                        ze
                        az
                                e
azeazeazeazeaz                                        
        // Ajoute les tuiles vides 
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
        
        
        
        

    }
    
  
}
