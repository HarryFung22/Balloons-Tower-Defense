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
        speed = 4;
    }
    public void act()
    {
        onPath();
        attacked();
        if(health < 1){
            ((GameWorld) getWorld()).addMoney(20);
            ((GameWorld) getWorld()).addScore(5);
            getWorld().removeObject(this);
        }
    }
}
