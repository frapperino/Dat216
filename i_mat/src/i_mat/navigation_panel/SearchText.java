/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.navigation_panel;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author time
 */
public class SearchText extends JTextField implements FocusListener {
    private final String text;
    public SearchText(String text) {
        this.text = text;
        this.setForeground(Color.gray);
        this.setText(text);
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent fe) {
        this.setForeground(Color.BLACK);
        this.setText("");
    }

    @Override
    public void focusLost(FocusEvent fe) {
        this.setForeground(Color.gray);
        this.setText(text);
    }
}
