import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Select icon for the sniper
 * 
 * <p> Art: https://bloons.fandom.com/wiki/Faster_Firing_(Sniper_Monkey) <p/>
 * @author Harry F
 * @version June 23 2022
 */
public class SelectSniper extends SelectMonkey
{
    GreenfootImage image;
    
    /**
     * Constructor for the selectSniper icon
     */
    public SelectSniper(){
        image = new GreenfootImage("Sniper Monkey.png");
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }
    
    public void act()
    {
        select("SniperMonkey");
    }
}
