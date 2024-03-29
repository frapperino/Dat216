/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.shopping_cart;

import i_mat.model.Model;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author time
 */
public class cartItemPanel extends javax.swing.JPanel {
    
    private ShoppingItem item;
    private ShoppingCartPanel2 scp;
    /**
     * Creates new form cartItemPanel
     */
    public cartItemPanel(ShoppingItem i, ShoppingCartPanel2 scp) {
        this.setPreferredSize(new Dimension(250,40));
        item = i;
        this.scp = scp;
        initComponents();
        this.jLabel2.setAlignmentX(RIGHT_ALIGNMENT);
    }
    
    public ShoppingItem getItem() {
        return item;
    }
    
    public void update() {
        jSpinner1.setValue(item.getAmount());
        jSpinner1.updateUI();
        jLabel2.setText(item.getTotal()+" kr");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jLabel2 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        add(filler2);

        jLabel1.setText(item.getProduct().getName());
        jLabel1.setToolTipText(item.getProduct().getName());
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(75, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(115, 16));
        add(jLabel1);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(1.0d), null, Double.valueOf(1.0d)));
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSpinner1.setMaximumSize(new java.awt.Dimension(30, 20));
        jSpinner1.setMinimumSize(new java.awt.Dimension(10, 10));
        jSpinner1.setPreferredSize(new java.awt.Dimension(45, 30));
        jSpinner1.setValue(item.getAmount());
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        add(jSpinner1);
        add(filler3);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(item.getTotal()+" kr");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(jLabel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        Object o = jSpinner1.getValue();
        Number value = new Double(1);
        if (o instanceof Number) {
            value = (Number)o;
            item.setAmount(value.doubleValue());
            Model.fireShoppingCartChanged(item, true);
        }
        update();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Model.getShoppingCart().removeItem(item);
        scp.removeCartItem(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables

    /**
     * Enable interaction with this panel
     */
    void enableInteraction() {
        jButton1.setEnabled(true);
        jSpinner1.setEnabled(true);
        jButton1.setVisible(true);
        jSpinner1.setVisible(true);
    }

    /**
     * Disable interaction with this panel
     */
    void disableInteraction() {
        jButton1.setEnabled(false);
        jSpinner1.setEnabled(false);
        jButton1.setVisible(false);
        jSpinner1.setVisible(false);
    }

}
