/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartPanel;


public class OverallStatisticsDialog extends javax.swing.JDialog {

    private InventoryDatabase id;
    private int mm,dd;
    private DefaultTableModel tm;
    
    private HashMap<String,Float>Profit;
    private HashMap<String,Float>Sales;
    private HashMap<String,Float>YearlyProfit;
    private HashMap<String,Float>MonthlyProfit;
    
    
    public OverallStatisticsDialog(java.awt.Frame parent, boolean modal, InventoryDatabase nid) {
        super(parent, modal);
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Icon.png"));
        this.setIconImage(icon.getImage());
        YearlyProfit = new HashMap<>();
        MonthlyProfit = new HashMap<>();
        ProfitModel.setSelected(true);
        id = nid;
        DiagramPanel.setLayout(new FlowLayout());
        tm = (DefaultTableModel)StatsList.getModel();
    
        Profit = new HashMap<>();
        Sales = new HashMap<>();
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        GetStatisticsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        monthComboEnd = new javax.swing.JComboBox();
        ViewBy = new javax.swing.JComboBox();
        dayComboEnd = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        monthComboStart = new javax.swing.JComboBox();
        dayComboStart = new javax.swing.JComboBox();
        DiagramPanel = new javax.swing.JPanel();
        yearComboEnd = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        yearComboStart = new javax.swing.JComboBox();
        ProductProfitCompare = new javax.swing.JRadioButton();
        ProfitModel = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatsList = new javax.swing.JTable();
        Exit = new javax.swing.JButton();
        PrintStatistics = new javax.swing.JButton();
        PrintButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        GetStatisticsButton.setText("Get Statistics");
        GetStatisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetStatisticsButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Select End Time : ");

        ViewBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Month", "Year" }));

        jLabel5.setText("View By:");

        monthComboStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout DiagramPanelLayout = new javax.swing.GroupLayout(DiagramPanel);
        DiagramPanel.setLayout(DiagramPanelLayout);
        DiagramPanelLayout.setHorizontalGroup(
            DiagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        DiagramPanelLayout.setVerticalGroup(
            DiagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jLabel2.setText("Select Start Time : ");

        buttonGroup1.add(ProductProfitCompare);
        ProductProfitCompare.setText("Product profit comparision");

        buttonGroup1.add(ProfitModel);
        ProfitModel.setText("Profit Model");

        StatsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StatsList);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        PrintStatistics.setText("Print statistics");
        PrintStatistics.setEnabled(false);
        PrintStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintStatisticsActionPerformed(evt);
            }
        });

        PrintButton.setText("Print");
        PrintButton.setEnabled(false);
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                                .addComponent(GetStatisticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrintStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(54, 54, 54)
                                        .addComponent(ViewBy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ProfitModel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ProductProfitCompare)
                                        .addGap(101, 101, 101)
                                        .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(GetStatisticsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(PrintStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ViewBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProfitModel)
                            .addComponent(ProductProfitCompare)
                            .addComponent(Exit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrintButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetStatisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetStatisticsButtonActionPerformed
        // TODO add your handling code here:
        PrintButton.setEnabled(true);
    if(dayComboStart.getSelectedIndex()==0||monthComboStart.getSelectedIndex()==0||yearComboStart.getSelectedIndex()==0||dayComboEnd.getSelectedIndex()==0||monthComboEnd.getSelectedIndex()==0||yearComboEnd.getSelectedIndex()==0)
    {
        JOptionPane.showMessageDialog(null, "One or more time specifiers not selected!");
    }
    else
    {
        PrintStatistics.setEnabled(true);
       
        String startDate,endDate;
        Profit.clear();
        Sales.clear();
        int j=0;
        
        startDate = yearComboStart.getSelectedItem().toString()+"/"+monthComboStart.getSelectedIndex()+"/"+dayComboStart.getSelectedItem().toString();
        endDate = yearComboEnd.getSelectedItem().toString()+"/"+monthComboEnd.getSelectedIndex()+"/"+dayComboEnd.getSelectedItem().toString();

        Profit = id.getOverallProfit(startDate, endDate);
        Sales = id.getOverallStats(startDate, endDate);
        
        if(ProfitModel.isSelected())
        {
            
            if(Profit!=null)
            {
                JTableHeader th = StatsList.getTableHeader();
                TableColumnModel tcm = th.getColumnModel();
                TableColumn tc = tcm.getColumn(0);
                tc.setHeaderValue( "Time" );
                th.repaint();

                tm.getDataVector().removeAllElements();
                tm.fireTableDataChanged();

                if(ViewBy.getSelectedIndex()==0)
                {
                    for(String i:Profit.keySet())
                    {
                        tm.addRow(new Object[2]);                        
                        tm.setValueAt(i, j, 0);
                        tm.setValueAt(Profit.get(i), j, 1);
                        j++;
                    }

                    DiagramPanel.removeAll();
                    JPanel jp = BarChart.createProfitChart(Profit,0);

                    DiagramPanel.add(jp);
                    DiagramPanel.repaint();
                    DiagramPanel.revalidate();
                }
            
                else if(ViewBy.getSelectedIndex()==1)
                {
                    MonthlyProfit.clear();
                    
                    String lastMonth = Collections.min(Profit.keySet()).substring(0,Collections.min(Profit.keySet()).lastIndexOf("/"));
                
                    String newMonth;
                    float ProfitSum=0;
                
                    for(String i:Profit.keySet())
                    {   
                        newMonth = i.substring(0,i.lastIndexOf("/"));

                        if(!lastMonth.equals(newMonth))
                        {
                            tm.addRow(new Object[2]);

                            tm.setValueAt(lastMonth, j, 0);
                            tm.setValueAt(ProfitSum, j, 1);
                            
                            MonthlyProfit.put(lastMonth, ProfitSum);
                            
                            lastMonth = newMonth;

                            ProfitSum = 0;
                            j++;
                        }
                        else
                        {
                            ProfitSum += Profit.get(i);
                        }
                    }       
            
                    tm.addRow(new Object[0]);
                    tm.setValueAt(lastMonth, j, 0);
                    tm.setValueAt(ProfitSum, j, 1);
                    
                    MonthlyProfit.put(lastMonth, ProfitSum);
                    
                    DiagramPanel.removeAll();
                    JPanel jp = BarChart.createProfitChart(MonthlyProfit,1);
                    
                    DiagramPanel.add(jp);
                    DiagramPanel.repaint();
                    DiagramPanel.revalidate();
                    
                }
            
                else if(ViewBy.getSelectedIndex()==2)
                {
                    String lastYear = Collections.min(Profit.keySet()).substring(0,Collections.min(Profit.keySet()).indexOf("/"));
                    String newYear;
                    
                    YearlyProfit.clear();
                    
                    float ProfitSum=0;
                
                    for(String i:Profit.keySet())
                    {   
                        newYear = i.substring(0,i.indexOf("/"));

                        if(!lastYear.equals(newYear))
                        {
                            tm.addRow(new Object[2]);

                            tm.setValueAt(lastYear, j, 0);
                            tm.setValueAt(ProfitSum, j, 1);
                            
                            YearlyProfit.put(lastYear, ProfitSum);
                            
                            lastYear = newYear;

                            ProfitSum = 0;
                            j++;
                        }
                        else
                        {
                            ProfitSum += Profit.get(i);
                        }
                    }       
            
                    tm.addRow(new Object[0]);
                    tm.setValueAt(lastYear, j, 0);
                    tm.setValueAt(ProfitSum, j, 1);

                    YearlyProfit.put(lastYear, ProfitSum);
                    
                    DiagramPanel.removeAll();
                    JPanel jp = BarChart.createProfitChart(YearlyProfit,2);

                    DiagramPanel.add(jp);
                    DiagramPanel.repaint();
                    DiagramPanel.revalidate();
                }
            }
        
            else
            {
                JOptionPane.showMessageDialog(null, "No profits yet registered!");
            }
        }
        
        else if(ProductProfitCompare.isSelected())
        {
            JTableHeader th = StatsList.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc = tcm.getColumn(0);
            tc.setHeaderValue( "Product" );
            th.repaint();
            
            if(Sales!=null)
            {
                tm.getDataVector().removeAllElements();
                tm.fireTableDataChanged();

                for(String i:Sales.keySet())
                {
                    tm.addRow(new Object[2]);                        
                    tm.setValueAt(i, j, 0);
                    tm.setValueAt(Sales.get(i), j, 1);
                    j++;
                }

                DiagramPanel.removeAll();
                JPanel jp = PieChart.createProfitChart(Sales);

                DiagramPanel.add(jp);
                DiagramPanel.repaint();
                DiagramPanel.revalidate();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No sales history yet registered!");
            }   
        }
    }
    }//GEN-LAST:event_GetStatisticsButtonActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void PrintStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintStatisticsActionPerformed
        // TODO add your handling code here:
        String table;
        table = "<html><body><h3 style = 'font-family:Tahoma'><center>Statistics</center></h3>";
        table+="<br /><table><tr><th width = 120><center>";
        
        if(ProfitModel.isSelected()) 
        {
            table+="Time";
        }   
        else 
        {
            table += "Product";
        }        
                
        table +="</center></th><th width = 120><center>Price realized</center></th><th width = 120><center>Sales</center></th><th width = 120><center>Profit</center></th></tr>";
        
        int i;
        for(i=0;i<StatsList.getRowCount();i++)
        {
            
            table+="<tr><td><center>"+(String)StatsList.getModel().getValueAt(i, 0)+"</center></td><td><center>"+(Float)StatsList.getModel().getValueAt(i, 1)+"</center></td><td><center>"+(Float)StatsList.getModel().getValueAt(i, 2)+"</center></td><td><center>"+(Float)StatsList.getModel().getValueAt(i, 3)+"</center></td></tr>";
            
        }
        table+="</table></body></html>";
        
        StatisticsPrintPreview spp = new StatisticsPrintPreview(new JFrame(), true, table);
        spp.setLocationRelativeTo(null);
        spp.setVisible(true);
    }//GEN-LAST:event_PrintStatisticsActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        ChartPanel cp = null;
        if(ProductProfitCompare.isSelected()){
           cp = PieChart.createProfitChart(Sales);
        }
        else{
            int i = ViewBy.getSelectedIndex();
            if(i == 0 ){
                cp = BarChart.createProfitChart(Profit, i);
            }
            else if(i==1){
                cp = BarChart.createProfitChart(MonthlyProfit, i);
            }
            else{
                cp = BarChart.createProfitChart(YearlyProfit, i);
            }
        }
        cp.createChartPrintJob();
    }//GEN-LAST:event_PrintButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DiagramPanel;
    private javax.swing.JButton Exit;
    private javax.swing.JButton GetStatisticsButton;
    private javax.swing.JButton PrintButton;
    private javax.swing.JButton PrintStatistics;
    private javax.swing.JRadioButton ProductProfitCompare;
    private javax.swing.JRadioButton ProfitModel;
    private javax.swing.JTable StatsList;
    private javax.swing.JComboBox ViewBy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox dayComboEnd;
    private javax.swing.JComboBox dayComboStart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthComboEnd;
    private javax.swing.JComboBox monthComboStart;
    private javax.swing.JComboBox yearComboEnd;
    private javax.swing.JComboBox yearComboStart;
    // End of variables declaration//GEN-END:variables
}
