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
    {
        scroll(((Background)getWorld()).jumper);
        removeIfAtEdge();
    }    
}
