import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author Nick S
 * @version June 23 2022
 */
public class PlayButton extends Button
{
    private GreenfootImage pButton;
    
    public PlayButton(){
        drawPButton();
        setImage(pButton);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void drawPButton(){
        pButton = new GreenfootImage(30, 30);
        Color rect = new Color (66, 40 , 9);
        pButton.setColor(rect);
        pButton.fill();
        
        pButton.setColor(Color.GREEN);
        pButton.drawPolygon(new int[] {8, 8, 22}, new int[] {8, 22, 16}, 3);
        pButton.fillPolygon(new int[] {8, 8, 22}, new int[] {8, 22, 16}, 3);
        
    }
}
