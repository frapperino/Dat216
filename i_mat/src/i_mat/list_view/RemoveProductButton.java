/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.list_view;

import javax.swing.JButton;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
public class RemoveProductButton extends JButton {
    private ShoppingItem item;
    
    RemoveProductButton(ShoppingItem item) {
        this.item = item;
    }
    
    ShoppingItem getItem() {
        return item;
    }
}
