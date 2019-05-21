
public class CarteInondation extends CarteTresor {

    private Tuile tuile;

    CarteInondation(Tuile tuile) {
        setTuile(tuile);
    }

    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }

    //@Override
    public void Piocher() {
        //piocher le nombre de cartes inondation seln le marqueur de niveau d'eau
        // size(3) --> int niveauEchelle et supprimer les verif nb cartes aventurier
    }

}
