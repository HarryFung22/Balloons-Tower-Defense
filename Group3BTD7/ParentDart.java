import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ParentDart extends Actor
{
    protected int projSpeed;
    protected int damage;
    /**
     * Act - do whatever the Dart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /**
     * Accessor that returns the current damage of the projectile
     */
    public int getDamage(){
        return damage;
    }
    
    public void fire(){
        move(projSpeed);
        if(this.isTouching(Balloons.class)){
            getWorld().removeObject(this);
        }
    }
}
