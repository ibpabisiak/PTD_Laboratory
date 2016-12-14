/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab5;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import ptd.core.CBasicTask;
import ptd.core.CPoint;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CTask2 extends CBasicTask implements ITask{
    private final float fi = (float) ((3/4) * Math.PI);
    private final float Ts = 1;
    private final float A = (float) 0.4;
    private final float f = 5; //hz
    private final float fs = 2000; //hz
    private final float N = fs * Ts; //buffer size        

    @Override
    public XYSeries execute() 
    {
        return PSK("raz dwa trzy");
    }
    
    public XYSeries PSK(String a_strMessage) 
    {
        String strBinaryMessage = stringToBinaryCode(a_strMessage);
        XYSeries oResult = new XYSeries("PSK - message: \"" +a_strMessage+"\", binary: \"" + strBinaryMessage + "\"");

        ArrayList<CPoint> lowSignal = new ArrayList<CPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (-1)*(float) (5 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) ));

            lowSignal.add(new CPoint(X, Y));
        }    

        ArrayList<CPoint> hightSignal = new ArrayList<CPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (10 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) ));

            hightSignal.add(new CPoint(X, Y));
        }    

        for(int i = 0; i < strBinaryMessage.length(); i++)
        {
            if(strBinaryMessage.charAt(i) == '1')
            {
                Float lastX = hightSignal.get(hightSignal.size() - 1).getPosX();
                
                for(CPoint point : hightSignal)
                {
                    oResult.add(point.getPosX() + (i * lastX), point.getPosY());
                }
            }
            else if(strBinaryMessage.charAt(i) == '0')
            {
                Float lastX = lowSignal.get(lowSignal.size() - 1).getPosX();
                
                for(CPoint point : lowSignal)
                {
                    oResult.add(point.getPosX() + (i * lastX), point.getPosY());
                }
            }
        }
        
        return oResult;
    }        
}
