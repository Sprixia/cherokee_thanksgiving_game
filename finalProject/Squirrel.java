import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Squirrels are game animals.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Squirrel extends Actor
{
    /**
     * Controls which methods are called for each act cycle.
     */
    public void act() 
    {
        movement();
        cleanUp();
    } // end method act

    /**
     * Controls the movement of Squirrels.
     */
    public void movement() // move left and counterclockwise
    {
        setLocation( getX()-2, getY() );
        turn(-1);
    } // end method movement

    /**
     * Removes squirrels that have crossed the entire screen.
     */
    public void cleanUp() // remove at left edge of world
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp
} // end class Squirrel
