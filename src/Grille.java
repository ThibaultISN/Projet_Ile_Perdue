
import java.util.*;

public class Grille {

    ArrayList tuiles = new ArrayList<Tuile>();

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

    public Position générateurpositionrandom() {
        Position randompos = new Position();
        int Min = 0;
        int Max = 5;

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

        while ( positionnul.contains(randompos)){
            randompos.setX(Min + (int) (Math.random() * ((Max - Min) + 1)));
            randompos.setY(Min + (int) (Math.random() * ((Max - Min) + 1)));
            }


        return randompos;



    }

    public void générationgrille() {

        ArrayList<String> nomtuiles = new ArrayList<String>();
        nomtuiles.add("Le Pont des Abimes");
        nomtuiles.add("La Porte de Bronze");
        nomtuiles.add("La Caverne des Ombres");
        nomtuiles.add("La Porte de Fer");
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

        for (String i : nomtuiles) {
            // while (i < nomtuiles.size()){
            ArrayList<Position> positionoccupé = new ArrayList<>(); //Liste des positions non disponible
            Position pos = générateurpositionrandom(); // génere une position aléatoire
            //--------------------------------------------
            boolean param3 = true;
            // tant que la position généré appartient a la liste des position non dispo regenéré la pos

            while (param3==false){

                 pos = générateurpositionrandom();
                param3=(positionoccupé.contains(pos));




                }

            // si la carte correspond a un emplacement trésor utiliser une autre méthode
             if( "La Caverne des Ombres".equals(i) || "La Caverne du Brasier".equals(i) ){
                 Trésor Flamme = new Trésor("flamme");
                 Tuile x = new Tuile(i,Flamme,pos);
                 tuiles.add(x);
             }
             else if( "Le Temple du Soleil".equals(i) || "Le Temple de La Lune".equals(i) ){
                Trésor Lune = new Trésor("lune");
                 Tuile x = new Tuile(i,Lune,pos);
                 tuiles.add(x);//
            }
             else if( "Le Jardin des Hurlements".equals(i) || "Le Jardin des Murmures".equals(i) ){
                Trésor Lion = new Trésor("lion");
                 Tuile x = new Tuile(i,Lion,pos);
                 tuiles.add(x);//
            }
             else if( "Le Palais de Corail".equals(i) || "Le Palais des Marees".equals(i) ){
                Trésor Coupe = new Trésor("coupe");
                 Tuile x = new Tuile(i,Coupe,pos);
                 tuiles.add(x);//
            }
             else {
                 Tuile x = new Tuile(i,pos);
                 tuiles.add(x);
             }


            positionoccupé.add(pos); //Cette position n'est désormais plus disponible


            }

















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
