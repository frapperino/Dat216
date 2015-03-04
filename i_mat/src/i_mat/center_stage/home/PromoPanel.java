/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage.home;

import i_mat.center_stage.ThumbsPanel;
import i_mat.model.Model;

/**
 *
 * @author Hjort
 */
public class PromoPanel extends ThumbsPanel {
    
    public PromoPanel () {
        super(Model.getPromoProducts());
        this.updateUI();
    }
}
