/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.list_view;

import i_mat.model.Model;
import i_mat.utilities.ColorScheme;
import i_mat.utilities.GUIConstants;
import i_mat.utilities.ListOrder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Hjort
 */
public class HistoryFullListPanel extends javax.swing.JPanel {
    private Order o;
    /**
     * Creates new form HistoryFullListPanel
     */
    public HistoryFullListPanel() {
        
    }
    
    public HistoryFullListPanel(Order o) {
        initComponents();
        this.setLayout(new GridLayout(0, 1, 0, 0));
        this.o = o;
        new Thread(new Runnable() {
           @Override
           public void run() {
               addAllItems();
           }
        }).start();
    }
    
    private void addAllItems(){
        
        int total = 0;
        boolean striped = false;
        if (o instanceof ListOrder) {
            System.out.println("listitem");
            for (ShoppingItem item : o.getItems()) {
                total += item.getTotal();
                JLabel image = new JLabel();
                image.setIcon(Model.getImageIconForProduct(item.getProduct(), GUIConstants.MICRO_THUMBNAIL_SIZE));
                JLabel nameL = new JLabel(item.getProduct().getName());
                JLabel amountL = new JLabel(Integer.toString((int)item.getAmount()) 
                + " " + item.getProduct().getUnitSuffix());
                JLabel costL = new JLabel(item.getTotal() + " kr");
                JPanel rowPanel = new JPanel();
                GridLayout gl = new GridLayout(1,5, 0, 0);
                rowPanel.setLayout(gl);
                rowPanel.setAlignmentX(SwingConstants.LEFT);
                Color bgColor = striped ? ColorScheme.rowStripingDark() : ColorScheme.rowStripingLight();
                striped = !striped;
                RemoveProductButton button = new RemoveProductButton(item);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeItem(((RemoveProductButton)e.getSource()).getItem());
                    }

                });
                button.setText("Ta bort");
                rowPanel.setBackground(bgColor);
                rowPanel.add(button);
                rowPanel.add(image);
                rowPanel.add(nameL);
                rowPanel.add(amountL);
                rowPanel.add(costL);
                this.add(rowPanel);
            }
        } else {
            for (ShoppingItem item : o.getItems()) {
                total += item.getTotal();
                JLabel image = new JLabel();
                image.setIcon(Model.getImageIconForProduct(item.getProduct(), GUIConstants.MICRO_THUMBNAIL_SIZE));
                JLabel nameL = new JLabel(item.getProduct().getName());
                JLabel amountL = new JLabel(Integer.toString((int)item.getAmount()) 
                + " " + item.getProduct().getUnitSuffix());
                JLabel costL = new JLabel(item.getTotal() + " kr");
                JPanel rowPanel = new JPanel();
                GridLayout gl = new GridLayout(1,4, 0, 0);
                rowPanel.setLayout(gl);
                rowPanel.setAlignmentX(SwingConstants.LEFT);
                Color bgColor = striped ? ColorScheme.rowStripingDark() : ColorScheme.rowStripingLight();
                striped = !striped;
                rowPanel.setBackground(bgColor);
                rowPanel.add(image);
                rowPanel.add(nameL);
                rowPanel.add(amountL);
                rowPanel.add(costL);
                this.add(rowPanel);
            }
        }
        JPanel rowPanel = new JPanel();
        GridLayout gl = new GridLayout(1,4, 0, 10);
        rowPanel.setLayout(gl);
        rowPanel.setAlignmentX(SwingConstants.RIGHT);
        Color bgColor = striped ? ColorScheme.rowStripingDark() : ColorScheme.rowStripingLight();
        rowPanel.setBackground(bgColor);
        JLabel totalLabel1 = new JLabel("Totalt:");
        totalLabel1.setFont(totalLabel1.getFont().deriveFont(Font.BOLD));
        JLabel totalLabel2 = new JLabel(Integer.toString(total) + " kr");
        totalLabel2.setFont(totalLabel2.getFont().deriveFont(Font.BOLD));
        rowPanel.add(new JLabel(""));
        rowPanel.add(new JLabel(""));
        if (this.o instanceof ListOrder)rowPanel.add(new JLabel(""));
        rowPanel.add(totalLabel1);
        rowPanel.add(totalLabel2);
        this.add(rowPanel);
        this.revalidate();
    }
    
    private void removeItem(ShoppingItem item) {
        List<ShoppingItem> l = o.getItems();
        l.remove(item);
        o.setItems(l);
        this.removeAll();
        this.addAllItems();
        this.revalidate();                   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}