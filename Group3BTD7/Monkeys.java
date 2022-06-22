import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Monkeys here.
 * 
 * @author Harry F 
 * @version (a version number or a date)
 */
public abstract class Monkeys extends Actor
{
    int fireRate, attackSpeed, cost, level, upgradeCost, sellCost;

    boolean isBought = false;

    String type, name, title;

    Balloon targetBalloon;
    CamoBalloon targetCamoBalloon;
    MetalBalloon targetMetalBalloon;

    MouseInfo mouse = Greenfoot.getMouseInfo();

    int balloonRange;

    boolean stats = false;
    boolean poor = false;

    int balance;

    /**
     * Act - do whatever the Monkeys wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Pathing p = (Pathing)getOneIntersectingObject(Pathing.class);
        Square s = (Square)getOneIntersectingObject(Square.class);
        SelectMonkey sel = (SelectMonkey)getOneIntersectingObject(SelectMonkey.class);
        Monkeys m = (Monkeys)getOneIntersectingObject(Monkeys.class);
        if(!Greenfoot.mouseClicked(this)){
            balance = ((GameWorld)getWorld()).getMoney();

            if(isBought == false){
                buyTower(cost);
                isBought = true;
                setLocation((mouse.getX() / 50) * 50 + 25, (mouse.getY() / 50) * 50 + 25);
            }
        } else if(isBought == true && Greenfoot.mouseClicked(this) && stats == false){
            if(((GameWorld)getWorld()).getStatOpen() == false){
                title = (name + " lvl." + level);
                stats = true;
                ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(), stats, upgradeCost, sellCost, getX(), getY());
            }
        }else if(isBought == true && Greenfoot.mouseClicked(this) && stats == true){
            if(((GameWorld)getWorld()).getStatOpen() == true){
                stats = false;
                ((GameWorld)getWorld()).menu(title, 0, 0, stats, upgradeCost, sellCost,getX(), getY());
            }
        }

        if(stats && ((GameWorld)getWorld()).getUpgraded() == true && balance - upgradeCost >= 0){
            if(level <= 4){
                level++;
                title = (name + " lvl." + level);
                if(attackSpeed > 1){
                    attackSpeed = attackSpeed - 4;
                }

                stats = false;

                ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(),stats, upgradeCost, sellCost, getX(), getY());

                ((GameWorld)getWorld()).setMoney(upgradeCost);
            }
            ((GameWorld)getWorld()).setUpgraded(false);
        }else if(stats && ((GameWorld)getWorld()).getUpgraded() == true && balance - upgradeCost < 0) {
            stats = false;

            ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(),stats, upgradeCost, sellCost, getX(), getY());
        }

        if(((GameWorld)getWorld()).isOn() == false){
            ((GameWorld)getWorld()).setUpgraded(false);
        }
        if(stats && ((GameWorld)getWorld()).getSold() == true){
            stats = false;
            ((GameWorld)getWorld()).menu(title, attackSpeed, getRange(), stats, upgradeCost, sellCost, getX(), getY());
            ((GameWorld)getWorld()).setMoney(-1 * sellCost);
            ((GameWorld)getWorld()).setSold(false);
            getWorld().removeObject(this);
        }
    }

    protected void findBalloon(String type){
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

    protected void findCamo(){
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

    protected void findMetal(){
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

    protected void shootDart(){
        if(fireRate > attackSpeed){
            Dart d = new Dart();
            getWorld().addObject(d, getX(), getY());
            d.turnTowards(targetBalloon.getX(), targetBalloon.getY());
            fireRate = 0;
        }
    }
    
    protected void shootLaser(){
        if(fireRate > attackSpeed){
            Laser l = new Laser();
            getWorld().addObject(l, getX(), getY());
            l.turnTowards(targetBalloon.getX(), targetBalloon.getY());
            fireRate = 0;
        }
    }

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
        }
    }

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
        }
    }

    public void buyTower(int cost){
        ((GameWorld) getWorld()).setMoney(cost);
    }

    public int getRange(){
        return balloonRange;
    }

    public void setTowerStats(boolean b){
        stats = b;
    }
}

