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

    private GreenfootImage bg = new GreenfootImage("flowerbackground.jfif");
    int map [][] = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,2,0,0,0,0,0,3,1,1,1,1,1,1},
            {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,3,1,1,1,1,1,4,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
            {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
            {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
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
    
    private PlayButton playButton;
    private RemoveButton removeButton;
    MouseInfo mouse = Greenfoot.getMouseInfo();
    
    Label healthTitle = new Label("Health: " + userHP, 40);
    Label moneyTitle = new Label("Money: " + userMoney, 40);
    Label waveTitle = new Label("Wave: " + wave, 40);
    Label scoreTitle = new Label("Score: " + score, 40);
    Label rangePrice = new Label("$200|", 25);
    Label slowPrice = new Label("$150|", 25);
    Label reconPrice = new Label("$350|", 25);
    Label meleePrice = new Label("$400|", 25);
    
    Label towerName = new Label("", 30);
    Label towerAttackSpeed = new Label("", 30);
    Label towerRange = new Label("", 30);
    
    
    
    Label sellPriceTitle = new Label("",30);
    SellButton sellButton = new SellButton();
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        setBackground(bg);
        
        moreDifficult = 1;
        
        playButton = new PlayButton();
        addObject(playButton, 25, 125);
        
        removeButton = new RemoveButton();
        addObject(removeButton, 25, 400);
        pathMap();
        
        //Instantiate the Monkeys that can be selected
        SelectDart selectDartMonkey = new SelectDart();
        SelectCannon selectCannon = new SelectCannon();
        SelectSniper selectSniperMonkey = new SelectSniper();
        SelectSuper selectSuperMonkey = new SelectSuper();
        
        //Add the objects and interactable buttons into the UI
        addObject(selectDartMonkey, 220, 485);
        addObject(selectCannon, 220, 550);
        addObject(selectSniperMonkey, 300, 485);
        addObject(selectSuperMonkey, 300, 550);
        
        userHP = 100;
        healthTitle.setFillColor(Color.RED);
        addObject(healthTitle, 90, 490);
        
        userMoney = 500;
        moneyTitle.setFillColor(Color.GREEN);
        addObject(moneyTitle, 90, 530);
        
        score = 0;
        scoreTitle.setFillColor(Color.WHITE);
        addObject(scoreTitle, 90, 570);
        
        waveTitle.setFillColor(Color.WHITE);
        addObject(waveTitle, 125, 125);
        
        
    }

    public void act(){
        
        if(Greenfoot.mousePressed(playButton)){
            start = true;
            
            removeObject(playButton);
            
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
            addObject(playButton, 25, 125);
        }
        
        healthTitle.setValue("Health: " + userHP);
        
        if(userHP <= 0){
            Greenfoot.setWorld(new GameOverWorld());
        }
        
        moneyTitle.setValue("Money: " + userMoney);
        waveTitle.setValue("Wave: " + wave);
        scoreTitle.setValue("Score: " + score);
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
                addObject(new Balloon(), 0 , 175);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }else if(balloonOrder.get(0) == 1){
                addObject(new CamoBalloon(), 0, 175);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }else if(balloonOrder.get(0) == 2){
                addObject(new MetalBalloon(), 0, 175);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }
        }
    }
    
    public boolean getSold(){
        return sold;
    }
    
    public void setSold(boolean current){
        sold = current;
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
    
    public static int getMoney(){
        return userMoney;
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