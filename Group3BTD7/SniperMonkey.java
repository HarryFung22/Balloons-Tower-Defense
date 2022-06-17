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
    GreenfootImage image;
    public SniperMonkey(){
        image = new GreenfootImage("snipermonkey.png");
        image.scale(image.getWidth()/3, image.getHeight()/3);
        image.rotate(180);
        setImage(image);
        type = "sniperMonkey";
        name = "Sniper Monkey";
        attackSpeed = 60;
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
