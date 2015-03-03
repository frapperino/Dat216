/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static List<DeliveryAddress> deliveryAddresses;
    private static List<CreditCardInstance> creditCards;
    private static final String ADDRESSES_FILENAME = "addresses.imat",
                                CREDITCARDS_FILENAME = "cards.imat";
    

    /*
    * Analogous to the constructor of an instantiatable class. Add any set-up
    * procedures here...
    */
    static {
        readAddresses();
        readCreditCards();
    }

    /*
     * ... but *do not* add them here.
     */
    private Model() {};
    
    private static void readAddresses() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(ADDRESSES_FILENAME));
            Object o = ois.readObject();
            if(o instanceof List) {
                deliveryAddresses = (List) o;
            }
        } catch (ClassNotFoundException | IOException ex) {
            deliveryAddresses = new ArrayList<>();
            deliveryAddresses.add(new DeliveryAddress(dataHandler.getCustomer()));
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                System.out.println("Unable to close input stream.");
                ex.printStackTrace();
            } catch (NullPointerException ex) {}
        }
    }

    private static void readCreditCards() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(CREDITCARDS_FILENAME));
            Object o = ois.readObject();
            if(o instanceof List) {
                creditCards = (List) o;
            }
        } catch (ClassNotFoundException | IOException ex) {
            creditCards = new ArrayList<>();
            creditCards.add(new CreditCardInstance(dataHandler.getCreditCard()));
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                System.out.println("Unable to close input stream.");
                ex.printStackTrace();
            } catch (NullPointerException ex) {}
        }
    }

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

    /**
     * Edits the address stored in the backend so that it matches the parameter.
     * @param newAddress The new address. Should be a modified version of an address
     *                   that was previously returned by the Model.
     */
    public static void editDeliveryAddress(DeliveryAddress newAddress) {
        DeliveryAddress internalAddress = null;

        for (DeliveryAddress deliveryAddress : deliveryAddresses) {
            if (deliveryAddress.getID().equals(newAddress.getID())) {
                internalAddress = deliveryAddress;
                break;
            }
        }

        internalAddress.setFirstName(newAddress.getFirstName());
        internalAddress.setLastName(newAddress.getLastName());
        internalAddress.setAddress(newAddress.getAddress());
        internalAddress.setPostCode(newAddress.getPostCode());
        internalAddress.setPostAddress(newAddress.getPostAddress());
        internalAddress.setPhoneNumber(newAddress.getPhoneNumber());
        internalAddress.setMobilePhoneNumber(newAddress.getMobilePhoneNumber());
        internalAddress.setEmail(newAddress.getEmail());

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
    
    public static List<CreditCardInstance> getCreditCards() {
        List<CreditCardInstance> externalCards = new LinkedList<>();

        for (CreditCardInstance cc : creditCards) {
            externalCards.add(cc.copy());
        }

        return externalCards;
    }

    /**
     * Returns the address with the ID, if it exists. Otherwise null.
     * @param id The ID of the address.
     * @return The address.
     */
    public static DeliveryAddress getAddress(String id) {
        DeliveryAddress externalAddress = null;
        
        for (DeliveryAddress internalAddress : deliveryAddresses) {
            if (internalAddress.getID().equals(id)) {
                externalAddress = internalAddress.copy();
                break;
            }
        }
        
        return externalAddress;
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

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADDRESSES_FILENAME));
            oos.writeObject((Serializable) deliveryAddresses);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Could not save delivery addresses to file.");
            ex.printStackTrace();
        }
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
        List <Product> l = getPromoProducts();
        List<Product> theirList;
        switch (name) {
            //BAKARTIKLAR
            case ("Mjöl") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.retainAll(dataHandler.findProducts("mjöl"));
                return l;
            case ("Salt") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.clear();
                l.addAll(dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT));
                l.retainAll(dataHandler.findProducts("salt"));
                return l;
            case ("Socker") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.addAll(dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT));
                l.retainAll(dataHandler.findProducts("socker"));
                return l;
            
            //BRÖD
            case("Bröd") :
                return dataHandler.getProducts(ProductCategory.BREAD);
                
            //BÖNOR, ÄRTOR LINSER
            case("Bönor, Ärtor & Linser") :
                return dataHandler.getProducts(ProductCategory.POD);
            
            //FRUKT OCH GÖNT
                //Bär
            case("Bär") :
                return dataHandler.getProducts(ProductCategory.BERRY);
                //Berry does not return any values. Why? Backend problem?
                
                //Frukt
            case ("Citrus") :
                return dataHandler.getProducts(ProductCategory.CITRUS_FRUIT);
            case ("Exotiskt") :
                return dataHandler.getProducts(ProductCategory.EXOTIC_FRUIT);
            case ("Meloner") :
                return dataHandler.getProducts(ProductCategory.MELONS);
            case ("Stenfrukter") :
                return dataHandler.getProducts(ProductCategory.FRUIT);
                //
            case ("Grönsaker") :
                return dataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT);
                //
            case ("Kryddväxter") :
                return dataHandler.getProducts(ProductCategory.HERB);
            //
            case ("Kål") :
                return dataHandler.getProducts(ProductCategory.CABBAGE);
            //
            case ("Nötter & Frön") :
                return dataHandler.getProducts(ProductCategory.NUTS_AND_SEEDS);
            case ("Potatis") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.clear();
                l.addAll(dataHandler.getProducts(ProductCategory.POTATO_RICE));
                l.retainAll(dataHandler.findProducts("potatis"));
                l.removeAll(dataHandler.findProducts("potatispur"));
                return l;    
            default :
                return new LinkedList<>();
        }
    }
}
