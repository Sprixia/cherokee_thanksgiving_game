import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the male Player character in the Cherokee Thanksgiving game.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Player extends Actor
{
    private int speed;
    private int cycleCountPow;
    private int cycleCountMons;
    private boolean powerUpStatus;
    private boolean monsterStatus;

    /**
     * This is the contructor for Player.
     */
    public Player()
    {
        // initializes several instance variables
        speed = 4; // initial speed of 4 for male
        cycleCountPow = 0;
        cycleCountMons = 0;
        powerUpStatus = false;
        monsterStatus = false;
    } // end constructor

    /**
     * Controls which methods are called for each act cycle.
     */
    public void act() 
    {
        checkKeyPress();
        collisionCheck();
        powerCheck();
        monsterCheck();
    } // end method act

    /**
     * Allows for player-controlled movement.
     */
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown( "up" )) // up arrow key to move vertically up
        {
            setLocation( getX(), getY()-speed);
        } // end if up

        if (Greenfoot.isKeyDown( "down")) // down arrow key to move vertically down
        {
            setLocation( getX(), getY()+speed );
        } // end if down
    } // end method checkKeyPress

    /**
     * Checks for collision with in-game objects and adjusts points/speed accordingly.
     */
    public void collisionCheck()
    {
        /*
         * The addScore(int points) method is in Bluffton and allows points earned or lost from collision with ingame
         * objects to affect the player's overall score in the game.
         */
        
        if ( isTouching(Pumpkin.class) ) // lose points for collecting Pumpkins
        {
            removeTouching(Pumpkin.class);
            Greenfoot.playSound("au.wav");
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(-50);
        } // end if

        if ( isTouching(Berry.class) ) // lose points for collecting Berries
        {
            removeTouching(Berry.class);
            Greenfoot.playSound("au.wav");
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(-25);
        } // end if

        if ( isTouching(Squirrel.class) ) // gain points for collecting Squirrels
        {
            removeTouching(Squirrel.class);
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(50);
        } // end if

        if ( isTouching(Pig.class) ) // gain points for collecting Pigs
        {
            removeTouching(Pig.class);
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(100);
        } // end if

        if ( isTouching(Powerup.class) && !powerUpStatus ) // Dr. Canada helped with temporary movement changes from PowerUp and Monster
        {
            removeTouching(Powerup.class);
            speed = speed * 2; // double speed
            powerUpStatus = true; // triggers powerCheck method
        } // end if

        if ( isTouching(Monster.class) && !monsterStatus )
        {
            removeTouching(Monster.class);
            Greenfoot.playSound("au.wav");
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(-100);
            speed = speed / 2; // half speed
            monsterStatus = true; // triggers monsterCheck method
        } // end if
    } // end method collisionCheck

    /**
     * Checks if you've collected a powerup recently and adjusts speed accordingly.
     */
    public void powerCheck()
    {
        if ( powerUpStatus )
        {
            cycleCountPow++; // increment by 1
        } // end if

        if ( cycleCountPow >= 100 )
        {
            powerUpStatus = false; // after 100 cycles, switch status to false to disable the movement buff
            cycleCountPow = 0; // reset to 0 so this can repeat when a new PowerUp is collected
            speed = 4; // speed back to original
        } // end if
    } // end method powerCheck

    /**
     * Checks if you've hit a monster recently and adjusts speed accordingly.
     */
    public void monsterCheck()
    {
        if ( monsterStatus )
        {
            cycleCountMons++; // decrement by 1
        } // end if

        if ( cycleCountMons >= 100 )
        {
            monsterStatus = false;
            cycleCountMons = 0;
            speed = 4; 
        } // end if
    } // end method monsterCheck
}// end class Player
