import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This is a bomb tower/cannon. Its purpose is to attack metal balloons or normal balloons 
 * (will prioritize the metal balloons).
 * Only tower that is able to hit metal balloons
 * 
 * @author Harry F
 * @version June 23 2022
 */
public class Cannon extends Monkeys
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean isBought = false;
    GreenfootImage image;
    
    /**
     * Constructor for the cannon
     */
    public Cannon(){
        image = new GreenfootImage("Bomb Tower Transparent Square.png");
        image.scale(image.getWidth()/8 + 10, image.getHeight()/8 + 10);
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
    
    /**
     * Act method to check which balloon type to attack
     */
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
