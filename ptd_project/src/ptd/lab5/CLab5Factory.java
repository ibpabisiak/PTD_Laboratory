/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptd.lab5;

import ptd.core.ILabFactory;
import ptd.core.ITask;

/**
 *
 * @author ibpabisiak
 */
public class CLab5Factory implements ILabFactory 
{

    @Override
    public ITask getTask1() 
    {
        return new CTask1();
    }

    @Override
    public ITask getTask2(float a_fF1, float a_fF2) {
        return null;
    }

    @Override
    public ITask getTask3(float a_fK) {
        return null;
    }
    
}
