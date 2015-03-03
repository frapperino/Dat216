/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.controllers;

/**
 *
 * @author weeeeeew
 */
public class PaymentController {
    private static PaymentController instance = null;
    
    private PaymentController() {}
    
    public static PaymentController getInstance() {
        if (instance == null) {
            instance = new PaymentController();
        }
        
        return instance;
    }

    public void newCard(String cardType, String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvcCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
