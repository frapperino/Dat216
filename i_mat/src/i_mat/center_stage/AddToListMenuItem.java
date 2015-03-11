/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage;

import i_mat.model.Model;
import i_mat.utilities.ListOrder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
class AddToListMenuItem extends JMenuItem {
    private ListOrder order;

    public AddToListMenuItem(ListOrder l) {
        this.order = l;
        super.setText(order.getName());
    }
    
    void addToList(ShoppingItem item) {
        Model.addItemToShoppingList(this.order, item);
    }    
}
