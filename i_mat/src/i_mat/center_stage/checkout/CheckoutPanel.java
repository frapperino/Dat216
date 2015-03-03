/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.checkout;
import i_mat.IMat;
import i_mat.model.CreditCardInstance;
import i_mat.model.DeliveryAddress;
import java.time.Clock;
import javax.swing.*;
import i_mat.model.Model;
import static i_mat.model.Model.addDeliveryAddress;
import static i_mat.model.Model.getAddress;
import static i_mat.model.Model.getDeliveryAddresses;
import i_mat.shopping_cart.ShoppingCartPanel2;
import java.awt.event.ActionListener;
import java.util.List;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;
/**
 *
 * @author Hjort
 */

public class CheckoutPanel extends javax.swing.JPanel {
    
    private static final IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
    ShoppingCart cart;
    ThankYouPanel p1;
    DeliveryAddress deliv;
    Customer tempCust;
    /**
     * Creates new form CheckoutPanel
     */
    public CheckoutPanel(List<DeliveryAddress> deliveryAddresses) {
        initComponents();
        
        String[] idArray = new String[deliveryAddresses.size()];
        for(int i = 0; i < deliveryAddresses.size();i++){
            idArray[i] = deliveryAddresses.get(i).getID();
        }
        
        selectedAddress.setModel(new DefaultComboBoxModel(idArray));
        setShowingAddress();

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressButtonGroup = new javax.swing.ButtonGroup();
        paymentButtonGroup = new javax.swing.ButtonGroup();
        deliveryButtonGroup = new javax.swing.ButtonGroup();
        oldAdressButton = new javax.swing.JRadioButton();
        newAdressButton = new javax.swing.JRadioButton();
        selectedAddress = new javax.swing.JComboBox();
        oldCardButton = new javax.swing.JRadioButton();
        newCardButton = new javax.swing.JRadioButton();
        cardNumber = new javax.swing.JComboBox();
        purchase = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();

        addressButtonGroup.add(oldAdressButton);
        oldAdressButton.setSelected(true);
        oldAdressButton.setText("Skicka till:");
        oldAdressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldAdressButtonActionPerformed(evt);
            }
        });

        addressButtonGroup.add(newAdressButton);
        newAdressButton.setText("Ny adress…");
        newAdressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAdressButtonActionPerformed(evt);
            }
        });

        selectedAddress.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gatvägen 7" }));
        selectedAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedAddressActionPerformed(evt);
            }
        });

        paymentButtonGroup.add(oldCardButton);
        oldCardButton.setSelected(true);
        oldCardButton.setText("Mitt kort med nummer: ");
        oldCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCardButtonActionPerformed(evt);
            }
        });

        paymentButtonGroup.add(newCardButton);
        newCardButton.setText("Nytt kort...");
        newCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCardButtonActionPerformed(evt);
            }
        });

        cardNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1234 1234 1234 1234", "5678 5678 5678 5678" }));
        cardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberActionPerformed(evt);
            }
        });

        purchase.setText("Genomför köp");
        purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });

        jLabel1.setText("Förnamn:");

        jTextField1.setText("Jonas");
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Efternamn:");

        jTextField2.setText("Petterson");
        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Adress:");

        jTextField3.setText("Nånstansibergen 2");
        jTextField3.setEnabled(false);

        jLabel4.setText("Postkod:");

        jTextField4.setText("441 22");
        jTextField4.setEnabled(false);

        jLabel5.setText("Stad:");

        jTextField5.setText("Göteborg");
        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Mobil:");

        jLabel7.setText("Telefon:");

        jTextField6.setText("087658472");
        jTextField6.setEnabled(false);

        jTextField7.setText("0705869632");
        jTextField7.setEnabled(false);

        jLabel8.setText("Korttyp:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visa", "MasterCard" }));
        jComboBox1.setEnabled(false);

        jLabel9.setText("Kortnummer:");

        jTextField8.setEnabled(false);

        jLabel10.setText("Giltigt tom:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBox2.setEnabled(false);
        jComboBox2.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel11.setText("/");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));
        jComboBox3.setEnabled(false);
        jComboBox3.setMinimumSize(new java.awt.Dimension(45, 20));
        jComboBox3.setPreferredSize(new java.awt.Dimension(40, 20));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel12.setText("Cvc kod:");

        jTextField9.setEnabled(false);

        jLabel13.setText("Ägare (namn):");

        jTextField10.setEnabled(false);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Spara adress");
        jCheckBox1.setEnabled(false);

        jLabel14.setText("Email:");

        jTextField11.setText("Jonas@testmail.com");
        jTextField11.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(76, 76, 76)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(newCardButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(oldCardButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator2)
                                .addComponent(jLabel6)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(27, 27, 27)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addGap(6, 6, 6)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(newAdressButton)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(oldAdressButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(selectedAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel14))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField3)
                                            .addComponent(jTextField11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField4)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextField5)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))))
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(purchase)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(jTextField8)))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(185, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldAdressButton)
                    .addComponent(selectedAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newAdressButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldCardButton)
                    .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newCardButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchase)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void oldAdressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldAdressButtonActionPerformed
        //this.newAddressPanel = null;
        selectedAddress.setEnabled(true);
        setShowingAddress();
        setTextEnabled(false,1);
        this.validate();
    }//GEN-LAST:event_oldAdressButtonActionPerformed

    private void selectedAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedAddressActionPerformed
        // TODO add your handling code here:
        setShowingAddress();
    }//GEN-LAST:event_selectedAddressActionPerformed

    private void newAdressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAdressButtonActionPerformed
        selectedAddress.setEnabled(false);
        clearShowingAddress();
        setTextEnabled(true,1);
        
        this.validate();
    }//GEN-LAST:event_newAdressButtonActionPerformed

    private void cardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberActionPerformed
        
    }//GEN-LAST:event_cardNumberActionPerformed

    private void purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseActionPerformed
        //TODO if ett fält är tomt lr inte tillräckligt ifyllt(text substring av numret), be att fylla i innan gå vidare
        if (newAdressButton.isSelected() && newCardButton.isSelected()){
            
            if (jCheckBox1.isSelected()){
                //in progress
                DeliveryAddress test = new DeliveryAddress(jTextField1.getText(),jTextField2.getText(),
                    jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),
                    jTextField6.getText(),jTextField7.getText(),jTextField11.getText(), "test");
                
                p1 = new ThankYouPanel(iMatDataHandler.placeOrder(true),test , createTempCard() );
            
            }
            
            else {
                p1 = new ThankYouPanel(iMatDataHandler.placeOrder(true), createTempAdress(), createTempCard() );
            }
            IMat.setCenterStage(p1);
            System.out.println(getDeliveryAddresses());
        }
        else if(oldAdressButton.isSelected() && newCardButton.isSelected()){
            
            
            //DeliveryAddress dsss = getDeliveryAddresses().get(1);
            
            
            p1 = new ThankYouPanel(iMatDataHandler.placeOrder(true), getAddress(selectedAddress.getSelectedItem().toString()), createTempCard() );
            IMat.setCenterStage(p1);

        }
    }//GEN-LAST:event_purchaseActionPerformed

    private void newCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCardButtonActionPerformed
        // TODO add your handling code here:
        setTextEnabled(true,2);
        this.validate();
    }//GEN-LAST:event_newCardButtonActionPerformed

    private void oldCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCardButtonActionPerformed
        // TODO add your handling code here:
        setTextEnabled(false,2);
        this.validate();
    }//GEN-LAST:event_oldCardButtonActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed
    private void clearShowingAddress(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField7.setText("");
        jTextField6.setText("");
        jTextField11.setText("");
    }
    
    private void setShowingAddress(){
        String id1 = selectedAddress.getSelectedItem().toString();
        jTextField1.setText(getAddress(id1).getFirstName());
        jTextField2.setText(getAddress(id1).getLastName());
        jTextField3.setText(getAddress(id1).getAddress());
        jTextField4.setText(getAddress(id1).getPostCode());
        jTextField5.setText(getAddress(id1).getPostAddress());
        jTextField7.setText(getAddress(id1).getMobilePhoneNumber());
        jTextField6.setText(getAddress(id1).getPhoneNumber());
        jTextField11.setText(getAddress(id1).getEmail());
        
    }
    private DeliveryAddress createTempAdress(){
        DeliveryAddress d = new DeliveryAddress(jTextField1.getText(),jTextField2.getText(),
                    jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),
                    jTextField6.getText(),jTextField7.getText(),jTextField11.getText());
        return d;
    }
    private CreditCardInstance createTempCard(){
        CreditCardInstance c = new CreditCardInstance(jTextField8.getText(), 
                    jComboBox1.getSelectedItem().toString(), jTextField10.getText(), 
                    Integer.parseInt(jComboBox2.getSelectedItem().toString()), Integer.parseInt(jComboBox3.getSelectedItem().toString()),
                    Integer.parseInt(jTextField9.getText()));
        return c;
    }
    
    private void setTextEnabled(Boolean t, int i){
        if(i == 1){
            if(t){
                jTextField1.setEnabled(true);
                jTextField2.setEnabled(true);
                jTextField3.setEnabled(true);
                jTextField4.setEnabled(true);
                jTextField5.setEnabled(true);
                jTextField6.setEnabled(true);
                jTextField7.setEnabled(true);
                jTextField11.setEnabled(true);
                jCheckBox1.setEnabled(true);
            }
            else if (!t){
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jTextField3.setEnabled(false);
                jTextField4.setEnabled(false);
                jTextField5.setEnabled(false);
                jTextField6.setEnabled(false);
                jTextField7.setEnabled(false);
                jTextField11.setEnabled(false);
                jCheckBox1.setEnabled(false);
            }
        }
        else if(i == 2){
            if(t){
                jComboBox1.setEnabled(true);
                jComboBox2.setEnabled(true);
                jComboBox3.setEnabled(true);
                jTextField8.setEnabled(true);
                jTextField9.setEnabled(true);
                jTextField10.setEnabled(true);
            }
            else if(!t){
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(false);
                jComboBox3.setEnabled(false);
                jTextField8.setEnabled(false);
                jTextField9.setEnabled(false);
                jTextField10.setEnabled(false);
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup addressButtonGroup;
    private javax.swing.JComboBox cardNumber;
    private javax.swing.ButtonGroup deliveryButtonGroup;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JRadioButton newAdressButton;
    private javax.swing.JRadioButton newCardButton;
    private javax.swing.JRadioButton oldAdressButton;
    private javax.swing.JRadioButton oldCardButton;
    private javax.swing.ButtonGroup paymentButtonGroup;
    private javax.swing.JButton purchase;
    private javax.swing.JComboBox selectedAddress;
    // End of variables declaration//GEN-END:variables
}
