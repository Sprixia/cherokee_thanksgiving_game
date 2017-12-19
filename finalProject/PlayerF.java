import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the PlayerF character in the Cherokee Thanksgiving game.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class PlayerF extends Actor
{
    private int speed;
    private int cycleCountPow;
    private int cycleCountMons;
    private boolean powerUpStatus;
    private boolean monsterStatus;

    /**
     * This is the contructor for PlayerF.
     */
    public PlayerF()
    {
        speed = 6;
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
        if (Greenfoot.isKeyDown( "up" ))
        {
            setLocation( getX(), getY()-speed );
        } // end if up

        if (Greenfoot.isKeyDown( "down"))
        {
            setLocation( getX(), getY()+speed );
        } // end if down

        if (Greenfoot.isKeyDown( "left" ))
        {
            setLocation( getX()-speed, getY() );
        } // end if left

        if (Greenfoot.isKeyDown( "right" ))
        {
            setLocation( getX()+speed, getY() );
        } // end if right
    } // end method checkKeyPress

    /**
     * Checks for collision with in-game objects and adjusts points/speed accordingly.
     */
    public void collisionCheck()
    {
        if ( isTouching(Pumpkin.class) )
        {
            removeTouching(Pumpkin.class);
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(50);
        } // end if

        if ( isTouching(Berry.class) )
        {
            removeTouching(Berry.class);
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(25);
        } // end if

        if ( isTouching(Squirrel.class) )
        {
            removeTouching(Squirrel.class);
            Greenfoot.playSound("au.wav");
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(-30);
        } // end if

        if ( isTouching(Pig.class) )
        {
            removeTouching(Pig.class);
            Greenfoot.playSound("au.wav");
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(-75);
        } // end if

        if ( isTouching(Powerup.class) && !powerUpStatus )
        {
            removeTouching(Powerup.class);
            speed = speed * 2;
            powerUpStatus = true;
        } // end if

        if ( isTouching(Monster.class) && !monsterStatus )
        {
            removeTouching(Monster.class);
            Greenfoot.playSound("au.wav");
            Bluffton bluffton = (Bluffton)getWorld();
            bluffton.addScore(-100);
            speed = speed / 2;
            monsterStatus = true;
        } // end if
    } // end method collisionCheck

    /**
     * Checks if you've collected a powerup recently and adjusts speed accordingly.
     */
    public void powerCheck()
    {
        if ( powerUpStatus )
        {
            cycleCountPow++;
        } // end if

        if ( cycleCountPow >= 100 )
        {
            powerUpStatus = false;
            cycleCountPow = 0;
            speed = 6;
        } // end if
    } // end method powerCheck

    /**
     * Checks if you've hit a monster recently and adjusts speed accordingly.
     */
    public void monsterCheck()
    {
        if ( monsterStatus )
        {
            cycleCountMons++;
        } // end if

        if ( cycleCountMons >= 100 )
        {
            monsterStatus = false;
            cycleCountMons = 0;
            speed = 6;
        } // end if
    } // end method monsterCheck
} // end class PlayerF
