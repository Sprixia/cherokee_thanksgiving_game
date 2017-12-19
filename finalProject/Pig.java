import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pig are game animals.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Pig extends Actor
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
     * Controls the movement of Pig.
     */
    public void movement() 
    {
        setLocation( getX()-4, getY() );
        turn(-1);
    } // end method movement

    /**
     * Removes Pig that have crossed the entire screen.
     */
    public void cleanUp()
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp
} // end class Pig
