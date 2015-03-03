/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

import i_mat.center_stage.ProductThumbnail;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
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
    public synchronized static List<ProductThumbnail> generateThumbnailsFromProducts(List<Product> products) {
        List<ProductThumbnail> returnList = new ArrayList<>();
        List<Product> prodList = products.subList(0, products.size());
        try {
            for(Product p : prodList) {
                returnList.add(new ProductThumbnail(p));
            }
        } catch (java.util.ConcurrentModificationException e) {
            
        } finally {
            return returnList;
        }
    }
    
    public static String getProductsString(List<ShoppingItem> items) {
        String s = "| ";
        int i = 0;
        int size = items.size();
        for(ShoppingItem item : items) {
            s += item.getProduct().getName();
            
            i++;
            //If we have more than 5 objects, we truncate and add ellipsis
            if(i > 4) {
               s += "…"; 
               break;
               
               //If we have not reached the end of the list, we add colon.
            } else if (i < size) {
                s += ", ";
            }
        }
        return s;
    }
    
    public static String getNameFromDate(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String s = ""; 
        s += c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        s += " " + c.get(Calendar.DAY_OF_MONTH);
        s += " " + c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        s += " " + c.get(Calendar.YEAR);
       
        return s;
    }
}
