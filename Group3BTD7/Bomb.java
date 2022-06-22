import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends ParentDart
{
    GreenfootImage image;
    public Bomb(){
        image = new GreenfootImage("Bomb.png");
        image.scale(image.getWidth()/60, image.getHeight()/60);
        image.mirrorHorizontally();
        image.rotate(180);
        setImage(image);
        projSpeed = 20;
        damage = 5;
    }
    public void act()
    {
        fire();
    }
}
