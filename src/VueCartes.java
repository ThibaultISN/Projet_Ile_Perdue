
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
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
public class VueCartes extends JPanel {

    private CarteTresor c;
    private JLabel JL;
    private ImageIcon img;
    private int imgWidth = 120;
    private int imgHeigh = 168;

    public VueCartes(CarteTresor c) {
        System.out.println(c.getType());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        if (c.getT() != null) {
            switch (c.getType()) {
                
                case "Sac de Sable":System.out.println("sac");
                    img = new ImageIcon(new ImageIcon("src/cartes/SacsDeSable.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    System.out.println("test");
                    this.add(JL);
                    this.setBorder(blackline);
                    break;
                    
                case "flamme":System.out.println("flamme");
                    img = new ImageIcon(new ImageIcon("src/cartes/Cristal.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    this.add(JL);
                    this.setBorder(blackline);
                    break;

                case "coupe":
                    img = new ImageIcon(new ImageIcon("src/cartes/Calice.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    this.add(JL);
                    this.setBorder(blackline);
                    break;

                case "lion":
                    img = new ImageIcon(new ImageIcon("src/cartes/Zephyr.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    this.add(JL);
                    this.setBorder(blackline);
                    break;

                case "lune":
                     
                    img = new ImageIcon(new ImageIcon("src/cartes/Pierre.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));

                    JL = new JLabel(img, JLabel.CENTER);
                    this.add(JL);
                    this.setBorder(blackline);
                    break;

               

                case "Helicopter":
                     System.out.println("Helico");
                    img = new ImageIcon(new ImageIcon("src/cartes/helico.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    
                    this.add(JL);
                    this.setBorder(blackline);
                    break;

            }
            
            if(c.getType() == "Helicopter"){
                System.out.println("Helico");
                    img = new ImageIcon(new ImageIcon("src/cartes/helico.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    
                    this.add(JL);
                    this.setBorder(blackline);
            }
            
            if(c.getType() == "Sac de Sable"){
                 img = new ImageIcon(new ImageIcon("src/cartes/SacsDeSable.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
                    JL = new JLabel(img, JLabel.CENTER);
                    System.out.println("test");
                    this.add(JL);
                    this.setBorder(blackline);
            }
            
        }

    }

    public VueCartes() {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        img = new ImageIcon(new ImageIcon("src/cartes/Fondrouge.png").getImage().getScaledInstance(imgWidth, imgHeigh, Image.SCALE_SMOOTH));
        JL = new JLabel(img, JLabel.CENTER);
        this.add(JL);
        this.setBorder(blackline);
    }
}
