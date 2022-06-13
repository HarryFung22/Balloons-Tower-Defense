import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the instructions page, where players can check the towers abilities,
 * the balloons stats, other features and the objective of the game -- survive.
 * 
 * @author Aiden S
 * @version June 7, 2022
 */
public class InstructionWorld extends World
{

    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new GameWorld());
        } 
    }
}
