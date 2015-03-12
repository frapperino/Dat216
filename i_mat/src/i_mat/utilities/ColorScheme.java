/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.utilities;

import java.awt.Color;

/**
 *
 * @author Hjort
 */
public class ColorScheme {
    public static Color rowStripingLight() {
        return Color.WHITE;
    }
    public static Color rowStripingDark() {
        return new Color(248, 248, 248);
    }
    
    public static Color enabledButtonForeground() {
        return Color.black;
    }
    
    public static Color disabledButtonForeground() {
        return Color.gray;
    }
    
    public static Color getSelectedProductBorderColor() {
        return new Color(217,175,191);
    }
    
    public static Color selectedThumbnailBackground() {
        return new Color(247,205,221);
    }
    
    public static Color getAddItemBlinkColor() {
        return new Color(250, 230, 250);
    }
    
    public static Color getShoppingCartBackgroundColor() {
        return Color.white;
    }
    
    public static Color getDescriptionBackground() {
        return new Color(222,185,106);
    }
    
    public static Color getSelectedBrowseItemBackground() {
        return Color.blue;
    }
    
   public static Color getSelectedBrowseItemForeground() {
        return Color.white;
    } 
   
   public static Color getThumbsPanelBackground() {
       return Color.white;
   }
   
   public static Color getNavbarBackground() {
       return new Color(204,51,0);
   }
   
   public static Color getStandardPanelBackground() {
       return Color.white;
   }
}
