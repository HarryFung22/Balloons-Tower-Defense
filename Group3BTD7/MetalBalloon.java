import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MetalBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MetalBalloon extends Balloons
{
    public MetalBalloon(){
        metal = true;
        health = 40;
        speed = 1;
    }
    public void act()
    {
        if(health <= 0){
            removeMe = true;
        }
    }
}
