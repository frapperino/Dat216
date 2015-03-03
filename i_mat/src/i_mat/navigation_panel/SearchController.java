package i_mat.navigation_panel;

import i_mat.model.Model;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * Controlls all interaction between the search view and the model.
 * @author time
 */
public class SearchController {

    public static String[] getAllProducts() {
        List<Product> products = Model.getAllProducts();
        String[] s = new String[products.size()];
        int i=0;
        for (Product p: products) {
            s[i] = p.getName();
            i++;
        }
        return s;
    }
    
    public static Product getProduct(String name) {
        return Model.getProduct(name);
    }

    public static void addShoppingItem(Product product) {
        Model.addShoppingItem(new ShoppingItem(product));
    }
}
