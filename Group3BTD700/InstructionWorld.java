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
    GreenfootImage bg = new GreenfootImage("Instruction World.png");
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground(bg);
        
        //Play background music 
        main.setVolume(20);
        main.playLoop();
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new GameWorld());
            main.stop();
        } 
    }
}
