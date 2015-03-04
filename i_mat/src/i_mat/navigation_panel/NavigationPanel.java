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
import i_mat.utilities.ColorScheme;
import java.awt.Color;

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

        autoSuggest1 = new i_mat.navigation_panel.SearchBoxPanel();
        navigationBar = new javax.swing.JToolBar();
        homeButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        backwardButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        autoSuggest2 = new i_mat.navigation_panel.SearchBoxPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
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

        backwardButton.setForeground(this.decideBackwardEnabledColor());
        backwardButton.setText("Bakåt");
        backwardButton.setFocusable(false);
        backwardButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backwardButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwardButtonActionPerformed(evt);
            }
        });
        navigationBar.add(backwardButton);

        forwardButton.setForeground(this.decideForwardEnabledColor());
        forwardButton.setText("Framåt");
        forwardButton.setFocusable(false);
        forwardButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        forwardButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });
        navigationBar.add(forwardButton);
        navigationBar.add(filler2);

        autoSuggest2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        navigationBar.add(autoSuggest2);
        navigationBar.add(filler6);
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

    private void backwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwardButtonActionPerformed
        if (IMat.moveBackwardPossible())
            IMat.moveBackward();
    }//GEN-LAST:event_backwardButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        IMat.setCenterStage(new ViewHomePanel());
    }//GEN-LAST:event_homeButtonActionPerformed

    private void listsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listsButtonActionPerformed
        IMat.setCenterStage(new ListView());
    }//GEN-LAST:event_listsButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        IMat.setCenterStage(new CustomerProfilePanel());
    }//GEN-LAST:event_profileButtonActionPerformed

    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        if (IMat.moveForwardPossible())
            IMat.moveForward();
    }//GEN-LAST:event_forwardButtonActionPerformed

    public void setNavButtonsColor() {
        this.backwardButton.setForeground(decideBackwardEnabledColor());
        this.forwardButton.setForeground(decideForwardEnabledColor());
    }
    
    private Color decideBackwardEnabledColor() {
        if (IMat.moveBackwardPossible()) {
            return ColorScheme.enabledButtonForeground();
        }
        return ColorScheme.disabledButtonForeground();
    }
    
     private Color decideForwardEnabledColor() {
        if (IMat.moveForwardPossible()) {
            return ColorScheme.enabledButtonForeground();
        }
        return ColorScheme.disabledButtonForeground();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private i_mat.navigation_panel.SearchBoxPanel autoSuggest1;
    private i_mat.navigation_panel.SearchBoxPanel autoSuggest2;
    private javax.swing.JButton backwardButton;
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
    // End of variables declaration//GEN-END:variables
}
