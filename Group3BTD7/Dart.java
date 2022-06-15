import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends ParentDart
{
    public Dart(){
        projSpeed = 40;
        damage = 1;
    }
    public void act()
    {
        fire();
    }
}
