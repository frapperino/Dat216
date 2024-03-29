/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.customer_profile.address;

import i_mat.controllers.AddressController;
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
public class SingleAddressPanel extends javax.swing.JPanel {
    
    private DeliveryAddress deliveryAddress;
    private JPanel expandedAddressPanel;
    private Filler leftFiller;
    
    /**
     * Creates new form SingleAddress
     */
    public SingleAddressPanel(DeliveryAddress da) {
        setDeliveryAddress(da);
        initComponents();
        leftFiller = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        validate();
        repaint();
    }
    
    protected void setDeliveryAddress(DeliveryAddress da) {
        deliveryAddress = da;
        expandedAddressPanel = new EditAddressPanel(deliveryAddress);
        validate();
        repaint();
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
        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jToggleButton2 = new javax.swing.JToggleButton();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(263, 31));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        jToggleButton1.setText("►");
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
        jPanel2.add(jToggleButton1);

        jLabel1.setText(deliveryAddress.getAddress());
        jPanel2.add(jLabel1);
        jPanel2.add(filler1);

        jPanel1.add(jPanel2);

        jToggleButton2.setText("Förval");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        if (jToggleButton1.isSelected()) {
            jToggleButton1.setText("▼");
            jLabel1.setText("");
            add(leftFiller,BorderLayout.WEST);
            add(expandedAddressPanel,BorderLayout.CENTER);
        } else {
            jToggleButton1.setText("►");
            jLabel1.setText(deliveryAddress.getAddress());
            remove(expandedAddressPanel);
        }
        validate();
        revalidate();
        repaint();
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // perhaps the same as jToggleButton1MouseClicked(), i dunno lol?
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (jToggleButton2.isSelected()) {
            AddressController.getInstance().setDefault(deliveryAddress);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        jToggleButton1.setSelected(!jToggleButton1.isSelected());
        jToggleButton1MouseClicked(evt);
    }//GEN-LAST:event_jPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
