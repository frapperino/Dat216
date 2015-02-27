/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.list_view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import net.miginfocom.swing.MigLayout;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JLabel;

/**
 *
 * @author Hjort
 */
public class HistoryFullListPanel extends javax.swing.JPanel {
    private Order o;
    /**
     * Creates new form HistoryFullListPanel
     */
    public HistoryFullListPanel() {
        
    }
    
    public HistoryFullListPanel(Order o) {
        initComponents();
        this.setLayout(new MigLayout());
        int total = 0;
        for (ShoppingItem item : o.getItems()) {
            this.add(new JLabel(item.getProduct().getName()));
            this.add(new JLabel(Double.toString(item.getAmount()) 
            + item.getProduct().getUnitSuffix()));
            this.add(new JLabel(item.getTotal() + " kr"), "wrap");
        }
        JLabel totalLabel = new JLabel(Integer.toString(total) + " kr");
        totalLabel.setAlignmentX(RIGHT_ALIGNMENT);
        this.add(totalLabel,  "span 3");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private PopupMenu JLabel(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}