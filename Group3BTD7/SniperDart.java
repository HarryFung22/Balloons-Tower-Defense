import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SniperDart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperDart extends ParentDart
{
    public SniperDart(){
        projSpeed = 150;
        damage = 4;
    }

    public void act()
    {
        fire();
    }
}
