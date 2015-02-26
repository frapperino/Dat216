/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Hjort
 */
public class PriceFilter implements Filter<Product> {
    
    private double lowest, highest;
    
    public PriceFilter(double lowest, double highest) {
        this.lowest=lowest;
        this.highest=highest;
    }
    
    @Override
    public boolean filter(Product p) {
        return lowest <= p.getPrice() && p.getPrice() <= highest;
    }
}
