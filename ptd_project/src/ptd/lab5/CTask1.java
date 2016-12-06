/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab5;

import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask1 extends CBasicTask implements ITask 
{
    float fi = (float) ((3/4) * Math.PI);
    float Ts = 1;
    float A = (float) 0.4;
    float f = 22; //hz
    float fs = 2000; //hz
    float N = fs * Ts; //buffer size
    
    @Override
    public XYSeries execute() 
    {
        
    
        return ASK();
    }
    
    public XYSeries PSK() 
    {
        XYSeries oResult = new XYSeries("zad1");


        int samples = 0;
        boolean state = false;
        
        for(int t = 0; t < N; t++)
        {
            samples++;
            Float X = t / fs;
            Float Y = 0f;
            
            if(samples == 200)
            {
                samples = 0;
                state = !state;
            }
            
            if(state)
            {
                Y = (float) (1.0 *  Math.sin( ((float) (2 * Math.PI * 10 ) * t / fs + fi) ));            
            }
            oResult.add(X, Y);
        }
    
        return oResult;
    }    
    
    public XYSeries ASK() 
    {
        XYSeries oResult = new XYSeries("zad1");


        int samples = 0;
        boolean state = false;
        
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y;
            

            
            if(state)
            {
                Y = (float) (1.0 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) ));            
            }
            else
            {
                Y = (float) (0.5 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) ));                            
            }

            if(Y >= -0.01f && Y <= 0.01f)
            {
                samples++;
                if(samples == 4)
                {
                    samples = 0;
                    state = !state;
                }
            }

            oResult.add(X, Y);
        }
    
        return oResult;
    }    
    
}
