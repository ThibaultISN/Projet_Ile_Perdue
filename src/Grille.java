import java.util.*;

public class Grille {

	ArrayList tuiles = new ArrayList<Tuile>();
        Grille(ArrayList tuiles){
            setTuiles(tuiles);
            
        }

    

    public ArrayList getTuiles() {
        return tuiles;
    }

    public void setTuiles(ArrayList tuiles) {
        this.tuiles = tuiles;
    }
    
    public Position générateurpositionrandom(){
        Position randompos = new Position();
        int Min = 0 ;
        int Max = 6 ;
        
        randompos.setX( Min + (int)(Math.random() * ((Max - Min) + 1)) ); 
        randompos.setY( Min + (int)(Math.random() * ((Max - Min) + 1)) );
        
        return randompos;
             
    }
    public void attributionnom(){
            
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
    
  
    
    int i = 0; 
 
         while (i < nomtuiles.size()){
             
             String nom = nomtuiles.get(i);
             Position pos = générateurpositionrandom();
             
             ArrayList<Tuile> listuilenonvide = new ArrayList<>();
             
              Tuile x =new Tuile(nom,pos);
              listuilenonvide.add(x);
             
             i=i+1;
         }


    
    }

    