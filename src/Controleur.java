
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
    
    public Controleur(){
        
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
    
    public void donCarte(Aventurier joueurRec, Aventurier joueurEnv, CarteTresor cartetrésor){
        if(PossibleDon(joueurRec,joueurEnv,cartetrésor)){
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
        if (x.getRole() == "Explorateur") {
            if ((x.estcontigue(tuile) || x.estcontigue(tuile)) && tuile.getEtatTuile() == EtatTuile.inondé) {
                return true;
            } else {
                return false;
            }
        } else {
            if (x.estcontigue(tuile) && tuile.getEtatTuile() == EtatTuile.inondé) {
                return true;
            } else {
                return false;
            }
        }
    }
    public void assecher(Tuile tuile,Aventurier x){
        if(Possibleasseche(tuile,x)){
            tuile.setEtatTuile(EtatTuile.seche);
        }
    }
    
     public void prendretrésor(Aventurier joueur,Tresor trésor) {
		
         //V2
         if ( Possibleprisetrésor(joueur, trésor)){
             joueur.addTresor(trésor);
         }
         
        }

   
    public boolean Possibleprisetrésor(Aventurier joueur, Tresor tresor) {
        // TODO - implement Controleur.Possibleprisetrésor
        int i = 0;
        boolean a = false;
        for (CarteTresor c : joueur.cartes) {
            if (c.getT() == tresor) {
                i = i + 1;
            }
        }
        if (i >= 4) {
            for (Tuile t : grille.TuileTresor(tresor)) {
                if (joueur.getEmplacement() == t && t.getEtatTuile() != EtatTuile.disparue) {
                    a = true;

                } else {
                    a = false;

                }
            }
        } else {
            a = false;

        }
        return a;

    }
    
    public ArrayList<String> randomrole(){
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
    
    public  void Initialisation(){
        boolean a = true ;
    } 
   
    
    
    
    
}



