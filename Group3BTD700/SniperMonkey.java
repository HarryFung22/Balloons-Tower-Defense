import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This is a sniper monkey. Its purpose is to attack camo balloons or normal balloons 
 * (will prioritize the camo balloons).
 * Only tower that is able to hit camo balloons
 * 
 * <p> Art: https://bloons.fandom.com/wiki/Faster_Firing_(Sniper_Monkey) <p/>
 * @author Harry F
 * @version June 23 2022
 */
public class SniperMonkey extends Monkeys
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean isBought = false;
    GreenfootImage image;
    /**
     * Constructor for the sniper monkey
     */
    public SniperMonkey(){
        image = new GreenfootImage("Sniper Monkey Box Hitbox.png");
        image.scale(image.getWidth()/6, image.getHeight()/6);
        image.mirrorHorizontally();
        image.mirrorVertically();
        setImage(image);
        type = "sniperMonkey";
        name = "Sniper Monkey";
        cost = 300;
        attackSpeed = 100;
        level = 0;
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
    
    /**
     * Act method to check which balloon type to attack
     */
    public void act(){
        ArrayList<CamoBalloon> cBalloon = (ArrayList<CamoBalloon>)getWorld().getObjects(CamoBalloon.class);
        if(cBalloon.size() > 0){
            findCamo();
        }else{
            findBalloon("SniperMonkey");
        }
        super.act();
    }
}
