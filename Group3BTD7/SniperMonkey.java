import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SniperMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperMonkey extends Monkeys
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean isBought = false;
    public SniperMonkey(){
        type = "sniperMonkey";
        name = "Sniper Monkey";
        cost = 300;
        level = 0;
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
}
