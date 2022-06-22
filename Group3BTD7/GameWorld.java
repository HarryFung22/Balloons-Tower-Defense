import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 * This is the world where the game is played. 
 * 
 * @author Harry F, Aiden S, Nick S
 * @version June 21, 2022
 */
public class GameWorld extends World
{
    //Map layout - how are the balloons going to follow the path and what path they will take
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
    private int highscore;
    private boolean start;
    private boolean turnedOn;

    private boolean upgraded = false;
    private boolean sold = false;
    private boolean isClicked;
    private boolean statOpen;

    private ArrayList<Integer> balloonOrder = new ArrayList<Integer>();

    private PlayButton playButton;
    private UserInfo user;
    //These are all texts within the game that will display onto the UI.
    Label healthTitle = new Label("Health: " + userHP, 40);
    Label moneyTitle = new Label("Money: " + userMoney, 40);
    Label waveTitle = new Label("Wave: " + wave, 40);
    Label scoreTitle = new Label("Score: " + score, 40);
    Label sniperPrice = new Label("$300", 24);
    Label dartPrice = new Label("$200", 24);
    Label bombPrice = new Label("$400", 24);
    Label superPrice = new Label("$600", 24);

    Label towerName = new Label("", 30);
    Label towerAttackSpeed = new Label("", 30);
    Label towerRange = new Label("", 30);

    Label upgradeCostTitle = new Label("", 30);
    UpgradeButton upgradeButton = new UpgradeButton();

    Label sellPriceTitle = new Label("",30);
    SellButton sellButton = new SellButton();

    Selected circle = new Selected();
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        moreDifficult = 1;

        playButton = new PlayButton();
        addObject(playButton, 25, 125);
        pathMap();

        //Instantiate the Monkeys that can be selected
        SelectDart selectDartMonkey = new SelectDart();
        SelectCannon selectCannon = new SelectCannon();
        SelectSniper selectSniperMonkey = new SelectSniper();
        SelectSuper selectSuperMonkey = new SelectSuper();

        //Add the objects and interactable buttons into the UI
        addObject(selectDartMonkey, 25, 485);
        addObject(selectCannon, 25, 555);
        addObject(selectSniperMonkey, 100, 485);
        addObject(selectSuperMonkey, 100, 555);

        userHP = 100;
        healthTitle.setFillColor(Color.RED);
        addObject(healthTitle, 680, 480);

        userMoney = 500;
        moneyTitle.setFillColor(Color.GREEN);
        addObject(moneyTitle, 680, 520);

        score = 0;
        scoreTitle.setFillColor(Color.WHITE);
        addObject(scoreTitle, 680, 560);
        
        sniperPrice.setFillColor(Color.WHITE);
        addObject(sniperPrice, 100,520); 
        dartPrice.setFillColor(Color.WHITE);
        addObject(dartPrice, 25,520); 
        bombPrice.setFillColor(Color.WHITE);
        addObject(bombPrice, 25,585); 
        superPrice.setFillColor(Color.WHITE);
        addObject(superPrice, 100,585); 

        waveTitle.setFillColor(Color.WHITE);
        addObject(waveTitle, 125, 125);
        
        upgradeCostTitle.setFillColor(Color.GREEN);
        sellPriceTitle.setFillColor(Color.RED);
        
        start = false;
        statOpen = false;
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
        
        if(Greenfoot.mouseClicked(upgradeButton)){
            upgraded = true;
        }else if(Greenfoot.mouseClicked(sellButton)){
            sold = true;
        }
        
        healthTitle.setValue("Health: " + userHP);
        
        if(userHP <=0){
            Greenfoot.setWorld(new GameOver());
        }
        
        moneyTitle.setValue("Money: " + userMoney);
        waveTitle.setValue("Wave: " + wave);
        scoreTitle.setValue("Score: " + score);
        
        //For the scoreboard - checking login to see if the score can be updated
        if (UserInfo.isStorageAvailable()) { 
            user = UserInfo.getMyInfo();
        }
        if (score > highscore){
            highscore = score;
        }
        //Sets the score and pushes it into the server
        if (user != null){
            user.setScore(highscore);
            user.store();
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

    public void menu(String displayName, int attackspeed, int range, boolean on, int upgradeCost, int sellPrice, int towerX, int towerY){
        turnedOn = on;
        if(on){
            //List out all labels and titles to show information to user
            towerName.setValue(displayName);
            towerAttackSpeed.setValue("Atk Delay: " + attackspeed);
            towerRange.setValue("Range: " + range);
            upgradeCostTitle.setValue("Upgrade: $" + upgradeCost); 
            sellPriceTitle.setValue("Sell: $" + sellPrice);
            
            //Add those labels into the tower menu interface 
            addObject(towerName, 260, 470);
            addObject(towerAttackSpeed, 260, 500);
            addObject(towerRange, 260, 530);
            addObject(upgradeCostTitle, 460, 470);
            addObject(sellPriceTitle, 460, 500);
            addObject(upgradeButton, 430, 530);
            addObject(sellButton, 480, 530);
            
            //Add a green circle to show the user which tower they have selected
            addObject(circle, towerX, towerY);
            
            //Tell the computer that there is currently a tower menu open
            statOpen = true;
        }
        //Else if the tower menu is asked to be turned off
        else if(!on){
            //Set all label values to nothing
            towerName.setValue("");
            towerAttackSpeed.setValue("");
            towerRange.setValue("");
            
            upgradeCostTitle.setValue("");
            removeObject(upgradeButton);
            sellPriceTitle.setValue("");
            removeObject(sellButton);
            
            //Remove the green circle as the user is no longer selecting the respective tower's menu
            removeObject(circle);
            
            //Tell the computer that there is no tower menu open anymore
            statOpen = false;
        }
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
    
    public boolean isOn(){
        return turnedOn;
    }
    
    public boolean getUpgraded(){
        return upgraded;
    }
    
    public void setUpgraded(boolean b){
        upgraded = b;
    }
    
    public boolean getSold(){
        return sold;
    }
    
    public void setSold(boolean b){
        sold = b;
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

    public static int getMoney(){
        return userMoney;
    }

    public static void addScore(int points){
        score = score + points;
    }
}