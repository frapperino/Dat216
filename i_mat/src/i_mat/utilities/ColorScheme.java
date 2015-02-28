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
}
