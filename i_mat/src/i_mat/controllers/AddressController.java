/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.controllers;

import i_mat.model.DeliveryAddress;
import i_mat.model.Model;

/**
 *
 * @author weeeeeew
 */
public class AddressController {
    
    private static AddressController instance = null;
    
    public static AddressController getInstance() {
        if (instance == null) {
            instance = new AddressController();
        }
        
        return instance;
    }
    
    private AddressController() {}
    
    public void newAddress(String firstName, String lastName, String address,
                                    String postCode, String postAddress, String phone, String cell, String email, String id) {
        Model.addDeliveryAddress(firstName,lastName,address,postCode,postAddress,phone, cell, email, id);
    }
    
    public void setDefault(DeliveryAddress deliveryAddress) {
        Model.setDefaultDeliveryAddress(deliveryAddress);
    }
    
    public void editAddress(DeliveryAddress newAddress) {
        Model.editDeliveryAddress(newAddress);
    }

    public void remove(DeliveryAddress deliveryAddress) {
        Model.deleteDeliveryAddress(deliveryAddress);
    }
}
