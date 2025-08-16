// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

import student.TestCase;

/**
 *  Testing the Tower class
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class TowerTest extends TestCase
{
    private Tower tower;
    private Disk bigDisk;
    
    
    
    /**
     * This is the setUp for the tests
     */
    public void setUp()
    {
        Disk smallDisk;
        
        tower = new Tower(Position.LEFT);
        smallDisk = new Disk(1);
        bigDisk = new Disk(2);
    }
    
    /**
     * Tests the Position method
     */
    public void testPosition() 
    {
        assertEquals(Position.LEFT, tower.position());
    }
    
    /**
     * Tests the Push Method
     */
    public void testPush()
    {
        Exception exception = null;
        try 
        {
            tower.push(null);
        }
        catch (Exception e) 
        {
            exception = e;
        }
        assertNotNull(exception);
        
        tower.push(bigDisk);
        assertEquals(bigDisk, tower.peek());
        
        exception = null;
        try 
        {
            tower.push(bigDisk);
        }
        catch (Exception e) 
        {
            exception = e;
        }
        assertNotNull(exception);
        
    }

}
