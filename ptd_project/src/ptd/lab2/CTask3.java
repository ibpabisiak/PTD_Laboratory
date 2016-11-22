/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab2;

import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask3 extends CBasicTask implements ITask 
{
    private float m_iK;
    private double fs = 3000;
    private double Ts = 3;
    private double f = 22;
    private double N = fs * Ts;
    private double l = 4 / Math.PI;
    
    public CTask3(float a_iK)
    {
        m_iK = a_iK;
    }
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("dla k = " + m_iK);
       
        
        for(int i = 0; i < N; i++)
        {
            double v = 0;
            double t = i * Ts / fs;
            
            for(int j = 1; j < m_iK; j++)
            {
                v += (1 / (2 * j - 1) * Math.sin((2 * j - 1) 
                        * f * 2 * Math.PI * t));
            }
            v += l;
            
            oResult.add(t, v);
        }
        
        return oResult;
    }
}
