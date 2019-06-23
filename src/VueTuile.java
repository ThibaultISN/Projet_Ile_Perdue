
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
    Controleur c;

    VueTuile(Tuile t, Controleur c) {
        this.c = c;
        JLabel tempo;
        JLabel tempo2;
        this.setLayout(new GridLayout(3, 1));
        
        if (t.getEtatTuile() == EtatTuile.disparue) {

            this.setBackground(new Color(16, 20, 25));

            tempo = new JLabel(t.getNom());
            if (t.getTrésor() != null) {
                tempo2 = new JLabel(t.getTrésor().getNom());
                tempo2.setForeground(Color.black);
                tempo.setBackground(Color.white);
                this.add(tempo2);
            }
            tempo.setForeground(Color.white);
            this.add(tempo);
        }
        
        if (t.getEtatTuile() == EtatTuile.inondé) {

            this.setBackground(new Color(71, 108, 155));

            tempo = new JLabel(t.getNom());
            if (t.getTrésor() != null) {
                tempo2 = new JLabel(t.getTrésor().getNom());
                tempo2.setForeground(Color.black);
                tempo.setBackground(Color.white);
                this.add(tempo2);
            }
            tempo.setForeground(Color.white);
            this.add(tempo);
        }

        if (t.getEtatTuile() == EtatTuile.seche) {

            this.setBackground(new Color(152, 68, 71));

            tempo = new JLabel(t.getNom());
            if (t.getTrésor() != null) {
                tempo2 = new JLabel(t.getTrésor().getNom());
                tempo2.setForeground(Color.black);
                tempo.setBackground(Color.white);
                this.add(tempo2);
            }
            tempo.setForeground(Color.white);
            this.add(tempo);

        }
        if (!c.joueursurtuile(t).isEmpty()) {
            for (Aventurier av : c.joueursurtuile(t)) {
                ImageIcon img;
                 JLabel nomdujoueur;
                switch (av.getRole()) {
                    case "Pilote":

                        img = new ImageIcon(new ImageIcon("src/pions/pionBleu.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
                        nomJoueur = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                          nomdujoueur = new JLabel(av.getNom());
                         nomdujoueur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
                        this.add(nomdujoueur);
                        this.add(nomJoueur);
                        break;
                    case "Messager":

                        img = new ImageIcon(new ImageIcon("src/pions/pionGris.png").getImage().getScaledInstance(25, 60, Image.SCALE_SMOOTH));
                        nomJoueur = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                         nomdujoueur = new JLabel(av.getNom());
                        nomdujoueur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
                        this.add(nomdujoueur);
                        this.add(nomJoueur);
                        break;
                    case "Navigateur":

                        img = new ImageIcon(new ImageIcon("src/pions/pionJaune.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
                        nomJoueur = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        nomdujoueur = new JLabel(av.getNom());
                         nomdujoueur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
                        this.add(nomdujoueur);
                        this.add(nomJoueur);
                        break;
                    case "Plongeur":

                        img = new ImageIcon(new ImageIcon("src/pions/pionNoir.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
                        nomJoueur = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        nomdujoueur = new JLabel(av.getNom());
                        nomdujoueur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
                        this.add(nomdujoueur);
                        this.add(nomJoueur);
                        break;
                    case "Explorateur":

                        img = new ImageIcon(new ImageIcon("src/pions/pionVert.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
                        nomJoueur = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        nomdujoueur = new JLabel(av.getNom());
                        nomdujoueur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
                        this.add(nomdujoueur);
                        this.add(nomJoueur);
                        break;
                    case "Ingenieur":

                        img = new ImageIcon(new ImageIcon("src/pions/pionRouge.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
                        nomJoueur = new JLabel(img, JLabel.CENTER);
                        System.out.println("test");
                        nomdujoueur = new JLabel(av.getNom());
                         nomdujoueur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
                        this.add(nomdujoueur);
                        this.add(nomJoueur);
                        break;

                }

            }
        }
        Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
        //associer à JLabel
        this.setBorder(lineborder);

    }

    VueTuile(Tuile t, String nomj) {
        if (t.getEtatTuile() == EtatTuile.vide) {
            this.setBackground(Color.white);
        } else if (t.getEtatTuile() == EtatTuile.inondé) {
            this.setBackground(Color.cyan);
            nom = new JLabel(t.getNom());

            if (t.getTrésor() != null) {
                nomtresor = new JLabel(t.getTrésor().getNom());
            }

        } else if (t.getEtatTuile() == EtatTuile.seche) {
            this.setBackground(Color.green);
            nom = new JLabel(t.getNom());
            if (t.getTrésor() != null) {
                nomtresor = new JLabel(t.getTrésor().getNom());
                nomJoueur = new JLabel(nomj);
            }
        }
    }

    VueTuile() {
        this.setBackground(Color.white);
    }
}
