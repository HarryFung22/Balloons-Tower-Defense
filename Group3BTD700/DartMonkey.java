import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a dart monkey. Nothing special about it, just attacks normal balloons and does 
 * low-moderate damage and has slow and short fire rate/range
 * <p> Art: https://www.pinpng.com/picture/Jxxxbb_1200-x-1200-3-dart-monkey-hd-png/
 * 
 * @author Harry F
 * @version June 23 2022
 */
public class DartMonkey extends Monkeys
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean isBought = false;
    GreenfootImage image;
    
    /** 
     * Constructor for the dart monkey
     */
    public DartMonkey(){
        image = new GreenfootImage("Dart Monkey.png");
        image.scale(image.getWidth()/8, image.getHeight()/8);
        image.rotate(90);
        setImage(image);
        cost = 200;
        attackSpeed = 60;
        type = "dartMonkey";
        name = "Dart Monkey";
        level = 0;
        upgradeCost = cost * 2;
        sellCost = cost / 2;
        
    }
    
    /**
     * Act method to interact with the world
     */
    public void act(){
        findBalloon("DartMonkey");
        super.act();
    }
}
