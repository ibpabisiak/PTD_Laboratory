/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab3;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask1 extends CBasicTask implements ITask 
{
    private double fi = (3/4) * Math.PI;
    private double Ts = 1;
    private double A = 0.4;
    private double f = 220; //hz
    private double fs = 1500; //hz
    private double N = fs * Ts; //buffer size
    
    public CTask1()
    {
        
    }
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("first");

       
        ArrayList<Float> x = new ArrayList<Float>();
        
        for(int t = 0; t < N; t++)
        {
            x.add((float) (A *  Math.sin( (2 * Math.PI * f 
                    * t / fs + fi))));
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
                
                Ex += x.get(n) * ex;
                Ey += x.get(n) * ey;
            }

            Y.add((float)Math.sqrt(Ex*Ex + Ey*Ey));           

            float asd = (float) (k * (fs / N));
            X.add(asd);
        }
        
        for(int i = 0; i < N/2; i++)
        {
            oResult.add(X.get(i), Y.get(i));
        }
        
        return oResult;
    }
}
