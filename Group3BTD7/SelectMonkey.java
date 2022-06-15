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
    boolean pressed = false;
    public void select(String tower){

        if(Greenfoot.mouseClicked(this)){
            pressed = true;
            MouseInfo m = Greenfoot.getMouseInfo();
            pickX = m.getX();
            pickY = m.getY();

        }

        if(pressed == true && Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null){
            MouseInfo m = Greenfoot.getMouseInfo();
            if(tower == "Cannon"){
                getWorld().addObject(new Cannon(), m.getX(), m.getY());
                pressed = false;
            } else if(tower ==  "DartMonkey"){
                getWorld().addObject(new DartMonkey(), m.getX(), m.getY());
                pressed = false;
            } else if(tower == "SniperMonkey"){
                getWorld().addObject(new SniperMonkey(), (pickX/60) * 60 + 30, (pickY/60) * 60 + 30);
            } else if(tower == "SuperMonkey"){
                getWorld().addObject(new SuperMonkey(), (pickX/60) * 60 + 30, (pickY/60) * 60 + 30);
            }
        }
        
    }
}
