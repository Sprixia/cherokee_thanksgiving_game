import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the game world that we play in. The game is set in Bluffton.
 * 
 * @author amm21@email.uscb.edu
 * @version final
 */
public class Bluffton extends World
{
    private int score;
    private int time; 
    private boolean setupStatus; // used for controlling character selection on new game

    /**
     * Constructor for objects of class Bluffton.
     */
    public Bluffton()
    {    
        // TODO: Add welcome screen & instructions screen
        super(900, 350, 1); 
        setupStatus = true; // defaults to true
        prepare();
        score = 0; // initialize score at 0
        time = 2000; // initialize time at 2000
        showScore();
        showTime();
    } // end constructor Bluffton

    /**
     * Determines which methods and actions will repeat each cycle in Bluffton.
     */
    public void act() 
    {
        characterSelect();
        spawn(); 
        countTime();
        checkWin();
    } // end method act

    /**
     * Allows the player to select male or female.
     */
    public void characterSelect()
    {
        // TODO: change boolean to male/female, add validation
        
        if ( setupStatus ) // if setupStatus is true (set to true in constructor)
        {
            boolean playerChoice = true; // first, set to false
            String playerChar = Greenfoot.ask("Type true to play female, and false to play male.");
            playerChoice = Boolean.parseBoolean( playerChar );

            if ( !playerChoice ) // if the value is false, play male
            {
                Player player = new Player();
                addObject( player, 35, 175);
            } 
            else { // if the value is not false, play female
                PlayerF playerf = new PlayerF();
                addObject( playerf, 35, 175 );
            } // end nested if-else

            setupStatus = false; // prevents this method from executing every cycle
        } // end if
    } // end method characterSelect

    /**
     * Prepares the new game world by instantiating initial objects.
     */
    private void prepare()
    {
        // Currently empty because it has been replaced by characterSelect above.
    } // end method prepare

    /**
     * Controls the spawn location and rates of all ingame objects.
     */
    public void spawn()
    {
        if (Greenfoot.getRandomNumber(200) < 1) // spawns a Berry 0.5% of the time
        {
            addObject( new Berry(), 949, Greenfoot.getRandomNumber(350) );
        } // end if

        if (Greenfoot.getRandomNumber(300) < 1) // spawns a Pumpkin 0.33% of the time
        {
            addObject( new Pumpkin(), 949, Greenfoot.getRandomNumber(350) );
        } // end if

        if (Greenfoot.getRandomNumber(400) < 1 )// spawns a Squirrel 0.25% of the time
        {
            addObject( new Squirrel(), 949, Greenfoot.getRandomNumber(350) );
        } // end if

        if (Greenfoot.getRandomNumber(800) < 1) // spawns a Pig 0.8% of the time
        {
            addObject( new Pig(), 949, Greenfoot.getRandomNumber(350) );
        } // end if

        if (Greenfoot.getRandomNumber(800) < 1) // spawn a Powerup 0.8% of the time
        {
            addObject( new Powerup(), 949, Greenfoot.getRandomNumber(350) );
        } // end if

        if (Greenfoot.getRandomNumber(2000) < 1) // spawn a Monster 0.05% of the time
        {
            addObject( new Monster(), 949, Greenfoot.getRandomNumber(350) );
        } // end if
    } // end method spawn

    /**
     * Shows the player's current score in the game.
     */
    public void showScore() 
    {
        showText("Score: " + score, 55, 15);
    } // end method showScore 

    /**
     * Adds points earned to the score that displays on screen.
     */
    public void addScore(int points) // allows Player and PlayerF to input points and increase score 
    {
        score = score + points;  // adds new point value to the current score
        showScore();

        if (score < 0)
        {
            showText("Game over, you lose!", 450, 175);
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();

        } // end if
    } // end method addScore

    /**
     * Count down the time remaining in the game.
     */
    public void countTime()
    {
        time--; // decrement time by 1 
        showTime();

        if (time == 0)
        {
            showText("Out of time, you lose!", 450, 175);
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();
        } // end if
    } // end method countTime

    /**
     * Shows the remaining time left in the game.
     */
    public void showTime() 
    {
        showText("Time: " + time, 845, 15);
    } // end method showTime

    /**
     * Check if you have won. If so, end the game.
     */
    public void checkWin()
    {
        if (score >= 500)
        {
            showText("Congratulations, you win!", 450, 175);
            Greenfoot.playSound("hooray.wav");
            Greenfoot.stop();
        } // end if
    } // end method checkWin
} // end class Bluffton
