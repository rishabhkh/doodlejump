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
    
  
    public void act() 
    {   
       Background background = (Background)getWorld(); 
       if(isFirstFlag)
       {
           initialy = getY();
           isFirstFlag = false;           
       }
                      
        
        if(background.jumper.upFlag && (background.jumper.getY()<CUT_OFF))
        {
            int diff = CUT_OFF-background.jumper.getY();
            setLocation(getX(),initialy+diff);      
        }   
        else
            initialy=getY();
        
        if(isAtEdge())
            getWorld().removeObject(this);
        
    }
        
    }    

