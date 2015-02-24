/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Hjort
 */
public class IMat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Set look and feel to system standard
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | 
                InstantiationException | IllegalAccessException e) {
            System.out.println(UIManager.getSystemLookAndFeelClassName() + 
                    " look and feel not supported");
        }
        
        new TopFrame().setVisible(true);
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                //This code will run before shutdown
                System.out.println("Closing RecipeSearch");
            }
        }));
    }
    
}
