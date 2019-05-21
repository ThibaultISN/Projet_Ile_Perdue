/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author remulef
 */
public class Position {
    
    private int x ;
    private int y;
    
    
    
    
     Position(){
    setX(1);
    setY(1);
    
    }
    
    
    Position(int ValX,int ValY){
    setX(ValX);
    setY(ValY);
    
    }
    
    public void modifposition(int dX,int dY){
    setX(dX);
    setY(dY);
    }
    
    void setX(int valX){
       if (valX>0 && valX<7) { this.x=valX;} // Si ValY n'est pas hors plateau Sinon la valeur ne change pas 
       else { this.x=x;} 
       
      
    }
    void setY(int valY){
        if (valY>0 && valY<7) { this.y=valY;} // Si ValY n'est pas hors plateau Sinon la valeur ne change pas 
       else { this.y=y;} 
    }
    
    public int getX(){
    return x;
    
    }
    
     public int getY(){
    return y;
    
    }
     
    
    
    
}
