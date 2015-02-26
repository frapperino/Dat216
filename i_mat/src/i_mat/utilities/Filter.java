/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

/**
 *
 * @author Hjort
 */
public interface Filter<T> {
    /**
     * This method returns true if a given item passes thorugh the filter, else 
     * returns false.
     * @param item
     * @return 
     */
    public boolean filter(T item);
}
