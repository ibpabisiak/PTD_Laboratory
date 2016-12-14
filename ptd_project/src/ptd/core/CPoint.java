/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.core;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CPoint 
{
    private Float m_fPosX;
    private Float m_fPosY;

    public CPoint(Float a_fPosX, Float a_fPosY)
    {
        setPosX(a_fPosX);
        setPosY(a_fPosY);
    }
    
    public CPoint()
    {
        setPosX(0f);
        setPosY(0f);
    }
    
    public Float getPosX()
    {
        return m_fPosX;
    }
    public Float getPosY()
    {
        return m_fPosY;
    }
    
    public void setPosX(Float a_fPosX)
    {
        m_fPosX = a_fPosX;
    }
    
    public void setPosY(Float a_fPosY)
    {
        m_fPosY = a_fPosY;
    }
}
