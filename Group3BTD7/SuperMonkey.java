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
        image = new GreenfootImage("Dart Monkey.png");
        image.scale(image.getWidth()/8, image.getHeight()/8);
        image.rotate(90);
        setImage(image);
        cost = 600;
        attackSpeed = 15;
        type = "superMonkey";
        name = "Super Monkey";
        level = 0;
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
    public void act()
    {
        // Add your action code here.
    }
}
