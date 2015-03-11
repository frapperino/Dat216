/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.model;

import java.io.Serializable;
import java.util.UUID;
import se.chalmers.ait.dat215.project.Customer;

/**
 * This class is needed since customers in the backend is basically our delivery
 * addresses, and we are not allowed to create multiple customers... 
 * @author weeeeeew
 */
public class DeliveryAddress implements Serializable {
    
    private final String id;
    private String firstName, lastName, address, postCode, postAddress,
                   phoneNumber, mobilePhoneNumber, email;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }
    
    protected DeliveryAddress(Customer c) {
        this(c.getFirstName(),c.getLastName(),c.getAddress(),c.getPostCode(),
             c.getPostAddress(),c.getPhoneNumber(),c.getMobilePhoneNumber(),c.getEmail());
    }
    
    public DeliveryAddress(String firstName, String lastName, String address,
                              String postCode, String postAddress, String phoneNumber,
                              String mobilePhoneNumber, String email) {
        this(firstName, lastName, address, postCode, postAddress, phoneNumber,
             mobilePhoneNumber, email, UUID.randomUUID().toString());
    }
    
    private DeliveryAddress(Customer c, String id) {
        this(c.getFirstName(), c.getLastName(), c.getAddress(), c.getPostCode(),
             c.getPostAddress(), c.getPhoneNumber(), c.getMobilePhoneNumber(),
             c.getEmail(), id);
    }
    
    private DeliveryAddress(DeliveryAddress da, String id) {
        this(da.getFirstName(), da.getLastName(), da.getAddress(), da.getPostCode(),
             da.getPostAddress(), da.getPhoneNumber(), da.getMobilePhoneNumber(),
             da.getEmail(), id);
    }
    
    private DeliveryAddress(String firstName, String lastName, String address,
                              String postCode, String postAddress, String phoneNumber,
                              String mobilePhoneNumber, String email, String id) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPostCode(postCode);
        setPostAddress(postAddress);
        setPhoneNumber(phoneNumber);
        setMobilePhoneNumber(mobilePhoneNumber);
        setEmail(email);
        this.id = id;
    }
    
    public DeliveryAddress copy() {
        return new DeliveryAddress(this, this.id);
    }
    
    public boolean equals(Object o) {
        if (o instanceof Customer) {
            Customer c = (Customer) o;
            
            return getFirstName().equals(c.getFirstName())
                 & getLastName().equals(c.getLastName())
                 & getAddress().equals(c.getAddress())
                 & getPostCode().equals(c.getPostCode())
                 & getPostAddress().equals(c.getPostAddress())
                 & getPhoneNumber().equals(c.getPhoneNumber())
                 & getMobilePhoneNumber().equals(c.getMobilePhoneNumber());
        } else if (o instanceof DeliveryAddress) {
            DeliveryAddress da = (DeliveryAddress) o;
            
            return this.id.equals(da.getID());
        } else {
            return false;
        }
    }
    
    public String getID() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Address {" +
                "\n\t ID: " + getID() +
                "\n\t Name: " + getFirstName() + getLastName() + 
                "\n\t Address: " + getAddress() + 
                "\n\t Postcode: " + getPostCode() + 
                "\n\t Postaddress: " + getPostAddress() + 
                "\n\t Phone: " + getPhoneNumber() +
                "\n }";
    }
}
