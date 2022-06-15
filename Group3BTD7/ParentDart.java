import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public void fire(){
        move(projSpeed);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
