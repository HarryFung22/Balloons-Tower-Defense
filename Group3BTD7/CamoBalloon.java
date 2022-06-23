import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Camo balloon enemy; Only sniper monkeys can attack and destroy them
 * Hidden to every other tower
 * <p>Art: https://www.pngwing.com/en/free-png-imzrn <p/>
 * 
 * @author Aiden S 
 * @version June 23 2022
 */
public class CamoBalloon extends Balloons
{
    GreenfootImage image;
    /**
     * Constructor for the camo balloon at it's properties
     */
    public CamoBalloon(){
        camo = true;
        health = 10;
        speed = 4;
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
