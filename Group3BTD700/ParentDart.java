import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all darts/projectiles.
 * Each tower shoots a different type of projectile which have different stats, etc
 * 
 * @author Nick S
 * @version june 23 2022
 */
public abstract class ParentDart extends Actor
{
    protected int projSpeed = 8;
    protected int damage;
    
    /**
     * Accessor that returns the current damage of the projectile
     */
    public int getDamage(){
        return damage;
    }
    
    /**
     * Method to mvoe the projectile depending on its speed
     */
    public void fire(){
        move(projSpeed);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
