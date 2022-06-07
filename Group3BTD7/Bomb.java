import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends ParentDart
{
    public Bomb(){
        projSpeed = 20;
        damage = 5;
    }
    public void act()
    {
        fire();
    }
}
