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
    protected int fireRate, attackSpeed, cost, level, upgradeCost, sellCost;

    protected boolean isBought = false;

    protected String type, name, title;

    protected Balloon targetBalloon;
    protected CamoBalloon targetCamoBalloon;
    protected MetalBalloon targetMetalBalloon;

    MouseInfo mouse = Greenfoot.getMouseInfo();
    
    /**
     * Act - do whatever the Monkeys wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    protected void findBalloon(String type){
        double distanceToActor;
        double closestTargetDistance = 0;

        ArrayList<Balloon> balloon = (ArrayList<Balloon>)getObjectsInRange(200, Balloon.class);
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
                shootDart();
            }
        } else if(balloon.isEmpty()){
        }
    }

    protected void findCamo(){
        double distanceToActor;
        double closestTargetDistance = 0;

        ArrayList<CamoBalloon> cballoon = (ArrayList<CamoBalloon>)getObjectsInRange(400, CamoBalloon.class);
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
        double distanceToActor;
        double closestTargetDistance = 0;

        ArrayList<MetalBalloon> mballoon = (ArrayList<MetalBalloon>)getObjectsInRange(150, MetalBalloon.class);
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
        fireRate++;
        if(fireRate > attackSpeed){
                Dart d = new Dart();
                getWorld().addObject(d, getX(), getY());
                d.turnTowards(targetBalloon.getX(), targetBalloon.getY());
                fireRate = 0;
            }
    }
    
    protected void shootBomb(){
        ArrayList<MetalBalloon> mBalloon = (ArrayList<MetalBalloon>)getWorld().getObjects(MetalBalloon.class);
        
        fireRate++;
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
        
        fireRate++;
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
}

