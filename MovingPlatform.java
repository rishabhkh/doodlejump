import greenfoot.*;

/**
 * Write a description of class MovingPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingPlatform extends Platform
{
    private boolean moveRight;
    public void act() 
    {
        scroll(((Background)getWorld()).jumper);        
        moveHorizontal();
        removeIfAtEdge();
    }
    
    private void moveHorizontal(){
        if(moveRight)
        {   move(5);
            if(getX()>=470)
                moveRight = false;
        }   
        else
        {   move(-5);
            if(getX()<=30)
                moveRight = true;
        }     
    }
}
