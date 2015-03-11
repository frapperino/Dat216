/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.controllers;

import i_mat.model.CreditCardInstance;
import i_mat.model.Model;

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
        Model.addCreditCard(cardNumber, cardType, cardHolder, Integer.parseInt(expiryMonth),
                            Integer.parseInt(expiryYear), Integer.parseInt(cvcCode));
    }

    public void setDefault(CreditCardInstance creditCard) {
        Model.setDefaultCreditCard(creditCard);
    }

    public void delete(CreditCardInstance creditCard) {
        Model.deleteCreditCard(creditCard);
    }
}
