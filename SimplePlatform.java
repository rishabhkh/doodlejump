import greenfoot.*;

/**
 * Write a description of class SimplePlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimplePlatform extends Platform
{  
    
    
    
    public void act() 
    {
        scroll(((Background)getWorld()).jumper);
        removeIfAtEdge();
    }    
}
