import greenfoot.*;

/**
 * Write a description of class SpringPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpringPlatform extends Platform
{
    /**
     * Act - do whatever the SpringPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   Jumper j = ((Background)getWorld()).jumper;
        scroll(((Background)getWorld()).jumper);
        
        if(isTouching(Jumper.class)&&!j.upFlag)
        {  
            j.jumpFlag = false;
            j.countYSpeed=0;            
            j.ySpeed = 45;
        }
        removeIfAtEdge();
    }    
}
