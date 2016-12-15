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
public class CDoublePoint 
{
    private Double m_dPosX;
    private Double m_dPosY;

    public CDoublePoint(Double a_fPosX, Double a_fPosY)
    {
        setPosX(a_fPosX);
        setPosY(a_fPosY);
    }
    
    public CDoublePoint()
    {
        setPosX(0.00);
        setPosY(0.00);
    }
    
    public Double getPosX()
    {
        return m_dPosX;
    }
    public Double getPosY()
    {
        return m_dPosY;
    }
    
    public void setPosX(Double a_fPosX)
    {
        m_dPosX = a_fPosX;
    }
    
    public void setPosY(Double a_fPosY)
    {
        m_dPosY = a_fPosY;
    }
}
