import greenfoot.*;

/**
 * Write a description of class BrittlePlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrittlePlatform extends Platform
{
    /**
     * Act - do whatever the BrittlePlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean flagGoDown;

    public BrittlePlatform()
    {
        shouldJumpFlag = false;
    }

    public void act() 
    {
        scroll(((Background)getWorld()).jumper);
        checkAndBreak();
        checkAndGoDown();   
        removeIfAtEdge();
    }

    public void checkAndBreak()
    {
        if(isTouching(Jumper.class)&&!((Background)getWorld()).jumper.upFlag)
        {   flagGoDown=true;
            setImage("p-brown-3.png");            
        }
    }
    
    public void checkAndGoDown()
    {
        if(flagGoDown)
            setLocation(getX(),getY()+30);
    }

}
