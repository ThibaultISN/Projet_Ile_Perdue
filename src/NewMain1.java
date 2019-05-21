
import java.util.ArrayList;
import Grille.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author remulef
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
             Tuile(nom,pos);
             
             i=i+1;
         }
        // TODO code application logic here
    }
    
}
