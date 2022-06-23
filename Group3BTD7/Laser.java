import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Laser projectile, shot by the super monkey
 * 
 * <p> Art: https://www.pngitem.com/so/red-laser/ <p/>
 * @author Nick S
 * @version June 23 2022
 */
public class Laser extends ParentDart
{
    GreenfootImage image;
    
    /**
     * Constructor for the laser
     */
    public Laser(){
        image = new GreenfootImage("Laser.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);
        image.rotate(90);
        setImage(image);
        projSpeed = 20;
        damage = 1;
    }
    public void act()
    {
        fire();
    }
}
