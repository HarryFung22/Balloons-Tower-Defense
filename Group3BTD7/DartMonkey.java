import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DartMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DartMonkey extends Monkeys
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean isBought = false;
    GreenfootImage image;
    public DartMonkey(){
        image = new GreenfootImage("Dart Monkey.png");
        image.scale(image.getWidth()/8, image.getHeight()/8);
        image.rotate(90);
        setImage(image);
        cost = 200;
        attackSpeed = 20;
        type = "dartMonkey";
        name = "Dart Monkey";
        level = 0;
        upgradeCost = cost * 2;
        sellCost = cost / 2;
        
    }
    public void act(){
        findBalloon("DartMonkey");
    }
}
