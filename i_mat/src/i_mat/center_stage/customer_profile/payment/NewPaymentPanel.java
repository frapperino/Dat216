/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.customer_profile.payment;

import i_mat.center_stage.customer_profile.address.*;
import i_mat.model.DeliveryAddress;
import i_mat.model.Model;
import java.awt.BorderLayout;
import javax.swing.Box.Filler;
import javax.swing.JPanel;
import se.chalmers.ait.dat215.project.Customer;

/**
 *
 * @author weeeeeew
 */
public class NewPaymentPanel extends javax.swing.JPanel {
    
    private JPanel expandedAddressPanel;
    private Filler leftFiller;
    
    /**
     * Creates new form SingleAddress
     */
    public NewPaymentPanel() {
        initComponents();
        expandedAddressPanel = new InputNewPaymentMethodPanel();
        leftFiller = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(263, 26));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(263, 26));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jToggleButton1.setText("+");
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jToggleButton1.setMaximumSize(new java.awt.Dimension(60, 30));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(60, 30));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(60, 30));
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1);

        jLabel1.setText("Lägg till nytt kort");
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // perhaps the same as jToggleButton1MouseClicked(), i dunno lol?
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        if (jToggleButton1.isSelected()) {
            jToggleButton1.setText("X");
            add(leftFiller,BorderLayout.WEST);
            add(expandedAddressPanel,BorderLayout.CENTER);
        } else {
            jToggleButton1.setText("+");
            remove(expandedAddressPanel);
        }
        validate();
        revalidate();
        repaint();
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jToggleButton1MouseClicked(evt);
    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
