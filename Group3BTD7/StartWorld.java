import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the start world, where the player can navigate our main menu.
 * Players can start the world or check the instructions on how to play.
 * 
 * @author Aiden S
 * @version June 7, 2022
 */
public class StartWorld extends World
{
    GreenfootImage background;
    
    public StartWorld()
    {    
        super(800, 600, 1); 
        
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new GameWorld());
        }
        if(Greenfoot.isKeyDown("i")){
            Greenfoot.setWorld(new InstructionWorld());
        }
    }
}
