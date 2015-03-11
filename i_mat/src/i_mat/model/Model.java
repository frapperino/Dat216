/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import i_mat.utilities.ListOrder;
import java.awt.Dimension;
import java.io.*;
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
import se.chalmers.ait.dat215.project.CreditCard;
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
                                CREDITCARDS_FILENAME = "cards.imat",
                                LISTS_FILENAME = "lists.imat";
    private static List<ListOrder> shoppingLists;
    

    /*
    * Analogous to the constructor of an instantiatable class. Add any set-up
    * procedures here...
    */
    static {
        readAddresses();
        readCreditCards();
    }

    public static Product getProduct(String name) {
        List<Product> s = getAllProducts();
        for (Product p: s) {
            if ((p.getName().toLowerCase()).equals(name.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    /*
     * ... but *do not* add them here.
     */
    private Model() {};
    
    private static void readShoppingLists() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(LISTS_FILENAME));
            Object o = ois.readObject();
            if (o instanceof List) {
                shoppingLists = (List<ListOrder>)o;
            }  
        } catch (ClassNotFoundException | IOException ex) {
            shoppingLists = new ArrayList<>();
        } 
        try {
            if (ois != null)
                ois.close();
        } catch (IOException ex) {
            System.out.println("Unable to close input stream");
            ex.printStackTrace();
        }
    }
        
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
     * Gives a List of all products returned by search function findProducts in 
     * the IMatDataHandler.
     * @param s String to be searched for.
     * @return A list containing all the products found.
     */
    public static List<Product> getSearchResults(String s) {
        return dataHandler.findProducts(s);
    }

    /**
     * Changes the default delivery address.
     * @param externalAddress the address that should be the new default.
     */
    public static void setDefaultDeliveryAddress(DeliveryAddress externalAddress) {
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

            setBackendAddress(newDefault);
        }
    }

    public static void deleteDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddresses.remove(deliveryAddress);

        if (!deliveryAddresses.isEmpty()) {
            if (!deliveryAddresses.get(0).equals(dataHandler.getCustomer())) {
                setDefaultDeliveryAddress(deliveryAddresses.get(0));
            }
        } else {
            clearBackendAddress();
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

        internalAddress.update(newAddress);

        if (deliveryAddresses.indexOf(internalAddress) == 0) {
            setDefaultDeliveryAddress(internalAddress);
        }
    }

    public static DeliveryAddress getDefaultAddress() {
        return deliveryAddresses.get(0).copy();
    }

    public static CreditCardInstance getDefaultCard() {
        return creditCards.get(0).copy();
    }
    
    public static void addDeliveryAddress(String firstName, String lastName, String address, String postCode, String postAddress, String phone, String cell, String email) {
        DeliveryAddress newAddress = new DeliveryAddress(firstName, lastName, address, postCode, postAddress, phone, cell, email);
        deliveryAddresses.add(newAddress);
        
        if (isBackendAddressEmpty()) {
            setBackendAddress(newAddress);
        }
    }

    public static List<DeliveryAddress> getDeliveryAddresses() {
        List<DeliveryAddress> externalAddresses = new LinkedList<DeliveryAddress>();

        for (DeliveryAddress da : deliveryAddresses) {
            externalAddresses.add(da.copy());
        }

        return externalAddresses;
    }
    
    public static void addCreditCard(String number, String type, String name, int month, int year, int cvc) {
        CreditCardInstance newCard = new CreditCardInstance(number, type, name, month, year, cvc);
        creditCards.add(newCard);
        
        if (isBackendCardEmpty()) {
            setBackendCard(newCard);
        }
    }
    
    public static void setDefaultCreditCard(CreditCardInstance externalCard) {
        CreditCard backendCard = dataHandler.getCreditCard();
        CreditCardInstance newDefault = null;
        
        for (CreditCardInstance creditCard : creditCards) {
            if (creditCard.getID().equals(externalCard.getID())) {
                newDefault = creditCard;
                break;
            }
        }
        
        if (newDefault != null) {
            creditCards.remove(newDefault);
            creditCards.add(0, newDefault);
            
            setBackendCard(newDefault);
        }
    }
    
    
    public static void deleteCreditCard(CreditCardInstance creditCard) {
        creditCards.remove(creditCard);
        
        if (!creditCards.isEmpty()) {
            if (!deliveryAddresses.get(0).equals(dataHandler.getCreditCard())) {
                setDefaultCreditCard(creditCards.get(0));
            }
        } else {
            clearBackendCard();
        }
    }
    
    public static List<CreditCardInstance> getCreditCards() {
        List<CreditCardInstance> externalCards = new LinkedList<>();

        for (CreditCardInstance cc : creditCards) {
            externalCards.add(cc.copy());
        }

        return externalCards;
    }
    
    public static CreditCardInstance getCreditCardByNum(String num) {
        CreditCardInstance cardIns = null;
        
        for (CreditCardInstance c : getCreditCards()) {
            if (c.getCardNumber().equals(num)) {
                cardIns = c.copy();
                break;
            }
        }
        
        return cardIns;
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
    //hahahah sry för paste-koden, behövde bara den här lite snabbt :D (används i checkoutpanel)
    public static DeliveryAddress getAddressByAddress(String address) {
        DeliveryAddress externalAddress2 = null;
        
        for (DeliveryAddress internalAddress : deliveryAddresses) {
            if (internalAddress.getAddress().equals(address)) {
                externalAddress2 = internalAddress.copy();
                break;
            }
        }
        
        return externalAddress2;
    }
    
    
    /**
     * Return a customer from the database for testing.
     * @return
     */
    public static DeliveryAddress getTestDeliveryAddress() {
        return new DeliveryAddress("Test", "Testsson", "Testgatan 42", "123 45",
                    "Testberga", "031-420420", "070-312 1337", "test@test.test");
    }
    
    public static List<ListOrder> getShoppingLists() {
        return new ArrayList<>(shoppingLists);
    }
    
    public static void addShoppingList(ListOrder ord) {
        if (shoppingLists == null) readShoppingLists();
        shoppingLists.add(ord);
    }
    
    public static void deleteOrderByOrder(ListOrder ord) {
        if (shoppingLists == null) readShoppingLists();
        shoppingLists.remove(ord);
    }
    
    public static ListOrder getTestShoppingList() {
        ListOrder o = new ListOrder("Test");
        List<ShoppingItem> l = new ArrayList<>();
        l.add(new ShoppingItem(getTestProduct(), 4.0));
        o.setItems(l);
        return o;
    }

    public static void save() {
        dataHandler.shutDown();
        saveAddresses();
        saveCreditCards();
    }

    private static void saveAddresses() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADDRESSES_FILENAME));
            oos.writeObject((Serializable) deliveryAddresses);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Could not save delivery addresses to file.");
            ex.printStackTrace();
        }
    }
    
    private static void saveCreditCards() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CREDITCARDS_FILENAME));
            oos.writeObject((Serializable) creditCards);
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
    
    public static void addToFavorites(Product p) {
        dataHandler.addFavorite(p);
    }
    
    public static void removeFromFavorites(Product p) {
        dataHandler.removeFavorite(p);
    }
    
    public static boolean isFavorite(Product p) {
        return dataHandler.isFavorite(p);
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
                fireShoppingCartChanged(item, containsItem);
            }
        }
        if (!containsItem) {
            dataHandler.getShoppingCart().addItem(i);
        }
    }
    
    /**
     * Fires a ShoppingCartChangedEvent
     * @param item
     * @param containsItem 
     */
    public static void fireShoppingCartChanged(ShoppingItem item, boolean containsItem) {
        dataHandler.getShoppingCart().fireShoppingCartChanged(item, containsItem);
    }

    public static ShoppingCart getShoppingCart() {
        return dataHandler.getShoppingCart();
    }
    
    public static List<Product> getProductsInCategory(ProductCategory category) { 
        return dataHandler.getProducts(category);
    }
    
    public static List<Product> getProductsInCategory(String name) {
        List <Product> l = new LinkedList<>();
        List<Product> theirList;
        Product p;
        switch (name) {
            case("Alla produkter") :
                return dataHandler.getProducts();
            case("Favoriter") :
                return dataHandler.favorites();
            //BAKARTIKLAR
            case ("Mjöl") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.retainAll(dataHandler.findProducts("mjöl"));
                return l;
            case ("Salt") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.retainAll(dataHandler.findProducts("salt"));
                return l;
            case ("Socker & Kakao") :
                theirList = dataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
                l = theirList.subList(0, theirList.size());
                l.retainAll(dataHandler.findProducts("socker"));
                l.add(dataHandler.getProduct(27));
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
                theirList = dataHandler.getProducts(ProductCategory.POTATO_RICE);
                l = theirList.subList(0, theirList.size());
                l.retainAll(dataHandler.findProducts("potatis"));
                l.removeAll(dataHandler.findProducts("potatispur"));
                return l;  
            case ("Övriga rotfrukter") :
                return dataHandler.getProducts(ProductCategory.ROOT_VEGETABLE);
            case ("Kaffe & Te") :
                theirList = dataHandler.getProducts(ProductCategory.HOT_DRINKS);
                l = theirList.subList(0, theirList.size());
                l.remove(dataHandler.getProduct(27));
                return l;
            case ("Kalla drycker") :
                return dataHandler.getProducts(ProductCategory.COLD_DRINKS) ;
            case ("Fisk") :
                return dataHandler.getProducts(ProductCategory.FISH) ;
            case ("Kött") :
                return dataHandler.getProducts(ProductCategory.MEAT) ;
            case ("Fil & Yoghurt") :
                l = dataHandler.findProducts("Filmjölk");
                l.addAll(dataHandler.findProducts("Yoghurt"));
                return l;  
            case ("Mjölk") :
                p = dataHandler.getProduct(80);
                l.add(p);
                return l;  
            case ("Ost") :
                l.add(dataHandler.getProduct(77));
                l.add(dataHandler.getProduct(79));
                l.add(dataHandler.getProduct(81));
                l.add(dataHandler.getProduct(82));
                return l;  
            case ("Pasta") :
                return dataHandler.getProducts(ProductCategory.PASTA);
            case ("Ris") :
                theirList = dataHandler.getProducts(ProductCategory.POTATO_RICE);
                l = theirList.subList(0, theirList.size());
                l.removeAll(dataHandler.findProducts("potatis"));
                return l; 
            case ("Snacks") :
                return dataHandler.getProducts(ProductCategory.SWEET);
            case ("Ägg") :
                return dataHandler.findProducts("Ägg");
            default :
                return new LinkedList<>();
        }
    }
    
    public static void removeProductForever(Product p ) {
        dataHandler.removeProduct(p);
    }
    
    /**
     * Wrapper for function findProducts in dataHandler
     * @param str
     * @return 
     */
    public static List<Product> findProducts(String str) {
        return dataHandler.findProducts(str);
    }
    
    public static void ereaseOrderFromHistory(Order order) {
        dataHandler.getOrders().remove(order);
    }
    
    private static void setBackendAddress(DeliveryAddress address) {
        Customer backendCustomer = dataHandler.getCustomer();
        
        backendCustomer.setFirstName(address.getFirstName());
        backendCustomer.setLastName(address.getLastName());
        backendCustomer.setAddress(address.getAddress());
        backendCustomer.setPostCode(address.getPostCode());
        backendCustomer.setPostAddress(address.getPostAddress());
        backendCustomer.setPhoneNumber(address.getPhoneNumber());
        backendCustomer.setMobilePhoneNumber(address.getMobilePhoneNumber());
        backendCustomer.setEmail(address.getEmail());
    }
    
    private static void setBackendCard(CreditCardInstance card) {
        CreditCard backendCard = dataHandler.getCreditCard();
        
        backendCard.setCardNumber(card.getCardNumber());
        backendCard.setCardType(card.getCardType());
        backendCard.setHoldersName(card.getHolder());
        backendCard.setValidMonth(card.getExpiryMonth());
        backendCard.setValidYear(card.getExpiryYear());
        backendCard.setVerificationCode(card.getCVC());
    }
    
    private static void clearBackendAddress() {
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
    
    private static void clearBackendCard() {
        CreditCard backendCard = dataHandler.getCreditCard();

        backendCard.setHoldersName("");
        backendCard.setCardNumber("");
        backendCard.setCardType("");
        backendCard.setValidMonth(-1);
        backendCard.setValidYear(-1);
        backendCard.setVerificationCode(-1);
    }
    
    private static boolean isBackendAddressEmpty() {
        Customer backend = dataHandler.getCustomer();
        
        return backend.getAddress().equals("")
            && backend.getFirstName().equals("")
            && backend.getLastName().equals("")
            && backend.getEmail().equals("")
            && backend.getMobilePhoneNumber().equals("")
            && backend.getPhoneNumber().equals("")
            && backend.getPostAddress().equals("")
            && backend.getPostCode().equals("");
    }
    
    private static boolean isBackendCardEmpty() {
        CreditCard backend = dataHandler.getCreditCard();
        
        return backend.getCardNumber().equals("")
            && backend.getCardType().equals("")
            && backend.getHoldersName().equals("")
            && backend.getValidMonth() == -1
            && backend.getValidYear() == -1
            && backend.getVerificationCode() == -1;
    }
}
