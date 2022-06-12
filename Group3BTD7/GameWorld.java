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
    private static int userMoney;
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
    
    private Button startButton;

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        startButton = new Button();
        addObject(startButton, 25, 125);

        pathMap();
    }

    public void act(){
        if(Greenfoot.mousePressed(startButton)){
            start = true;
            
            removeObject(startButton);
            
            if(balloonsLeft == 0){
                wave++;
                if(wave == 5 || wave == 20){
                    moreDifficult++;
                }
                balloonsLeft = (Greenfoot.getRandomNumber(3) + 10) * wave;
                
                for(int i = 0; i < balloonsLeft; i++){
                    spawn = Greenfoot.getRandomNumber(moreDifficult);
                    balloonOrder.add(spawn);
                }
            }
        }
        
        if(start && balloonsLeft > 0){
            spawnBalloon();
        }
        
        if(balloonsLeft == 0 && wave != 0){
            start = false;
            addObject(startButton, 25, 125);
        }
        
    
    }

    private void pathMap(){
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 12; j++){
                if(map[j][i] == 1){
                    addObject(new Pathing(true), 25 + i * 50, 25 + j * 50);
                }if(map[j][i] == 2){
                    addObject(new Pathing(90), 25 + i * 50, 25 + j * 50);
                }if(map[j][i] == 3){
                    addObject(new Pathing(0), 25 + i * 50, 25 + j * 50);
                }if(map[j][i] == 4){
                    addObject(new Pathing(270), 25 + i * 50, 25 + j * 50);
                }if(map[j][i] == 5){
                    addObject(new Pathing(180), 25 + i * 50, 25 + j * 50);
                }if(map[j][i] == 6){
                    addObject(new Square(), 25 + i * 50, 25 + j * 50);
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

    private void spawnBalloon(){
        timeBetweenWaves = Greenfoot.getRandomNumber(50);
        if(timeBetweenWaves == 1){
            if(balloonOrder.get(0) == 0){
                addObject(new Balloon(), 0 , 325);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }else if(balloonOrder.get(0) == 1){
                addObject(new CamoBalloon(), 0, 325);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }else if(balloonOrder.get(0) == 2){
                addObject(new MetalBalloon(), 0, 325);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }
        }
    }
    
    public boolean getStatOpen(){
        return statOpen;
    }
    
    public static int getHealth(){
        return userHP;
    }
    
    public static void setHealth(int num){
        userHP = userHP - num;
    }
    
    public static void setMoney(int cost){
        userMoney = userMoney - cost;
    }
    
    public static void addMoney(int money){
        userMoney = userMoney + money;
    }
    
    public static void addScore(int points){
        score = score + points;
    }
}