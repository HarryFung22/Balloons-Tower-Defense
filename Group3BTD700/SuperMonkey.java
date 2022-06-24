import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a super monkey. Nothing super about it, just attacks normal balloons at a faster 
 * rate than the dart monkey
 * <p> Art: https://tcrf.net/File:BTD5-MonkeyStormPro.png
 * 
 * @author Harry F
 * @version June 23 2022
 */
public class SuperMonkey extends Monkeys
{
    GreenfootImage image;
    
    /**
     * Constructor for the super monkey
     */
    public SuperMonkey(){
        image = new GreenfootImage("Super Monkey.png");
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
        level = 0;
        attackSpeed = 40;
        cost = 600;
        type = "superMonkey";
        name = "Super Monkey";
        upgradeCost = cost * 2;
        sellCost = cost / 2;
    }
    
    /**
     * Act method to interact with the world
     */
    public void act()
    {
        findBalloon("SuperMonkey");
        super.act();
    }
}
