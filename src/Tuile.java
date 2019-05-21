
import java.util.ArrayList;

public class Tuile {

	private String nom;
	private Trésor trésor;
        private Position position;
        private EtatTuile etatTuile;

	/**
	 * 
	 * @param nom
	 */
	public Tuile(String nom, Trésor trésor , Position position) { //Pour les tuiles disposant d'un trésor
		setNom(nom);
                setTrésor(trésor);
                setPosition(position);
                etatTuile=EtatTuile.seche;
                setEtatTuile(etatTuile);
		
	}
        
        public Tuile(String nom,Position position) { //Pour les tuiles non nul
		setNom(nom);
                
                setPosition(position);
                
                etatTuile=EtatTuile.seche;
                setEtatTuile(etatTuile);
		
	}
        
        public Tuile(Position position) { //Pour les tuiles vide
		setNom(nom);
                
                setPosition(position);
                
                etatTuile=EtatTuile.vide;
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


        
        public Position générateurpositionrandom(){
        Position randompos = new Position();
        int Min = 0 ;
        int Max = 6 ;
        
        randompos.setX( Min + (int)(Math.random() * ((Max - Min) + 1)) ); 
        randompos.setY( Min + (int)(Math.random() * ((Max - Min) + 1)) );
        
        return randompos;
             
    }
        
    

}

