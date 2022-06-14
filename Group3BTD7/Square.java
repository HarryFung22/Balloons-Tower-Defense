import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    GreenfootImage square;
    
    public Square(){
        drawSquare();
        setImage(square);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void drawSquare(){
        square = new GreenfootImage(50,50);
        Color beige = new Color(224, 202, 180);
        square.setColor(beige);
        square.fill();
    }
}
