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
        if ( isAtEdge() ) // turns if at edge of world
        {
            turn( Greenfoot.getRandomNumber(30) );
        } // end if

        if ( Greenfoot.getRandomNumber(100) > 89 ) // allows somewhat random movement
        {
            turn( Greenfoot.getRandomNumber(31) - 15 );

        } // end if

        move(-7); // constantly moves to the left
    } // end method movement

    /**
     * Removes monsters that have crossed the entire screen.
     */
    public void cleanUp()
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp
} // end class Monster
