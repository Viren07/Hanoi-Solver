// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 *  Tower Structure 
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class Tower extends LinkedStack<Disk>
{
    private Position position; 
    
    // ----------------------------------------------------------
    /**
     * Create a new Tower object
     * @param position
     *      this is the position of the tower 
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }
    
    // ----------------------------------------------------------
    /**
     * Gives the position of the tower
     * @return
     *      position of the tower
     */
    public Position position()
    {
        return position;
    }
    
    // ----------------------------------------------------------
    /**
     * adding disk on top of larger disk
     * 
     * @param disk
     *      the disk that is being added
     */
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        
        if (size() == 0 || peek().compareTo(disk) > 0)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException();
        }
    }
}