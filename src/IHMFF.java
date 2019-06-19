
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author veyrunel
 */
public class IHMFF  extends Observe{
    
    private JFrame fenetre;
    private JPanel grille;
    private Grille grille2;
    private JPanel panelD;
    private JPanel panelG;
    private JPanel panelB;
    private JLabel etatJeu;
    private JTextField j1, j2, j3, j4;
    private JLabel joueur1, joueur2, joueur3, joueur4;
    private JButton commencer, voirCartes, seDeplacer, donner, assecher, carteHeli, carteSac, prendre, passerTour;
    private JSlider montee;
    private JComboBox difficulte;

    public IHMFF() {
        fenetre = new JFrame("L'île Perdue");
        this.configureWindow(fenetre);
        grille2 = new Grille();
        ArrayList<Tuile> tuiles = new ArrayList<Tuile>();
        tuiles = grille2.getTuiles();

        grille = new JPanel();
        difficulte = new JComboBox(new String[]{"Novice", "Normal", "Elite", "Légendaire"});
        joueur1 = new JLabel("J1");
        joueur2 = new JLabel("J2");
        joueur3 = new JLabel("J3");
        joueur4 = new JLabel("J4");
        j1 = new JTextField();
        j2 = new JTextField();
        j3 = new JTextField();
        j4 = new JTextField();
        voirCartes = new JButton("Voir Cartes");
        seDeplacer = new JButton("Se Déplacer");
        donner = new JButton("Donner Carte");
        assecher = new JButton("Assécher Tuile");
        carteHeli = new JButton("Utiliser Carte Helicoptère");
        carteSac = new JButton("Utiliser Carte Sac de Sable");
        prendre = new JButton("Prendre Trésor");
        passerTour = new JButton("Passer Son Tour");
        
                

        fenetre.setLayout(new BorderLayout());

        panelG = new JPanel();
        panelG.setLayout(new GridLayout(5, 3));
        panelG.add(joueur1);
        panelG.add(j1);
        panelG.add(new JLabel(""));
        panelG.add(joueur2);
        panelG.add(j2);
        panelG.add(new JLabel(""));
        panelG.add(joueur3);
        panelG.add(j3);
        panelG.add(new JLabel(""));
        panelG.add(joueur4);
        panelG.add(j4);
        panelG.add(new JLabel(""));
        panelG.add(difficulte);
        panelG.add(new JLabel(""));

        commencer = new JButton("Commencer");
        commencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Message m = new Message();
                m.type = TypesMessage.DEMARRER_PARTIE;
                m.j1 = j1.getText();
                m.j2 = j2.getText();
                m.j3 = j3.getText();
                m.j4 = j4.getText();
                notifierObservateur(m);
            }
        });
        panelG.add(commencer);

        fenetre.add(panelG, BorderLayout.WEST);

        grille.setLayout(new GridLayout(6, 6));
        for (int i = 0; i < 36; i++) {
            for (Tuile t : tuiles) {
                JButton bouton = new JButton(t.getNom());
                grille.add(bouton);
            }
            JPanel panel = new JPanel(new BorderLayout());
            if (i == 1) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 2) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 5) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 6) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 7) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 12) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 25) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 30) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 31) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 32) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 35) {
                panel.add(new JLabel(""));
                grille.add(panel);
            } else if (i == 36) {
                panel.add(new JLabel(""));
                grille.add(panel);
            }
        }
        grille.setEnabled(false);
        fenetre.add(grille, BorderLayout.CENTER);
        
        panelD = new JPanel();
        panelD.setLayout(new GridLayout(4, 2));
        panelD.add(voirCartes);
        panelD.add(seDeplacer);
        panelD.add(donner);
        panelD.add(assecher);
        panelD.add(carteHeli);
        panelD.add(carteSac);
        panelD.add(prendre);
        panelD.add(passerTour);
        fenetre.add(panelD, BorderLayout.EAST);
        
        etatJeu = new JLabel();
        panelB = new JPanel();
        panelB.add(etatJeu);
        fenetre.add(panelB, BorderLayout.SOUTH);

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
        fenetre.setSize(400, 150);
        fenetre.setVisible(true);                        
    }
    
}
