import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dart projectile, shot by the dart monkey
 * 
 * <p> Art: https://favpng.com/png_view/pink-wave-point-bloons-td-5-bloons-td-3-tower-defense-darts-minecraft-png/iZ3GeTCN <p/>
 * @author Nick S
 * @version June 23 2022
 */
public class Dart extends ParentDart
{
    GreenfootImage image;
    /**
     * Constructor for the dart
     */
    public Dart(){
        image = new GreenfootImage("Dart.png");
        image.scale(image.getWidth()/20, image.getHeight()/20);
        image.rotate(8);
        setImage(image);
        projSpeed = 40;
        damage = 1;
    }

    public void act()
    {
        fire();
    }
}
