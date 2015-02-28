/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
public class Model {
    private static final IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private static final List<Product> promoProducts = Arrays.asList(dataHandler.getProduct(1), dataHandler.getProduct(2));
    /**
    * The standard way to get all products. 
    * Should exclude unwanted products on the "no show"-list.
    * @return all products except unwanted ones
    */
    public static List<Product> getAllProducts() {
        return dataHandler.getProducts();
    }
    
    public static List<Product> getPromoProducts() {
        return promoProducts;
    }
    
    /**
     * Return a product from the database for testing where you need one product
     * @return 
     */
    public static Product getTestProduct() {
        return dataHandler.getProducts().get(3);
    }
    
    public static ImageIcon getImageIconForProduct(Product p, Dimension d) {
        return Model.dataHandler.getImageIcon(p, d);
    }
    
    public static void save() {
        dataHandler.shutDown();
    }
    
    public static List<Order> getOrderHistory() {
        Random r = new Random();
        int nbrOfProducts = r.nextInt(29) + 1;
        //Only for testing: fills shopping cart with up to 30 random products and places order.
        for (int i = 0; i<nbrOfProducts; i++) {
            Product p = dataHandler.getProducts().get((r.nextInt(dataHandler.getProducts().size())));            
            addShoppingItem(new ShoppingItem(p));
        }
        dataHandler.placeOrder();
        return dataHandler.getOrders();
    }
    
    /*
    Resets dataHandler.isFirstRun() to true
    */
    public static void resetToFirstRun() {
        dataHandler.resetFirstRun();
    }
    /*
    Resets data handler completely.
    */
    public static void reset() {
        dataHandler.reset();
    }
    
    /*
    Use this for adding products to shopping cart. It first checks whether the 
    product is already in the shopping cart. If it is, the method just adds more
    of the same, rather than create a new item in the shopping cart.
    */
    public static void addShoppingItem(ShoppingItem i) {
        List<ShoppingItem> items = dataHandler.getShoppingCart().getItems();
        boolean containsItem = false;
        for (ShoppingItem item : items) {
            if (i.getProduct().equals(item.getProduct())) {
                item.setAmount(item.getAmount() + i.getAmount());
                containsItem = true;
            }
        }
        if (!containsItem) {
            dataHandler.getShoppingCart().addItem(i);
        }
    }
}
