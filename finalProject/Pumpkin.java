import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pumpkin is food.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Pumpkin extends Actor
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
     * Controls the movement of Pumpkin.
     */
    public void movement() // slowly move left and rotate counterclockwise
    {
        setLocation( getX()-1, getY() ); 
        turn(-1); 
    } // end method movement

    /**
     * Removes Pumpkin that has crossed the entire screen.
     */
    public void cleanUp() // remove at left edge of world
    {
        if ( getX() == 0 )
        {
            getWorld().removeObject(this);
        } // end if
    } // end method cleanUp  
} // end class Pumpkin
