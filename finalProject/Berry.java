import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Berries are food.
 * 
 * @author amm21@email.uscb.edu   
 * @version final
 */
public class Berry extends Actor
{
    /**
     * Determines which methods will be called for each act cycle.
     */
    public void act() 
    {
        movement();
        cleanUp();
    } // end method act   

    /**
     * Controls movement of the Berry.
     */
    public void movement() // slowly move left and counterclockwise
    {
        setLocation( getX()-1, getY() );
        turn(-1);
    } // end method movement

    /**
     * Removes berries that have crossed the entire screen.
     */
    public void cleanUp() // remove at left edge of screen
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp
} // end class Berry
