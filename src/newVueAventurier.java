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
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
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
    private JPanel Sedeplacer, Secher, Donner, Autrechoix, Helicopter, SacdeSable;
    private JPanel special;
    private JPanel bot;
    private JLabel joueur, role, nbaction, tresorp, capacite, seDeplacer3, assecher3, donnercarte3, carteHeli3, carteSac3;
    private JComboBox JCTuiledep, JCaventurierREC, JCCartedon, JCTuileass, carteHeli2, JCTuileassSAC, jMessager, cMessager, tuile1, tuile2, tPilote, JCtuileingenieur;
    private JButton voirCartes, seDeplacer, donner, assecher, BoutonHelico, carteSac, prendre, passerTour, valider, boutonpilote;
    private Aventurier av;
    private Controleur c;

    public newVueAventurier(Aventurier av, Controleur c) {
        this.av = av;
        this.c = c;
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

        
       
        
         if (c.Possibleprisetrésor(av)) {
            prendre.setEnabled(true);
        } else {
            prendre.setEnabled(false);
        };
        
        if (c.posssedeSdS().contains(av)) {
            carteSac.setEnabled(true);
        } else {
            carteSac.setEnabled(false);
        };

        if (c.posssedeHelico().contains(av)) {
            BoutonHelico.setEnabled(true);
        } else {
            BoutonHelico.setEnabled(false);
        };

        Border blackline = BorderFactory.createLineBorder(Color.black);
        seDeplacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
                Message m = new Message();
                m.av = getAv();
                m.action = "seDeplacer";
                m.tuile = (Tuile) JCTuiledep.getSelectedItem();
                m.type = TypesMessage.JOUER_COUP;
                notifierObservateur(m);
            }
        });
        
        voirCartes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "voir";  
                    m.av=av;
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
         
        passerTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.av = av;
                m.action = "passerTour";
                m.type = TypesMessage.JOUER_COUP;
                notifierObservateur(m);
            }

        });
        /* 
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
         */
        assecher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.action = "assecher";
                m.av = av;
                if (av.getRole() == "Ingénieur") {
                    m.tuile2 = (Tuile) JCtuileingenieur.getSelectedItem();
                }
                m.tuile = (Tuile) JCTuileass.getSelectedItem();
                m.type = TypesMessage.JOUER_COUP;
                notifierObservateur(m);
            }
        });
        /*
        carteHeli.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    //A définir
                    
                    
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        */
        carteSac.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "carteSac";    
                    m.av=av;
                    m.cartetresor = av.cartes.get(av.numcarte("Sac de Sable"));
                    m.tuile = (Tuile) JCTuileassSAC.getSelectedItem();
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });
        
        prendre.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();       
                    m.action = "prendre";   
                    m.av=av;
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        }); 

        joueur = new JLabel("Joueur : " + av.getNom());
        //joueur.setBackground(av.getCouleur());
        role = new JLabel("Rôle : " + av.getRole());
        nbaction = new JLabel("Nombre Action : " + av.getNbAction());
        tresorp = new JLabel("Trésor possédé : " + c.tresorjoueurs.toString());
        info = new JPanel();
        info.setLayout(new BorderLayout());
         ImageIcon img;
        switch (av.getRole()) {
                        
                    case "Pilote":

                        img = new ImageIcon(new ImageIcon("src/personnages/pilote.png").getImage().getScaledInstance(150, 210, Image.SCALE_SMOOTH));
                        capacite = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        info.add(capacite,BorderLayout.EAST);
                        
                        break;
                    case "Messager":

                        img = new ImageIcon(new ImageIcon("src/personnages/messager.png").getImage().getScaledInstance(150, 210, Image.SCALE_SMOOTH));
                        capacite = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        info.add(capacite,BorderLayout.EAST);
                       
                        break;
                    case "Navigateur":

                        img = new ImageIcon(new ImageIcon("src/personnages/navigateur.png").getImage().getScaledInstance(150, 210, Image.SCALE_SMOOTH));
                        capacite = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        info.add(capacite,BorderLayout.EAST);
                        
                        break;
                    case "Plongeur":

                        img = new ImageIcon(new ImageIcon("src/personnages/plongeur.png").getImage().getScaledInstance(150, 210, Image.SCALE_SMOOTH));
                        capacite = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        info.add(capacite,BorderLayout.EAST);
                        
                        break;
                    case "Explorateur":

                       img = new ImageIcon(new ImageIcon("src/personnages/explorateur.png").getImage().getScaledInstance(150, 210, Image.SCALE_SMOOTH));
                        capacite = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        info.add(capacite,BorderLayout.EAST);
                        
                        break;
                    case "Ingénieur":

                        img = new ImageIcon(new ImageIcon("src/personnages/ingenieur.png").getImage().getScaledInstance(150, 210, Image.SCALE_SMOOTH));
                        capacite = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        info.add(capacite,BorderLayout.EAST);
                        
                        break;

                }


        
        
        JPanel info2 = new JPanel(new GridLayout(4, 1));
        info2.add(joueur);
        info2.add(role);
        info2.add(nbaction);
        info2.add(tresorp);
        
        info.add(info2,BorderLayout.WEST);
       
        info.setBorder(blackline);

        action = new JPanel();
        action.setLayout(new GridLayout(6, 1));

        Sedeplacer = new JPanel();
        seDeplacer3 = new JLabel("Se déplacer : ");
        JCTuiledep = new JComboBox();
        for (Tuile t : c.tuilepossibledep(av)) {
            JCTuiledep.addItem(t);
        }
        Sedeplacer.add(seDeplacer3);
        Sedeplacer.add(JCTuiledep);
        Sedeplacer.add(seDeplacer);

        Secher = new JPanel();
        assecher3 = new JLabel("Assècher : ");
        JCTuileass = new JComboBox();
        for (Tuile t : c.tuileassechable(av)) {
            JCTuileass.addItem(t);
        }

        if (av.getRole() == "Ingénieur") {
            JCtuileingenieur = new JComboBox();
            
            for (Tuile t : c.tuileassechable(av)) {
            JCtuileingenieur.addItem(t);
        }
             Secher.add(assecher3);
            Secher.add(JCtuileingenieur);
           
        Secher.add(JCTuileass);
        Secher.add(assecher);
        }else{
            Secher.add(assecher3);
        Secher.add(JCTuileass);
        Secher.add(assecher);
        }
        

        Donner = new JPanel();
        donnercarte3 = new JLabel("Donner carte : ");
        JCaventurierREC = new JComboBox();
        if (av.getRole() != "Messager") {
            for (Aventurier t : c.joueursurtuile(av.getEmplacement())) {
                if (t != av) {
                    JCaventurierREC.addItem(av);
                }
            }
        } else {
            for (Aventurier t : c.joueurs) {
                if (t != av) {
                    JCaventurierREC.addItem(t);
                }

        }
        }
    

        JCCartedon = new JComboBox();
        for (CarteTresor l : av.cartes) {
            JCCartedon.addItem(l);
        }

        Donner.add(donnercarte3);
        Donner.add(JCaventurierREC);
        Donner.add(JCCartedon);
        Donner.add(donner);

        Helicopter = new JPanel();
        carteHeli3 = new JLabel("Helicoptère : ");
        carteHeli2 = new JComboBox();
        for (Tuile t : c.caseinonde()) {
            carteHeli2.addItem(t);
        }
        SacdeSable = new JPanel();
        carteSac3 = new JLabel("Sac de sable : ");
        JCTuileassSAC = new JComboBox();
        for (Tuile t : c.caseinonde()) {
            JCTuileassSAC.addItem(t);
        }
        Helicopter.add(carteHeli3);
        Helicopter.add(carteHeli2);
        Helicopter.add(BoutonHelico);

        SacdeSable.add(carteSac3);
        SacdeSable.add(JCTuileassSAC);
        SacdeSable.add(carteSac);

        Autrechoix = new JPanel();
        Autrechoix.add(voirCartes);
        Autrechoix.add(prendre);

        action.add(Sedeplacer);
        action.add(Secher);
        action.add(Donner);

        action.add(Helicopter);
        action.add(SacdeSable);
        action.add(Autrechoix);
        action.setBorder(blackline);

        bot = new JPanel();
        bot.setBorder(blackline);
        bot.add(passerTour);

        fenetre.setLayout(new GridLayout(3, 1));
        fenetre.add(info);
        fenetre.add(action);

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

    public Aventurier getAv() {
        return av;
    }

    public void actualiser(Controleur c, Aventurier av) {
        this.setAv(av);
        this.setC(c);
        JCTuiledep.removeAllItems();

        for (Tuile t : c.tuilepossibledep(av)) {
            JCTuiledep.addItem(t);
        }
        JCTuileassSAC.removeAllItems();
        

        for (Tuile t : c.caseinonde()) {
            JCTuileassSAC.addItem(t);
        }
        
        nbaction.setText("Nombre Action : " + av.getNbAction());

        JCTuileass.removeAllItems();

        for (Tuile t : c.tuileassechable(av)) {
            JCTuileass.addItem(t);
        }

        if (av.getRole() == "Ingénieur") {
            JCtuileingenieur.removeAllItems();
            JCtuileingenieur = JCTuileass;
        }
        
        if (c.Possibleprisetrésor(av)) {
            prendre.setEnabled(true);
        } else {
            prendre.setEnabled(false);
        };
        
        if (c.posssedeSdS().contains(av)) {
            carteSac.setEnabled(true);
        } else {
            carteSac.setEnabled(false);
        };

        if (c.posssedeHelico().contains(av)) {
            BoutonHelico.setEnabled(true);
        } else {
            BoutonHelico.setEnabled(false);
        };

    }

    public void fermer() {
        fenetre.setVisible(false);
    }

}
