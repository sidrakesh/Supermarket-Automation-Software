/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2011, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------------
 * XYLineAnnotation.java
 * ---------------------
 * (C) Copyright 2003-2009, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   Peter Kolb (see patch 2809117);
 *
 * Changes:
 * --------
 * 02-Apr-2003 : Version 1 (DG);
 * 19-Aug-2003 : Added equals method, implemented Cloneable, and applied
 *               serialization fixes (DG);
 * 21-Jan-2004 : Update for renamed method in ValueAxis (DG);
 * 14-Apr-2004 : Fixed draw() method to handle plot orientation correctly (DG);
 * 29-Sep-2004 : Added support for tool tips and URLS, now extends
 *               AbstractXYAnnotation (DG);
 * 04-Oct-2004 : Renamed ShapeUtils --> ShapeUtilities (DG);
 * 08-Jun-2005 : Fixed equals() method to handle GradientPaint() (DG);
 * 05-Nov-2008 : Added workaround for JRE bug 6574155, see JFreeChart bug
 *               2221495 (DG);
 *
 */
package sas;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.*;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class BarChart
{

        public BarChart()
        {
                
        }

        public static CategoryDataset createSaleDataset(java.util.HashMap<String,Float> lsh)
        {
                DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
                for(String sh:lsh.keySet()){
                    defaultcategorydataset.addValue(lsh.get(sh), "Sales", sh);
                }
                
                return defaultcategorydataset;
        }
        public static CategoryDataset createProfitDataset(HashMap<String,Float> lsh)
        {
                DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
                for(String sh:lsh.keySet()){
                    defaultcategorydataset.addValue(lsh.get(sh), "Profit", sh);
                }
                
                return defaultcategorydataset;
        }
        public static CategoryDataset createPriceDataset(HashMap<String,Float> lsh)
        {
                DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
                for(String sh:lsh.keySet()){
                    defaultcategorydataset.addValue(lsh.get(sh), "Prices", sh);
                }
                
                return defaultcategorydataset;
        }

        public static JFreeChart createChart(CategoryDataset categorydataset, String name, String type, String t)
        {
                JFreeChart jfreechart = ChartFactory.createLineChart(name, null, type, categorydataset, PlotOrientation.VERTICAL, false, true, false);
                jfreechart.addSubtitle(new TextTitle(t));
                TextTitle texttitle = new TextTitle("");
                texttitle.setFont(new Font("SansSerif", 0, 10));
                texttitle.setPosition(RectangleEdge.BOTTOM);
                texttitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
                jfreechart.addSubtitle(texttitle);
                CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
                categoryplot.setRangePannable(true);
                categoryplot.setRangeGridlinesVisible(false);
                java.net.URL url = (BarChart.class).getClassLoader().getResource("line_Chart_example.png");
                if (url != null)
                {
                        ImageIcon imageicon = new ImageIcon(url);
                        jfreechart.setBackgroundImage(imageicon.getImage());
                        categoryplot.setBackgroundPaint(null);
                }
                NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
                numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                ChartUtilities.applyCurrentTheme(jfreechart);
                LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
                lineandshaperenderer.setBaseShapesVisible(true);
                lineandshaperenderer.setDrawOutlines(true);
                lineandshaperenderer.setUseFillPaint(true);
                lineandshaperenderer.setBaseFillPaint(Color.white);
                lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
                lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
                lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
                return jfreechart;
        }

        public static ChartPanel createSaleChart(java.util.HashMap<String,Float> lsh,int i)
        {
                String s  = i==0?"Daily Analysis":(i==1)?"Monthly Analysis":"Yearly Analysis";
                JFreeChart jfreechart = createChart(createSaleDataset(lsh),"Sales Chart","quantity",s);
                ChartPanel chartpanel = new ChartPanel(jfreechart);
                chartpanel.setMouseWheelEnabled(true);
                
                return chartpanel;
        }
        public static ChartPanel createProfitChart(java.util.HashMap<String,Float> profit, int i){
            String s  = i==0?"Daily Analysis":(i==1)?"Monthly Analysis":"Yearly Analysis";
            JFreeChart jfreechart = createChart(createProfitDataset(profit),"Profit Chart","amount(in Rs.)",s);
                ChartPanel chartpanel = new ChartPanel(jfreechart);
                chartpanel.setMouseWheelEnabled(true);
                
                return chartpanel;
        }
        public static ChartPanel createPriceChart(java.util.HashMap<String,Float> price, int i){
            String s  = i==0?"Daily Analysis":(i==1)?"Monthly Analysis":"Yearly Analysis";
            JFreeChart jfreechart = createChart(createPriceDataset(price),"Price Chart","amount(in Rs.)",s);
                ChartPanel chartpanel = new ChartPanel(jfreechart);
                chartpanel.setMouseWheelEnabled(true);
                
                return chartpanel;
        }
        
}
 
