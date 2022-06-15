import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Balloons
{
    GreenfootImage image;
    public Balloon(){
        health = 2;
        speed = 3;
        image = getImage();
        image.scale(50,50);
        setImage(image);
    }
    public void act()
    {
        onPath();
        attacked();
        if(health < 1){
            ((GameWorld) getWorld()).addMoney(20);
            ((GameWorld) getWorld()).addScore(5);
            getWorld().removeObject(this);
        }
    }
}