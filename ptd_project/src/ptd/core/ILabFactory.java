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
public interface ILabFactory 
{
    public ITask getTask1();
    public ITask getTask2(float a_fF1, float a_fF2);
    public ITask getTask3(float a_fK);    
}
