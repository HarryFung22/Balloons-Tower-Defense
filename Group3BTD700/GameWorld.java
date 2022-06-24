import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 * This is the world where the game is played. 
 * 
 * <p> Credits: <p/>
 * <p> All visual credits (for photos) and SFX (for sounds) are credited in their own respective class 
 * <p> For example: Dart monkey png is credited in the dark monkey class API 
 * <p> Code: <p/>
 * All targetting methods found in the monkey class were derived from Jordan Cohen's find method
 * from the bug simulation. The ScoreBoard class was also borrowed from Jordan Cohen and was
 * used to display the score at the end of the game. The Label class was borrowed from Amjad Altadmri
 * and was used to display the visual text on the screen (such as user health, money, etc).
 * 
 * <p> General Features: <p/>
 * - Main objective of the game is to "defend" against the enemies (balloons) using 
 * towers (monkeys) 
 * <p> - 3 types of balloons: Normal, Camo, Metal
 * <p> - 4 types of Towers: Dart, Sniper, Bomb, Super
 * <p> - Each tower has specific properties (Ex. Sniper Monkeys are the only tower able to 
 * see Camo Balloons)
 * 
 * <p> Additional Features: 
 * <p> - An upgrade menu is availible, allowing for each tower to be upgraded
 * <p> - Projectiles work like a "homing" projectile, which will follow the closest 
 * targetable balloon. This ensures that projectiles will hit the balloon, despite projectile
 * speeds or attack speeds. 
 * <p> - A simple UI ensures that the user will have no trouble understanding the game
 * <p> - An arraylist was used to randomize the spawn rate of balloons, and the order at 
 * which they spawn. This is evident as you play through the game, seeing as to how one
 * wave may end quickly, while another might take longer to finish.
 * 
 * <p> Bugs/Notes:
 * <p> - Not aware of any current bugs
 * <p> - (Important) If the "F" and "J" key are held down together at the same time, $100 of currency
 * will be added. This will help buy all the towers at an early stage if need be. 
 * <p> - However, some actor hitboxes may appear to be "bugged". However, this is most likely
 * due to scaling down the image as the initial image size was too large
 * <p> - The game sometimes lags after a cannon shoots its first bomb projectile. After that,
 * there shouldn't be any lag. In the case of an exception for the bomb projectile, this is 
 * due to the name of the png not matching the name of the png in the bomb class (This has
 * occured before but we have check before submitting that the name of the png should be
 * correct)
 * 
 * <p> Game Music: https://www.youtube.com/watch?v=K-4SthopN2U
 * @author Harry F, Aiden S, Nick S
 * @version June 23, 2022
 */
public class GameWorld extends World
{
    //Background
    private GreenfootImage bg = new GreenfootImage("Game Background.jpg");
    
    
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

    //list of variables used to keep track of user's info
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

    //variables used to check if a tower is selected to be upgraded
    private boolean upgraded = false;
    private boolean sold = false;
    private boolean isClicked;
    private boolean statOpen;

    //Arraylist used to set the order the balloons spawn 
    private ArrayList<Integer> balloonOrder = new ArrayList<Integer>();

    //Button that is pressed in order for a wave to start
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

    Chosen circle = new  Chosen();
    
    //background sound
    GreenfootSound BGM = new GreenfootSound("BGM.wav");
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //scale and set the background
        bg.scale(bg.getWidth()/3, bg.getHeight()/3);
        setBackground(bg);
        BGM.setVolume(30);
        BGM.playLoop();
        
        //indicated difficulty for the balloon, 1 indicates normal balloons
        moreDifficult = 1;

        //setup the "play button"
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

        //Setting up UI such as user hp, money, selectable towers, etc
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

        //setup the map
        start = false;
        statOpen = false;
    }

    public void act(){
        //checks if a wave has started
        if(Greenfoot.mousePressed(playButton)){
            //variable to start the wave
            start = true;
            //removes the button
            removeObject(playButton);

            //Code below is used to randomize the # of ballons per wave, types or balloons, etc
            //Arraylist is used and the computer randomizes the amount of balloons per wave
            //This is apparent as some waves may be short, while others are longer
            if(balloonsLeft == 0){
                wave++;
                //increases difficulty, header ballons spawn at these thresholds
                if(wave == 5 || wave == 20){
                    moreDifficult++;
                }
                //randomizes balloon count
                balloonsLeft = (Greenfoot.getRandomNumber(3) + 10) * wave;

                //adds balloons to the arraylist, sets a spawning order
                for(int i = 0; i < balloonsLeft; i++){
                    //A balloon will be spawned depending on the user's progression
                    spawn = Greenfoot.getRandomNumber(moreDifficult);
                    //Balloon gets added into the arraylist
                    balloonOrder.add(spawn);
                }
            }
        }
        
        //Grabs the current high score if possible
        if (UserInfo.isStorageAvailable()) { 
            user = UserInfo.getMyInfo();
        }
        if (user != null){ // check if logged in
            highscore = user.getScore();
        }

        //if user wants to start another wave even if there are still balloons left
        if(start && balloonsLeft > 0){
            //spawns the balloons
            spawnBalloon();
        }

        //checks if there are no balloons left in the arraylist and if the wave is greater than 0
        if(balloonsLeft == 0 && wave != 0){
            //Doesn't start the next wave
            start = false;
            //Adds back the play button
            addObject(playButton, 25, 125);
        }

        //if the user upgrades the tower (by clicking the upgrade button)
        if(Greenfoot.mouseClicked(upgradeButton)){
            upgraded = true;
        }//checks if the user has sold the tower
        else if(Greenfoot.mouseClicked(sellButton)){
            sold = true;
        }
        //updates current hp
        healthTitle.setValue("Health: " + userHP);

        if(userHP <=0){
            //stops the music and swaps world
            BGM.stop();
            Greenfoot.setWorld(new GameOver());
        }
        
        if(Greenfoot.isKeyDown("f") && Greenfoot.isKeyDown("j")){
            userMoney += 100;
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
        if (user != null){
            user.setScore(highscore);
            user.store();
        }
    }

    /**
     * Method used to setup pathing for balloons, used to indicate where balloons will need to
     * rotate depending on the number that corresponds to that given "tile" in the 2d array
     */
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

    /** 
     * Method used to create an interface for the user to upgrade or select the tower depending on which tower has been selected
     */
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

    /**
     * Method used to randomly spawn a variety of balloons
     */
    private void spawnBalloon(){
        //Randomizes the spawn rate
        timeBetweenWaves = Greenfoot.getRandomNumber(50);
        if(timeBetweenWaves == 1){
            //spawns regular balloons
            if(balloonOrder.get(0) == 0){
                addObject(new Balloon(), 0 , 175);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }//Spawns camo balloons
            else if(balloonOrder.get(0) == 1){
                addObject(new CamoBalloon(), 0, 175);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }//spawns metal balloons
            else if(balloonOrder.get(0) == 2){
                addObject(new MetalBalloon(), 0, 175);
                balloonsLeft--;
                if(balloonsLeft > 0){
                    balloonOrder.remove(0);
                }
            }
        }
    }

    /**
     * Getter Method that "indirectly" returns boolean value of whether the monkey's stats
     * variable is on or not (in the menu method)
     */
    public boolean isOn(){
        return turnedOn;
    }

    /**
     * Getter Method that returns boolean value of whether a tower has been upgraded or not
     */
    public boolean getUpgraded(){
        return upgraded;
    }

    /**
     * Setter Method that sets the "upgraded" boolean variable
     */
    public void setUpgraded(boolean b){
        upgraded = b;
    }

    /**
     * Getter Method that returns boolean value of whether a tower has been sold or not
     */
    public boolean getSold(){
        return sold;
    }

    /**
     * Setter Method that sets the "sold" boolean variable
     */
    public void setSold(boolean b){
        sold = b;
    }

    /**
     * Getter Method that returns boolean value of whether a tower menu is open
     */
    public boolean getStatOpen(){
        return statOpen;
    }

    /**
     * Getter Method that returns an int value of the user's health
     */
    public static int getHealth(){
        return userHP;
    }

    /**
     * Setter Method that sets the user's health 
     */
    public static void setHealth(int num){
        userHP = userHP - num;
    }

    /**
     * Setter Method that sets the user's money after a purchase
     */
    public static void setMoney(int cost){
        userMoney = userMoney - cost;
    }

    /**
     * Setter Method that adds money to the user's money
     */
    public static void addMoney(int money){
        userMoney = userMoney + money;
    }

    /**
     * Getter Method that returns a int value of the user's money
     */
    public static int getMoney(){
        return userMoney;
    }

    /**
     * Setter Method that sets the score variable
     */
    public static void addScore(int points){
        score = score + points;
    }
}