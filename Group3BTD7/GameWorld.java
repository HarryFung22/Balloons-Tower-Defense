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
                   
    private static int userHP;
    private static int startingMoney;
    private static int score;
    private int wave = 0;
    private int balloonsLeft = 0;
    private int timeBetweenWaves;
    private int moreDifficult;
    private int spawn;
    private boolean start;
    
    private boolean upgraded = false;
    private boolean sold = false;
    private boolean isClicked;
    private boolean statOpen;
    
    private ArrayList<Integer> balloonOrder = new ArrayList<Integer>();
    
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    private void pathMap(){
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 8; j++){
                if(map[j][i] == 1){
                    
                }
            }
        }
    }
    
    /**
     * This method determines the distance between 2 actors in a world
     * Code courtesy of Mr.Cohen
     * 
     * @param a The first actor that will be used to measure the distance
     * @param b The second actor that will be used to measure the distance between the two actors
     */
    public static float getDistance(Actor a, Actor b){
        double distance;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        distance = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return (float)distance;
    }
}
