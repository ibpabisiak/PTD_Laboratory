/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab4;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask3 extends CBasicTask implements ITask 
{
    public float k;
    private double fs = 3000;
    private double Ts = 1;
    private double f = 2200;
    private double N = fs * Ts;
    private double l = 4 / Math.PI;
    
    public CTask3(float a_fK)
    {
        k = a_fK;
    }    
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("dla k = " + k + " | ");
       
        ArrayList<Float> temp = new ArrayList<Float>();
        for(int i = 0; i < N; i++)
        {
            double v = 0;
            double t = i * Ts / fs;
            
            for(int j = 1; j < k; j++)
            {
                v += (1 / (2 * j - 1) * Math.sin((2 * j - 1) 
                        * f * 2 * Math.PI * t));
            }
            v += l;
            temp.add((float)v);
            

        }

        ArrayList<Float> Y = new ArrayList<Float>();
        ArrayList<Float> X = new ArrayList<Float>();
        
        for(int kk = 0; kk < N/2; kk++)
        {
            float Ex = 0, Ey = 0;
            for(int n = 0; n < N; n++)
            {
                float val = (float) ((2 * Math.PI * n * kk) / N);
                
                float ex = (float) (Math.sin(val));
                float ey = (float) (Math.cos((val)));
                
                Ex += temp.get(n) * ex;
                Ey += temp.get(n) * ey;
            }

            Y.add((float)Math.sqrt(Ex*Ex + Ey*Ey));           

            float asd = (float) (kk * (fs / N));
            X.add(asd);
            
            oResult.add(asd, (float)Math.sqrt(Ex*Ex + Ey*Ey));
        }
        
        return oResult;
    }
}
