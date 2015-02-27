/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat;

import i_mat.model.Model;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Hjort
 */
public class IMat {

    private static TopFrame topFrame;
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
        
        topFrame = new TopFrame();
        topFrame.setVisible(true);
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Model.save();
            }
        }));
    }
    
    public static void setCenterStage(javax.swing.JPanel panel) {
        topFrame.setCenterStage(panel);
    }
}
