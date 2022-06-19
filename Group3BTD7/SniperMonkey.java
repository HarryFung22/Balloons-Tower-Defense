import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    
    public void act(){
        ArrayList<CamoBalloon> cBalloon = (ArrayList<CamoBalloon>)getWorld().getObjects(CamoBalloon.class);
        if(cBalloon.size() > 0){
            findCamo();
        }else{
            findBalloon("SniperMonkey");
        }
    }
}
