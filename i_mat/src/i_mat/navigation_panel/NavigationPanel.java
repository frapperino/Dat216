/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.navigation_panel;

import i_mat.IMat;
import i_mat.center_stage.customer_profile.CustomerProfilePanel;
import i_mat.center_stage.home.ViewHomePanel;
import i_mat.list_view.ListView;

/**
 *
 * @author weeeeeew
 */
public class NavigationPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchPanel
     */
    public NavigationPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationBar = new javax.swing.JToolBar();
        homeButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        backButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        searchField = new javax.swing.JTextField();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        listsButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        profileButton = new javax.swing.JButton();

        navigationBar.setFloatable(false);
        navigationBar.setRollover(true);

        homeButton.setText("Hem");
        homeButton.setFocusable(false);
        homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        navigationBar.add(homeButton);
        navigationBar.add(filler1);

        backButton.setText("Bakåt");
        backButton.setFocusable(false);
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        navigationBar.add(backButton);

        forwardButton.setText("Framåt");
        forwardButton.setFocusable(false);
        forwardButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        forwardButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navigationBar.add(forwardButton);
        navigationBar.add(filler2);
        navigationBar.add(filler6);

        searchField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        searchField.setText("Sök produkter och kategorier");
        searchField.setToolTipText("");
        navigationBar.add(searchField);
        navigationBar.add(filler4);
        navigationBar.add(filler5);

        listsButton.setText("Inköpslistor");
        listsButton.setFocusable(false);
        listsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        listsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listsButtonActionPerformed(evt);
            }
        });
        navigationBar.add(listsButton);
        navigationBar.add(filler3);

        profileButton.setText("Mina sidor");
        profileButton.setFocusable(false);
        profileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        navigationBar.add(profileButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        IMat.setCenterStage(new ViewHomePanel());
    }//GEN-LAST:event_homeButtonActionPerformed

    private void listsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listsButtonActionPerformed
        IMat.setCenterStage(new ListView());
    }//GEN-LAST:event_listsButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        IMat.setCenterStage(new CustomerProfilePanel());
    }//GEN-LAST:event_profileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JButton forwardButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton listsButton;
    private javax.swing.JToolBar navigationBar;
    private javax.swing.JButton profileButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
