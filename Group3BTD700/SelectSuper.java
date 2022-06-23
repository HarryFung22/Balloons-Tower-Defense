import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Select icon for the super monkey
 * 
 * @author Harry F
 * @version June 23 2022
 */
public class SelectSuper extends SelectMonkey
{
    GreenfootImage image;
    
    /**
     * Constructor for the selectSuper icon
     */
    public SelectSuper(){
        image = new GreenfootImage("Super Monkey.png");
        image.scale(image.getWidth()-10, image.getHeight()-10);
        image.rotate(180);
        setImage(image);
    }
    
    public void act()
    {
        select("SuperMonkey");
    }
}
