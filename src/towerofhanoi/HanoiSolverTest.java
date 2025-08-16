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
 *  Testing the HanoiSolver class
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class HanoiSolverTest extends TestCase 
{
    private HanoiSolver solver;
    private Tower left;
    private Tower center;
    private Tower right;

    
    /**
     * This is the set up for the test cases 
     */
    public void setUp()
    {
        solver = new HanoiSolver(3);
        left = solver.getTower(Position.LEFT);
        center = solver.getTower(Position.CENTER);
        right = solver.getTower(Position.RIGHT);
    }
    
    /**
     * testing the getTower method 
     */
    public void testGetTower()
    {
        HanoiSolver hanoi1 = new HanoiSolver(3);
        assertEquals(hanoi1.getTower(Position.LEFT).position(), 
            Position.LEFT);
        assertEquals(hanoi1.getTower(Position.CENTER).position(), 
            Position.CENTER);
        assertEquals(hanoi1.getTower(Position.RIGHT).position(), 
            Position.RIGHT);
        assertEquals(hanoi1.getTower(null).position(), Position.CENTER);
    }
    
    /**
     * Testing the toString method
     */
    public void testToString()
    {
        HanoiSolver hanoi1 = new HanoiSolver(5);
        for (int i = 5; i > 0; i--) 
        {
            hanoi1.getTower(Position.LEFT).push(new Disk(i));
        }

        assertEquals(hanoi1.toString(), "[1, 2, 3, 4, 5][][]");

        hanoi1.solve();
        assertEquals(hanoi1.toString(), "[][][1, 2, 3, 4, 5]");


        HanoiSolver hanoi2 = new HanoiSolver(5);
        hanoi2.getTower(Position.LEFT).push(new Disk(5));
        hanoi2.getTower(Position.CENTER).push(new Disk(1));
        hanoi2.getTower(Position.RIGHT).push(new Disk(5));
        hanoi2.getTower(Position.RIGHT).push(new Disk(2));

        assertEquals(hanoi2.toString(), "[5][1][2, 5]");

        HanoiSolver empty = new HanoiSolver(0);

        assertEquals(empty.toString(), "[][][]");
    }
    
    /**
     * testing the Solve method
     */
    public void testSolve()
    {
        left.push(new Disk(30)); 
        left.push(new Disk(20));
        left.push(new Disk(10));

        solver.solve();

        assertTrue(left.isEmpty());
        assertTrue(center.isEmpty());
        assertEquals(3, right.size());
        
        HanoiSolver hanoiEmpty = new HanoiSolver(0);
        Tower emptyLeft = hanoiEmpty.getTower(Position.LEFT);
        Tower emptyCenter = hanoiEmpty.getTower(Position.CENTER);
        Tower emptyRight = hanoiEmpty.getTower(Position.RIGHT);

        hanoiEmpty.solve();
        
        assertTrue(emptyLeft.isEmpty());
        assertTrue(emptyCenter.isEmpty());
        assertTrue(emptyRight.isEmpty());
    }
    
    /**
     * This is to test the Disk method 
     */
    public void testDisks()
    {
        HanoiSolver hanoi1 = new HanoiSolver(5);
        assertEquals(hanoi1.disks(), 5);
    }

}
