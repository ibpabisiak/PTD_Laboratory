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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
