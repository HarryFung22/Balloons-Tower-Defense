import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Balloons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Balloons extends Actor
{
    int health, speed;
    boolean camo = false;
    boolean metal = false;
    
    public void onPath(){
        move(speed);
        List<Pathing> path90 = getObjectsAtOffset(-25,-25,  Pathing.class);
        for(Pathing paths: path90)
        {
            if(paths.straight == false && getRotation() == 0)
            {
                setRotation(paths.rotation);
            }
        }
        List<Pathing> path0 = getObjectsAtOffset(-25,-25, Pathing.class);
        for(Pathing paths: path0)
        {
            if(paths.straight == false && getRotation() == 90)
            {
                setRotation(paths.rotation);
            }
        }
        List<Pathing> path270 = getObjectsAtOffset(-25,-25, Pathing.class);
        for(Pathing paths: path270)
        {
            if(paths.straight == false && getRotation() == 180)
            {
                setRotation(paths.rotation);
            }
        }
        List<Pathing> path180 = getObjectsAtOffset(20,20, Pathing.class);
        for(Pathing paths: path180)
        {
            if(paths.straight == false && getRotation() == 270)
            {
                setRotation(paths.rotation);
            }
        }
        removeMe();
    }
    
    public void takeDamage(){
        try{
            Dart dart = (Dart)getOneIntersectingObject(Dart.class);
            if(dart != null){
                health = health - dart.getDamage();
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void removeMe(){
        if(isAtEdge()){
            getWorld().removeObject(this);
            ((GameWorld)getWorld()).setHealth(health);
        }
    }
}