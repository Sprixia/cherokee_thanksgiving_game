import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Powerups are beneficial and should be collected!
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Powerup extends Actor
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
     * Controls movement of Powerups.
     */
    public void movement() 
    {
        if ( isAtEdge() ) // turns if at edge of world
        {
            turn( Greenfoot.getRandomNumber(30) );
        } // end if

        if ( Greenfoot.getRandomNumber(100) > 89 ) // allows somewhat random movement
        {
            turn( Greenfoot.getRandomNumber(31) - 15 );

        } // end if

        move(-8); // constantly moves to the left
    } // end method movement

    /**
     * Removes powerups that have crossed the entire screen.
     */
    public void cleanUp()
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp
} // end class Powerup
