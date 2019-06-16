import java.util.*;


public class Plongeur extends Aventurier {

        Collection<CarteTresor> carte;
	private Tuile emplacement;
	private String Nom;
	private int nbAction;
	private Boolean enVie;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }
        
        
        Plongeur(String nom){
            super.setNom(nom);
            super.setRole("Plongeur");
        }
        
         public Plongeur(){
         super.setRole("Plongeur");
        }
	public void plonger(Tuile tuile) {
		// TODO - implement Plonguer.plonger
                setEmplacement(tuile);
        }

}