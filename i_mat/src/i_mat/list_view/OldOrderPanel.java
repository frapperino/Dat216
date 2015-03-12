/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.list_view;

import i_mat.model.Model;
import i_mat.utilities.GenerateComponentsUtilities;
import i_mat.utilities.ListOrder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalIconFactory;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
public class OldOrderPanel extends javax.swing.JPanel implements ActionListener{

    private Order order;
    private HistoryFullListPanel fullList;
    private boolean clicked = false;
    private JButton collapseButton;
    private String name;
    
    /**
     * Creates new form OldOrderPanel
     */
    public OldOrderPanel() {
        this(Model.getOrderHistory().get(0));
    }

    public OldOrderPanel(Order o) {
        this.order = o == null ? new Order(): o;
        this.fullList = new HistoryFullListPanel(this.order);
        this.collapseButton = new JButton();
        this.collapseButton.setBackground(Color.red);
        this.collapseButton.setIcon(new MetalIconFactory.PaletteCloseIcon());
        this.collapseButton.setOpaque(false);
        this.collapseButton.setText(null);
        this.collapseButton.addActionListener(this);
        initComponents();
        this.jButton1.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        changeNameMenuItem = new javax.swing.JMenuItem();
        subPanel = new javax.swing.JPanel();
        subLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        headPanel = new javax.swing.JPanel();
        headLabel = new javax.swing.JLabel();

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem1.setText("Radera");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        changeNameMenuItem.setText("Ändra namn");
        changeNameMenuItem.setEnabled(this.order instanceof ListOrder);
        changeNameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(changeNameMenuItem);

        setBackground(new java.awt.Color(0, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(600, 0));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        subPanel.setOpaque(false);
        subPanel.setLayout(new java.awt.BorderLayout());

        subLabel.setFont(subLabel.getFont().deriveFont(subLabel.getFont().getSize()-1f));
        subLabel.setForeground(new java.awt.Color(153, 153, 153));
        subLabel.setText(GenerateComponentsUtilities.getProductsString(this.order.getItems()));
        subLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subLabelMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        subPanel.add(subLabel, java.awt.BorderLayout.CENTER);

        jPanel1.setMinimumSize(jButton1.minimumSize());
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(jButton1.preferredSize());
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cart.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        headPanel.setMinimumSize(new java.awt.Dimension(123, 300));
        headPanel.setOpaque(false);
        headPanel.setLayout(new java.awt.BorderLayout());

        headLabel.setFont(headLabel.getFont().deriveFont(headLabel.getFont().getStyle() | java.awt.Font.BOLD, headLabel.getFont().getSize()+5));
        headLabel.setText(this.getListName());
        headLabel.setToolTipText("");
        headLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        headLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        headPanel.add(headLabel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(406, 415, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void headLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headLabelMouseClicked
        
        
    }//GEN-LAST:event_headLabelMouseClicked

    String getListName() {
        return GenerateComponentsUtilities.getNameFromDate(this.order.getDate());
    }
    
    void setHeader() {
        this.headLabel.setText(this.getListName());
        this.revalidate();
    }
    
    private void headLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headLabelMousePressed
         if (evt.isPopupTrigger()) {
            this.popupMenu(evt);
        } else {
             this.switchView();
         }
    }//GEN-LAST:event_headLabelMousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Model.ereaseOrderFromHistory(this.order);
        this.revalidate();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void subLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subLabelMousePressed
        headLabelMousePressed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_subLabelMousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.jButton1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.jButton1.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.addWholeOrderToShoppingCart();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changeNameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameMenuItemActionPerformed
        if(this.order instanceof ListOrder)
            this.startNameChange();        // TODO add your handling code here:
    }//GEN-LAST:event_changeNameMenuItemActionPerformed
      
    private void startNameChange() {
        this.headPanel.remove(this.headLabel);
        final JTextField tf = new JTextField();
        tf.setText(this.headLabel.getText());
        tf.setFont(this.headLabel.getFont());
        tf.requestFocus();
        this.headPanel.add(tf);
        this.headPanel.revalidate();
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishNameChange(tf.getText()); 
            }
        });
    }
    
    private void finishNameChange(String name) {
        headLabel.setText(name);
        headPanel.removeAll();
        headPanel.add(headLabel);
        if (this.order instanceof ListOrder) {
            ((ListOrder)this.order).setName(name);
        }
        headPanel.setPreferredSize(this.headLabel.getPreferredSize());
        headPanel.revalidate();
    }
    
    private void addWholeOrderToShoppingCart() {
        for (ShoppingItem item : this.order.getItems()) {
            Model.addShoppingItem(item);
        }
    }
    
    private void popupMenu(java.awt.event.MouseEvent evt){
        this.jPopupMenu1.show(this, evt.getX(), evt.getY());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changeNameMenuItem;
    private javax.swing.JLabel headLabel;
    private javax.swing.JPanel headPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel subLabel;
    private javax.swing.JPanel subPanel;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.switchView();
    }
    
    private void switchView() {
        if (this.clicked) {
            this.subPanel.removeAll();
            this.subLabel.setText(GenerateComponentsUtilities.getProductsString(this.order.getItems()));
            this.subPanel.add(this.subLabel);
        }
        else {
            this.subPanel.removeAll();
            this.subPanel.add(this.fullList);
            this.subPanel.add(this.collapseButton, BorderLayout.SOUTH);
        }
        this.clicked = !this.clicked;
        this.revalidate();
        this.firePropertyChange("Changed value", !clicked, clicked);
    }
}
