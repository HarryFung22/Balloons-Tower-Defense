import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SniperDart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperDart extends ParentDart
{
    GreenfootImage image;
    public SniperDart(){
        image = new GreenfootImage("Dart.png");
        image.scale(image.getWidth()/20, image.getHeight()/20);
        image.rotate(8);
        setImage(image);
        projSpeed = 60;
        damage = 5;
    }

    public void act()
    {
        fire();
    }
}
