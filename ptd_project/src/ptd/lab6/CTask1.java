/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab6;

import java.util.ArrayList;
import java.util.Random;
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
    private final float f = 2; //hz
    private final float fs = 2000; //hz
    private final float N = fs * Ts; //buffer size
    
    @Override
    public XYSeries execute() 
    {
//        return ASK("raz");
//        return ZeroOne("raz dwa trzy");
        return FSK("raz");
//        return PSK("raz");
    }

    public XYSeries FSK(String a_strMessage) 
    {
        String strBinaryMessage = stringToBinaryCode(a_strMessage);
        XYSeries oResult = new XYSeries("FSK - message: \"" +a_strMessage+"\", binary: \"" + strBinaryMessage + "\"");

//        strBinaryMessage = "01010101010101010101";
        ArrayList<CFloatPoint> hightSignal = new ArrayList<CFloatPoint>();
        Float temp = 0f;
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (1 *  Math.sin( ((float) (2 * Math.PI * 4 ) * t / fs + fi) ));
            
            Y = (Y < 0f) ? (-1)*Y : Y;
            
            hightSignal.add(new CFloatPoint(X, Y));
            temp += Y;
        }   
//        System.out.println("highSignal sum: " + temp);

        ArrayList<CFloatPoint> lowSignal = new ArrayList<CFloatPoint>();
        Float temp2 = 0f;
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (1 *  Math.sin( ((float) (2 * Math.PI * 2 ) * t / fs + fi) ));

            Y = (Y < 0f) ? (-1)*Y : Y;
            lowSignal.add(new CFloatPoint(X, Y));
            temp2 += Y;
        }           
//        System.out.println("lowSignal sum: " + temp2);
        

        
        for(int i = 0; i < strBinaryMessage.length(); i++)
        {
            if(strBinaryMessage.charAt(i) == '1')
            {
                Float lastX = hightSignal.get(hightSignal.size() - 1).getPosX();
                
                for(int j = 0; j < hightSignal.size(); j++)
                {
                    Float Y = 0f;
                    for(int k = 0; k <= j; k++)
                    {
                        Y += hightSignal.get(k).getPosY();
                    }
                    
//                    Y = (Y > 1270.6122f) ? 0f : 1f;
                    oResult.add(hightSignal.get(j).getPosX()+ (i * lastX), Y);
                }
                
//                for(CPoint point : hightSignal)
//                {
//                    oResult.add(point.getPosX() + (i * lastX), point.getPosY());
//                }
                
            }
            else if(strBinaryMessage.charAt(i) == '0')
            {
                Float lastX = lowSignal.get(lowSignal.size() - 1).getPosX();
                
                for(int j = 0; j < lowSignal.size(); j++)
                {
                    Float Y = 0f;
                    for(int k = 0; k <= j; k++)
                    {
                        Y += lowSignal.get(k).getPosY();
                    }
                    
//                    Y = (Y > 1270.6122f) ? 0f : 1f;
                    
                    oResult.add(lowSignal.get(j).getPosX()+ (i * lastX), Y);
                }

//                for(CPoint point : lowSignal)
//                {
//                    oResult.add(point.getPosX() + (i * lastX), point.getPosY());
//                }

            }
        }
        return oResult;
    }        
    
    public XYSeries ZeroOne(String a_strMessage)
    {
        String strBinaryMessage = stringToBinaryCode(a_strMessage);
        XYSeries oResult = new XYSeries("ZeroOne - message: \"" +a_strMessage+"\", binary: \"" + strBinaryMessage + "\"");
        
//        strBinaryMessage = "101010101010";
        
        ArrayList<CFloatPoint> hightSignal = new ArrayList<CFloatPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = 1f;
            
            hightSignal.add(new CFloatPoint(X, Y));
        }   

        ArrayList<CFloatPoint> lowSignal = new ArrayList<CFloatPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = 0f;

            lowSignal.add(new CFloatPoint(X, Y));
        }           
        
        for(int i = 0; i < strBinaryMessage.length(); i++)
        {
            if(strBinaryMessage.charAt(i) == '1')
            {
                Float lastX = hightSignal.get(hightSignal.size() - 1).getPosX();
                
                for(CFloatPoint point : hightSignal)
                {
                    oResult.add(point.getPosX() + (i * lastX), point.getPosY());
                }
                
            }
            else if(strBinaryMessage.charAt(i) == '0')
            {
                Float lastX = lowSignal.get(hightSignal.size() - 1).getPosX();
                
                for(CFloatPoint point : lowSignal)
                {
                    oResult.add(point.getPosX() + (i * lastX), point.getPosY());
                }                
            }
        }
        
        return oResult;
    }
    
    public XYSeries ASK(String a_strMessage) 
    {
        String strBinaryMessage = stringToBinaryCode(a_strMessage);
        XYSeries oResult = new XYSeries("ASK - message: \"" +a_strMessage+"\", binary: \"" + strBinaryMessage + "\"");

//        strBinaryMessage = "10101010";
        ArrayList<CFloatPoint> hightSignal = new ArrayList<CFloatPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (2 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) )) ;
            
            hightSignal.add(new CFloatPoint(X, Y));
        }   

        ArrayList<CFloatPoint> lowSignal = new ArrayList<CFloatPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (1 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) )) ;

            lowSignal.add(new CFloatPoint(X, Y));
        }           
        
        ArrayList<CFloatPoint> oAskSignal = new ArrayList<CFloatPoint>();
        

        
        float prog = 1300f;
        
        for(int i = 0; i < strBinaryMessage.length(); i++)
        {
            if(strBinaryMessage.charAt(i) == '1')
            {
                Float lastX = hightSignal.get(hightSignal.size() - 1).getPosX();
                
                for(int j = 0; j < hightSignal.size(); j++)
                {
                    Float Y = 0f;

                    for(int k = 0; k <= j; k++)
                    {
                        Float asd = hightSignal.get(k).getPosY();
                        Float yy = (asd < -0.1) ? (-1)*asd : asd;
                        
                        Y += yy;
                    }                    
//                    Y = (Y > prog) ? 1f : 0f;
                    
//                    Y = hightSignal.get(i).getPosY();
//                    oAskSignal.add(new CPoint(lowSignal.get(j).getPosX() + (i * lastX), 
//                            /*(float)((Y > prog) ? 1f : 0f))*/(float)Y));
                    oAskSignal.add(new CFloatPoint(hightSignal.get(j).getPosX() + (i * lastX), Y));
                }
            }
            else if(strBinaryMessage.charAt(i) == '0')
            {
                Float lastX = lowSignal.get(hightSignal.size() - 1).getPosX();
                
                for(int j = 0; j < lowSignal.size(); j++)
                {
                    Float Y = 0f;

                    for(int k = 0; k <= j; k++)
                    {
                        Float asd = lowSignal.get(k).getPosY();
                        Float yy = (asd < -0.1) ? (-1)*asd : asd;
                        
                        Y += yy;
                    }
                    
//                    Y = (Y > prog) ? 1f : 0f;
//                    Y = hightSignal.get(i).getPosY();
                    
//                    oAskSignal.add(new CPoint(lowSignal.get(j).getPosX() + (i * lastX), 
//                            /*(float)((Y > prog) ? 1f : 0f))*/(float)Y));


                    oAskSignal.add(new CFloatPoint(lowSignal.get(j).getPosX() + (i * lastX), Y));
                }
            }
        }
        
        for(CFloatPoint point : oAskSignal)
        {
            oResult.add(point.getPosX(), point.getPosY());
        }
//        System.out.println("here i am");
//        for(int i = 0; i < oAskSignal.size(); i++)
//        {
//            Float Y = 0f;
//            for(int j = 0; j <= i; j++)
//            {
//                Float asd = oAskSignal.get(j).getPosY();
//                Float yy = (asd < -0.1) ? (-1)*asd : asd;
//                Y += yy;
//            }
//            oResult.add((float)oAskSignal.get(i).getPosX(), (float)Y);
//        }
            

        
        return oResult;
    }    

    public XYSeries PSK(String a_strMessage) 
    {
        String strBinaryMessage = stringToBinaryCode(a_strMessage);
        XYSeries oResult = new XYSeries("PSK - message: \"" +a_strMessage+"\", binary: \"" + strBinaryMessage + "\"");

        ArrayList<CFloatPoint> lowSignal = new ArrayList<CFloatPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (-1)*(float) (10 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) ));

            Y = (Y > 0.01) ? (-1)*Y : Y;
            lowSignal.add(new CFloatPoint(X, Y));
        }    

        ArrayList<CFloatPoint> hightSignal = new ArrayList<CFloatPoint>();
        for(int t = 0; t < N; t++)
        {
            Float X = t / fs;
            Float Y = (float) (10 *  Math.sin( ((float) (2 * Math.PI * f ) * t / fs + fi) ));

            Y = (Y < 0.01) ? (-1)*Y : Y;
            hightSignal.add(new CFloatPoint(X, Y));
        }    

        for(int i = 0; i < strBinaryMessage.length(); i++)
        {
            if(strBinaryMessage.charAt(i) == '1')
            {
                Float lastX = hightSignal.get(hightSignal.size() - 1).getPosX();
                
                for(int j = 0; j < hightSignal.size(); j++)
                {
                    Float Y = 0f;
                    for(int k = 0; k <= j; k++)
                    {
                        Y += hightSignal.get(k).getPosY();
                    }
                    
                    Y = (Y > 0) ? 1f : 0f;
                    
                    oResult.add(hightSignal.get(j).getPosX() + (i * lastX), Y);
                }
            }
            else if(strBinaryMessage.charAt(i) == '0')
            {
                Float lastX = lowSignal.get(lowSignal.size() - 1).getPosX();
                
                for(int j = 0; j < lowSignal.size(); j++)
                {
                    Float Y = 0f;
                    for(int k = 0; k <= j; k++)
                    {
                        Y += lowSignal.get(k).getPosY();
                    }
                    Y = (Y > 0) ? 1f : 0f;
                    
                    oResult.add(lowSignal.get(j).getPosX() + (i * lastX), Y);
                }
            }
        }
        
        return oResult;
    }  
}
