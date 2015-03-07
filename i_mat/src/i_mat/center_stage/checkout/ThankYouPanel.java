/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.checkout;


import i_mat.model.CreditCardInstance;
import i_mat.model.DeliveryAddress;
import i_mat.model.Model;
import static i_mat.model.Model.getDeliveryAddresses;
import i_mat.utilities.GenerateComponentsUtilities;
import java.util.ArrayList;
import javax.swing.JList;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Fredrik
 */
public class ThankYouPanel extends javax.swing.JPanel {
    /**
     * Creates new form ThankYouPanel
     */
    Order order;
    DeliveryAddress delivery;
    CreditCardInstance card;
    ArrayList<String> orderItems;
    ArrayList<Integer> orderItemsAmount;
    int amount;
    String sub, rev, rev2, mask, returnString, s, sum;
    StringBuilder sb;
    String cType, cName, cNum;
            
    public ThankYouPanel() {
        initComponents();
    }
    
    /* behövs inte
    public ThankYouPanel(Order o, DeliveryAddress d, String cType, String cName, String cNum){
        initComponents();
        this.order = o;
        this.delivery = d;
        this.cType = cType;
        this.cName = cName;
        this.cNum = cNum;
                
        orderItems = new ArrayList<String>();
        orderItemsAmount = new ArrayList<Integer>();
        
        for (int i = 0; i < order.getItems().size(); i++){
            orderItems.add(order.getItems().get(i).getProduct().getName());
            amount = (int) Math.floor(order.getItems().get(i).getAmount());
            orderItemsAmount.add(amount);
        }
        
        itemNumberField.setText(arrayParse(orderItemsAmount));
        
        orderNrL.setText(""+ order.getOrderNumber());
        orderDateL.setText(GenerateComponentsUtilities.getNameFromDate(order.getDate()));
        shoppingCartList.setText(arrayParse(orderItems));
        firstNameL.setText(delivery.getFirstName());
        lastNameL.setText(delivery.getLastName());
        custAddress.setText(delivery.getAddress());
        jLabel11.setText(delivery.getPostAddress());
        postCode.setText(delivery.getPostCode());
        phoneNumber.setText(delivery.getPhoneNumber());
        cellNumber.setText(delivery.getMobilePhoneNumber());
        jLabel13.setText(delivery.getEmail());
        
        jLabel18.setText(cNum);
        jLabel22.setText(cName);
        jLabel20.setText(cType);
        
    }
    */
    
    public ThankYouPanel(Order o, DeliveryAddress d, CreditCardInstance c, String sum ){
        initComponents();
        this.order = o;
        this.delivery = d;
        this.card = c;
        this.sum = sum;
        orderItems = new ArrayList<String>();
        orderItemsAmount = new ArrayList<Integer>();
        
        for (int i = 0; i < order.getItems().size(); i++){
            orderItems.add(order.getItems().get(i).getProduct().getName());
            amount = (int) Math.floor(order.getItems().get(i).getAmount());
            orderItemsAmount.add(amount);
        }
        
        itemNumberField.setText(arrayParse(orderItemsAmount));
        
        sub = card.getCardNumber();
        /* denna var för att maska kortet med **** men ändras nu med flera input-fields (todo)
        rev = new StringBuilder(sub).reverse().toString();
        mask = rev.substring(4);
        sb = new StringBuilder();
        
        for(int i = 0; i < mask.length(); i++){
            sb.append("*");
        }
        s = sb.toString();
        
        rev2 = new StringBuilder(rev.substring(0, 4)).reverse().toString();
        returnString = s + rev2;
        */
        
        //kvittot
        //leveransens info
        orderNrL.setText(""+ order.getOrderNumber());
        orderDateL.setText(GenerateComponentsUtilities.getNameFromDate(order.getDate()));
        shoppingCartList.setText(arrayParse(orderItems));
        firstNameL.setText(delivery.getFirstName());
        lastNameL.setText(delivery.getLastName());
        custAddress.setText(delivery.getAddress());
        jLabel11.setText(delivery.getPostAddress());
        postCode.setText(delivery.getPostCode());
        phoneNumber.setText(delivery.getPhoneNumber());
        cellNumber.setText(delivery.getMobilePhoneNumber());
        jLabel13.setText(delivery.getEmail());
        
        //kortets info
        jLabel18.setText(sub); //returnString här sen
        jLabel22.setText(card.getHolder());
        jLabel20.setText(card.getCardType());
        jLabel24.setText(sum);
    }
    
    
    public String arrayParse(ArrayList list){
        String done = ""; 
        for (Object s : list){
            done += s + "\n";
        }
        return done;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstNameL = new javax.swing.JLabel();
        lastNameL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shoppingCartList = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        custAddress = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        postCode = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cellNumber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        orderNrL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        orderDateL = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemNumberField = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Tack för ditt köp!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Här kommer ditt kvitto");

        firstNameL.setText("\"ändras\"");

        lastNameL.setText("\"ändras\"");

        shoppingCartList.setColumns(20);
        shoppingCartList.setRows(5);
        jScrollPane1.setViewportView(shoppingCartList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Varor:");

        jlabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlabel5.setText("Leveransadress:");

        custAddress.setText("\"ändras\"");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Postkod:");

        postCode.setText("\"ändras\"");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Telefonnummer:");

        phoneNumber.setText("\"ändras\"");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Mobilnummer:");

        cellNumber.setText("\"ändras\"");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Ordernummer:");

        orderNrL.setText("\"ändras\"");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Orderdatum");

        orderDateL.setText("\"ändras\"");

        itemNumberField.setColumns(20);
        itemNumberField.setRows(5);
        jScrollPane2.setViewportView(itemNumberField);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Antal:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Stad:");

        jLabel11.setText("\"ändras\"");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Email:");

        jLabel13.setText("\"ändras\"");

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel14.setText("Leveransuppgifter");

        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel15.setText("Betalningsuppgifter");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Mottagare:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Korttyp:");

        jLabel18.setText("\"ändras\"");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Kortnummer:");

        jLabel20.setText("\"ändras\"");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Kortinnehavare:");

        jLabel22.setText("\"ändras\"");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Totalt: ");

        jLabel24.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cellNumber))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderNrL))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderDateL))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postCode))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(phoneNumber))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(custAddress))
                                    .addComponent(jLabel15)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(firstNameL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lastNameL))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)))
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(firstNameL)
                        .addComponent(lastNameL)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(custAddress)
                                .addComponent(jlabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(postCode))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(phoneNumber))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cellNumber))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(orderNrL))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(orderDateL))
                            .addGap(45, 45, 45)
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel18)))
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel20))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel24)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cellNumber;
    private javax.swing.JLabel custAddress;
    private javax.swing.JLabel firstNameL;
    private javax.swing.JTextArea itemNumberField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel lastNameL;
    private javax.swing.JLabel orderDateL;
    private javax.swing.JLabel orderNrL;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JLabel postCode;
    private javax.swing.JTextArea shoppingCartList;
    // End of variables declaration//GEN-END:variables
}
