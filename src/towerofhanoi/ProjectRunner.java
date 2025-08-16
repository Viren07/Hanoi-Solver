// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

/**
 *  This is for initializing the Tower Of Hanoi puzzle
 * 
 *  @author viren
 *  @version 25-Mar-2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * method to run the project and sets the starting number of disks to 5 or
     * a number chosen by user 
     * @param args
     *      command line arguments
     */
    public static void main(String[] args)
    {
        int disks = 5; 
        
        if(args.length == 1)
        {
            try 
            {
                disks = Integer.parseInt(args[0]); 
            } 
            catch (NumberFormatException e)
            {
                
            }
        }
        
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow puzzle = new PuzzleWindow(solver);
    }

}
