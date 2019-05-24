
import java.util.ArrayList;

public class Tuile {

    private String nom;
    private Trésor trésor;
    private Position position;
    private EtatTuile etatTuile;


    /** des Abimes|| position : (2,4)
La Porte de
     *
     * @param nom
     */
    public Tuile(String nom, Trésor trésor, Position position) { //Pour les tuiles disposant d'un trésor
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

    public Trésor getTrésor() {
        return trésor;
    }

    public void setTrésor(Trésor trésor) {
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

    public boolean estcontigue(Tuile tuile) {
        Position pos = this.position;
        Position param = tuile.position;

        int paramX = tuile.position.getX();
        int paramY = tuile.position.getY();

        ArrayList<Position> listconti = new ArrayList<>(); // liste des position contigue de la tuile en parametre

        listconti.add(new Position(paramX + 1, paramY));
        listconti.add(new Position(paramX, paramY + 1));
        listconti.add(new Position(paramX - 1, paramY));
        listconti.add(new Position(paramX, paramY - 1));


        return (listconti.contains(this.position));



    }
    // Surcharge de méthode pour une position donné en parametre 
    public boolean estcontigue(Position pos) {
        

        

        ArrayList<Position> listconti = new ArrayList<>(); // liste des position contigue de la tuile en parametre

        int parametreX = pos.getX();
        int parametreY = pos.getY();
        listconti.add(new Position(parametreX + 1, parametreY));
        listconti.add(new Position(parametreX, parametreY + 1));
        listconti.add(new Position(parametreX - 1, parametreY));
        listconti.add(new Position(parametreX, parametreY - 1));


        return (listconti.contains(this.position));



    }
    
    public boolean estdiagonal(Tuile tuile){
       
        int paramX = tuile.position.getX();
        int paramY = tuile.position.getY();

        ArrayList<Position> listconti = new ArrayList<>(); // liste des position contigue de la tuile en parametre
        
        listconti.add(new Position(paramX + 1, paramY + 1));
        listconti.add(new Position(paramX -1 , paramY + 1));
        listconti.add(new Position(paramX - 1, paramY +1));
        listconti.add(new Position(paramX +1, paramY - 1));


        return (listconti.contains(this.position));
        
    }
        // Surcharge de méthode pour une position donné en parametre 
    public boolean estdiagonal(Position pos){
       

        int paramX = pos.getX();
        int paramY = pos.getY();

        ArrayList<Position> listconti = new ArrayList<>(); // liste des position diagonal de la tuile en parametre

        listconti.add(new Position(paramX + 1, paramY + 1));
        listconti.add(new Position(paramX -1 , paramY + 1));
        listconti.add(new Position(paramX - 1, paramY +1));
        listconti.add(new Position(paramX +1, paramY - 1));


        return (listconti.contains(this.position));
        
    }

    public void affiche(){
        System.out.println( this.getNom()+ "|| position : (" + this.position.getX() +","+ this.position.getY()+")" );


    }
}
