/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab4;

import ptd.lab3.*;
import ptd.core.ITask;
import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask2 extends CBasicTask implements ITask 
{
    private float f1, f2;
    private ArrayList<Double> list1 = new ArrayList<Double>();
    private ArrayList<Double> list2 = new ArrayList<Double>();
    private double fs = 1000;
    private double Ts = 2;
    private double N = fs * Ts;
    
    public CTask2(float a_fF1, float a_fF2)
    {
        f1 = a_fF1;
        f2 = a_fF2;
    }
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("dla f1 = " + f1 + ", f2 = " + f2 + " | ");
        
        
        for(int i = 0; i < N/2; i++)
        {
            list1.add(Math.sin(2 * Math.PI * i / fs));
            list2.add(i * (1 / (N / 2)));
        }
        list1.addAll(list2);
        
        ArrayList<Float> temp = new ArrayList<Float>();
        for(int i = 0; i < N; i++)
        {
            double t = i * Ts / fs;
            temp.add((float)(list1.get(i) * Math.sin(2 * Math.PI * f1 * t)
                    * Math.cos(2 * Math.PI * f2 * t)));            
        }
        
        ArrayList<Float> Y = new ArrayList<Float>();
        ArrayList<Float> X = new ArrayList<Float>();
        
        for(int k = 0; k < N/2; k++)
        {
            float Ex = 0, Ey = 0;
            for(int n = 0; n < N; n++)
            {
                float val = (float) ((2 * Math.PI * n * k) / N);
                
                float ex = (float) (Math.sin(val));
                float ey = (float) (Math.cos((val)));
                
                Ex += temp.get(n) * ex;
                Ey += temp.get(n) * ey;
            }

            Y.add((float)Math.sqrt(Ex*Ex + Ey*Ey));           

            float asd = (float) (k * (fs / N));
            X.add(asd);
            
            oResult.add(asd, (float)Math.sqrt(Ex*Ex + Ey*Ey));
        }
        return oResult;     
    }
}
