/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import java.io.Serializable;
import java.util.UUID;
import se.chalmers.ait.dat215.project.CreditCard;

/**
 *
 * @author weeeeeew
 */
public class CreditCardInstance implements Serializable {
    
    private final String cardNumber, cardType, holder, id;
    private final int expiryMonth, expiryYear, cvc;

    public CreditCardInstance(String number, String type, String name, int month, int year, int cvc) {
        this(number,type,name,month,year,cvc, UUID.randomUUID().toString());
    }
    
    public CreditCardInstance(CreditCard c) {
        this(c, UUID.randomUUID().toString());
    }
    
    private CreditCardInstance(CreditCardInstance c) {
        this(c.getCardNumber(), c.getCardType(), c.getHolder(),
             c.getExpiryMonth(), c.getExpiryYear(), c.getCVC(), c.getID());
    }
    
    private CreditCardInstance(CreditCard c, String id) {
        this(c.getCardNumber(), c.getCardType(), c.getHoldersName(),
             c.getValidMonth(), c.getValidYear(), c.getVerificationCode(), id);
    }
    
    private CreditCardInstance(String number, String type, String name, int month, int year, int cvc, String id) {
        this.cardNumber = number;
        this.cardType = type;
        this.holder = name;
        this.expiryMonth = month;
        this.expiryYear = year;
        this.cvc = cvc;
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getHolder() {
        return holder;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public int getCVC() {
        return cvc;
    }
    
    public String getID() {
        return id;
    }
    
    public CreditCardInstance copy() {
        return new CreditCardInstance(this);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof CreditCardInstance) {
            CreditCardInstance cc = (CreditCardInstance) o;
            
            return cc.getID().equals(id);
        } else if (o instanceof CreditCard) {
            CreditCard cc = (CreditCard) o;
            
            return cc.getCardNumber().equals(cardNumber)
                 & cc.getCardType().equals(cardType)
                 & cc.getHoldersName().equals(holder)
                 & cc.getVerificationCode() == cvc
                 & cc.getValidMonth() == expiryMonth
                 & cc.getValidYear() == expiryYear;
        } else {
            return false;
        }
    }
}
