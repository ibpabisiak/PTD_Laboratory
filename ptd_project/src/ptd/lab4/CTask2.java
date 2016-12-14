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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
}
