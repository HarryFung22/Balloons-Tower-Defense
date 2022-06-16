import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectCannon extends SelectMonkey
{
    GreenfootImage image;
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
