import greenfoot.*;

public class Jumper extends Actor
{
    private static final int JUMP_HEIGHT = 100;
    private static final int GRAVITY = 5;
    private static final int INITIAL_JUMP_SPEED = 25;
    private static final int SMOOTH_FACTOR = 2;
    private static final int XSMOOTH_FACTOR = 1;
    private static final int HORIZONTAL_SPEED = 10;
    
    
    
    public static int jumpPosition;
    
    private int speed = INITIAL_JUMP_SPEED;
   
    public boolean upFlag = false;
    private boolean jumpFlag = false;
    private boolean lFlag = false;
    private boolean rFlag = false;
    private int xspeed = HORIZONTAL_SPEED;
    
    private int countSpeed = 0;
    private int countXSpeed = 0; 
    private Platform previousPlatform;
    
    public void act()
    {   
        if(Greenfoot.isKeyDown("Left"))
        {   lFlag = true;
            rFlag=false;
            xspeed=HORIZONTAL_SPEED;
            setLocation(getX() - xspeed , getY());
           //countXSpeed = 0;
        }   
        else if(lFlag && xspeed>0)
        {
            setLocation(getX() - xspeed , getY());
            countXSpeed++;
            if(countXSpeed==XSMOOTH_FACTOR)
            {    xspeed--;
                countXSpeed=0;
            }
                
        }
            
        if(Greenfoot.isKeyDown("Right"))
        {   rFlag = true;
            lFlag = false;
            xspeed=HORIZONTAL_SPEED;
            setLocation(getX() + xspeed , getY());
           // countXSpeed = 0;
        } 
        else if(rFlag && xspeed>0)
        {
            setLocation(getX() + xspeed , getY());
            countXSpeed++;
            if(countXSpeed==XSMOOTH_FACTOR)
            {
                xspeed--;
                countXSpeed=0;
            }
        }
        
        
        if(!jumpFlag&&!upFlag)
        {        
            jumpFlag = true;
            upFlag = true;
            jumpPosition = getY();
            
        }

        else if(upFlag&&jumpFlag)
        {   //System.out.println("Speed="+speed);
            setLocation(getX(),getY()-speed);
            countSpeed++;
            if(countSpeed == SMOOTH_FACTOR)
            {
                speed-=GRAVITY;
                countSpeed=0;
            }
            if(speed<=0)
            {  
              upFlag = false;
              countSpeed=0;
            }
        }
        else if((!upFlag)&&jumpFlag)        
        {
            setLocation(getX(),getY()+speed);
            countSpeed++;
            if(countSpeed == SMOOTH_FACTOR)
            {
                speed+=GRAVITY;
                countSpeed=0;
            }
            if(getY() >= 580)
            {
                upFlag = false;
                jumpFlag = false;
                lFlag = false;
                rFlag = false;
                xspeed = HORIZONTAL_SPEED;
                countSpeed = 0;
                speed = INITIAL_JUMP_SPEED;
            }

        }
        Platform platform = (Platform)getOneIntersectingObject(Platform.class);
        if((platform!=null)&&!upFlag)
        {   
            jumpFlag = false;
            countSpeed=0;            
            speed = INITIAL_JUMP_SPEED;
        }               

    
       
    
    }
     
}
