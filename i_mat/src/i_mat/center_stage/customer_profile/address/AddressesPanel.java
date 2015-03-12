/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.customer_profile.address;

import i_mat.model.DeliveryAddress;
import i_mat.model.Model;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.Customer;

/**
 *
 * @author weeeeeew
 */
public class AddressesPanel extends javax.swing.JPanel {

    private List<DeliveryAddress> deliveryAddresses;
    
    /**
     * Creates new form AdressesPanel
     */
    public AddressesPanel() {
        this(Model.getDeliveryAddresses());
    }

    public AddressesPanel(List<DeliveryAddress> deliveryAddresses) {
        this.deliveryAddresses = deliveryAddresses;
        initComponents();
        
        for (DeliveryAddress deliveryAddress : deliveryAddresses) {
            add(new SingleAddressPanel(deliveryAddress));
        }
        
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

        newAddressPanel2 = new i_mat.center_stage.customer_profile.address.NewAddressPanel();

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        add(newAddressPanel2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private i_mat.center_stage.customer_profile.address.NewAddressPanel newAddressPanel2;
    // End of variables declaration//GEN-END:variables
}
