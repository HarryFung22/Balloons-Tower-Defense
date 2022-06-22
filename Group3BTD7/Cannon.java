import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    GreenfootImage image;
    public Cannon(){
        image = new GreenfootImage("Bomb Tower.png");
        image.scale(image.getWidth()/9, image.getHeight()/9);
        image.rotate(180);
        setImage(image);
        level = 0;
        attackSpeed = 80;
        cost = 400;
        type = "cannonTower";
        name = "Cannon";
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
    
    public void act(){
        ArrayList<MetalBalloon> mBalloon = (ArrayList<MetalBalloon>)getWorld().getObjects(MetalBalloon.class);
        if(mBalloon.size() > 0){
            findMetal();
        }else{
            findBalloon("Cannon");
        }
        super.act();
    }
    
}
