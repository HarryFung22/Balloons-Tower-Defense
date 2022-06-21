import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class SelectMonkey here.
 * 
 * @author Harry F 
 * @version (a version number or a date)
 */
public abstract class SelectMonkey extends Actor
{
    int pickX, pickY;
    boolean pressed = false;
    public void select(String tower){

        ArrayList<Selected> s = (ArrayList<Selected>)getWorld().getObjects(Selected.class);
        
        int balance = ((GameWorld)getWorld()).getMoney();
        Selected select = new Selected();
        
        if(s.size() <= 0){
            pressed = false;
        }
        
        if(Greenfoot.mouseClicked(this)){
            pressed = true;
            MouseInfo m = Greenfoot.getMouseInfo();
            pickX = m.getX();
            pickY = m.getY();
            getWorld().addObject(select, pickX, pickY);
        }

        if(pressed == true && Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null){
            MouseInfo m = Greenfoot.getMouseInfo();
            if(tower == "Cannon" && balance - 400 >= 0){
                getWorld().addObject(new Cannon(), m.getX(), m.getY());
                
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            }else{
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            }
            
            if(tower ==  "DartMonkey" && balance - 200 >= 0){
                getWorld().addObject(new DartMonkey(), m.getX(), m.getY());
                
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            } else{
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            }
            
            if(tower == "SniperMonkey" && balance - 300 >= 0){
                getWorld().addObject(new SniperMonkey(), m.getX(), m.getY());
                
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            } else{
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            }
            
            if(tower == "SuperMonkey" && balance - 600 >= 0){
                getWorld().addObject(new SuperMonkey(), m.getX(), m.getY());
                
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            } else{
                getWorld().removeObjects(getWorld().getObjects(Selected.class));
            }
        }
        
    }
}
