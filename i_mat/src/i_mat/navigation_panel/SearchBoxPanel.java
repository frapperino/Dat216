/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.navigation_panel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * SearchBoxPanel displays automatically a search result in a combobox. Pressing
 * escape hides the popup, enter adds 1 of that product to the shoppingcart.
 * This is badsearch1.0, hopefully a better implementation can be realized.
 * @author time
 */
public class SearchBoxPanel extends JPanel{
    private final JTextField tf;
    private final JComboBox combo = new JComboBox();
    private final Vector<String> v = new Vector<>(); //All the products
    private boolean hide_flag = false; //Indicates the popup should hide/show
    
    
    /**
     * Creates a new SearchBoxPanel
     */
    public SearchBoxPanel() {
        super(new BorderLayout());
        
        //Set the combobox UI to not include a down-arrow.
        combo.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });
        
        /**
         * Sets the TextField as the editor for the combobox.
         */
        combo.setEditable(true);
        tf = (JTextField) combo.getEditor().getEditorComponent();
        
       /**
        * Adds a keyListener to the textField and defines all of the behaviors
        * of the textField. There among hiding the combobox-popup if no text has
        * been entered, hiding the combobox if escape is pressed, displaying 
        * search results as being typed.
        */
        tf.addKeyListener(new KeyAdapter() {
            
            //Updates the combobox depending on input
            @Override
            public void keyTyped(KeyEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String text = tf.getText();
                        if (text.length()==0) {
                            combo.hidePopup();
                            setModel(new DefaultComboBoxModel(v), "");
                        } else {
                            DefaultComboBoxModel m = getSuggestedModel(v, text);
                            if (m.getSize()==0 || hide_flag) {
                                combo.hidePopup();
                                hide_flag = false;
                            } else {
                                setModel(m, text);
                                combo.showPopup();
                            }
                        }
                    }
                });
            }
            
            //Press enter -> ShoppingItem added to cart.
            //Press escape -> popup gets hidden.
            @Override
            public void keyPressed(KeyEvent e) {
                String text = tf.getText();
                int code = e.getKeyCode();
                if (code==KeyEvent.VK_ENTER) {
                    String productName = tf.getText();
                    if (v.contains(productName)) {
                        if (SearchController.getProduct(productName) != null) {
                            SearchController.addShoppingItem(SearchController.getProduct(productName));
                        }
                    }
                    hide_flag = true; 
                } else if (code==KeyEvent.VK_ESCAPE) {
                    hide_flag = true; 
                }
            }
        });
        
        String[] products = SearchController.getAllProducts();
        for (String product : products) {
            v.addElement(product);
        }
        
        //init combobox and add combobox to panel.
        setModel(new DefaultComboBoxModel(v), "");
        add(combo, BorderLayout.CENTER);
    }
    
    /**
     * Sets the combobox to a certain model with the text str showing in the 
     * TextField.
     * @param mdl //The comboboxmodel
     * @param str
     */
    private void setModel(DefaultComboBoxModel mdl, String str) {
        combo.setModel(mdl);
        combo.setSelectedIndex(-1);
        tf.setText(str);
    }
    
    /**
     * The ComboBoxModel which correspond to the current search.
     * 
     * @param list //All the products.
     * @param text //The text currently being searched for.
     * @return The ComboBoxModel which correspond to the current search.
     */
    private static DefaultComboBoxModel getSuggestedModel(java.util.List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String s: list) {
            if(s.toLowerCase().startsWith(text.toLowerCase())) m.addElement(s);
        }
        return m;
    }
}