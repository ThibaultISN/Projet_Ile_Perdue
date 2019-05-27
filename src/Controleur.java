
import java.util.*;

public class Controleur {

    Grille grille;
    Collection<Aventurier> joueurs;
    Collection<CarteTresor> cartes;
    Collection<CarteInondation> cartesinnond;
    Echelle echelle;
    int a;

    /**
     *
     * @param nomjoueur
     * @param cartetrésor
     */
    public boolean PossibleDon(Aventurier joueurRec, Aventurier joueurEnv, CarteTresor cartetrésor) {
        // TODO - implement Controleur.PossibleDon
        if (joueurEnv.getRole() == "Messager") {
            if (joueurEnv.carte.contains(cartetrésor)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (joueurEnv.getTuile() == joueurRec.getTuile() && joueurEnv.carte.contains(cartetrésor)) {
                return true;
            } else {
                return false;
            }
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
            if ((x.estContigue(tuile) || x.estDiagonale(tuile)) && tuile.getEtatTuile() == innonde) {
                return true;
            } else {
                return false;
            }
        } else {
            if (x.estContigue(tuile) && tuile.getEtatTuile() == innonde) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     *
     * @param joueur
     * @param tresor
     */
    public boolean Possibleprisetrésor(Aventurier joueur, Trésor tresor) {
        // TODO - implement Controleur.Possibleprisetrésor

        for (CarteTresor c : joueur.cartes) {
            if (c.getT() == tresor) {
                i = i + 1;
            }
        }
        if (i >= 4) {
            for (Tuile t : grille.TuileTresor(tresor)) {
                if (joueur.getTuile() == t && t.getEtatTuile() != disparue) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

    }
