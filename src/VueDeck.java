
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rabie
 */
public class VueDeck extends Observe{
  private  JFrame fenetre;
 private   ArrayList<VueCartes> cartes ;
  private  Aventurier av ;
 private   JPanel top,mid,bot;
  private  JLabel txt,defosse;
 private   JComboBox JCcartes;
 private   JButton Valider;
            
   
    public VueDeck(Aventurier av,Boolean besoindefosse) {
    fenetre = new JFrame();
    this.av = av;
    fenetre.setTitle("Cartes de "+ av.getNom());
    fenetre.setSize(300, 300);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setLocationRelativeTo(null);
        
        
        top = new JPanel();
        mid = new JPanel();
        bot = new JPanel();
        
        txt = new JLabel("Cartes de :" + av.getNom() );
        top.add(txt);
        
        
        cartes = new ArrayList<>();
        for(CarteTresor c : av.getCartes()){
           cartes.add(new VueCartes(c));
           
        }
        
        for(VueCartes c : cartes){
          mid.add(c);
           
        }
        
        
        int i = 1;
        int reste = 6 - av.getCartes().size();
        while(i <= reste){
            VueCartes vc = new VueCartes();
            mid.add(vc);
        i =i+1;
        }
        
        
        JCcartes = new JComboBox();
         for (CarteTresor t : av.getCartes()) {
              
                    JCcartes.addItem(t);
                }
       defosse = new JLabel("Choisir la carte à défosser ");
       Valider = new JButton(" Valider");
       
       Valider.setEnabled(besoindefosse);
       Valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.av = getAv();
                m.cartetresor = (CarteTresor)JCcartes.getSelectedItem();
                m.action = "defosser";
                m.type = TypesMessage.JOUER_COUP;
                notifierObservateur(m);
            }

        });
       
       
       bot.add(defosse);
       bot.add(JCcartes);
       bot.add(Valider);
       
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        fenetre.setLayout(new GridLayout(3, 1));
        fenetre.add(top);
        fenetre.add(mid);
        fenetre.add(bot);
        
        
    }
    
    
   public void actualiser(Aventurier av,Boolean besoindefosse){
       fenetre.removeAll();
       
          fenetre.setTitle("Cartes de "+ av.getNom());
    fenetre.setSize(300, 300);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setLocationRelativeTo(null);
        
        this.av = av;
        
        txt = new JLabel("Cartes de :" + av.getNom() );
        top.add(txt);
        
        
        mid.setLayout(new GridLayout(1,6));
        for(CarteTresor c : av.getCartes()){
           VueCartes vc = new VueCartes(c);
           mid.add(vc);
        }
        int i = 1;
        int reste = 6 - av.getCartes().size();
        while(i <= reste){
            VueCartes vc = new VueCartes();
            mid.add(vc);
        i =i+1;
        }
        
        
        JCcartes = new JComboBox();
         for (CarteTresor t : av.getCartes()) {
              
                    JCcartes.addItem(t);
                }
       defosse = new JLabel("Choisir la carte à défosser ");
       Valider = new JButton(" Valider");
       
       Valider.setEnabled(besoindefosse);
       
       
       bot.add(defosse);
       bot.add(JCcartes);
       bot.add(Valider);
       
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        fenetre.setLayout(new GridLayout(3, 1));
        fenetre.add(top);
        fenetre.add(mid);
        fenetre.add(bot);
   }

    public Aventurier getAv() {
        return av;
    }
    
    public void afficher() {
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(720, 1080);
        fenetre.setVisible(true);
    }
}
