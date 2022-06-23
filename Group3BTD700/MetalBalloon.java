import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Heavy balloon, only bomb towers can detect and shoot them
 * Not detectable from any other class.
 * <p>Art: https://bloons.fandom.com/wiki/Lead_Bloon <p/>
 * 
 * @author Aiden S 
 * @version June 23 2022
 */
public class MetalBalloon extends Balloons
{
    GreenfootImage image;
    
    /**
     * Constructor for the metal balloon at it's properties
     */
    public MetalBalloon(){
        metal = true;
        health = 10;
        speed = 1;
        image = getImage();
        image.scale(image.getWidth()/2 + 10,image.getHeight()/2 + 10);
        setImage(image);
    }

    /**
     * Act method which allows the balloons to interact with the world and acheive its goal 
     * (reaching the end)
     */
    public void act()
    {
        onPath();
        attacked();
        if(health < 1){
            ((GameWorld) getWorld()).addMoney(20);
            ((GameWorld) getWorld()).addScore(5);
            getWorld().removeObject(this);
        }
    }
}
