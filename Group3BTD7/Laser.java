import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends ParentDart
{
    GreenfootImage image;
    public Laser(){
        image = new GreenfootImage("Laser.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);
        image.rotate(90);
        setImage(image);
        projSpeed = 20;
        damage = 1;
    }
    public void act()
    {
        fire();
    }
}
