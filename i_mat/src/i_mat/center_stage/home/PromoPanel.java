/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.home;

import i_mat.center_stage.ProductThumbnail;
import i_mat.center_stage.ResultsPanel;
import i_mat.center_stage.ThumbsPanel;
import i_mat.center_stage.WrapLayout;
import i_mat.model.Model;
import i_mat.utilities.GenerateComponentsUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author time
 */
public class PromoPanel extends JScrollPane {

    private PromoPanel.InternalMainPanel mainPanel;
    
    /**
     * Creates new form PromoPanel
     */
    public PromoPanel() {
        this(Model.getPromoProducts());
    }
    
    public PromoPanel(List<Product> prodList) {
        this.mainPanel = new PromoPanel.InternalMainPanel(prodList, this);
        this.getViewport().add(mainPanel);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.SHIFT_DOWN_MASK), "putInCart");
            this.getActionMap().put("putInCart", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   for (ProductThumbnail thumb : mainPanel.displayList)
                       if (thumb.isSelected()) thumb.addThisToShoppingCart();
                    };
                });
    }
    
    private static class InternalMainPanel extends JPanel {
        private List<ProductThumbnail> displayList;
        public InternalMainPanel(List<Product> prodList, JScrollPane parent) {
            super(new WrapLayout(FlowLayout.LEFT));
            this.displayList = GenerateComponentsUtilities.generateThumbnailsFromProducts(prodList);
            for (ProductThumbnail thumb : this.displayList) {
                this.add(thumb);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
