import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
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

