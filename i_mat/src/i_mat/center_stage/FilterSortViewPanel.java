/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i_mat.center_stage;

/**
 *
 * @author Hjort
 */
public class FilterSortViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form FIlterSortViewPanel
     */
    public FilterSortViewPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterSearchPanel1 = new i_mat.center_stage.FilterSearchPanel();
        filterSearchPanel2 = new i_mat.center_stage.FilterSearchPanel();
        viewSearchPanel2 = new i_mat.center_stage.ViewSearchPanel();
        sortSearchPanel1 = new i_mat.center_stage.SortSearchPanel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());
        add(filterSearchPanel2, java.awt.BorderLayout.CENTER);
        add(viewSearchPanel2, java.awt.BorderLayout.LINE_END);
        add(sortSearchPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private i_mat.center_stage.FilterSearchPanel filterSearchPanel1;
    private i_mat.center_stage.FilterSearchPanel filterSearchPanel2;
    private i_mat.center_stage.SortSearchPanel sortSearchPanel1;
    private i_mat.center_stage.ViewSearchPanel viewSearchPanel2;
    // End of variables declaration//GEN-END:variables
}
