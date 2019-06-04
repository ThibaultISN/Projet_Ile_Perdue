
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rabie
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ArrayList<String> str = new ArrayList<>();
         str.add(new String("a"));
         str.add(new String("b"));
         str.add(new String("c"));
         str.add(new String("d"));
         str.add(new String("e"));
         str.add(new String("f"));
         str.add(new String("g"));
         str.add(new String("h"));
         str.add(new String("i"));
         
         for(String i : str){
           System.out.println(i);
            
         }
         System.out.println("\n");
         
         
         str.remove(0);
          
           System.out.println(str.get(0));
            str.remove(0);
          
           System.out.println(str.get(0));
            str.remove(0);
          
           System.out.println(str.get(0));
            
        
           
         }
         
         
    }
    
    
    
    
    

