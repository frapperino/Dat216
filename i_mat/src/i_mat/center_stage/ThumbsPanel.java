/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage;

import i_mat.model.Model;
import i_mat.utilities.ColorScheme;
import i_mat.utilities.Filter;
import i_mat.utilities.GUIConstants;
import i_mat.utilities.GenerateComponentsUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Hjort
 */
public class ThumbsPanel extends JScrollPane implements ResultsPanel {

    private InternalMainPanel mainPanel;
    private List<Product> prodList;
    
    public ThumbsPanel() {
        this(Model.getPromoProducts());
    }
    
    public ThumbsPanel(List<Product> prodList) {
        //Copies product list so that stuff does not get rearranged/sorted
        this.setBorder(BorderFactory.createEmptyBorder());
        this.prodList = prodList.subList(0, prodList.size());
        this.getVerticalScrollBar().setUnitIncrement(GUIConstants.SCROLL_INCREMENT);
        this.redoFromNewProdList(prodList);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.SHIFT_DOWN_MASK), "putInCart");
        this.getActionMap().put("putInCart", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
               putSelectedInCart();
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_DOWN_MASK), "selectAll");
        this.getActionMap().put("selectAll", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
               selectAll();
            }
        });
    }
    
    private void selectAll() {
        for (ProductThumbnail thumb : mainPanel.displayList) {
            thumb.setSelected();
        } 
    }
    
    private void redoFromNewProdList(List<Product> prodList) {
        this.getViewport().removeAll();
        this.mainPanel = new InternalMainPanel(prodList, this);
        this.getViewport().add(mainPanel);
        this.revalidate();
        this.getViewport().repaint();
    }
    
    @Override
    public void putSelectedInCart() {
        for (ProductThumbnail thumb : mainPanel.displayList) {
            if (thumb.isSelected()) {
                thumb.addThisToShoppingCart();
                thumb.setUnselected();
            }
        }
    }

    @Override
    public void sortBy(Comparator<Product> c) {
        System.out.println("Sort by");
        this.prodList.sort(c);
        this.redoFromNewProdList(this.prodList);
    }

    @Override
    public void filterBy(Filter f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       private static class InternalMainPanel extends JPanel {
        private List<ProductThumbnail> displayList;
        public InternalMainPanel(List<Product> prodList, JScrollPane parent) {
            super(new WrapLayout(FlowLayout.LEFT));
            this.displayList = GenerateComponentsUtilities.generateThumbnailsFromProducts(prodList);
            for (ProductThumbnail thumb : this.displayList) {
                this.add(thumb);
                this.revalidate();
                this.repaint();
                this.updateUI();
            }
            this.setBackground(ColorScheme.getThumbsPanelBackground());
            addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                for(ProductThumbnail prod: displayList) {
                    prod.setUnselected();
                }
            
            }
        });
        }
        
        
    }
    
}
