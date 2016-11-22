/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.main;

import ptd.core.ILabFactory;
import ptd.lab2.CLab2Factory;
import ptd.lab3.CLab3Factory;
import ptd.lab4.CLab4Factory;
import ptd.lab5.CLab5Factory;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CLabFactory 
{
    public static ILabFactory getLab(int a_iLabId)
    {
        ILabFactory oResult = null;

        switch(a_iLabId)
        {
            case 2:
                oResult = new CLab2Factory();
                break;
            case 3:
                oResult = new CLab3Factory();
                break;
            case 4:
                oResult = new CLab4Factory();
                break;                   
            case 5:
                oResult = new CLab5Factory();
                break;                
            default:
                oResult = null;
                break;
        }
        
        return oResult;
    }
}
