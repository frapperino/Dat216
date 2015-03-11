/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
public class ListOrder extends Order implements Serializable {
    
    private String name = "";
    private List<ShoppingItem> items;
    private Date date;
    
    public ListOrder(String name) {
        super();
        this.name = name;
        this.date = new Date();
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
    
    @Override
    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }
    
    @Override
    public List<ShoppingItem> getItems() {
        return this.items;
    }
    
    @Override
    public Date getDate() {
        return this.date;
    }
    
    @Override
    public String toString() {
        return this.name + this.getItems();
    }
    
}
