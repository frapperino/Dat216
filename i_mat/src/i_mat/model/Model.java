/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
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
        deliveryAddresses.add(new DeliveryAddress(dataHandler.getCustomer()));
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
     * @param id The id of the new default address.
     */
    public static void setDefaultDeliveryAddress(DeliveryAddress externalAddress) {
        Customer backendCustomer = dataHandler.getCustomer();
        DeliveryAddress newDefault = null;
        
        for (DeliveryAddress deliveryAddress : deliveryAddresses) {
            if (deliveryAddress.getID().equals(externalAddress.getID())) {
                newDefault = deliveryAddress;
                break;
            }
        }
        
        if (newDefault != null) {
            deliveryAddresses.remove(newDefault);
            deliveryAddresses.add(0,newDefault);
            
            backendCustomer.setFirstName(newDefault.getFirstName());
            backendCustomer.setLastName(newDefault.getLastName());
            backendCustomer.setAddress(newDefault.getAddress());
            backendCustomer.setPostCode(newDefault.getPostCode());
            backendCustomer.setPostAddress(newDefault.getPostAddress());
            backendCustomer.setPhoneNumber(newDefault.getPhoneNumber());
            backendCustomer.setMobilePhoneNumber(newDefault.getMobilePhoneNumber());
            backendCustomer.setEmail(newDefault.getEmail());
        }
    }
    
    public static void deleteDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddresses.remove(deliveryAddress);
        
        if (!deliveryAddresses.isEmpty()) {
            if (!deliveryAddresses.get(0).equals(dataHandler.getCustomer())) {
                setDefaultDeliveryAddress(deliveryAddresses.get(0));
            }
        } else {
            Customer backendCustomer = dataHandler.getCustomer();
            
            backendCustomer.setFirstName("");
            backendCustomer.setLastName("");
            backendCustomer.setAddress("");
            backendCustomer.setPostAddress("");
            backendCustomer.setPostCode("");
            backendCustomer.setEmail("");
            backendCustomer.setPhoneNumber("");
            backendCustomer.setMobilePhoneNumber("");
        }
    }
    
    public static void editDeliveryAddress(DeliveryAddress externalAddress) {
        DeliveryAddress internalAddress = null;
        System.out.println(externalAddress);
        
        for (DeliveryAddress deliveryAddress : deliveryAddresses) {
            System.out.println(deliveryAddress);
            if (deliveryAddress.getID().equals(externalAddress.getID())) {
                internalAddress = deliveryAddress;
                break;
            }
        }
        
        internalAddress.setFirstName(externalAddress.getFirstName());
        internalAddress.setLastName(externalAddress.getLastName());
        internalAddress.setAddress(externalAddress.getAddress());
        internalAddress.setPostCode(externalAddress.getPostCode());
        internalAddress.setPostAddress(externalAddress.getPostAddress());
        internalAddress.setPhoneNumber(externalAddress.getPhoneNumber());
        internalAddress.setMobilePhoneNumber(externalAddress.getMobilePhoneNumber());
        internalAddress.setEmail(externalAddress.getEmail());
        
        if (deliveryAddresses.indexOf(internalAddress) == 0) {
            setDefaultDeliveryAddress(internalAddress);
        }
    }
    
    public static DeliveryAddress getDefaultAddress() {
        return deliveryAddresses.get(0).copy();
    }
    
    public static void addDeliveryAddress(String firstName, String lastName, String address, String postCode, String postAddress, String phone) {
        DeliveryAddress newAddress = new DeliveryAddress(firstName, lastName, address, postCode, postAddress, phone, phone, null);
        deliveryAddresses.add(newAddress);
    }
    
    
    public static List<DeliveryAddress> getDeliveryAddresses() {
        List<DeliveryAddress> externalAddresses = new LinkedList<DeliveryAddress>();
        
        for (DeliveryAddress da : deliveryAddresses) {
            externalAddresses.add(da.copy());
        }
        
        return externalAddresses;
    }
    
    
    /**
     * Return a customer from the database for testing.
     * @return 
     */
    public static DeliveryAddress getTestDeliveryAddress() {
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
    
    public static List<Product> getProductsInCategory(String name) {
        switch (name) {
            case ("Bakartiklar") :
                return dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
            case("Bröd") :
                return dataHandler.getProducts(ProductCategory.BREAD);
            case("Bönor, Ärtor & Linser") :
                return dataHandler.getProducts(ProductCategory.POD);
            case("Frukt & Grönt") :
                List<Product> comboList = getProductsInCategory("Kål");
                comboList.addAll(getProductsInCategory("Bär"));
                comboList.addAll(getProductsInCategory("Citrus"));
                comboList.addAll(getProductsInCategory("Bär"));
                comboList.addAll(dataHandler.getProducts(ProductCategory.FRUIT));
                //comboList.addAll(dataHandler.getProducts(ProductCategory.));
                
               // return dataHandler.getProducts(ProductCategory.);
                 return Model.promoProducts;   
            default :
                return Model.promoProducts;
        }
        
    }
}
