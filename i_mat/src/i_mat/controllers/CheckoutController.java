/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.controllers;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.ShoppingItem;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.Order;
import i_mat.center_stage.checkout.CheckoutPanel;
import i_mat.center_stage.checkout.NewAdressPanel;
import java.util.List;
/**
 *
 * @author Fredrik
 */
public class CheckoutController {
    
    //Gamla, ska tas bort 
    public CheckoutController(){
        
    }
    private static final IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
   
    ShoppingCart cart = iMatDataHandler.getShoppingCart();
    Customer customer = iMatDataHandler.getCustomer();
    CreditCard card = iMatDataHandler.getCreditCard(); //behövs här?
    
    public void checkoutReceipt(){
        //på tack för att du handlat åt oss kan bland annat följande finnas
        double totalValue = cart.getTotal();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String custAddress = customer.getAddress();
        List <ShoppingItem> cartlist = cart.getItems();
        }
    
    //ska köras när man trycker på Genomför köp. egentligen listener till den knappen
    public void checkoutMethod(){
        checkoutReceipt();
        iMatDataHandler.placeOrder();
    }
}
