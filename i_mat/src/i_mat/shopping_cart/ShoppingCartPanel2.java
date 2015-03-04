/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.shopping_cart;

import i_mat.center_stage.WrapLayout;
import i_mat.model.Model;
import i_mat.utilities.GUIConstants;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author time
 */
public class ShoppingCartPanel2 extends JScrollPane implements ShoppingCartListener {
    private JPanel mainPanel;
    private List<cartItemPanel> cip;
    
    /**
     * Creates new form ShoppingCartPanel2
     */
    public ShoppingCartPanel2() {
        cip = new ArrayList<cartItemPanel>();
        Model.getShoppingCart().addShoppingCartListener(this);
        mainPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
        this.getVerticalScrollBar().setUnitIncrement(GUIConstants.SCROLL_INCREMENT);
        this.addAllItemsInCart();
    }
        
    private void addAllItemsInCart() {
        for (ShoppingItem i:Model.getShoppingCart().getItems()) {
            cartItemPanel c = new cartItemPanel(i, this);
            cip.add(c);
            mainPanel.add(c);
        }
        this.getViewport().add(mainPanel);
        this.validate();
        this.repaint();
        this.updateUI();
    }
    public void removeCartItem(cartItemPanel cip) {
        this.cip.remove(cip);
        mainPanel.remove(cip);
        this.updateUI();
        this.validate();        
    }
    
    @Override
    public void shoppingCartChanged(CartEvent ce) {
        if (ce.isAddEvent()) {
            for (cartItemPanel c: cip) {
                if (c.getItem().equals(ce.getShoppingItem())) {
                    c.update();
                    return;
                }
            }
            cartItemPanel c = new cartItemPanel(ce.getShoppingItem(), this);
            cip.add(c);
            mainPanel.add(c);
            mainPanel.validate();
            mainPanel.updateUI();
        }
        else {
            cip.clear();
            mainPanel.removeAll();
            addAllItemsInCart();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
