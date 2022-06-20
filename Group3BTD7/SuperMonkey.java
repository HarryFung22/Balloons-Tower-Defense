import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperMonkey extends Monkeys
{
    GreenfootImage image;
    public SuperMonkey(){
        image = new GreenfootImage("Super Monkey.png");
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
        level = 0;
        attackSpeed = 20;
        cost = 600;
        type = "superMonkey";
        name = "Super Monkey";
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
    public void act()
    {
        findBalloon("SuperMonkey");
    }
}
