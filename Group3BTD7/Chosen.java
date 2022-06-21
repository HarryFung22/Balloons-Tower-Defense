import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chosen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chosen extends Actor
{
    public Chosen(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }
}
