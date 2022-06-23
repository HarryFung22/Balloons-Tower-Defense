import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Select icon for the dart monkey
 * 
 * @author Harry F
 * @version June 23 2022
 */
public class SelectDart extends SelectMonkey
{
    GreenfootImage image;
    /**
     * Constructor for the selectDart icon
     */
    public SelectDart(){
        image = new GreenfootImage("Dart Monkey.png");
        image.scale(image.getWidth()/9, image.getHeight()/9);
        setImage(image);
    }
    
    public void act()
    {
        select("DartMonkey");
    }
}
