import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class used to create a path for the balloons 
 * 50x50 are the dimensions of a singular grid
 * The path is created by implementing multiple instances of this class to create an overall map
 * 
 * @author Aiden S
 * @version June 23 2022
 */
public class Pathing extends Actor
{
    public int rotation;
    public boolean straight;
    GreenfootImage path;
    
    /**
     * Method to create a path that rotates the balloons depensing on the specified int
     * Overloads the other constructor if an int is specified
     */
    public Pathing(int rotation){
        drawPath();
        setImage(path);
        this.rotation = rotation;
    }
    
    /**
     * Method to create a path that moves the balloons in a straight path
     */
    public Pathing(boolean straight){
        drawPath();
        setImage(path);
        this.straight = straight;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Method to draw the path
     */
    public void drawPath(){
        path = new GreenfootImage(50,50);
        Color brown = new Color(66, 40, 9);
        path.setColor(brown);
        path.fill();
    }
}
