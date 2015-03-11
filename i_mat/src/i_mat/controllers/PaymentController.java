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
    
    public boolean isCardNumberValid(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }
    
    public boolean isExpiryMonthValid(String expiryMonth) {
        return expiryMonth.matches("\\d{1,2}");
    }
    
    public boolean isExpiryYearValid(String expiryYear) {
        return expiryYear.matches("\\d{4}|\\d{2}");
    }
    
    public boolean isCVCValid(String cvc) {
        return cvc.matches("\\d{3}");
    }

    public void newCard(String cardType, String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvcCode) {
        if (!isCardNumberValid(cardNumber) || !isExpiryMonthValid(expiryMonth)
               || !isExpiryYearValid(expiryYear) || !isCVCValid(cvcCode)) {
            throw new IllegalArgumentException("Invalid card!");
        }
        
        Model.addCreditCard(cardNumber, cardType, cardHolder, Integer.parseInt(expiryMonth),
                            Integer.parseInt(expiryYear), Integer.parseInt(cvcCode));
    }

    public void setDefault(CreditCardInstance creditCard) {
        Model.setDefaultCreditCard(creditCard);
    }

    public void delete(CreditCardInstance creditCard) {
        Model.deleteCreditCard(creditCard);
    }

    public boolean isCardValid(String cardNumber, String expiryMonth, String expiryYear, String cvcCode) {
        return isCardNumberValid(cardNumber)
            && isExpiryMonthValid(expiryMonth)
            && isExpiryYearValid(expiryYear)
            && isCVCValid(cvcCode);
    }
}
