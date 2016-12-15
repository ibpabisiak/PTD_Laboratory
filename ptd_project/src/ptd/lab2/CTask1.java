/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab2;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.CFloatPoint;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask1 extends CBasicTask implements ITask 
{
    private final float fi = (float) ((3/4) * Math.PI);
    private final float Ts = 1;
    private final float A = (float) 0.4;
    private final float f = 22; //hz
    private final float fs = 1500; //hz
//    private final float N = fs * Ts; //buffer size
    
    @Override
    public XYSeries execute() 
    {
        XYSeries oResult = new XYSeries("zad1");

        ArrayList<CFloatPoint> oSimpleSinusSignalPoints = getSimpleSinusSignal(fi, Ts, A, f, fs);

        for(CFloatPoint oPoint : oSimpleSinusSignalPoints)
        {
            oResult.add(oPoint.getPosX(), oPoint.getPosY());
        }
        
        return oResult;
    }
}
