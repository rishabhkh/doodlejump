import greenfoot.*;

public class Jumper extends Actor
{
    private static final int JUMP_HEIGHT = 200;
    private static final int GRAVITY = 1;
    private static final int INITIAL_JUMP_SPEED = 20;
    private static final int SMOOTH_FACTOR = 1;
    private static final int XSMOOTH_FACTOR = 1;
    private static final int HORIZONTAL_SPEED = 10;
    public static final int BOUNDARY = 150;

    
    public static int jumpPosition;

    public int speed = INITIAL_JUMP_SPEED;

    public boolean upFlag = false;
    private boolean jumpFlag = false;
    private boolean lFlag = false;
    private boolean rFlag = false;
    private int xspeed = HORIZONTAL_SPEED;

    int jumpHeight = JUMP_HEIGHT;

    private int countSpeed = 0;
    private int countXSpeed = 0; 
    private Platform previousPlatform;

    public static boolean movePlats = false;
    public boolean hold = false;
    public int holdcount = 0;
    public static int moveAmount = 0;

    public void act()
    {  // System.out.println(speed);
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

        if(!(hold)) {
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
                if(speed==0)
                {  
                    upFlag = false;
                    countSpeed=0;
                }
                if(getY()<=BOUNDARY)
                {
                    hold =true;
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

            if(isTouching(Platform.class)&&!upFlag)
            {  // jumpHeight = platform.getY()-400;
                jumpFlag = false;
                countSpeed=0;            
                speed = INITIAL_JUMP_SPEED;
            }               
            

        }
        else
        {
            speed--;
            if(speed<=0)
            {
                hold=false;
                upFlag=false;
                speed =0;
                //speed=INITIAL_JUMP_SPEED;
            }
        }

       
    }
}
