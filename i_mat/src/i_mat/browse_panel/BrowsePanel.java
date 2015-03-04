/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.browse_panel;

import i_mat.IMat;
import i_mat.center_stage.DisplayResultsPanel;
import i_mat.center_stage.ThumbsPanel;
import i_mat.model.Model;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author weeeeeew
 */
public class BrowsePanel extends javax.swing.JPanel {
    
    private List<Thread> threadList = new LinkedList<>();
    /**
     * Creates new form BrowsePanel
     */
    public BrowsePanel() {
        initComponents();
        browseTree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                                                        Object value,
                                                        boolean selected,
                                                        boolean expanded,
                                                        boolean leaf,
                                                        int row,
                                                        boolean hasFocus) {
                             
                //Use the standard tree cell renderer
                Component c = super.getTreeCellRendererComponent(
                      tree, value, selected,
                      expanded, leaf, row,
                      hasFocus); 
                return c; 
            }
        });
        DefaultTreeCellRenderer rend = (DefaultTreeCellRenderer)browseTree.getCellRenderer();
        rend.setClosedIcon(null);
        rend.setOpenIcon(null);
        rend.setLeafIcon(null);
        rend.setOpaque(false);
        rend.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseScrollPane = new javax.swing.JScrollPane();
        browseTree = new javax.swing.JTree();

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Bakartiklar");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mjöl");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Salt");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Socker & Kakao");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Bröd");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Bönor, Ärtor & Linser");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Frukt & Grönt");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Bär");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Frukt");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Citrus");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Exotiskt");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Meloner");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Stenfrukter");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Grönsaker");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kryddväxter");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kål");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Nötter & Frön");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Rotfrukter");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Potatis");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Övriga rotfrukter");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Dryck");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kaffe & Te");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Kalla drycker");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Fisk");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Kött");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Mejeri");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fil & Yoghurt");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mjölk");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Ost");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Pasta");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Ris");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Snacks");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Ägg");
        treeNode1.add(treeNode2);
        browseTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        browseTree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        browseTree.setName(""); // NOI18N
        browseTree.setRootVisible(false);
        browseTree.setShowsRootHandles(true);
        browseTree.setToggleClickCount(1);
        browseTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                browseTreeValueChanged(evt);
            }
        });
        browseScrollPane.setViewportView(browseTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(browseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_browseTreeValueChanged
        loadProducts();
    }//GEN-LAST:event_browseTreeValueChanged

    private void loadProducts() {
        this.setCenterStageFromList(this.getProductListFromSelection(browseTree.getLastSelectedPathComponent()));

    }
    
    private List<Product> getProductListFromSelection(Object node) {
        //If this is a leaf, just get the contents for it
        if (browseTree.getModel().isLeaf(node)) {
            return Model.getProductsInCategory(node.toString());
        }
        //Else look through the nodes and get all their products/
        else { 
            TreeNode n = (TreeNode)node;
            Enumeration children = n.children();
            List<Product> list = getProductListFromSelection(children.nextElement());
            while(children.hasMoreElements()) {
                for(Product p : getProductListFromSelection(children.nextElement())) {
                    list.add(p);
                }
            }
            return list;
        }
    }
    
    private void setCenterStageFromList(final List<Product> l) {
        Thread t = new SetStageThread(l);
        t.setPriority(Thread.MAX_PRIORITY);
        t.setDaemon(true);
        t.start();
    }
    

    private class SetStageThread extends Thread {
        private List<Product> l;
        
        public SetStageThread(List<Product> l) {
            this.l = l;
        }
        
        @Override
        public void run() {
            if (!this.getName().equals("kill")) {
                IMat.setLoadingCenterStage();
                IMat.setCenterStage(new DisplayResultsPanel(new ThumbsPanel(l)));
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane browseScrollPane;
    private javax.swing.JTree browseTree;
    // End of variables declaration//GEN-END:variables
}
