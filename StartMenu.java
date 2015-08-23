import greenfoot.*;

/**
 * Write a description of class StartMenu1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{
    public StartMenu()
    {    
        super(Background.WORLD_WIDTH, Background.WORLD_HEIGHT, 1); 
    }

    public void act()
    {   
        checkIfPlayClicked();
    }

    private void checkIfPlayClicked()
    {
        MouseInfo mInfo = Greenfoot.getMouseInfo();
        if(mInfo!=null&&Greenfoot.mouseClicked(this))        
        {   
            int x= mInfo.getX();
            int y=mInfo.getY();            
            if(x<=200&&x>=70&&y<=207&&y>=159)
            {
               launchBackground(); 
            }
        }
    }
    
    private void launchBackground()
    {
        Background back = new Background();
        Greenfoot.setWorld(back); 
    }
}