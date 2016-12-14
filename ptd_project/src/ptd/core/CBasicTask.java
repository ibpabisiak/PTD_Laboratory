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
    public ArrayList<CPoint> fourierTransform(ArrayList<CPoint> a_oPoints)
    {
        ArrayList<CPoint> oResult = null;
        
        //TODO implement fourier transform here
        
        return oResult;
    }
    
    public ArrayList<CPoint> getSimpleSinusSignal(float fi, float Ts, 
            float A, float f, float fs)
    {
        ArrayList<CPoint> oResult = new ArrayList<CPoint>();

        for(int t = 0; t < (fs * Ts); t++)
        {
            Float fPosX = t / fs;
            Float fPosY = (float) (A *  Math.sin( ((float) (2 * Math.PI * f) * t / fs + fi) ));
            oResult.add(new CPoint(fPosX, fPosY));
        }

        return oResult;
    }
}
