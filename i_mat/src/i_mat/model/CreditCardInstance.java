/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import se.chalmers.ait.dat215.project.CreditCard;

/**
 *
 * @author Fredrik
 */
public class CreditCardInstance extends CreditCard {
    
    
    public CreditCardInstance(String number, String type, String name, int month, int year, int cvc){
        super();
        setCardNumber(number);
        setCardType(type);
        setHoldersName(name);
        setValidMonth(month);
        setValidYear(year);
        setVerificationCode(cvc);
    }
    
    
    
}
