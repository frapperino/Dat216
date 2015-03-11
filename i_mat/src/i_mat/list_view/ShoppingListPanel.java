/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.list_view;

import i_mat.utilities.ListOrder;

/**
 *
 * @author Hjort
 */
public class ShoppingListPanel extends OldOrderPanel {
    private ListOrder lo;
    
    public ShoppingListPanel(ListOrder lo) {
        super(lo);
        //Sets text for header AFTER parent constructor finishes, to avoid null 
        //pointer exception when getListName is called in parent cosntructor.
        this.lo = lo;
        this.setHeader();
    }
    
    @Override
    String getListName() {
        return lo == null ? "Test1234" : lo.getName();
    }
    
}
