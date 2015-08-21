import greenfoot.*;

/**
 * Write a description of class Monsters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monsters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
