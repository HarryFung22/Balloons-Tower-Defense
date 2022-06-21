import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectSniper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectSniper extends SelectMonkey
{
    GreenfootImage image;
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
