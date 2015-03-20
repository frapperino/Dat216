/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage;

import i_mat.utilities.Filter;
import java.util.Comparator;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Hjort
 */
public interface ResultsPanel  {
    /**
     * Tells the view to sort its contents based on the sorting mechanism in the 
     * Comparator passed to it.
     * @param c 
     */
    public void sortBy(Comparator<Product> c);
    
    /**
     * Tells the view to only display items that passes through the given filter.
     * @param f 
     */
    public void filterBy(Filter f);
    
    
   public void putSelectedInCart();
    
}
