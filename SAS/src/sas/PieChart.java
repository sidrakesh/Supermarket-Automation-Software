/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import java.util.HashMap;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * A demo showing four pie charts.
 */
public class PieChart{

    public static ChartPanel createProfitChart(HashMap<String,Float> hm){
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(String s: hm.keySet()){
        dataset.setValue(s, hm.get(s));
        }
        JFreeChart chart = ChartFactory.createPieChart("Overall profit statistics", dataset, true, true, true);

        ChartPanel cp = new ChartPanel(chart);
        return cp;
    }
}
