import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Monkeys
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean isBought = false;
    public Cannon(){
        level = 0;
        attackSpeed = 20;
        cost = 400;
        type = "cannonTower";
        name = "Cannon";
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
}
