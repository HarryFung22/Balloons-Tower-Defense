import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Select icon for the cannon
 * 
 * @author Harry F
 * @version June 23 2022
 */
public class SelectCannon extends SelectMonkey
{
    GreenfootImage image;
    /**
     * Constructor for the selectCannon icon
     */
    public SelectCannon(){
        image = new GreenfootImage("Bomb Tower.png");
        image.scale(image.getWidth()/9, image.getHeight()/9);
        setImage(image);
    }
    
    public void act()
    {
        select("Cannon");
    }
}
