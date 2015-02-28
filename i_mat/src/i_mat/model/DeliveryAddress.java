/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import se.chalmers.ait.dat215.project.Customer;

/**
 * This class is needed since customers in the backend is basically our delivery
 * addresses, and we are not allowed to create multiple customers... 
 * @author weeeeeew
 */
public class DeliveryAddress extends Customer {
    
    private int id;
    
    protected DeliveryAddress(Customer c) {
        this(c.getFirstName(),c.getLastName(),c.getAddress(),c.getPostCode(),
             c.getPostAddress(),c.getPhoneNumber(),c.getMobilePhoneNumber(),c.getEmail());
    }
    
    protected DeliveryAddress(String firstName, String lastName, String address,
                              String postCode, String postAddress, String phoneNumber,
                              String mobilePhoneNumber, String email) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPostCode(postCode);
        setPostAddress(postAddress);
        setPhoneNumber(phoneNumber);
        setMobilePhoneNumber(mobilePhoneNumber);
        setEmail(email);
    }
    
    public boolean equals(Object o) {
        /*if (o instanceof DeliveryAddress) {
            DeliveryAddress da = (DeliveryAddress) o;
            
            return d
        } else*/ if (o instanceof Customer) {
            Customer c = (Customer) o;
            
            return getFirstName().equals(c.getFirstName())
                 & getLastName().equals(c.getLastName())
                 & getAddress().equals(c.getAddress())
                 & getPostCode().equals(c.getPostCode())
                 & getPostAddress().equals(c.getPostAddress())
                 & getPhoneNumber().equals(c.getPhoneNumber())
                 & getMobilePhoneNumber().equals(c.getMobilePhoneNumber());
        } else {
            return false;
        }
    }
}
