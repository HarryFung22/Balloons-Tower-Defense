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
    GreenfootImage path;
    
    public Pathing(int rotation){
        drawPath();
        setImage(path);
        this.rotation = rotation;
    }
    
    public Pathing(boolean straight){
        drawPath();
        setImage(path);
        this.straight = straight;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void drawPath(){
        path = new GreenfootImage(50,50);
        Color brown = new Color(66, 40, 9);
        path.setColor(brown);
        path.fill();
    }
}
