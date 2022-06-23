import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bomb projectile, shot by the cannon
 * 
 * <p> Art: https://favpng.com/png_view/alliance-vector-bloons-td-5-bloons-td-battles-ninja-kiwi-tower-defense-png/1HQuTH9f <p/>
 * @author Nick S
 * @version June 23 2022
 */
public class Bomb extends ParentDart
{
    GreenfootImage image;
    /**
     * Contructor for the bomb
     */
    public Bomb(){
        image = new GreenfootImage("bomb.png");
        image.scale(image.getWidth()/60, image.getHeight()/60);
        image.mirrorHorizontally();
        image.rotate(180);
        setImage(image);
        projSpeed = 20;
        damage = 5;
    }
    public void act()
    {
        fire();
    }
}
