
import java.util.ArrayList;

public class Tuile {

    private String nom;
    private Tresor trésor;
    private Position position;
    private EtatTuile etatTuile;


    /** des Abimes|| position : (2,4)
La Porte de
     *
     * @param nom
     */
    public Tuile(String nom, Tresor trésor, Position position) { //Pour les tuiles disposant d'un trésor
        setNom(nom);
        setTrésor(trésor);
        setPosition(position);
        etatTuile = EtatTuile.seche;
        setEtatTuile(etatTuile);

    }

    public Tuile(String nom, Position position) { //Pour les tuiles non nul
        setNom(nom);

        setPosition(position);

        etatTuile = EtatTuile.seche;
        setEtatTuile(etatTuile);

    }

    public Tuile(Position position) { //Pour les tuiles vide
        this.setNom("Nul");
        setPosition(position);

        etatTuile = EtatTuile.vide;
        setEtatTuile(etatTuile);

    }

    public EtatTuile getEtatTuile() {
        return etatTuile;
    }

    public void setEtatTuile(EtatTuile etatTuile) {
        this.etatTuile = etatTuile;
    }

    public String getNom() {
        return nom;
    }
  
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Tresor getTrésor() {
        return trésor;
    }

    public void setTrésor(Tresor trésor) {
        this.trésor = trésor;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position générateurpositionrandom() {
        Position randompos = new Position();
        int Min = 0;
        int Max = 5;

        randompos.setX(Min + (int) (Math.random() * ((Max - Min) + 1)));
        randompos.setY(Min + (int) (Math.random() * ((Max - Min) + 1)));

        return randompos;

    }

    public boolean estcontigue(Aventurier av) {
       
        

        

        return (((av.getEmplacement().getPosition().getX() == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == (this.getPosition().getY() + 1))) ||
                ((av.getEmplacement().getPosition().getX() == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == (this.getPosition().getY() - 1))) ||
                (((av.getEmplacement().getPosition().getX() + 1) == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == this.getPosition().getY())) ||
                (((av.getEmplacement().getPosition().getX() - 1) == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == this.getPosition().getY()))
                );

        }
    
    
    
    public boolean estdiagonal(Aventurier av) {
       
        


        return (((av.getEmplacement().getPosition().getX()+1 == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == (this.getPosition().getY() + 1))) ||
                ((av.getEmplacement().getPosition().getX()-1 == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == (this.getPosition().getY() - 1))) ||
                (((av.getEmplacement().getPosition().getX() - 1) == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == this.getPosition().getY()+1)) ||
                (((av.getEmplacement().getPosition().getX() - 1) == this.getPosition().getX()) && (av.getEmplacement().getPosition().getY() == this.getPosition().getY()+1))
                );

        }
   

    public void affiche(){
        System.out.println( this.getNom()+ "|| position : (" + this.position.getX() +","+ this.position.getY()+") " +" " + this.etatTuile );


    }
}
