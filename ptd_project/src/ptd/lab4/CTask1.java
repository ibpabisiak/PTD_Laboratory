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
public class CTask1 extends CBasicTask implements ITask 
{
    private final double fi = (float) ((3/4) * Math.PI);
    private final double Ts = 1;
    private final double A = 1;
    private final double f = 220; //hz
    private final double fs = 3000; //hz
    private final double N = fs * Ts; //buffer size
    private final double fm = 500;
    private final double fc = 200;
    
    public CTask1() { }
  
    @Override
    public XYSeries execute()
    {
        float Kam = 7f;
        float Kpm = 1.1f;
        XYSeries oResult = new XYSeries("Kpm = " + Kpm);
        

        ArrayList<Double> oAmPosX = new ArrayList<>();
        ArrayList<Double> oAmPosY = new ArrayList<>();
        ArrayList<Double> oPmPosX = new ArrayList<>();
        ArrayList<Double> oPmPosY = new ArrayList<>();

        for(int t = 0; t < N; t++)
        {
            //AM
            double X = t;
            double Ct = getSinusSignalSample(fi, Ts, A, f, fs, (double)t);
            double Y = (1 + Kam * Ct) * Math.sin((2 * Math.PI * fm * t) / fs);
            oAmPosX.add(X);
            oAmPosY.add(Y);
            
            //PM
            X = t;
            Ct = getSinusSignalSample(fi, Ts, A, f, fs, (double)t);
            Y = (1 + Kam * Ct) * (Math.sin(2 * Math.PI * fm*t + Kpm*Ct));
            oPmPosX.add(X);
            oPmPosY.add(Y);
            oResult.add(X, Y);
        }

        for(int i = 0; i < N; i++)
        {
            //......
            double X = oAmPosX.get(i) - getMaxFromList(oAmPosX);
        }
        
        
        return oResult;
    }
    
    private double getMaxFromList(ArrayList<Double> a_oList)
    {
        double oResult = -9999;

        for(Double oNum : a_oList)
        {
            if(oNum > oResult)
            {
                oResult = oNum;
            }
        }        
        return oResult;
    }
    
//    @Override
//    public XYSeries execute() 
//    {
//        XYSeries oResult = new XYSeries("dla j = 0.1");
//
//        double Kam = 0.1;
//        double Kpm = 1.1;
//        
//        for(int t = 0; t < N; t++)
//        {
//            double X = t;
//            double cT1 = (double) (A *  Math.sin( ((double) (2 * Math.PI * fc) * t / fs) + fi));
//            
//            double Y = (1 + Kam * cT1) * Math.sin((2 * Math.PI * fm * t) / fs);
//            oResult.add(X, Y);
//        }
//        
//        return oResult;
//    }
}
