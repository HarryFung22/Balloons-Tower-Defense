import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This is the superclass for all balloons
 * Objective is to reach the end of the path and turn the user's health to 0
 * Monkeys will be used in order to attack and destroy these balloons
 * 
 * @author Aiden S
 * @version June 23 2022
 */
public abstract class Balloons extends Actor
{
    //instances variables that each balloon type can set 
    int health, speed;
    boolean camo = false;
    boolean metal = false;

    /**
     * Method used to check if a balloon is "hit" by its respective projectile, deducts its
     * health if hit by the projectile
     * Results vary for each type of projectile
     */
    public void attacked(){
        //Try catch blocks were used to potentially avoid bugs
        //Checks to see if balloon is hit by a projectile
        try{
            Dart dart = (Dart)getOneIntersectingObject(Dart.class);
            if(dart != null){
                health = health - dart.getDamage();
                getWorld().removeObject(dart);
            }
        }catch (Exception e){

        }

        try{
            Bomb bomb = (Bomb)getOneIntersectingObject(Bomb.class);
            if(bomb != null){
                health = health - bomb.getDamage();
                getWorld().removeObject(bomb);
            }
        }catch (Exception e){

        }

        try{
            SniperDart sDart = (SniperDart)getOneIntersectingObject(SniperDart.class);
            if(sDart != null){
                health = health - sDart.getDamage();
                getWorld().removeObject(sDart);
            }
        }catch (Exception e){

        }

        try{
            Laser laser = (Laser)getOneIntersectingObject(Laser.class);
            if(laser != null){
                health = health - laser.getDamage();
                getWorld().removeObject(laser);
            }
        }catch (Exception e){

        }
    }

    /**
     * Method to make balloons react differently (rotate) depending on the path's number and
     * properties
     * Makes the balloon stay on the map's path
     */
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

    /**
     * Method to "despawn" balloons at the edge of the map
     */
    public void removeMe(){
        if(isAtEdge()){
            getWorld().removeObject(this);

            //updates the health of the base after a balloon reaches the end
            //reduces health depending on that balloon's current health before it despawned
            ((GameWorld)getWorld()).setHealth(health);
        }
    }
}