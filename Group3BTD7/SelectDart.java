import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectDart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectDart extends SelectMonkey
{
    GreenfootImage image;
    public SelectDart(){
        image = new GreenfootImage("Dart Monkey.png");
        image.scale(image.getWidth()/8, image.getHeight()/8);
        setImage(image);
    }
    
    public void act()
    {
        select("DartMonkey");
    }
}
