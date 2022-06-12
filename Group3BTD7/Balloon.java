import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Balloons
{
    public Balloon(){
        health = 1;
        speed = 2;
    }
    public void act()
    {
        if(health < 1){
            removeMe = true;
        }
    }
}
