import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SelectMonkey extends Actor
{
    int pickX, pickY;
    public void select(String tower){
        if(Greenfoot.mouseDragged(this)){
            MouseInfo m = Greenfoot.getMouseInfo();
            pickX = m.getX();
            pickY = m.getY();
        }
        
        if(Greenfoot.mouseDragEnded(this)){
            if(tower == "Cannon"){
                getWorld().addObject(new Cannon(), (pickX/60) * 60 + 30, (pickY/60) * 60 + 30);
            } else if(tower ==  "DartMonkey"){
                getWorld().addObject(new DartMonkey(), (pickX/60) * 60 + 30, (pickY/60) * 60 + 30);
            } else if(tower == "SniperMonkey"){
                getWorld().addObject(new SniperMonkey(), (pickX/60) * 60 + 30, (pickY/60) * 60 + 30);
            } else if(tower == "SuperMonkey"){
                getWorld().addObject(new SuperMonkey(), (pickX/60) * 60 + 30, (pickY/60) * 60 + 30);
            }
        }
    }
}
