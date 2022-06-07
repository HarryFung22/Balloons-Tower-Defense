import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CamoBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CamoBalloon extends Balloons
{
    public CamoBalloon(){
        camo = true;
        health = 10;
        speed = 3;
    }
    public void act()
    {
        if(health < 1){
            removeMe = true;
        }
    }
}
