/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat;

import i_mat.model.Model;
import java.awt.BorderLayout;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Hjort
 */
public class IMat {

    private static TopFrame topFrame;
    private final static Stack<JPanel> backwardStack = new Stack<>();
    private final static Stack<JPanel> forwardStack = new Stack<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Set look and feel to system standard
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.setProperty("apple.laf.useScreenMenuBar", "true");
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
    
    public synchronized static void setCenterStage(javax.swing.JPanel panel) {
        backwardStack.push(topFrame.getCenterStage());
        forwardStack.clear();
        topFrame.setCenterStage(panel); 
    }
    
    public static void moveBackward() {
        forwardStack.push(topFrame.getCenterStage());
        topFrame.setCenterStage(backwardStack.pop());
    }
    
    public static void moveForward() {
        backwardStack.push(topFrame.getCenterStage());
        topFrame.setCenterStage(forwardStack.pop());
    }
    
    public static boolean moveBackwardPossible() {
        return !backwardStack.empty();
    }
    
    public static boolean moveForwardPossible() {
        return !forwardStack.empty();
    }
    
    public static JPanel getCenterStage() {
        return topFrame.getCenterStage();
    }
    
    //For setting a loadpanel which does not go on the stack.
    public static void setLoadingCenterStage() {
        topFrame.setLoading();
    }
}
