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
    public DartMonkey(){
        cost = 200;
        attackSpeed = 20;
        type = "dartMonkey";
        name = "Dart Monkey";
        level = 0;
        upgradeCost = cost * 2;
        sellCost = cost / 2;
        
    }
    public void act(){
        findBalloon();
    }
}
