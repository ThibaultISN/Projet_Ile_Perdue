
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;

public class VueGrille {

    private Grille g;
    private final JFrame window;
    private JPanel jp;
    private JPanel jborderleft;
    private ArrayList<VueTuile> listetuile ;
    public VueGrille(Controleur c) {
        setG(c.grille);
        jp = new JPanel();
        jborderleft = new JPanel();
        this.window = new JFrame();
        window.setSize(1080, 720);
        //le titre = nom du joueur 
        window.setTitle("Grille");
        
        
        
        
        
                int a =0;
                jp.add(new VueTuile());
                jp.add(new VueTuile());
                jp.add(new VueTuile(g.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(g.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile());
                jp.add(new VueTuile());
                
                // ligne 2
                jp.add(new VueTuile());
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                 jp.add(new VueTuile());
                 
                 //ligne 3
                 jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                 jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                
                 //ligne 4
               jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                 jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                
                //ligne 5
                  jp.add(new VueTuile());
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                 jp.add(new VueTuile());
                 
                 //ligne 6
                jp.add(new VueTuile());
                jp.add(new VueTuile());
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile(c.grille.tuiles.get(a),c));a=a+1;
                jp.add(new VueTuile());
                jp.add(new VueTuile());
            
            
        
        
        jp.setLayout(new GridLayout(6, 6));
        
         JPanel exemple1  = new JPanel();
         JPanel coulé = new JPanel();
         coulé.setBackground(new Color(255,192,0));
         exemple1.add(coulé);
         exemple1.add(new JLabel("Case inondé"));
         
         
         JPanel exemple2  = new JPanel();
         JPanel seche = new JPanel();
         seche.setBackground(new Color(151,71,6));
         exemple2.add(seche);
         exemple2.add(new JLabel("Case seche"));
        
         
         JPanel exemple3  = new JPanel();
         JPanel disparue = new JPanel();
         disparue.setBackground(new Color(141,180,226));
         exemple3.add(disparue);
         exemple3.add(new JLabel("Case disparue"));
         
         
          JPanel exemple4  = new JPanel();
          
          
         jborderleft = new JPanel();
         jborderleft.setLayout(new BoxLayout(jborderleft, BoxLayout.PAGE_AXIS));
         jborderleft.add(exemple1);
         jborderleft.add(exemple2);
         jborderleft.add(exemple3);
         
         window.setLayout(new BorderLayout());
         window.add(jp,BorderLayout.CENTER);
         window.add(jborderleft,BorderLayout.EAST);
         
         
         
         
         
    }

    public void setG(Grille 
        g) {
        this.g = g;
    }

    public JFrame getWindow() {
        return window;
    }
    
     public void afficher() {
        window.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        window.setSize(1080 , 720);
        window.setVisible(true);
    }
    
    public void fermer() {
        window.setVisible(false);
    }
    
}
