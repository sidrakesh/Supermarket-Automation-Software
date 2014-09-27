/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import SupermarketData.Product;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sameer
 */
public class ItemManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateInventoryPrices
     */
    private InventoryDatabase id;
    private Client cl;
    private List<Product>prodList;
    private List<Product>displayList;
    private String ItemIDString;
    private DefaultListSelectionModel dlsm;
    
    public ItemManagementPanel(Client ncl) {
        cl = ncl;
        
        initComponents();
        id = new InventoryDatabase(cl);
        
        prodList = id.getProductList();
        
        //if(prodList!=null)
        //{
        displayList = new ArrayList<>();
        GenerateDisplayList("");
        //}
        dlsm = new DefaultListSelectionModel();
        ItemsList.setSelectionModel(dlsm);
        dlsm.addListSelectionListener(new SelectionHandler());
        ItemName.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent evt){
                GenerateDisplayList(ItemName.getText());
            }
        });
        
    }
    
    private void SetFields(Product prod)
    {
        ItemID.setText(prod.getProductID());
        ItemName.setText(prod.getName());
        Quantity.setText(prod.getQuantity()+"");
        Manufacturer.setText(prod.getManufacturer());
        MRP.setText(prod.getMRP()+"");
        Price.setText(prod.getCost()+"");
        Location.setText(prod.getLocation());
        Discount.setText(prod.getDiscount()+"");
        Description.setText(prod.getDescription());
    }
    
    private void SortTable()
    {
        DefaultRowSorter sorter = ((DefaultRowSorter)ItemsList.getRowSorter());
    	ArrayList list = new ArrayList();
    	list.add( new RowSorter.SortKey(1, SortOrder.ASCENDING) );
    	sorter.setSortKeys(list);
    	sorter.sort();
    }

    private void GenerateDisplayList(String s)
    {
        displayList.clear();
        int i;
        
        for(i=0;i<prodList.size();i++)
        {
            if(prodList.get(i).getName().indexOf(s)>=0)
            {
                displayList.add(prodList.get(i));
            }
        }
        
        PopulateTable();
    }
    
    private void PopulateTable()       
    {
        DefaultTableModel tm;
        tm = (DefaultTableModel)ItemsList.getModel();
        tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();
        
        int i;
        for(i=0;i<displayList.size();i++)
        {
            tm.addRow(new Object[4]);
            tm.setValueAt(displayList.get(i).getProductID(), i, 0);
            tm.setValueAt(displayList.get(i).getName(), i, 1);
            tm.setValueAt(displayList.get(i).getQuantity(), i, 2);
            tm.setValueAt(displayList.get(i).getMRP(), i, 3);
        }
        
        SortTable();
    }
    
    private class SelectionHandler implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent evt){
                if(!evt.getValueIsAdjusting()){
                    if(ItemsList.getSelectedRow()>=0)
                    {
                    ItemIDString = ItemsList.getValueAt(ItemsList.getSelectedRow(),0).toString();
                    
                    int i;
                    for(i=0;i<prodList.size();i++)
                    {
                        if(prodList.get(i).getProductID().equals(ItemIDString))
                        {
                            SetFields(prodList.get(i));
                            break;
                        }
                    }
                    }
                }
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MRP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ItemID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Discount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        Location = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UpdatePriceButton = new javax.swing.JButton();
        Manufacturer = new javax.swing.JTextField();
        Description = new javax.swing.JTextField();
        Quantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsList = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SavePriceButton = new javax.swing.JButton();
        SaveDiscount = new javax.swing.JButton();
        EditDiscount = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ItemName = new javax.swing.JTextField();
        ViewItemStatistics = new javax.swing.JButton();

        MRP.setEnabled(false);

        jLabel14.setText("Quantity:");

        jLabel3.setText("Item name: ");

        jLabel2.setText("MRP: ");

        jLabel12.setText("Discount:");

        ItemID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ItemIDKeyPressed(evt);
            }
        });

        jLabel13.setText("Description:");

        Discount.setEnabled(false);

        jLabel1.setText("Item ID: ");

        Price.setEnabled(false);

        Location.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Product details:");

        UpdatePriceButton.setText("Update price");
        UpdatePriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePriceButtonActionPerformed(evt);
            }
        });

        Manufacturer.setEnabled(false);

        Description.setEnabled(false);

        Quantity.setEnabled(false);

        ItemsList.setAutoCreateRowSorter(true);
        ItemsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Stock", "Price (Rs.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ItemsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ItemsList);
        ItemsList.getColumnModel().getColumn(0).setPreferredWidth(25);
        ItemsList.getColumnModel().getColumn(1).setPreferredWidth(200);
        ItemsList.getColumnModel().getColumn(2).setPreferredWidth(10);
        ItemsList.getColumnModel().getColumn(3).setPreferredWidth(30);

        jLabel7.setText("Manufacturer:");

        jLabel11.setText("Location:");

        jLabel10.setText("Cost price (Rs):");

        SavePriceButton.setText("Save new price");
        SavePriceButton.setEnabled(false);
        SavePriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePriceButtonActionPerformed(evt);
            }
        });

        SaveDiscount.setText("Save");
        SaveDiscount.setEnabled(false);
        SaveDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDiscountActionPerformed(evt);
            }
        });

        EditDiscount.setText("Edit");
        EditDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDiscountActionPerformed(evt);
            }
        });

        jLabel8.setText("%");

        ViewItemStatistics.setText("View item statistics");
        ViewItemStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewItemStatisticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Manufacturer)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Quantity, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Location, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(EditDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(SaveDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Description, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(Price))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UpdatePriceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SavePriceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ItemName)
                                    .addComponent(MRP)
                                    .addComponent(ItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3)
                            .addComponent(ViewItemStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(MRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdatePriceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SavePriceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(Discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(EditDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveDiscount))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ViewItemStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UpdatePriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePriceButtonActionPerformed
        // TODO add your handling code here:
        MRP.setEnabled(true);
        SavePriceButton.setEnabled(true);
        UpdatePriceButton.setEnabled(false);
    }//GEN-LAST:event_UpdatePriceButtonActionPerformed

    private void EditDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDiscountActionPerformed
        // TODO add your handling code here:
        Discount.setEnabled(true);
        EditDiscount.setEnabled(false);
        SaveDiscount.setEnabled(true);
    }//GEN-LAST:event_EditDiscountActionPerformed

    private void ItemIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ItemIDKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            int i;
            
            for(i=0;i<ItemsList.getRowCount();i++)
            {
                if(ItemsList.getValueAt(i, 0).equals(ItemID.getText()))
                {
                    ItemsList.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_ItemIDKeyPressed

    private void SavePriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePriceButtonActionPerformed
        // TODO add your handling code here:
        if(ItemName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Item name cannot be empty!");
        }
        else if(ItemID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Item ID cannot be empty!");
        }
        else if(MRP.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "MRP cannot be empty!");
        }
        else
        {
            String response = id.updatePrice(ItemID.getText(), Float.parseFloat(MRP.getText()));
        
            if(response.equals("UPDATED"))
            {
                int i;
                for(i=0;i<prodList.size();i++)
                {
                    if(prodList.get(i).getProductID().equals(ItemID.getText()))
                    {   
                        prodList.get(i).setMRP(Float.parseFloat(MRP.getText()));
                        ItemsList.setValueAt(Float.parseFloat(MRP.getText()), ItemsList.getSelectedRow(), 3);
                        break;
                    }
                }
            }
            SavePriceButton.setEnabled(false);
            UpdatePriceButton.setEnabled(true);
            MRP.setEnabled(false);
        }
    }//GEN-LAST:event_SavePriceButtonActionPerformed

    private void SaveDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDiscountActionPerformed
        // TODO add your handling code here:
        if(ItemName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Item name cannot be empty!");
        }
        else if(ItemID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Item ID cannot be empty!");
        }
        else if(Discount.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "MRP cannot be empty!");
        }
        else
        {
            EditDiscount.setEnabled(true);
            SaveDiscount.setEnabled(false);
            Discount.setEnabled(false);
            id.updateDiscount(ItemID.getText(), Float.parseFloat(Discount.getText()));
        }
    }//GEN-LAST:event_SaveDiscountActionPerformed

    private void ViewItemStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewItemStatisticsActionPerformed
        // TODO add your handling code here:
        if(ItemsList.getSelectedRow()>=0)
        {    
            ItemStatisticsDialog isd = new ItemStatisticsDialog(new JFrame(),true,ItemID.getText(),id);
            isd.setLocationRelativeTo(null);
            isd.setVisible(true);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "No item selected!");
        }
    }//GEN-LAST:event_ViewItemStatisticsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Discount;
    private javax.swing.JButton EditDiscount;
    private javax.swing.JTextField ItemID;
    private javax.swing.JTextField ItemName;
    private javax.swing.JTable ItemsList;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField MRP;
    private javax.swing.JTextField Manufacturer;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField Quantity;
    private javax.swing.JButton SaveDiscount;
    private javax.swing.JButton SavePriceButton;
    private javax.swing.JButton UpdatePriceButton;
    private javax.swing.JButton ViewItemStatistics;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
