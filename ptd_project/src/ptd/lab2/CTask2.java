/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab2;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask2 extends CBasicTask implements ITask 
{
    private double m_dF1;
    private double m_dF2;
    
    public CTask2 (double a_dF1, double a_dF2)
    {
        m_dF1 = a_dF1;
        m_dF2 = a_dF2;
    }
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("dla f1 = " + m_dF1 + ", f2 = " + m_dF2);
        
        ArrayList<Double> list1 = new ArrayList<Double>();
        ArrayList<Double> list2 = new ArrayList<Double>();
        double fs = 1000;
        double Ts = 2;
        double N = fs * Ts;
        
        for(int i = 0; i < N/2; i++)
        {
            list1.add(Math.sin(2 * Math.PI * i / fs));
            list2.add(i * (1 / (N / 2)));
        }
        list1.addAll(list2);
        
        for(int i = 0; i < N; i++)
        {
            double t = i * Ts / fs;
            double tmpVal = (list1.get(i) * Math.sin(2 * Math.PI * m_dF1 * t)
                    * Math.cos(2 * Math.PI * m_dF2 * t));
            
            oResult.add(t, tmpVal);
        }

        return oResult;
    }
    
}
