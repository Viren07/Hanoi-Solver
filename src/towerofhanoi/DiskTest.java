// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
//do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  This is testing the Disk class 
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class DiskTest extends TestCase
{
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
 
    /**
     * Set up for the test cases 
     */
    public void setUp() 
    {
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(10);
    }
    
    /**
     * Test for the compareTo method
     */
    public void testCompareTo()
    {
        Exception exception = null;
        try 
        {
            disk1.compareTo(null);
        }
        catch (Exception e) 
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        
        assertEquals(0, disk1.compareTo(disk3));
        assertTrue(disk1.compareTo(disk2) < 0);
        assertTrue(disk2.compareTo(disk3) > 0);
        
        Object obj = new Object();
        assertFalse(disk1.equals(obj));
    }
    
    /**
     * Test for the toString method
     */
    public void testToString()
    {
        assertEquals("10", disk1.toString());
        assertEquals("10", disk3.toString());
        assertEquals("20", disk2.toString());
    }
    
    /**
     * Test for equals method
     */
    public void testEquals()
    {
        assertTrue(disk1.equals(disk3));
        
        Disk disk4 = disk1;
        assertTrue(disk4.equals(disk1));
        
        assertFalse(disk1.equals(disk2));
        
        assertFalse(disk1.equals(null));
    }

}
