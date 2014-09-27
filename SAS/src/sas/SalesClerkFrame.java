
package sas;

import SupermarketData.Product;
import SupermarketData.SalesTransaction;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class SalesClerkFrame extends javax.swing.JFrame {
    private Client cl;
    private List<Product>ProductList;
    private InventoryDatabase id;
    private String transID;
    float total;
    private DefaultTableModel tm;
    private DefaultListSelectionModel dlsm;
    private String empId;
    
    public SalesClerkFrame(Client ncl, String eid) {
        empId = eid;
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Icon.png"));
        this.setIconImage(icon.getImage());
        cl = ncl;
        ProductList = new ArrayList<>();
        id = new InventoryDatabase(cl);
        
        ItemsList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        this.getRootPane().setDefaultButton(AddButton);
        dlsm = new DefaultListSelectionModel();
        ItemsList.setSelectionModel(dlsm);
        dlsm.addListSelectionListener(new SelectionHandler());
        tm = (DefaultTableModel)ItemsList.getModel();
        tm.addTableModelListener(new CheckBoxListener());
        ResetTransaction();
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BillingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        productID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Quantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsList = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Bill = new javax.swing.JTextPane();
        ProductInfoPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        Manufacturer = new javax.swing.JTextField();
        Location = new javax.swing.JTextField();
        Discount = new javax.swing.JTextField();
        Finish = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        PrintButton = new javax.swing.JButton();
        Total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NewTransaction = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        CancelTransaction = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ChangePasswordMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BillingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Product ID");

        jLabel2.setText("Quantity");

        Quantity.setText("1");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ItemsList.setAutoCreateRowSorter(true);
        ItemsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Product ID", "Product Name", "Rate", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ItemsList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ItemsList.setColumnSelectionAllowed(true);
        ItemsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ItemsList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ItemsList);
        ItemsList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ItemsList.getColumnModel().getColumn(0).setPreferredWidth(20);
        ItemsList.getColumnModel().getColumn(1).setPreferredWidth(100);
        ItemsList.getColumnModel().getColumn(2).setPreferredWidth(250);
        ItemsList.getColumnModel().getColumn(3).setPreferredWidth(80);
        ItemsList.getColumnModel().getColumn(4).setPreferredWidth(80);

        Bill.setBackground(new java.awt.Color(255, 255, 255));
        Bill.setContentType("text/html"); // NOI18N
        Bill.setEnabled(false);
        jScrollPane2.setViewportView(Bill);

        ProductInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Manufactured by:");

        jLabel6.setText("Location:");

        jLabel7.setText("Discount:");

        jLabel8.setText("Description: ");

        Description.setColumns(20);
        Description.setRows(5);
        Description.setAutoscrolls(false);
        Description.setEnabled(false);
        jScrollPane3.setViewportView(Description);

        Manufacturer.setEnabled(false);

        Location.setEnabled(false);

        Discount.setEnabled(false);

        javax.swing.GroupLayout ProductInfoPanelLayout = new javax.swing.GroupLayout(ProductInfoPanel);
        ProductInfoPanel.setLayout(ProductInfoPanelLayout);
        ProductInfoPanelLayout.setHorizontalGroup(
            ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Location)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3)))
                .addGap(10, 10, 10))
        );
        ProductInfoPanelLayout.setVerticalGroup(
            ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Manufacturer, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(ProductInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21))
        );

        Finish.setText("Finish");
        Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        PrintButton.setText("Print");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        Total.setEnabled(false);

        jLabel3.setText("Total:");

        NewTransaction.setText("New transaction");
        NewTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewTransactionActionPerformed(evt);
            }
        });

        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        CancelTransaction.setMnemonic('c');
        CancelTransaction.setText("Cancel Transaction");
        CancelTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BillingPanelLayout = new javax.swing.GroupLayout(BillingPanel);
        BillingPanel.setLayout(BillingPanelLayout);
        BillingPanelLayout.setHorizontalGroup(
            BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillingPanelLayout.createSequentialGroup()
                        .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BillingPanelLayout.createSequentialGroup()
                                .addComponent(CancelTransaction)
                                .addGap(13, 13, 13)
                                .addComponent(Finish, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillingPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ProductInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(BillingPanelLayout.createSequentialGroup()
                        .addComponent(NewTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        BillingPanelLayout.setVerticalGroup(
            BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingPanelLayout.createSequentialGroup()
                .addComponent(NewTransaction)
                .addGap(17, 17, 17)
                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillingPanelLayout.createSequentialGroup()
                        .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BillingPanelLayout.createSequentialGroup()
                                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BillingPanelLayout.createSequentialGroup()
                                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Total)
                                    .addComponent(jLabel3))
                                .addGap(22, 22, 22))
                            .addGroup(BillingPanelLayout.createSequentialGroup()
                                .addGroup(BillingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Finish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CancelTransaction))
                                .addGap(19, 19, 19)))
                        .addComponent(ProductInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("File");

        ChangePasswordMenuItem.setText("Change Password");
        ChangePasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ChangePasswordMenuItem);

        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setMnemonic('V');
        jMenu3.setText("View");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('P');
        jMenuItem1.setText("Profile");
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BillingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BillingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishActionPerformed
        // TODO add your handling code here:
        
        String bill;
        bill = "<html><body><h3 style = 'font-family:Tahoma'><center>Supermarket Automation Software</center></h3>";
        bill+="<h4><center>Transaction ID : "+transID+"</center></h4><br /><table><tr><th width = 180 align = 'left'>Product</th><th width = 70 align='right'></th><th>Cost</th></tr>";
        
        int i;
        for(i=0;i<ItemsList.getRowCount();i++)
        {
            if((Boolean)ItemsList.getModel().getValueAt(i, 0) && (Float)ItemsList.getValueAt(i, 4) != 0)
            {
                bill+="<tr><td>"+(String)ItemsList.getModel().getValueAt(i, 2)+"</td><td> x "+(Float)ItemsList.getModel().getValueAt(i, 4)+"</td>";
                bill+="<td align = 'right'>"+(Float)ItemsList.getModel().getValueAt(i, 5)+"</td></tr>";
            }
        }
        bill+="</table><hr color = 'gray' /><p align = 'right'>Total : "+total+"</p></body></html>";
        Bill.setText(bill);
    }//GEN-LAST:event_FinishActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        Product prod;
        int flag=0;
        if("".equals(productID.getText()))
        {
            JOptionPane.showMessageDialog(null, "No item ID entered!");
        }
        else if("".equals(Quantity.getText()))
        {
            JOptionPane.showMessageDialog(null, "No item quantity entered!");
        }
        else
        {
            for(Product p:ProductList)
            {
                if(p.getProductID().equals(productID.getText()))
                {
                    p.setQuantity(p.getQuantity()+Float.parseFloat(Quantity.getText()));
                    flag=1;
                    PopulateTable();
                    SetFields(p);
                    break;
                }
            }
            
            if(flag==0)
            {
                prod = id.getProduct(productID.getText());
               
                if(prod!=null) 
                {
                    prod.setQuantity(Float.parseFloat(Quantity.getText()));
                    ProductList.add(prod);
                    PopulateTable();
                    SetFields(prod);
                }
            }
        }
        
        productID.setText("");
    }//GEN-LAST:event_AddButtonActionPerformed

    private void SetFields(Product prod)
    {
        Manufacturer.setText(prod.getManufacturer());
        Location.setText(prod.getLocation());
        Discount.setText(prod.getDiscount()+"");
        Description.setText(prod.getDescription());
    }
    
    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        // TODO add your handling code here:
        SalesTransaction st = new SalesTransaction(empId);
        st.setTransID(transID);
        
        int i,j;
        for(i=0;i<ItemsList.getRowCount();i++)
        {
            if((Boolean)ItemsList.getValueAt(i, 0)&&ItemsList.getValueAt(i,4)!=0)
            {
               for(Product p:ProductList)
               {
                   if(p.getProductID().equals(ItemsList.getValueAt(i, 1)))
                   {
                      st.addItem(p);
                      break;
                   }
               }
            }
        }
        
        Calendar c = Calendar.getInstance();
        
        DocFlavor flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
        PrintRequestAttributeSet aset =
        new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.INVOICE);
        aset.add(new Copies(1));
        aset.add(Sides.ONE_SIDED);
        aset.add(Finishings.NONE);
        

        int date = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        
        String Time;
        
        if(date<10)
        {
            Time = "0"+date;
        }
        else
        {
            Time = ""+date;
        }
        if(month<10)
        {
            Time += "/0"+month;
        }
        else
        {
            Time += "/"+month;
        }
        
        Time+="/"+year+"     ";
        
        if(hour<10)
        {
            Time += "0"+hour;
        }
        else
        {
            Time += ""+hour;
        }
        if(min<10)
        {
            Time += ":0"+min;
        }
        else
        {
            Time += ":"+min;
        }
        if(second<10)
        {
            Time += ":0"+second;
        }
        else
        {
            Time += ":"+second;
        }
/* locate a print service that can handle it */
        try {
            Bill.print(new MessageFormat(""), new MessageFormat(Time), true, null, aset, true);
            id.addBill(st);
            ResetTransaction();
        } catch (PrinterException ex) {
            Logger.getLogger(SalesClerkFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void NewTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewTransactionActionPerformed
        // TODO add your handling code here:
        ResetTransaction();
    }//GEN-LAST:event_NewTransactionActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
        if("".equals(productID.getText()))
        {
            JOptionPane.showMessageDialog(null, "No item ID entered!");
        }
        else if("".equals(Quantity.getText()))
        {
            JOptionPane.showMessageDialog(null, "No item quantity entered!");
        }
        else if(Float.parseFloat(Quantity.getText())<0)
        {
            JOptionPane.showMessageDialog(null, "Item quantity cannot be negative!");
        }
        else
        {
            for(Product p:ProductList)
            {
                if(p.getProductID().equals(productID.getText()))
                {
                    if(p.getQuantity()-Float.parseFloat(Quantity.getText())<0)
                    {
                        JOptionPane.showMessageDialog(null, "Product quantity cannot be negative!");
                    }
                    else
                    {
                        p.setQuantity(p.getQuantity()-Float.parseFloat(Quantity.getText()));
                        PopulateTable();
                        SetFields(p);
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Given product not included in list!");
        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void CancelTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelTransactionActionPerformed
        // TODO add your handling code here:
        id.CancelBill(transID);
        ResetTransaction();
    }//GEN-LAST:event_CancelTransactionActionPerformed

    private void ChangePasswordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordMenuItemActionPerformed
        final ChangePassword dialog;
        boolean done = false;
        String error = "";
        dialog = new ChangePassword(new JFrame(), true);
        dialog.setLocationRelativeTo(this);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent evt){
                dialog.setWantToChange(false);
            }
        });
        do{
        
        dialog.setVisible(true);
        if(dialog.wantToChange()){
            String reply = EmployeeDatabase.changePassword(empId, dialog.getOldPassword(), dialog.getNewPassword(), cl);
            if(reply.startsWith("SUCCESS")){
                JOptionPane.showMessageDialog(null, "Password successfully changed","",JOptionPane.INFORMATION_MESSAGE);
                done = true;
            }
            else{
                dialog.showError(reply);
                done = false;
            }
        }
        else{
            done = true;
        }
        }while(!done);
    }//GEN-LAST:event_ChangePasswordMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            EmployeeDatabase.Logout(cl);
            cl.closeConnection();
            System.exit(0);
        } catch (IOException ex) {
            System.exit(-1);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ResetTransaction()
    {
        transID = id.newBill(empId);
        total = 0;
        Total.setText("");
        
        DefaultTableModel tma;
        tma = (DefaultTableModel)ItemsList.getModel();
        tma.getDataVector().removeAllElements();
        tma.fireTableDataChanged();
        
        ProductList.clear();
        Bill.setText("");
        productID.setText("");
        Quantity.setText("1");
        Manufacturer.setText("");
        Location.setText("");
        Discount.setText("");
        Description.setText("");
    }
    
    private void PopulateTable()
    {
        Product prod;
        int i;
        
        tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();
        
        
        for(i=0;i<ProductList.size();i++)
        {
            TableModelListener[] tnl = tm.getTableModelListeners();
            boolean removed = false;    
            
            if(tnl.length>0)
            {
                removed = true;
                tm.removeTableModelListener(tm.getTableModelListeners()[0]);
            }
            
            prod = ProductList.get(i);
            
            tm.addRow(new Object[6]);  
            tm.setValueAt(prod.getMRP()*prod.getQuantity(), i, 5);         
            tm.setValueAt(prod.getProductID(), i, 1);
            tm.setValueAt(prod.getName(), i, 2);
            tm.setValueAt(prod.getMRP(), i, 3);
            tm.setValueAt(prod.getQuantity(), i, 4);            
            tm.setValueAt(true, i, 0); 
            setTotal();
            
            if(removed){
            tm.addTableModelListener(new CheckBoxListener());
        }
        }
        
    }
    private void setTotal(){
        int i;
        total=0;
        
        for(i=0;i<ItemsList.getRowCount();i++)
        {
            if((Boolean)ItemsList.getValueAt(i, 0))
            {
                total+=(Float)ItemsList.getValueAt(i, 5);
            }
        }
        
        Total.setText(""+total);
    }
    
    private class CheckBoxListener implements TableModelListener{
        @Override
        public void tableChanged(TableModelEvent evt){
            setTotal();
        }
    }
    
    private class SelectionHandler implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent evt){
        String ItemIDString;
            if(!evt.getValueIsAdjusting()){
                    if(ItemsList.getSelectedRow()>=0)
                    {
                    ItemIDString = ItemsList.getValueAt(ItemsList.getSelectedRow(),1).toString();
                    
                    int i;
                    for(i=0;i<ProductList.size();i++)
                    {
                        if(ProductList.get(i).getProductID().equals(ItemIDString))
                        {
                            SetFields(ProductList.get(i));
                            break;
                        }
                    }
                    }
                }
            }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextPane Bill;
    private javax.swing.JPanel BillingPanel;
    private javax.swing.JButton CancelTransaction;
    private javax.swing.JMenuItem ChangePasswordMenuItem;
    private javax.swing.JTextArea Description;
    private javax.swing.JTextField Discount;
    private javax.swing.JButton Finish;
    private javax.swing.JTable ItemsList;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField Manufacturer;
    private javax.swing.JButton NewTransaction;
    private javax.swing.JButton PrintButton;
    private javax.swing.JPanel ProductInfoPanel;
    private javax.swing.JTextField Quantity;
    private javax.swing.JButton Remove;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField productID;
    // End of variables declaration//GEN-END:variables
}
