// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
//do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 *  For solving the puzzle
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class HanoiSolver extends Observable
{
    private final int numDisks;
    private final Tower left;
    private final Tower center;
    private final Tower right;
    
    // ----------------------------------------------------------
    /**
     * For setting up the game with a number disks 
     * 
     * @param numDisks
     *      the number of disks in the game 
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        this.left = new Tower(Position.LEFT);
        this.center = new Tower(Position.CENTER);
        this.right = new Tower(Position.RIGHT);
    }
    
    // ----------------------------------------------------------
    /**
     * the tower will update when the position is requested 
     * @param pos
     *      position that is requested 
     * @return
     *      location that is being requested 
     */
    public Tower getTower(Position pos)
    {
        if (pos == null)
        {
            return center;
        }

        switch (pos) 
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            default:
                return center; 
        }
    }
    
    /**
     * To return the size of disk in each tower 
     * @return
     *      the size of the disk in each tower 
     */
    @Override
    public String toString() {
        return  left.toString() + center.toString() + right.toString();
    }
    
    // ----------------------------------------------------------
    /**
     * This is used to move the disk from one tower to another 
     * @param src
     *      This is where the disk is currently at 
     * @param des
     *      the destination it will go to
     */
    public void move(Tower src, Tower des)
    {
        Disk disk = src.pop();
        des.push(disk);
        setChanged();
        notifyObservers(des.position());
    }
    
    // ----------------------------------------------------------
    /**
     * This is implementing the Tower of Hanoi recursive algorithm
     * @param curr
     *      number of current disks 
     * @param start
     *      Starting pole 
     * @param end
     *      End Pole (where the disks will end up)
     * @param temp
     *      temporary pole
     */
    public void solveTowers(int curr, Tower start, Tower temp, Tower end)
    {
        if (curr == 0)
        {
            return;
        }
        
        if (curr == 1)
        { 
            move(start, end);
        }
        else
        {
            solveTowers(curr - 1, start, end, temp);
            move(start, end);
            solveTowers(curr - 1, temp, start, end);
        }
    }
    
    // ----------------------------------------------------------
    /**
     * For identifying the number of disks
     * @return 
     *      number of disks 
     */
    public int disks()
    {
        return numDisks;
    }
    
    // ----------------------------------------------------------
    /**
     * method for solving the puzzle
     */
    public void solve()
    {
        solveTowers(disks(), left, center, right);
    }
}
