import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectSuperMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectSuper extends SelectMonkey
{
    GreenfootImage image;
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
