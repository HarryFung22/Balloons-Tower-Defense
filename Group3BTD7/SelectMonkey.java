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

        RemoveButton r = (RemoveButton)getOneIntersectingObject(RemoveButton.class);
        
        Selected s = (Selected)getOneIntersectingObject(Selected.class);
        Selected select = new Selected();
        if(Greenfoot.mouseClicked(this)){
            pressed = true;
            MouseInfo m = Greenfoot.getMouseInfo();
            pickX = m.getX();
            pickY = m.getY();
            getWorld().addObject(select, pickX, pickY);
        }
        
        
        int balance = ((GameWorld)getWorld()).getMoney();

        if(pressed == true && Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null){
            MouseInfo m = Greenfoot.getMouseInfo();
            if(tower == "Cannon" && balance - 400 >= 0){
                getWorld().addObject(new Cannon(), m.getX(), m.getY());
                ((GameWorld)getWorld()).setMoney(400);
                pressed = false;
                getWorld().removeObject(s);
            }else{
                getWorld().removeObject(s);
            }
            
            if(tower ==  "DartMonkey" && balance - 200 >= 0){
                getWorld().addObject(new DartMonkey(), m.getX(), m.getY());
                ((GameWorld)getWorld()).setMoney(200);
                pressed = false;
                getWorld().removeObject(s);
            } else{
                getWorld().removeObject(s);
            }
            
            if(tower == "SniperMonkey" && balance - 300 >= 0){
                getWorld().addObject(new SniperMonkey(), m.getX(), m.getY());
                ((GameWorld)getWorld()).setMoney(300);
                pressed = false;
                getWorld().removeObject(s);
            }else{
                getWorld().removeObject(s);
            }
            
            if(tower == "SuperMonkey" && balance - 600 >= 0){
                getWorld().addObject(new SuperMonkey(), m.getX(), m.getY());
                ((GameWorld)getWorld()).setMoney(600);
                pressed = false;
                getWorld().removeObject(s);
            }else{
                getWorld().removeObject(s);
            }
        }
        
    }
}
