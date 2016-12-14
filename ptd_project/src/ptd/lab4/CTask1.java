/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab4;

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
    private double A = 1;
    private double f = 220; //hz
    private double fs = 3000; //hz
    private double N = fs * Ts; //buffer size
    private double fm = 500;
    private double fc = 200;
    
    public CTask1() { }
  
    @Override
    public XYSeries execute()
    {
        XYSeries oResult = new XYSeries("dla j = 0.1");
        
        float Kam = 0.1f;
        float Kpm = 0.1f;
        
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
