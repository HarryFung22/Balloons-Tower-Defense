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
        onPath();
        if(health < 1){
            ((GameWorld) getWorld()).addMoney(20);
            ((GameWorld) getWorld()).addScore(5);
            removeMe();
        }
    }
}
