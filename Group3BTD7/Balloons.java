import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Balloons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Balloons extends Actor
{
    int health, speed;
    boolean camo = false;
    boolean metal = false;
    boolean removeMe = false;
    public void act()
    {
        if(!removeMe){
            
        }else{
            getWorld().removeObject(this);
        }
    }
    
    
}
