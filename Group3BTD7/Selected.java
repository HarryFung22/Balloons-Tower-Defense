import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selected here.
 * 
 * @author Nick S
 * 
 * <p> Art: Nick <p/>
 * @version June 23 2022
 */
public class Selected extends Actor
{
    public Selected(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
    }
}
