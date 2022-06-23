import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author Nick S
 * @version June 23 2022
 */
public class UpgradeButton extends Button
{
    GreenfootImage image;
    
    public UpgradeButton(){
        image = new GreenfootImage("Upgrade Button.png");
        image.scale(image.getWidth()/22, image.getHeight()/22);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
