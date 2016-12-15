/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.core;

import java.util.ArrayList;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public abstract class CBasicTask 
{
    protected ArrayList<CFloatPoint> fourierTransform(ArrayList<CFloatPoint> a_oPoints)
    {
        ArrayList<CFloatPoint> oResult = null;
        
        //TODO implement fourier transform here
        
        return oResult;
    }
    
    protected ArrayList<CFloatPoint> getSimpleSinusSignal(float fi, float Ts, 
            float A, float f, float fs)
    {
        ArrayList<CFloatPoint> oResult = new ArrayList<CFloatPoint>();

        for(int t = 0; t < (fs * Ts); t++)
        {
            Float fPosX = t / fs;
            Float fPosY = (float) (A *  Math.sin( ((float) (2 * Math.PI * f) * t / fs + fi) ));
            oResult.add(new CFloatPoint(fPosX, fPosY));
        }

        return oResult;
    }
    
    protected double getSinusSignalSample(double fi, double Ts, 
            double A, double f, double fs, double t)
    {
        return (double) (A *  Math.sin( ((double) (2 * Math.PI * f) * t / fs + fi) ));
    }

    protected String stringToBinaryCode(String a_strMessage)
    {
        String oResult = null;
        StringBuilder oBinary = new StringBuilder();
        byte[] bytes = a_strMessage.getBytes();
        for (byte b : bytes)
        {
           int val = b;
           for (int i = 0; i < 8; i++)
           {
              oBinary.append((val & 128) == 0 ? 0 : 1);
              val <<= 1;
           }
        }        
        oResult = oBinary.toString();
        return oResult;
    }    
    
    protected Float getMaxFloatFromList(ArrayList<Float> a_oList)
    {
        Float fMaxValue = -999f;
        for(Float value : a_oList)
        {
            if(value > fMaxValue)
            {
                fMaxValue = value;
            }
        }
        return fMaxValue;
    }
    
    protected Double getMaxDoubleFromList(ArrayList<Double> a_oList)
    {
        Double fMaxValue = -999.0;
        for(Double value : a_oList)
        {
            if(value > fMaxValue)
            {
                fMaxValue = value;
            }
        }
        return fMaxValue;
    }
    
}
