import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Monsters are dangerous and should be avoided.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Monster extends Actor
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
     * Controls the movement of Monsters.
     */
    public void movement() 
    {
        if ( isAtEdge() ) // turns a random degree (up to 30) if at edge of world
        {
            turn( Greenfoot.getRandomNumber(31) );
        } // end if

        if ( Greenfoot.getRandomNumber(100) < 10 ) // randomly turn from -15 to 15 degrees 10% of the time
        {
            turn( Greenfoot.getRandomNumber(31) - 15 );

        } // end if

        move(-7); // constantly moves to the left
    } // end method movement

    /**
     * Removes monsters that have crossed the entire screen.
     */
    public void cleanUp() // remove at left edge of world
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp
} // end class Monster
