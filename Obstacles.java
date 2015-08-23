import greenfoot.*;

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor
{
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {       
    }    
    
    public void scroll(Jumper jumper)
    {        
        if(jumper.freezeFlag&&jumper.ySpeed>=0)
        {
            setLocation(getX(),getY()+jumper.ySpeed);
        }       
    }
    public void removeIfAtEdge()
    {
         if(isAtEdge())
            getWorld().removeObject(this);
    }
}
