import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Superclass for all selectable icons on the UI
 * SelectMonkey are towers that the user can click, and then place on an open grid that isn't 
 * occupied. An icon will be placed on the selected tower type to indicate if the user can 
 * place the tower. To get rid of the tower you selected (if you don't want to place that tower),
 * just click the selected tower icon again
 * 
 * @author Harry F, Aiden S 
 * @version June 23 2022
 */
public abstract class SelectMonkey extends Actor
{
    int pickX, pickY;
    boolean pressed = false;
    
    /**
     * Method to place the selected tower
     */
    public void select(String tower){

        //arraylist of all "selected" objects in the world
        ArrayList<Selected> s = (ArrayList<Selected>)getWorld().getObjects(Selected.class);
        
        int balance = ((GameWorld)getWorld()).getMoney();
        Selected select = new Selected();
        
        Monkeys monkey = (Monkeys)getOneIntersectingObject(Monkeys.class);
        
        //if the size of the "selected" objects are 0, sets the pressed variable as false
        if(s.size() <= 0){
            pressed = false;
        }
        
        //checks if the monkey icon is clicked
        if(Greenfoot.mouseClicked(this)){
            pressed = true;
            MouseInfo m = Greenfoot.getMouseInfo();
            pickX = m.getX();
            pickY = m.getY();
            getWorld().addObject(select, pickX, pickY);
        }
        
        //checks if the user doesn't want to place the tower
        if(Greenfoot.mouseClicked(this) && pressed == true && s.size() > 0){
             getWorld().removeObjects(getWorld().getObjects(Selected.class));
        }

        //checks if the user is placing the monkey on an empty grid (and also if it isn't on
        //another actor)
        //Also checks if they have enough money to afford the tower
        //Else statement is used to set the pressed variable as false to that the tower won't
        //autoplace once the user gets enough money
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
