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
public class CTask1 extends CBasicTask implements ITask 
{
    float fi = (float) ((3/4) * Math.PI);
    float Ts = 1;
    float A = (float) 0.4;
    float f = 22; //hz
    float fs = 1500; //hz
    float N = fs * Ts; //buffer size
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("zad1");

        float firstValue = (float) (2 * Math.PI * f);
        float secondValue = fs + fi;
        
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (A *  Math.sin( (firstValue * t / secondValue) ));
            oResult.add(X, Y);
        }
    
        return oResult;
    }
}
