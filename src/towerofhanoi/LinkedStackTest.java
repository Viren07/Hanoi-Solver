// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Testing the LinkedStack class 
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class LinkedStackTest extends TestCase
{
    private LinkedStack<Integer> stack;

    // ----------------------------------------------------------
    /**
     * Set up for the test cases 
     */
    public void setUp() 
    {
        stack = new LinkedStack<>();
    }
    
    // ----------------------------------------------------------
    /**
     * Testing the clear method 
     */
    public void testClear()
    {
        stack.push(10);
        stack.push(20);
        stack.clear();
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Testing the isEmpty method 
     */
    public void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
    }
    
    /**
     * Testing the Peek method 
     */
    public void testPeek()
    {
        Exception exception = null; 
        try
        {
            stack.peek();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertEquals(stack.peek(), 30, 1);
    }
    
    /**
     * Testing the Pop method 
     */
    public void testPop()
    {
        Exception exception = null; 
        try
        {
            stack.pop();    
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
        
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek(), 1);
        stack.pop();
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek(), 1);
        stack.pop();
        assertEquals(0, stack.size());
    }
    
    /**
     * Testing the Push method 
     */
    public void testPush()
    {
        stack.push(10);
        assertEquals(1, stack.size());
        stack.push(20);
        assertEquals(2, stack.size());
        stack.push(30);
        assertEquals(3, stack.size());
        
        assertEquals(30, stack.peek(), 1);
    }
    
    /**
     * Testing the Size method 
     */
    public void testSize()
    {
        assertEquals(0, stack.size());
        
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        
        stack.pop();
        assertEquals(1, stack.size());
    }
    
    /**
     * Testing the toString method 
     */
    public void testToString()
    {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertEquals("[30, 20, 10]", stack.toString());
    }
}
