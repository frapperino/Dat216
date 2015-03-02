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
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
public class Model {
    private static final IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private static final List<Product> promoProducts = Arrays.asList(dataHandler.getProduct(1), dataHandler.getProduct(2));
    private static final List<DeliveryAddress> deliveryAddresses = new ArrayList<DeliveryAddress>();
    
    /* 
     * Analogous to the constructor of an instantiatable class. Add any set-up
     * procedures here...
     */
    static {
        
    }
    
    /*
     * ... but *do not* add them here.
     */
    private Model() {};
    
    /**
    * The standard way to get all products. 
    * Should exclude unwanted products on the "no show"-list.
    * @return all products except unwanted ones
    */
    public static List<Product> getAllProducts() {
        return dataHandler.getProducts();
    }
    
    public static List<Product> getPromoProducts() {
        return dataHandler.getProducts().subList(0, 10);
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
    
    /**
     * Changes the default delivery address.
     * @param deliveryAddress The new default address.
     */
    public static void setDefaultDeliveryAddress(DeliveryAddress deliveryAddress) {
        Customer backendCustomer = dataHandler.getCustomer();
        
        deliveryAddresses.add(new DeliveryAddress(backendCustomer));
        deliveryAddresses.remove(deliveryAddress);
        
        backendCustomer.setFirstName(deliveryAddress.getFirstName());
        backendCustomer.setLastName(deliveryAddress.getLastName());
        backendCustomer.setAddress(deliveryAddress.getAddress());
        backendCustomer.setPostCode(deliveryAddress.getPostCode());
        backendCustomer.setPostAddress(deliveryAddress.getPostAddress());
        backendCustomer.setPhoneNumber(deliveryAddress.getPhoneNumber());
        backendCustomer.setMobilePhoneNumber(deliveryAddress.getMobilePhoneNumber());
        backendCustomer.setEmail(deliveryAddress.getEmail());
    }
    
//TODO fix this    public static void editDeliveryAddress() 
    
    /**
     * Return a customer from the database for testing.
     * @return 
     */
    public static Customer getTestCustomer() {
        return new DeliveryAddress("Test", "Testsson", "Testgatan 42", "123 45",
                    "Testberga", "031-420420", "070-312 1337", "test@test.test");
    }
    
    public static void save() {
        dataHandler.shutDown();
    }
    
    public static List<Order> getOrderHistory() {
        
        //Commented code below was for adding when testing only, not actual functionlity.
        /*
        
        Random r = new Random();
        int nbrOfProducts = r.nextInt(29) + 1;
        //Only for testing: fills shopping cart with up to 30 random products and places order.
        for (int i = 0; i<nbrOfProducts; i++) {
            Product p = dataHandler.getProducts().get((r.nextInt(dataHandler.getProducts().size())));            
            addShoppingItem(new ShoppingItem(p));
        }
        dataHandler.placeOrder();*/
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
                dataHandler.getShoppingCart().fireShoppingCartChanged(item, containsItem);
            }
        }
        if (!containsItem) {
            dataHandler.getShoppingCart().addItem(i);
        }
    }
    
    public static ShoppingCart getShoppingCart() {
        return dataHandler.getShoppingCart();
    }
}
