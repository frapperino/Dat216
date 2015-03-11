/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

import java.io.Serializable;
import java.util.Date;
import se.chalmers.ait.dat215.project.Order;

/**
 *
 * @author Hjort
 */
public class ListOrder extends Order implements Serializable {
    
    private String name = "";
    
    public ListOrder(String name) {
        super();
        this.name = name;
    }

    public ListOrder() {
        this(GenerateComponentsUtilities.getNameFromDate(new Date())); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getName(){ 
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
}
