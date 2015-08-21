import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{   
    private static int BULLET_SPEED = 20;
    private boolean isActive = true;
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()-BULLET_SPEED);
        hitMonster();
        if(isActive&&isAtEdge())
            getWorld().removeObject(this); 
       
    }
    
    
    
    
    public void hitMonster() 
    {
        Bat b = (Bat)getOneIntersectingObject(Bat.class);
        if(b!=null)
        {   getWorld().removeObject(b);
            getWorld().removeObject(this);
            isActive = false;
            
        }
    }
    
    
    
    
    
}
