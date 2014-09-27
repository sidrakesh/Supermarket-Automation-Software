/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import SupermarketData.SalesHistory;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Sameer
 */
public class ItemStatisticsDialog extends javax.swing.JDialog {

    /**
     * Creates new form ItemStatisticsDialog
     */
    InventoryDatabase id;
    int mm,dd;
    private DefaultTableModel tm;
    private String ProductID;
    
    List<SalesHistory>sh;
    HashMap<String,Float>Profit;
    HashMap<String,Float>Sales;
    HashMap<String,Float>Price;
    
    public ItemStatisticsDialog(java.awt.Frame parent, boolean modal, String nProductID, InventoryDatabase nid) {
        super(parent, modal);
        initComponents();
        DiagramPanel.setLayout(new FlowLayout());
        id = nid;
        ProductID = nProductID;
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Icon.png"));
        this.setIconImage(icon.getImage());
        
        Profit = new HashMap<>();
        Sales = new HashMap<>();
        Price = new HashMap<>();
        
        tm = (DefaultTableModel)StatsList.getModel();
        
        final String months[] = {"Months:","January","February","March","April","May","June","July","August","September","October","November","December"};
        String days[]= new String[32];
        days[0] = "Day:";
        for(int i=1;i<=31;i++){
            days[i] = i+"";
        }
        final String year[] = new String[120];
        year[0]="Year:";
        int presentyear = new GregorianCalendar().get(GregorianCalendar.YEAR);
        for(int i=1;i<120;i++){
            year[i] = presentyear+"";
            presentyear--;
        }
        
        SalesModel.addActionListener(new RadioHandler(1));
        ProfitModel.addActionListener(new RadioHandler(0));
        PriceModel.addActionListener(new RadioHandler(2));
        
        monthComboStart.setModel(new JComboBox(months).getModel());
        monthComboEnd.setModel(new JComboBox(months).getModel());
        dayComboStart.setModel(new JComboBox(days).getModel());
        dayComboEnd.setModel(new JComboBox(days).getModel());
        yearComboStart.setModel(new JComboBox(year).getModel());
        yearComboEnd.setModel(new JComboBox(year).getModel());
        
        
        ItemListener il1 = new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                mm = monthComboStart.getSelectedIndex();
                String monthSelected = months[mm];
                if(monthSelected.equals(months[4]) || monthSelected.equals(months[6]) || monthSelected.equals(months[9]) || monthSelected.equals(months[11])){
                    String days[] = new String[31];
                    days[0] = "Day:";
                    for(int i=1;i<31;i++){
                        days[i] = i+"";
                    }
                    dayComboStart.setModel(new JComboBox(days).getModel());
                }
                else if(monthSelected.equals(months[2])){
                    String days[] = new String[29];
                    days[0] = "Day:";
                    for(int i=1;i<29;i++){
                        days[i]=i+"";
                    }
                    dayComboStart.setModel(new JComboBox(days).getModel());
                }
                else{
                    String days[] = new String[32];
                    days[0] = "Day:";
                    for(int i=1;i<32;i++){
                        days[i]=i+"";
                    }
                    dayComboStart.setModel(new JComboBox(days).getModel());
                }
            }
        };
        
        ItemListener il2 = new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                mm = monthComboEnd.getSelectedIndex();
                String monthSelected = months[mm];
                if(monthSelected.equals(months[4]) || monthSelected.equals(months[6]) || monthSelected.equals(months[9]) || monthSelected.equals(months[11])){
                    String days[] = new String[31];
                    days[0] = "Day:";
                    for(int i=1;i<31;i++){
                        days[i] = i+"";
                    }
                    dayComboEnd.setModel(new JComboBox(days).getModel());
                }
                else if(monthSelected.equals(months[2])){
                    String days[] = new String[29];
                    days[0] = "Day:";
                    for(int i=1;i<29;i++){
                        days[i]=i+"";
                    }
                    dayComboEnd.setModel(new JComboBox(days).getModel());
                }
                else{
                    String days[] = new String[32];
                    days[0] = "Day:";
                    for(int i=1;i<32;i++){
                        days[i]=i+"";
                    }
                    dayComboEnd.setModel(new JComboBox(days).getModel());
                }
            }
        };
        
        monthComboStart.addItemListener(il1);
        monthComboEnd.addItemListener(il2);
        
        ItemListener il3 = new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                dd = dayComboStart.getSelectedIndex();
            }
        };
        
        ItemListener il4 = new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                dd = dayComboEnd.getSelectedIndex();
            }
        };
        
        dayComboStart.addItemListener(il3);
        dayComboEnd.addItemListener(il4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DiagramType = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        ViewBy = new javax.swing.JComboBox();
        DiagramPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GetStatisticsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatsList = new javax.swing.JTable();
        yearComboEnd = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        yearComboStart = new javax.swing.JComboBox();
        dayComboStart = new javax.swing.JComboBox();
        monthComboStart = new javax.swing.JComboBox();
        dayComboEnd = new javax.swing.JComboBox();
        monthComboEnd = new javax.swing.JComboBox();
        PriceModel = new javax.swing.JRadioButton();
        SalesModel = new javax.swing.JRadioButton();
        ProfitModel = new javax.swing.JRadioButton();
        PrintStatisticsTable = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        PrintChart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("View By:");

        ViewBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Month", "Year" }));

        javax.swing.GroupLayout DiagramPanelLayout = new javax.swing.GroupLayout(DiagramPanel);
        DiagramPanel.setLayout(DiagramPanelLayout);
        DiagramPanelLayout.setHorizontalGroup(
            DiagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        DiagramPanelLayout.setVerticalGroup(
            DiagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STATISTICS PORTAL");

        jLabel3.setText("Select End Time : ");

        GetStatisticsButton.setText("Get Statistics");
        GetStatisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetStatisticsButtonActionPerformed(evt);
            }
        });

        StatsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Price realized", "Sales", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StatsList);

        jLabel2.setText("Select Start Time : ");

        monthComboStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        DiagramType.add(PriceModel);
        PriceModel.setText("Price Model");
        PriceModel.setEnabled(false);

        DiagramType.add(SalesModel);
        SalesModel.setText("Sales Model");
        SalesModel.setEnabled(false);

        DiagramType.add(ProfitModel);
        ProfitModel.setText("Profit Model");
        ProfitModel.setEnabled(false);

        PrintStatisticsTable.setText("Print Statistics table");
        PrintStatisticsTable.setEnabled(false);
        PrintStatisticsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintStatisticsTableActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        PrintChart.setText("Print");
        PrintChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PrintChart)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(monthComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(dayComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(yearComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(monthComboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(dayComboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(yearComboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(GetStatisticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(54, 54, 54)
                                            .addComponent(ViewBy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ProfitModel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(SalesModel)
                                            .addGap(18, 18, 18)
                                            .addComponent(PriceModel)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PrintStatisticsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(DiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PrintStatisticsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(monthComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dayComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(monthComboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dayComboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearComboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(GetStatisticsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ViewBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProfitModel)
                            .addComponent(SalesModel)
                            .addComponent(PriceModel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PrintChart)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetStatisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetStatisticsButtonActionPerformed
        // TODO add your handling code here:
    if(dayComboStart.getSelectedIndex()==0||monthComboStart.getSelectedIndex()==0||yearComboStart.getSelectedIndex()==0||dayComboEnd.getSelectedIndex()==0||monthComboEnd.getSelectedIndex()==0||yearComboEnd.getSelectedIndex()==0)
    {
        JOptionPane.showMessageDialog(null, "One or more time specifiers not selected!");
    }
    else
    {
        String startDate,endDate;
        
        PrintStatisticsTable.setEnabled(true);
        
        Profit.clear();
        Sales.clear();
        Price.clear();
        
        startDate = yearComboStart.getSelectedItem().toString()+"/"+monthComboStart.getSelectedIndex()+"/"+dayComboStart.getSelectedItem().toString();
        endDate = yearComboEnd.getSelectedItem().toString()+"/"+monthComboEnd.getSelectedIndex()+"/"+dayComboEnd.getSelectedItem().toString();
        
        sh = id.getSalesHistory(ProductID, startDate, endDate);
        
        
        
        if(sh!=null)
        {
            int i,j;
            
            tm.getDataVector().removeAllElements();
            tm.fireTableDataChanged();
            
            String dos;
            
            if(ViewBy.getSelectedIndex()==0)
            {
                for(i=0;i<sh.size();i++)
                {
                    if(sh.get(i).getDateOfSale().compareTo(startDate)>=0&&sh.get(i).getDateOfSale().compareTo(endDate)<=0)
                    {
                        tm.addRow(new Object[4]);
                        dos = sh.get(i).getDateOfSale();
                        tm.setValueAt(dos, i, 0);
                        tm.setValueAt(sh.get(i).getSellingPrice(), i, 1);
                        Price.put(dos, sh.get(i).getSellingPrice());
                        tm.setValueAt(sh.get(i).getQuantitySold(), i, 2);
                        Sales.put(dos, sh.get(i).getQuantitySold());
                        tm.setValueAt(sh.get(i).getQuantitySold()*(sh.get(i).getSellingPrice()-sh.get(i).getCostPrice()), i, 3); 
                        Profit.put(dos, sh.get(i).getQuantitySold()*(sh.get(i).getSellingPrice()-sh.get(i).getCostPrice()));
                    }
                }
                
                DiagramPanel.removeAll();
                JPanel jp = BarChart.createProfitChart(Profit,0);
            
                ProfitModel.setSelected(true);
                DiagramPanel.add(jp);
                DiagramPanel.repaint();
                DiagramPanel.revalidate();
                ProfitModel.setEnabled(true);
                PriceModel.setEnabled(true);
                SalesModel.setEnabled(true);
            }
            else if(ViewBy.getSelectedIndex()==1)
            {
                String lastMonth = sh.get(0).getDateOfSale().substring(0,sh.get(0).getDateOfSale().lastIndexOf("/"));
                String newMonth;
                float ProfitSum=0;
                float SellingPriceSum = 0;
                float QuantitySold = 0;
                float numInstances = 0;
                
                j=0;
                
                for(i=0;i<sh.size();i++)
                {
                    if(sh.get(i).getDateOfSale().compareTo(startDate)>=0&&sh.get(i).getDateOfSale().compareTo(endDate)<=0)
                    {
                        newMonth = sh.get(i).getDateOfSale().substring(0,sh.get(i).getDateOfSale().lastIndexOf("/"));
                    
                        if(!lastMonth.equals(newMonth))
                        {
                        
                            tm.addRow(new Object[4]);

                            tm.setValueAt(lastMonth, j, 0);
                            tm.setValueAt(SellingPriceSum/numInstances, j, 1);
                            tm.setValueAt(QuantitySold, j, 2);
                            tm.setValueAt(ProfitSum, j, 3);
                            
                            Profit.put(lastMonth, ProfitSum);
                            Sales.put(lastMonth, QuantitySold);
                            Price.put(lastMonth, SellingPriceSum/numInstances);
                            
                            lastMonth = newMonth;
                            
                            ProfitSum = 0;
                            SellingPriceSum = 0;
                            QuantitySold = 0;
                            numInstances = 0;
                        
                            j++;
                        }
                        else
                        {
                            ProfitSum += sh.get(i).getQuantitySold()*(sh.get(i).getSellingPrice()-sh.get(i).getCostPrice());
                            SellingPriceSum += sh.get(i).getSellingPrice();
                            QuantitySold += sh.get(i).getQuantitySold();
                            numInstances++;
                        }
                    }
                }
                
                tm.addRow(new Object[4]);
                tm.setValueAt(lastMonth, j, 0);
                tm.setValueAt(SellingPriceSum/numInstances, j, 1);
                tm.setValueAt(QuantitySold, j, 2);
                tm.setValueAt(ProfitSum, j, 3);
                
                Profit.put(lastMonth, ProfitSum);
                Sales.put(lastMonth, QuantitySold);
                Price.put(lastMonth, SellingPriceSum/numInstances);
                
                DiagramPanel.removeAll();
                JPanel jp = BarChart.createProfitChart(Profit,1);
            
                ProfitModel.setSelected(true);
                DiagramPanel.add(jp);
                DiagramPanel.repaint();
                DiagramPanel.revalidate();
                
                ProfitModel.setEnabled(true);
                PriceModel.setEnabled(true);
                SalesModel.setEnabled(true);
            }
            else if(ViewBy.getSelectedIndex()==2)
            {
                String lastYear = sh.get(0).getDateOfSale().substring(0,sh.get(0).getDateOfSale().indexOf("/"));
                String newYear;
                float ProfitSum=0;
                float SellingPriceSum = 0;
                float QuantitySold = 0;
                float numInstances = 0;
                
                j=0;
                
                for(i=0;i<sh.size();i++)
                {
                    if(sh.get(i).getDateOfSale().compareTo(startDate)>=0&&sh.get(i).getDateOfSale().compareTo(endDate)<=0)
                    {
                        newYear = sh.get(i).getDateOfSale().substring(0,sh.get(i).getDateOfSale().indexOf("/"));
                    
                        if(!lastYear.equals(newYear))
                        {
                        
                            tm.addRow(new Object[4]);

                            tm.setValueAt(lastYear, j, 0);
                            tm.setValueAt(SellingPriceSum/numInstances, j, 1);
                            tm.setValueAt(QuantitySold, j, 2);
                            tm.setValueAt(ProfitSum, j, 3);
                            
                            Profit.put(lastYear, ProfitSum);
                            Sales.put(lastYear, QuantitySold);
                            Price.put(lastYear, SellingPriceSum/numInstances);
                            
                            lastYear = newYear;
                            
                            ProfitSum = 0;
                            SellingPriceSum = 0;
                            QuantitySold = 0;
                            numInstances = 0;
                        
                            j++;
                        }
                        else
                        {
                            ProfitSum += sh.get(i).getQuantitySold()*(sh.get(i).getSellingPrice()-sh.get(i).getCostPrice());
                            SellingPriceSum += sh.get(i).getSellingPrice();
                            QuantitySold += sh.get(i).getQuantitySold();
                            numInstances++;
                        }
                    }
                }
                
                tm.addRow(new Object[4]);
                tm.setValueAt(lastYear, j, 0);
                tm.setValueAt(SellingPriceSum/numInstances, j, 1);
                tm.setValueAt(QuantitySold, j, 2);
                tm.setValueAt(ProfitSum, j, 3);
                
                Profit.put(lastYear, ProfitSum);
                Sales.put(lastYear, QuantitySold);
                Price.put(lastYear, SellingPriceSum/numInstances);
                
                DiagramPanel.removeAll();
                ProfitModel.setSelected(true);
                JPanel jp = BarChart.createProfitChart(Profit,2);
                
                
                DiagramPanel.add(jp);
                DiagramPanel.repaint();
                DiagramPanel.revalidate();
                
                ProfitModel.setEnabled(true);
                PriceModel.setEnabled(true);
                SalesModel.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No sales history yet registered!");
            }
            
        }
    }    
    }//GEN-LAST:event_GetStatisticsButtonActionPerformed

    private void PrintStatisticsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintStatisticsTableActionPerformed
        // TODO add your handling code here:
        String table;
        table = "<html><body><h3 style = 'font-family:Tahoma'><center>Statistics</center></h3>";
        table+="<br /><table><tr><th width = 120><center>Time</center></th><th width = 120><center>Price realized</center></th><th width = 120><center>Sales</center></th><th width = 120><center>Profit</center></th></tr>";
        
        int i;
        for(i=0;i<StatsList.getRowCount();i++)
        {
            
            table+="<tr><td><center>"+(String)StatsList.getModel().getValueAt(i, 0)+"</center></td><td><center>"+(Float)StatsList.getModel().getValueAt(i, 1)+"</center></td><td><center>"+(Float)StatsList.getModel().getValueAt(i, 2)+"</center></td><td><center>"+(Float)StatsList.getModel().getValueAt(i, 3)+"</center></td></tr>";
            
        }
        table+="</table></body></html>";
        
        StatisticsPrintPreview spp = new StatisticsPrintPreview(new JFrame(), true, table);
        spp.setLocationRelativeTo(null);
        spp.setVisible(true);
    }//GEN-LAST:event_PrintStatisticsTableActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void PrintChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintChartActionPerformed
        
        ChartPanel cp=null;
        if(ProfitModel.isSelected()){
            cp = BarChart.createProfitChart(Profit, 0);  
        }
        else if(SalesModel.isSelected()){
            cp = BarChart.createProfitChart(Sales, 0);
        }
        else if(PriceModel.isSelected()){
            cp = BarChart.createProfitChart(Price, 0);
        }
        cp.createChartPrintJob();
        
    }//GEN-LAST:event_PrintChartActionPerformed
    private class RadioHandler implements ActionListener{
        private int type;
        public RadioHandler(int i){
            type = i;
        }
        public void actionPerformed(ActionEvent evt){
            DiagramPanel.removeAll();
            JPanel jp;
            if(type == 0){
                jp = BarChart.createProfitChart(Profit,ViewBy.getSelectedIndex());
            }
            else if(type == 1){
                jp = BarChart.createSaleChart(Sales,ViewBy.getSelectedIndex());
            }
            else{
                jp = BarChart.createPriceChart(Price,ViewBy.getSelectedIndex());
            }
            
            DiagramPanel.add(jp);
            DiagramPanel.repaint();
            DiagramPanel.revalidate();
        }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DiagramPanel;
    private javax.swing.ButtonGroup DiagramType;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton GetStatisticsButton;
    private javax.swing.JRadioButton PriceModel;
    private javax.swing.JButton PrintChart;
    private javax.swing.JButton PrintStatisticsTable;
    private javax.swing.JRadioButton ProfitModel;
    private javax.swing.JRadioButton SalesModel;
    private javax.swing.JTable StatsList;
    private javax.swing.JComboBox ViewBy;
    private javax.swing.JComboBox dayComboEnd;
    private javax.swing.JComboBox dayComboStart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthComboEnd;
    private javax.swing.JComboBox monthComboStart;
    private javax.swing.JComboBox yearComboEnd;
    private javax.swing.JComboBox yearComboStart;
    // End of variables declaration//GEN-END:variables
}
