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
    GreenfootImage background = new GreenfootImage("BTD700 Background.jpg");
    private UserInfo userInfo;
    private String displayText;
    private GreenfootImage welcomeText;

    //Probably going to add some kind of background music

    //Constructor for the StartWorld
    public StartWorld()
    {    
        super(800, 600, 1);
        background.scale(800,600);
        setBackground(background);
        displayText = "Welcome Player";
        welcomeText = new GreenfootImage(displayText, 24, Color.WHITE,null);
        getBackground().drawImage(welcomeText, 335, 400);
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
