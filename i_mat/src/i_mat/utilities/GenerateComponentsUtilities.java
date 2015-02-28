/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

import i_mat.center_stage.ProductThumbnail;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Hjort
 */
public class GenerateComponentsUtilities {
    
    /**
     * Takes a list of products as argument and returns a list of corresponding ProductThumbnails.
     * 
     * @param products
     * @return 
     */
    public static List<ProductThumbnail> generateThumbnailsFromProducts(List<Product> products) {
        List<ProductThumbnail> returnList = new ArrayList<>();
        
        for(Product p : products) {
            returnList.add(new ProductThumbnail(p));
        }
        return returnList;
    }
    
    public static String getProductsString(List<ShoppingItem> items) {
        String s = "| ";
        int i = 0;
        for(ShoppingItem item : items) {
            s += item.getProduct().getName();
            
            i++;
            if(i > 4)
               s += "…"; 
               break;
        }
        return s;
    }
}
