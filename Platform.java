import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int CUT_OFF = 300;
    
    private int initialy;
    private boolean isFirstFlag = true;
    int speed;
  
    public void act() 
    {   
        Jumper jumper = ((Background)getWorld()).jumper;
        if(jumper.hold&&jumper.speed>=0)
        {
            setLocation(getX(),getY()+jumper.speed);
        }
        if(isAtEdge())
            getWorld().removeObject(this);
        
        
        
        
        
    }
        
    }    

