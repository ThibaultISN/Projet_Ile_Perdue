
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAventurier extends Observe {

    private JButton commencer, voirCartes, seDeplacer2, donner, assecher, carteHeli, carteSac, prendre, passerTour;
    private JLabel etatJeu;
    private JComboBox seDeplacer,donner2,assecher2,carteHeli2,carteSac2;
    private JFrame fenetre;
    private JPanel panelH;
    private JPanel panelB;
    public static final int ETAT_ACTION = 1;
    public static final int ETAT_GAGNANT = 2;
    Aventurier av;
    Controleur c ;

    public VueAventurier(Aventurier av, Controleur c) {
        this.av=av;
        this.c=c;
        fenetre = new JFrame("L'île Perdue : jouer coup");
        this.configureWindow(fenetre);
        voirCartes = new JButton("Voir Cartes");
        seDeplacer2 = new JButton("Se Déplacer");
        donner = new JButton("Donner Carte");
        assecher = new JButton("Assécher Tuile");
        carteHeli = new JButton("Utiliser Carte Helicoptère");
        carteSac = new JButton("Utiliser Carte Sac de Sable");
        prendre = new JButton("Prendre Trésor");
        passerTour = new JButton("Passer Son Tour");
        etatJeu = new JLabel("");
        seDeplacer = new JComboBox(new String[]{""});
        donner2 = new JComboBox(new String[]{""});
        assecher2 = new JComboBox(new String[]{""});
        carteHeli2 = new JComboBox(new String[]{""});
        carteSac2 = new JComboBox(new String[]{""});


        seDeplacer2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.action = "seDeplacer";
                    m.tuile = (Tuile) seDeplacer.getSelectedItem();
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
                    m.don = (String) donner2.getSelectedItem();
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });

        assecher.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.action = "assecher";
                    m.assecher = (String) assecher2.getSelectedItem();
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });

        carteHeli.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.action = "carteHeli";
                    m.carteHeli = (String) carteHeli2.getSelectedItem();
                    m.type = TypesMessage.JOUER_COUP;
                    notifierObservateur(m);
                }
        });

        carteSac.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.action = "carteSac";
                    m.carteSac = (String) carteSac2.getSelectedItem();
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
        });

        for(Tuile t : c.tuilepossibledep(av)){
            seDeplacer.addItem(t);
        }

         for(Tuile t : c.tuileassechable(av)){
            assecher2.addItem(t);
        }

        fenetre.setLayout(new BorderLayout());
        panelH = new JPanel();
        panelH.add(etatJeu);
        fenetre.add(panelH, BorderLayout.NORTH);

        panelB = new JPanel();
        panelB.setLayout(new GridLayout(7, 3));
        panelB.add(voirCartes);
        panelB.add(new JLabel(""));
        panelB.add(prendre);
        panelB.add(seDeplacer2);
        panelB.add(new JLabel("Choix :"));
        panelB.add(seDeplacer);
        panelB.add(donner);
        panelB.add(new JLabel("Choix :"));
        panelB.add(donner2);
        panelB.add(assecher);
        panelB.add(new JLabel("Choix :"));
        panelB.add(assecher2);
        panelB.add(carteHeli);
        panelB.add(new JLabel("Choix :"));
        panelB.add(carteHeli2);
        panelB.add(carteSac);
        panelB.add(new JLabel("Choix :"));
        panelB.add(carteSac2);
        panelB.add(new JLabel(""));
        panelB.add(passerTour);
        panelB.add(new JLabel(""));

        fenetre.add(panelB,BorderLayout.CENTER);

    }

    public void afficherEtatAction(int etat, String joueur) {
        switch(etat) {
            case ETAT_ACTION:
                etatJeu.setText("Joueur " + joueur + " choisir une action");
                break;

            case ETAT_GAGNANT:
                etatJeu.setText("Jeu terminé : " + joueur + " gagnant");
                break;
        }
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

    public void actualiser(Controleur c ,Aventurier av){

    }

}
