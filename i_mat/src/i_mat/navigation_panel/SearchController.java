package i_mat.navigation_panel;

import i_mat.IMat;
import i_mat.center_stage.DisplayResultsPanel;
import i_mat.center_stage.ProductFullView;
import i_mat.center_stage.ThumbsPanel;
import i_mat.model.Model;
import java.util.List;
import javax.swing.JPanel;
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

    public static void performSearch(final String text) {
        JPanel p = new JPanel();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                IMat.setLoadingCenterStage();
                IMat.setCenterStage(new DisplayResultsPanel(new ThumbsPanel(Model.getSearchResults(text))));
            }
        });
        t.setPriority(Thread.MAX_PRIORITY);
        t.setDaemon(true);
        t.start();
    }

    static void openProductPage(String text) {
        IMat.setCenterStage(new ProductFullView(Model.getProduct(text)));
    }
}
