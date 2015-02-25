/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage;

import i_mat.model.Model;
import i_mat.utilities.Filter;
import i_mat.utilities.GenerateComponentsUtilities;
import java.awt.FlowLayout;
import java.util.Comparator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Hjort
 */
public class ThumbsPanel extends JScrollPane implements ResultsPanel {

    private InternalMainPanel mainPanel;
    
    public ThumbsPanel() {
        this(Model.getAllProducts());
    }
    
    public ThumbsPanel(List<Product> prodList) {
        this.mainPanel = new InternalMainPanel(prodList, this);
        this.getViewport().add(mainPanel);
        
    }

    
    @Override
    public void sortBy(Comparator<Product> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            }
        }
    }
    
}
