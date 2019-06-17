public class Echelle {

    private int niveau;
    private int graduation;
    private String difficulté;

    Echelle(String difficulty){
        if (difficulty=="Novice" ){
            setNiveau(1);

        }

        else if (difficulty=="Normal" ){
            setNiveau(2);

        }

         else if (difficulty=="Elite" ){
            setNiveau(3);

        }
         else if (difficulty=="Legendaire" ){
            setNiveau(4);

        }
    

    }
    
    Echelle(int i){
        setNiveau(i);
             
    }   

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
        if (this.niveau>0 && niveau<3){
            setGraduation(2);
        }
        else if (this.niveau>2 && niveau<6 )
        {
            setGraduation(3);
        }
        else if( this.niveau>5 && niveau <8)
        {
            setGraduation(4);

        }

       else if( this.niveau >7 && niveau <10){
           setGraduation(5);
       }
        else if( this.niveau >7 && niveau <10){
           setGraduation(6);
       }
    }

    public int getGraduation() {
        return graduation;
    }

    public void setGraduation(int graduation) {
        this.graduation = graduation;
    }


    

    public void Monter(){
        setNiveau(this.getNiveau()+1);
        System.out.println("Niveau de l'eau :=" + this.getNiveau());
    }




}
