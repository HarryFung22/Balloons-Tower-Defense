import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the instructions page, where players can check the towers abilities,
 * the balloons stats, other features and the objective of the game -- survive.
 * 
 * <p> Game Music: https://www.youtube.com/watch?v=edwooGpMg8g
 * 
 * @author Aiden S
 * @version June 7, 2022
 */
public class InstructionWorld extends World
{
    GreenfootSound main = new GreenfootSound("Intro.wav");
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        main.setVolume(20);
        main.playLoop();
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            main.stop();
            Greenfoot.setWorld(new GameWorld());
        } 
    }
}
