/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CLineChart extends ApplicationFrame
{
    //static instance - singleton
    private static CLineChart INSTANCE = null;
    
    //frame size in pixels
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 400;
    
    private CLineChart() 
    {
        super("Chart");
    }

    public static CLineChart getInstance() 
    {
        if(null == INSTANCE)
        {
            INSTANCE = new CLineChart();
        }
        return INSTANCE;
    }
    
    public void plot(XYDataset a_oDataset, String a_strChartTitle)
    {
        JFreeChart oChart = ChartFactory.createXYLineChart(
            a_strChartTitle,            // chart title
            "",                         // x axis label
            "",                         // y axis label
            a_oDataset,                 // data
            PlotOrientation.VERTICAL,   // plot orientation
            true,                       // include legend
            true,                       // tooltips
            true                        // urls
        );

        ChartPanel chartPanel = new ChartPanel( oChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( FRAME_WIDTH, 
                FRAME_HEIGHT) );
        setContentPane( chartPanel );

        this.pack( );
        RefineryUtilities.centerFrameOnScreen( this );
        this.setVisible( true );
    }
}
