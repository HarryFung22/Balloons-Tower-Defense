import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends ParentDart
{
    GreenfootImage image;
    public Dart(){
        image = new GreenfootImage("Dart.png");
        image.scale(image.getWidth()/20, image.getHeight()/20);
        image.rotate(8);
        setImage(image);
        projSpeed = 40;
        damage = 1;
    }

    public void act()
    {
        fire();
    }
}
