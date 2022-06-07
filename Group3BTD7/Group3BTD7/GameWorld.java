import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    int map [][] = {
                    {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
                    {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
                    {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {1,1,1,2,0,0,0,0,0,3,1,1,1,1,1,1},
                    {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
                    {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
                    {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
                    {0,0,0,3,1,1,1,1,1,4,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                   };
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
}
