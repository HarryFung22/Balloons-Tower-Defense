import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Regular balloon, any tower can detect and shoot them
 * Nothing special about this class.
 * <p>Art: https://www.pngwing.com/en/free-png-zcmjx <p/>
 * 
 * @author Aiden S 
 * @version June 23 2022
 */
public class Balloon extends Balloons
{
    //variale used to scale the image
    GreenfootImage image;
    /**
     * Constructor for the balloon at it's properties
     */
    public Balloon(){
        health = 2;
        speed = 3;
        image = getImage();
        image.scale(50,50);
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