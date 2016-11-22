/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab4;

import ptd.core.ILabFactory;
import ptd.core.ITask;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CLab4Factory implements ILabFactory
{
    @Override
    public ITask getTask1()
    {        
        return new CTask1();
    }
    
    @Override
    public ITask getTask2(float a_fF1, float a_fF2)
    {        
        return new CTask2(a_fF1, a_fF2);
    }
    
    @Override
    public ITask getTask3(float a_fK)
    {        
        return new CTask3(a_fK);
    }    
}
