import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SellButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SellButton extends Button
{
    GreenfootImage image;
    public SellButton(){
        image = new GreenfootImage("Sell Button.png");
        image.scale(image.getWidth()/36, image.getHeight()/36);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
