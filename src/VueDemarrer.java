
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
public class VueDemarrer extends Observe{
    
    private JFrame fenetre;
    private JTextField j1, j2, j3, j4;
    private JLabel joueur1, joueur2, joueur3, joueur4;
    private JButton commencer;
    private JComboBox difficulte;
    private JPanel panelP;
    
    public VueDemarrer() {
        
        fenetre = new JFrame("L'île Perdue : début partie");
        this.configureWindow(fenetre);
        difficulte = new JComboBox(new String[]{"Novice", "Normal", "Elite", "Légendaire"});
        commencer = new JButton("Démarrer");
        commencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Message m = new Message();
                m.type = TypesMessage.DEMARRER_PARTIE;
                m.difficulte = (String) difficulte.getSelectedItem();
                 int i =0;
                 m.joueur= new ArrayList<>();
                 
                 if(!j1.getText().isEmpty()){
                    m.joueur.add(j1.getText());
                   
                 }
                 
                 if(!j2.getText().isEmpty()){
                    m.joueur.add(j2.getText());
                     
                 }
                 if(!j3.getText().isEmpty()){
                   m.joueur.add(j3.getText());
                     
                 }
                 if(!j3.getText().isEmpty()){
                    m.joueur.add(j4.getText());
                     
                 }
                 
                
                notifierObservateur(m);
            }
        });
        joueur1 = new JLabel("J1");
        joueur2 = new JLabel("J2");
        joueur3 = new JLabel("J3");
        joueur4 = new JLabel("J4");
        j1 = new JTextField();
        j2 = new JTextField();
        j3 = new JTextField();
        j4 = new JTextField();
        
        fenetre.setLayout(new BorderLayout());

        panelP = new JPanel();
        panelP.setLayout(new GridLayout(5, 4));
        panelP.add(new JLabel(""));
        panelP.add(joueur1);
        panelP.add(j1);
        panelP.add(new JLabel(""));
        panelP.add(new JLabel(""));
        panelP.add(joueur2);
        panelP.add(j2);
        panelP.add(new JLabel(""));
        panelP.add(new JLabel(""));
        panelP.add(joueur3);
        panelP.add(j3);
        panelP.add(new JLabel(""));
        panelP.add(new JLabel(""));
        panelP.add(joueur4);
        panelP.add(j4);
        panelP.add(new JLabel(""));
        panelP.add(new JLabel("Difficulté :"));
        panelP.add(difficulte);
        panelP.add(commencer);
        
        fenetre.add(panelP);
        
        
        
    }
        public void demarrerJeu(){
            commencer.setEnabled(false);
            difficulte.setEnabled(false);
            j1.setEnabled(false);
            j2.setEnabled(false);
            j3.setEnabled(false);
            j4.setEnabled(false);
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
        fenetre.setSize(300, 300);
        fenetre.setVisible(true);                        
    }
    
    
    public void fermer(){
        fenetre.setVisible(false);
    }
}
