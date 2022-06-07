import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pathing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pathing extends Actor
{
    public int rotation;
    public boolean straight;
    public Pathing(int rotation){
        
        this.rotation = rotation;
    }
    
    public Pathing(boolean straight){
        this.straight = straight;
    }
    public void act()
    {
        // Add your action code here.
    }
}
