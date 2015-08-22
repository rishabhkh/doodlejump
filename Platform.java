import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
//     GreenfootImage image;
//     image = new GreenfootImage(getWidth(), getHeight());
    public void act() 
    {   
        //image.drawString("Score: " + score, 20, 20);
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

