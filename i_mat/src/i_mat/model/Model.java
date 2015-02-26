/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import java.awt.Dimension;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Hjort
 */
public class Model {
    private static final IMatDataHandler dataHandler = IMatDataHandler.getInstance(); 
    
    /**
    * The standard way to get all products. 
    * Should exclude unwanted products on the "no show"-list.
    * @return all products except unwanted ones
    */
    public static List<Product> getAllProducts() {
        return dataHandler.getProducts();
    }
    
    /**
     * Return a product from the database for testing where you need one product
     */
    public static Product getTestProduct() {
        return dataHandler.getProducts().get(3);
    }
    
    public static ImageIcon getImageIconForProduct(Product p, Dimension d) {
        return Model.dataHandler.getImageIcon(p, d);
    }
}
