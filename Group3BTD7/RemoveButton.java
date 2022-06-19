import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RemoveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RemoveButton extends Button
{
    private boolean touched;
    public RemoveButton(){
        touched = false;
    }
    public void act()
    {
        pressed();
    }
    
    public void pressed(){
        if(Greenfoot.mouseClicked(this)){
            touched = !touched;//true;
        }
    }
    
    public boolean getTouched(){
        return touched;
    }
}
