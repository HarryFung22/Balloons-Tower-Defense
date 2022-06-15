import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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

        Selected s = (Selected)getOneIntersectingObject(Selected.class);
        Selected select = new Selected();
        if(Greenfoot.mouseClicked(this)){
            pressed = true;
            MouseInfo m = Greenfoot.getMouseInfo();
            pickX = m.getX();
            pickY = m.getY();
            getWorld().addObject(select, pickX, pickY);
        }

        if(pressed == true && Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null){
            MouseInfo m = Greenfoot.getMouseInfo();
            if(tower == "Cannon"){
                getWorld().addObject(new Cannon(), m.getX(), m.getY());
                pressed = false;
                getWorld().removeObject(s);
            } else if(tower ==  "DartMonkey"){
                getWorld().addObject(new DartMonkey(), m.getX(), m.getY());
                pressed = false;
                getWorld().removeObject(s);
            } else if(tower == "SniperMonkey"){
                getWorld().addObject(new SniperMonkey(), m.getX(), m.getY());
                pressed = false;
                getWorld().removeObject(s);
            } else if(tower == "SuperMonkey"){
                getWorld().addObject(new SuperMonkey(), m.getX(), m.getY());
                pressed = false;
                getWorld().removeObject(s);
            }
        }
        
    }
}
