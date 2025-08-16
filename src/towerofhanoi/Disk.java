// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;
import cs2.*; 
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  Disk Object
 * 
 *  @author viren
 *  @version 24-Mar-2025
 */
public class Disk extends Shape implements Comparable<Disk>
{
    private static final int DISK_HEIGHT = 10;

    // ----------------------------------------------------------
    /**
     * Making a disk with a certain width and giving it color 
     * @param width
     *      disk width 
     */
    public Disk(int width)
    {
        super(0, 0, width, DISK_HEIGHT);
        
        TestableRandom random = new TestableRandom();
        int color1 = random.nextInt(255);
        int color2 = random.nextInt(255);
        int color3 = random.nextInt(255);
        
        this.setBackgroundColor(new Color(color1, color2, color3));
    }
    
    
    /**
     * Comparing this disk to another disk
     * 
     * @param otherDisk
     *      The disk which the current disk is going to be compared to
     *      
     * @return 
     *      0 for the same disk, <0 for a smaller disk, and >0 for a larger disk
     */
    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }
        
        if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        }
        else if (this.getWidth() > otherDisk.getWidth())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    // ----------------------------------------------------------
    /**
     * This is to return the size of the disk as a string
     * @return
     *      Size as a string
     */
    public String toString()
    {
        return this.getWidth() + "";
    }
    
    /**
     * This is to check if the disk is equal to another object 
     * 
     * @param obj
     *      Object that is it being compared to 
     *      
     * @return 
     *      true if it is equal and false if it is not 
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        
        if (obj ==  null || getClass() != obj.getClass())
        {
            return false;
        }
        
        Disk otherDisk = (Disk)obj; 
        return this.getWidth() == otherDisk.getWidth();
    }

}
