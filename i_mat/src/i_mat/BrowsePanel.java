/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author weeeeeew
 */
public class BrowsePanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowsePanel
     */
    public BrowsePanel() {
        initComponents();
        BrowseTree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                                                        Object value,
                                                        boolean selected,
                                                        boolean expanded,
                                                        boolean leaf,
                                                        int row,
                                                        boolean hasFocus) {
                // Allow the original renderer to set up the label
                Component c = super.getTreeCellRendererComponent(
                      tree, value, selected,
                      expanded, leaf, row,
                      hasFocus); 

                if (leaf) { 
                    c.setBackground(Color.BLUE);
                } 

                return c; 
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BrowseScrollPane = new javax.swing.JScrollPane();
        BrowseTree = new javax.swing.JTree();

        BrowseTree.setName(""); // NOI18N
        BrowseTree.setRootVisible(false);
        BrowseTree.setScrollsOnExpand(true);
        BrowseScrollPane.setViewportView(BrowseTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BrowseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BrowseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane BrowseScrollPane;
    private javax.swing.JTree BrowseTree;
    // End of variables declaration//GEN-END:variables
}
