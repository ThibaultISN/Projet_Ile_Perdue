
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rabie
 */
public class VueTuile extends JPanel {
  Tuile t;
   JLabel nom;
   JLabel nomJoueur;
   JLabel nomtresor;
   
  VueTuile(Tuile t){
      
      JLabel tempo;
      JLabel tempo2;
      if(t.getEtatTuile()==EtatTuile.inondé) {
          
         this.setBackground(new Color(255,192,0));
        
          tempo =new JLabel(t.getNom());
          if(t.getTrésor()!=null){
               tempo2 =new JLabel(t.getTrésor().getNom());
              tempo2.setForeground(Color.black);
              tempo.setBackground(Color.white);
              this.add (tempo2);
          }
         tempo.setForeground(Color.white);
        this.add (tempo);
         }
          
             
         
         
          
         
         
         
     
     if (t.getEtatTuile()==EtatTuile.seche){
         
         this.setBackground(new Color(151,71,6));
        
          tempo =new JLabel(t.getNom());
           if(t.getTrésor()!=null){
              tempo2 =new JLabel(t.getTrésor().getNom());
              tempo2.setForeground(Color.black);
              tempo.setBackground(Color.white);
              this.add (tempo2);
          }
         tempo.setForeground(Color.white);
         this.add (tempo);
         
        
     }
      Border lineborder = BorderFactory.createLineBorder(Color.black, 1); 
    //associer à JLabel
    this.setBorder(lineborder);
     
     
  }
  
  VueTuile(Tuile t,String nomj){
     if(t.getEtatTuile()==EtatTuile.vide){
         this.setBackground(Color.white);
     }else if(t.getEtatTuile()==EtatTuile.inondé) {
         this.setBackground(Color.cyan);
         nom= new JLabel(t.getNom());
         nomJoueur= new JLabel(nomj);
         if(t.getTrésor()!=null){
             nomtresor= new JLabel(t.getTrésor().getNom());
         }
         
         
     }
     else if (t.getEtatTuile()==EtatTuile.seche){
         this.setBackground(Color.green);
         nom= new JLabel(t.getNom());
         if(t.getTrésor()!=null){
             nomtresor= new JLabel(t.getTrésor().getNom());
             nomJoueur= new JLabel(nomj);
         }
     }
}
  
  VueTuile(){
      this.setBackground(Color.white);
  }
}
