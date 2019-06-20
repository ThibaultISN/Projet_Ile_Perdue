/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author remulef
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class newVueAventurier extends Observe {
   private JFrame fenetre;
   private JPanel info;
   private JPanel action;
   private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
   private JPanel special;
   private JPanel bot;
   private JLabel joueur,role,nbaction,tresorp,capacite,seDeplacer3,assecher3,donnercarte3, carteHeli3, carteSac3;
   private JComboBox JCTuiledep,JCaventurierREC,JCCartedon,JCTuileass,carteHeli2,JCTuileassSAC,jMessager,cMessager,tuile1,tuile2,tPilote;
   private JButton voirCartes, seDeplacer, donner, assecher, BoutonHelico, carteSac, prendre, passerTour, valider;
   Aventurier av;
   Controleur c;
   public newVueAventurier(Aventurier av, Controleur c) {
        this.av=av;
        this.c=c;
        fenetre = new JFrame("L'île Perdue : jouer coup");
        this.configureWindow(fenetre);
        voirCartes = new JButton("Voir Cartes");
        seDeplacer = new JButton("Se Déplacer");
        donner = new JButton("Donner");
        assecher = new JButton("Secher");
        BoutonHelico = new JButton("Valider");
        carteSac = new JButton("Secher");
        prendre = new JButton("Prendre Trésor");
        passerTour = new JButton("Passer Son Tour");
        
        
        
        
        if(c.posssedeSdS().contains(av)){
            carteSac.setEnabled(true);
        }else{
            carteSac.setEnabled(false);
        };
        
        
         if(c.posssedeHelico().contains(av)){
            BoutonHelico.setEnabled(true);
        }else{
            BoutonHelico.setEnabled(false);
        };
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
          /*      seDeplacer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "seDeplacer";
                    m.tuile = (Tuile) seDeplacer2.getSelectedItem();                 
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        voirCartes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "voir";                
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        passerTour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "passerTour";                
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        donner.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "donner"; 
                    
                    
                    if(donner2.getSelectedItem()!=null){
                    m.av = (Aventurier) donner2.getSelectedItem();
                    }
                    
                    
                    if(donner3.getSelectedItem()!=null){
                    m.cartetresor = (CarteTresor) donner3.getSelectedItem();
                    }
                    
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        assecher.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "assecher";  
                    m.av = av;
                    m.tuile = (Tuile) tuile1.getSelectedItem();
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        carteHeli.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    //A définir
                    
                    
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        carteSac.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "carteSac";    
                    m.tuile = (Tuile) tuile2.getSelectedItem();
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        prendre.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "prendre";    
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        }); */
        
        joueur = new JLabel("Joueur : " + av.getNom());
        //joueur.setBackground(av.getCouleur());
        role = new JLabel("Rôle : " + av.getRole());
        nbaction = new JLabel("Nombre Action : " + av.getNbAction());
        tresorp = new JLabel("Trésor possédé : "+ av.getTresor().toString());
        capacite = new JLabel("Capacité : "/* + av.getCapacite()*/);
        
        info = new JPanel();
        info.setLayout(new GridLayout(5, 1));
        info.add(joueur);
        info.add(role);
        info.add(nbaction);
        info.add(tresorp);
        info.add(capacite);
        info.setBorder(blackline);
        
        
        
        action = new JPanel();
        action.setLayout(new GridLayout(5,1));
        panel1 = new JPanel();
        seDeplacer3 = new JLabel("Se déplacer : ");
        JCTuiledep = new JComboBox();
        for(Tuile t : c.tuilepossibledep(av)){
            JCTuiledep.addItem(t);
        }
        panel1.add(seDeplacer3);
        panel1.add(JCTuiledep);
        panel1.add(seDeplacer);
        
        
        action.add(panel1);
        
        panel2 = new JPanel();
        assecher3 = new JLabel("Assècher : ");
        JCTuileass = new JComboBox();
        for(Tuile t : c.tuileassechable(av)){
            JCTuileass.addItem(t);
        }
        panel2.add(assecher3);
        panel2.add(JCTuileass);
        panel2.add(assecher);
        action.add(panel2);
        
        panel3 = new JPanel();
        donnercarte3 = new JLabel("Donner carte : ");
        JCaventurierREC = new JComboBox();
       for(Aventurier t : c.joueursurtuile(av.getEmplacement())){
            JCaventurierREC.addItem(av);
        }
        JCCartedon = new JComboBox();
        for(CarteTresor l : av.cartes){
            JCCartedon.addItem(l);
        }
        
        panel3.add(donnercarte3);
        panel3.add(JCaventurierREC);
        panel3.add(JCCartedon);
        panel3.add(donner);
        action.add(panel3);
        
        panel4 = new JPanel();
        panel4.add(voirCartes);
        panel4.add(prendre);
        
        panel5 = new JPanel();
        carteHeli3 = new JLabel("Helicoptère : ");
        carteHeli2 = new JComboBox();
         for(Tuile t : c.caseinonde()){
            carteHeli2.addItem(t);
        }
        panel6 = new JPanel();
        carteSac3 = new JLabel("Sac de sable : ");
        JCTuileassSAC = new JComboBox();
        for(Tuile t : c.caseinonde()){
            JCTuileassSAC.addItem(t);
        }
        panel5.add(carteHeli3);
        panel5.add(carteHeli2);
        panel5.add(BoutonHelico);
        
        
        panel6.add(carteSac3);
        panel6.add(JCTuileassSAC);
        panel6.add(carteSac);
        action.add(panel5);
        action.add(panel6);
        action.setBorder(blackline);
        
        special = new JPanel();
        special.setLayout(new GridLayout(3, 1));
        special.add(new JLabel("Capacité Spécial"));
        switch(av.getRole()){
            
            case "Plongeur" : 
                special.add(new JLabel("Peut se déplacer dans les cases inondées"));
                
            break;
            
            case "Messager" :
                jMessager = new JComboBox();
                cMessager = new JComboBox();
                for(Aventurier d : c.joueurs){
                    jMessager.addItem(d);
                }
                for(CarteTresor g : av.getCartes()){
                    cMessager.addItem(g);
                }
                special.add(jMessager);
                special.add(cMessager);
            break;
            
            case "Ingenieur" :
                tuile1 = new JComboBox();
                tuile2 = new JComboBox();
                for(Tuile t : c.tuileassechable(av)){
                    tuile1.addItem(t);
                    tuile2.addItem(t);
                }
                special.add(tuile1);
                special.add(tuile2);
            break;
            
            case "Navigateur" :
                special.add(new JLabel("Possède 4 actions au lieu de 3"));
            break;
            
            case "Explorateur" :
                special.add(new JLabel("Peut se déplacer diagonalement"));
            break;
            
            case "Pilote" :
                tPilote = new JComboBox();
                for(Tuile t : c.tuilepossibledep(av)){
                    tPilote.addItem(t);
                }
                special.add(tPilote);
        }
        
        valider = new JButton("Valider");
        special.setBorder(blackline);
        special.add(valider);
        
        bot = new JPanel();
        bot.setBorder(blackline);
        bot.add(passerTour);
        
        fenetre.setLayout(new GridLayout(4,1));
        fenetre.add(info);
        fenetre.add(action);
        fenetre.add(capacite);
        fenetre.add(bot);
        
        
        
   
    
    
   }
   
   
   private void configureWindow(JFrame window) {
        window.setSize(500, 200);
        window.getContentPane().setLayout(new java.awt.BorderLayout());
        window.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new java.awt.event.WindowListener() {
            public void windowOpened(java.awt.event.WindowEvent e) {
            }

            public void windowClosed(java.awt.event.WindowEvent e) {
            }

            public void windowIconified(java.awt.event.WindowEvent e) {
            }

            public void windowDeiconified(java.awt.event.WindowEvent e) {
            }

            public void windowActivated(java.awt.event.WindowEvent e) {
            }

            public void windowDeactivated(java.awt.event.WindowEvent e) {
            }

            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void afficher() {
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(720, 1080);
        fenetre.setVisible(true);                        
    }
    
     
    public void setAv(Aventurier av) {
        this.av = av;
    }

    public void setC(Controleur c) {
        this.c = c;
    }
    
    public void actualiser(Controleur c ,Aventurier av){
       this.setAv(av);
       this.setC(c);
       
       
       
       
       
       
       
    }
}
