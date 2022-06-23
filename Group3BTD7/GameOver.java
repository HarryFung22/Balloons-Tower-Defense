import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the game over screen, where the scoreboard will display, as well as 
 * other instructions to restart or go back to the start menu.
 * 
 * @author Aiden S 
 * @version June 21, 2022
 * 
 */
public class GameOver extends World
{
    GreenfootSound gameOver = new GreenfootSound("End.wav");
    GreenfootImage background = new GreenfootImage("GameOver.png");
    Label text = new Label("Press 'space' to play again\nPress 'r' to return to the main menu", 30);
    /**
     * Constructor for objects of class GameOver.
     */
    public GameOver()
    {    
        super(800, 600, 1); 
        gameOver.setVolume(40);
        gameOver.play();
        setBackground(background);
        //Adds the scoreboard
        addObject (new ScoreBoard(400,300),400,300);
        addObject (text, 400, 500);
    }
    
    public void act()
    {
        //Send player to another game if the space key is pressed
        if (Greenfoot.isKeyDown("space")){
            gameOver.stop();
            Greenfoot.setWorld(new GameWorld());
        } 
        //Otherwise, pressing the r key will return them back to the start
        else if(Greenfoot.isKeyDown("r")){
            gameOver.stop();
            Greenfoot.setWorld(new StartWorld());
        }
    }
}
