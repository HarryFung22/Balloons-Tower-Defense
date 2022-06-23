import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This is the superclass for all monkeys
 * Helps differentiate between tower types, by adjusting their individual properties
 * 
 * <p> Dart Sound (Dart Sound effect HD): https://www.youtube.com/watch?v=pS7uyUNmQ08
 * <p> Bomb Sound (Force push sound): https://www.youtube.com/watch?v=mvtBFHT8fWY
 * <p> Sniper Sound (BOCW LW3 Tundra Sound): https://www.youtube.com/watch?v=P2Yi0vfA2ZQ
 * <p> Laser Sound (Laser gun sound effect): https://www.youtube.com/shorts/FsLkXXOyeRI
 * <p> Upgrade sound (Clash of Clans Elixir collect sound): https://www.youtube.com/watch?v=pjEfqcqnq_4 
 * <p> Sell sound (Tower Defense Simulator upgrade sound (roblox)): https://www.youtube.com/watch?v=1zK9yj6QY8A
 * 
 * @author Harry F, Aiden S 
 * @version June 23 2022
 */
public abstract class Monkeys extends Actor
{
    //instances variables that will be unique to every single monkey
    int fireRate, attackSpeed, cost, level, upgradeCost, sellCost;

    //checks if the tower has been bought
    boolean isBought = false;

    //strings to display monkey name, etc
    String type, name, title;

    //used for the targeting system
    Balloon targetBalloon;
    CamoBalloon targetCamoBalloon;
    MetalBalloon targetMetalBalloon;

    //variable that reads the mouse button
    MouseInfo mouse = Greenfoot.getMouseInfo();

    //gets the range of each tower
    int balloonRange;

    //Variable to check if the tower is opened
    boolean stats = false;
    boolean poor = false;

    //Variable used to set the user's money
    int balance;

    //projectile sounds
    GreenfootSound Dart = new GreenfootSound("Dart Sound.wav");
    GreenfootSound Bomb = new GreenfootSound("Bomb Sound.wav");
    GreenfootSound Sniper = new GreenfootSound("Sniper Sound.wav");
    GreenfootSound Laser = new GreenfootSound("Laser Sound.wav");

    //upgrade and sell sounds
    GreenfootSound upgrade = new GreenfootSound("Upgrade.wav");
    GreenfootSound Sold = new GreenfootSound("Sold.wav");

    /**
     * This is the act method which will be used for interactions between the monkey and 
     * the world
     */
    public void act()
    {
        if(!Greenfoot.mouseClicked(this)){
            //center the monkey into the closest 50x50 grid
            //updates the user's money
            balance = ((GameWorld)getWorld()).getMoney();

            if(isBought == false){
                buyTower(cost);
                isBought = true;
                setLocation((mouse.getX() / 50) * 50 + 25, (mouse.getY() / 50) * 50 + 25);
            }
        } 
        //If the user clicks on the tower and the menu is turned OFF
        else if(isBought == true && Greenfoot.mouseClicked(this) && stats == false){
            //Makes sure no other menus are turned on
            if(((GameWorld)getWorld()).getStatOpen() == false){
                //display title
                title = (name + " lvl." + level);
                //Turns on the menu
                stats = true;
                ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(), stats, upgradeCost, sellCost, getX(), getY());
            }
        }
        //If the user clicks on the green arrow and the menu is turned on
        else if(isBought == true && Greenfoot.mouseClicked(this) && stats == true){
            //checks if the menu was on
            if(((GameWorld)getWorld()).getStatOpen() == true){
                //turns off the menu
                stats = false;
                ((GameWorld)getWorld()).menu(title, 0, 0, stats, upgradeCost, sellCost,getX(), getY());
            }
        }

        //Checks if the user wants to upgrade the monkey
        if(stats && ((GameWorld)getWorld()).getUpgraded() == true && balance - upgradeCost >= 0){
            //if the tower isn't level 5
            if(level <= 4){
                //upgrade sound effect
                upgrade.play();
                //updates tower level
                level++;
                title = (name + " lvl." + level);
                //checks if the attackSpeed is above 1
                if(attackSpeed > 1){
                    //upgrades the attackSpeed (which is a delay)
                    //lower delay = more rapid firing
                    attackSpeed = attackSpeed - 4;
                }

                //turns on the menu if tower is upgraded
                stats = false;

                //Updates the UI, calls the menu method from GameWorld to put stats onto Labels
                ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(),stats, upgradeCost, sellCost, getX(), getY());

                //Updates the user's money (reduces money since they just upgraded)
                ((GameWorld)getWorld()).setMoney(upgradeCost);
            }else if(level >= 5){
                ((GameWorld)getWorld()).setUpgraded(false);
            }
            //Turn off the request for upgrading in GameWorld
            ((GameWorld)getWorld()).setUpgraded(false);
        }

        //if user doesn't have enough money to upgrade, closes menu
        if(stats && ((GameWorld)getWorld()).getUpgraded() == true && balance - upgradeCost < 0) {
            stats = false;

            ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(),stats, upgradeCost, sellCost, getX(), getY());
        }

        //sets the upgraded variable in GameWorld to false if menu is off
        //used so that tower doesn't get auto placed once the user gets enough money
        //(after they clicked the upgraded button)
        if(((GameWorld)getWorld()).isOn() == false){
            ((GameWorld)getWorld()).setUpgraded(false);
        }

        //if the user wants to sell the tower
        if(stats && ((GameWorld)getWorld()).getSold() == true){
            //play sell sound effect
            Sold.play();
            //turns off the tower menu
            stats = false;
            ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(), stats, upgradeCost, sellCost, getX(), getY());
            //Gives the user money back
            ((GameWorld)getWorld()).setMoney(-1 * sellCost);
            //Turn off the selling request in GameWorld
            ((GameWorld)getWorld()).setSold(false);
            //removes the tower
            getWorld().removeObject(this);
        }
    }

    /**
     * Method that detects the closest balloon, takes in a string as an input to differentiate
     * which projectile should be fired by which tower (since all towers attack normal balloons)
     */
    protected void findBalloon(String type){
        //add delay
        fireRate++;
        double distanceToActor;
        double closestTargetDistance = 0;

        balloonRange = 200;
        ArrayList<Balloon> balloon = (ArrayList<Balloon>)getObjectsInRange(balloonRange, Balloon.class);
        if(!balloon.isEmpty()){
            targetBalloon = balloon.get(0);
            closestTargetDistance = GameWorld.getDistance(this, targetBalloon);
            for(Balloon b : balloon){
                distanceToActor = GameWorld.getDistance(this, b);
                if(distanceToActor < closestTargetDistance){
                    targetBalloon = b;
                    closestTargetDistance = distanceToActor;                
                }
            }
            turnTowards(targetBalloon.getX(), targetBalloon.getY());
            //checks the monkey type, fires different projectiles depending on the monkey type
            if(type == "DartMonkey"){
                shootDart();
            }else if (type == "Cannon"){
                shootBomb();
            }else if (type == "SniperMonkey"){
                shootSniper();
            }else if(type == "SuperMonkey"){
                shootLaser();
            }
        } else if(balloon.isEmpty()){
        }
    }

    /**
     * Method that detects the closest camo balloon
     */
    protected void findCamo(){
        //add delay
        fireRate++;
        double distanceToActor;
        double closestTargetDistance = 0;

        balloonRange = 400;
        ArrayList<CamoBalloon> cballoon = (ArrayList<CamoBalloon>)getObjectsInRange(balloonRange, CamoBalloon.class);
        if(!cballoon.isEmpty()){
            targetCamoBalloon = cballoon.get(0);
            closestTargetDistance = GameWorld.getDistance(this, targetCamoBalloon);
            for(CamoBalloon b : cballoon){
                distanceToActor = GameWorld.getDistance(this, b);
                if(distanceToActor < closestTargetDistance){
                    targetCamoBalloon = b;
                    closestTargetDistance = distanceToActor;                
                }
            }
            turnTowards(targetCamoBalloon.getX(), targetCamoBalloon.getY());
            shootSniper();
        } else if(cballoon.isEmpty()){
        }
    }

    /**
     * Method that detects the closest metal balloon
     */
    protected void findMetal(){
        //add delay
        fireRate++;
        double distanceToActor;
        double closestTargetDistance = 0;

        balloonRange = 150;
        ArrayList<MetalBalloon> mballoon = (ArrayList<MetalBalloon>)getObjectsInRange(balloonRange, MetalBalloon.class);
        if(!mballoon.isEmpty()){
            targetMetalBalloon = mballoon.get(0);
            closestTargetDistance = GameWorld.getDistance(this, targetMetalBalloon);
            for(MetalBalloon b : mballoon){
                distanceToActor = GameWorld.getDistance(this, b);
                if(distanceToActor < closestTargetDistance){
                    targetMetalBalloon = b;
                    closestTargetDistance = distanceToActor;                
                }
            }
            turnTowards(targetMetalBalloon.getX(), targetMetalBalloon.getY());
            shootBomb();
        } else if(mballoon.isEmpty()){
        }
    }

    /**
     * Method to shoot the dart projectile towards the closest balloon
     */
    protected void shootDart(){
        if(fireRate > attackSpeed){
            Dart d = new Dart();
            getWorld().addObject(d, getX(), getY());
            d.turnTowards(targetBalloon.getX(), targetBalloon.getY());
            fireRate = 0;
            Dart.setVolume(85);
            Dart.play();
        }
    }

    /**
     * Method to shoot the laser projectile towards the closest balloon
     */
    protected void shootLaser(){
        if(fireRate > attackSpeed){
            Laser l = new Laser();
            getWorld().addObject(l, getX(), getY());
            l.turnTowards(targetBalloon.getX(), targetBalloon.getY());
            fireRate = 0;
            Laser.setVolume(90);
            Laser.play();
        }
    }

    /**
     * Method to shoot the bomb projectile towards the closest metal balloon or balloon
     * Bomb tower will prioritize metal balloons, thus an arraylist is used to get the size of
     * the metal balloon class. If it is 0, it will attack normal balloons
     */
    protected void shootBomb(){
        ArrayList<MetalBalloon> mBalloon = (ArrayList<MetalBalloon>)getWorld().getObjects(MetalBalloon.class);

        if(fireRate > attackSpeed){
            Bomb b = new Bomb();
            getWorld().addObject(b, getX(), getY());
            if(mBalloon.size() > 0){
                b.turnTowards(targetMetalBalloon.getX(), targetMetalBalloon.getY());
            }else{
                b.turnTowards(targetBalloon.getX(), targetBalloon.getY());
            }
            fireRate = 0;
            Bomb.setVolume(80);
            Bomb.play();
        }
    }

    /**
     * Method to shoot the sniper dart projectile towards the closest camo balloon or balloon
     * Sniper tower will prioritize camo balloons, thus an arraylist is used to get the size of
     * the camo balloon class. If it is 0, it will attack normal balloons
     */
    protected void shootSniper(){
        ArrayList<CamoBalloon> cBalloon = (ArrayList<CamoBalloon>)getWorld().getObjects(CamoBalloon.class);

        if(fireRate > attackSpeed){
            SniperDart s = new SniperDart();
            getWorld().addObject(s, getX(), getY());
            if(cBalloon.size() > 0){
                s.turnTowards(targetCamoBalloon.getX(), targetCamoBalloon.getY());
            }else{
                s.turnTowards(targetBalloon.getX(), targetBalloon.getY());
            }
            fireRate = 0;
            Sniper.setVolume(90);
            Sniper.play();
        }
    }

    /**
     * Method used to change the user's money count if a monkey has been purchases/placed
     */
    public void buyTower(int cost){
        ((GameWorld) getWorld()).setMoney(cost);
    }

    /**
     * Getter method that returns the monkeys's range
     */
    public int getRange(){
        return balloonRange;
    }

    /**
     * Setter method that sets's the "stats" boolean variable
     */
    public void setTowerStats(boolean b){
        stats = b;
    }
}

