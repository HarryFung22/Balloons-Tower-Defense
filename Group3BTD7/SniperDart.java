import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sniper dart projectile, shot by the sniper tower
 * 
 * <p> Art: https://favpng.com/png_view/pink-wave-point-bloons-td-5-bloons-td-3-tower-defense-darts-minecraft-png/iZ3GeTCN <p/>
 * @author Nick S
 * @version June 23 2022
 */
public class SniperDart extends ParentDart
{
    GreenfootImage image;
    
    /**
     * Constructor for the sniper dart
     */
    public SniperDart(){
        image = new GreenfootImage("Dart.png");
        image.scale(image.getWidth()/20, image.getHeight()/20);
        image.rotate(8);
        setImage(image);
        projSpeed = 60;
        damage = 5;
    }

    public void act()
    {
        fire();
    }
}
