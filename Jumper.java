import greenfoot.*;

public class Jumper extends Actor
{
    private static final int GRAVITY = 1;
    private static final int INITIAL_JUMP_SPEED = 22;
    private static final int YSMOOTH_FACTOR = 1;
    private static final int XSMOOTH_FACTOR = 1;
    private static final int HORIZONTAL_SPEED = 10;
    public static final int BOUNDARY = Background.worldHeight/2;  

    public int ySpeed;
    private int xSpeed;    

    private boolean jumpFlag;
    private boolean lFlag;
    private boolean rFlag; 
    public boolean upFlag;
    public boolean freezeFlag;

    private int countYSpeed;
    private int countXSpeed;
    private int countShoot;

    public Jumper(){
        ySpeed = INITIAL_JUMP_SPEED;
        xSpeed = HORIZONTAL_SPEED;
    }        

    public void act()
    {   
        checkAndMoveLeft();
        checkAndMoveRight();
        jump();
        shoot();
    }

    public void checkAndMoveLeft(){        
        if(Greenfoot.isKeyDown("Left"))
        {   lFlag = true;
            rFlag=false;
            xSpeed=HORIZONTAL_SPEED;
            setLocation(getX() - xSpeed , getY());            
        }   
        else if(lFlag && xSpeed>0)
        {
            setLocation(getX() - xSpeed , getY());
            countXSpeed++;
            if(countXSpeed==XSMOOTH_FACTOR)
            {    xSpeed--;
                countXSpeed=0;
            }
        }  
    }

    public void checkAndMoveRight(){        
        if(Greenfoot.isKeyDown("Right"))
        {   rFlag = true;
            lFlag = false;
            xSpeed=HORIZONTAL_SPEED;
            setLocation(getX() + xSpeed , getY());            
        } 
        else if(rFlag && xSpeed>0)
        {
            setLocation(getX() + xSpeed , getY());
            countXSpeed++;
            if(countXSpeed==XSMOOTH_FACTOR)
            {
                xSpeed--;
                countXSpeed=0;
            }
        }
    }

    public void jump(){

        if(!(freezeFlag)) {
            if(!jumpFlag&&!upFlag)
            {        
                jumpFlag = true;
                upFlag = true;
            }
            else if(upFlag&&jumpFlag)
            {   //System.out.println("Speed="+Speed);
                setLocation(getX(),getY()-ySpeed);
                countYSpeed++;
                if(countYSpeed == YSMOOTH_FACTOR)
                {
                    ySpeed-=GRAVITY;
                    countYSpeed=0;
                }
                if(ySpeed==0)
                {  
                    upFlag = false;
                    countYSpeed=0;
                }
                if(getY()<=BOUNDARY)
                {
                    freezeFlag =true;
                }
            }
            else if((!upFlag)&&jumpFlag)        
            {
                setLocation(getX(),getY()+ySpeed);
                countYSpeed++;
                if(countYSpeed == YSMOOTH_FACTOR)
                {
                    ySpeed+=GRAVITY;
                    countYSpeed=0;
                }
                if(getY() >= (Background.worldHeight-20))
                {
                    upFlag = false;
                    jumpFlag = false;
                    lFlag = false;
                    rFlag = false;
                    xSpeed = HORIZONTAL_SPEED;
                    countYSpeed = 0;
                    ySpeed = INITIAL_JUMP_SPEED;
                }
            }

            if(isTouching(Platform.class)&&!upFlag)
            {  // jumpHeight = platform.getY()-400;
                jumpFlag = false;
                countYSpeed=0;            
                ySpeed = INITIAL_JUMP_SPEED;
            }               

        }
        else
        {
            ySpeed--;
            if(ySpeed<=0)
            {
                freezeFlag=false;
                upFlag=false;
                ySpeed =0;                
            }
        }

    } 
    
    public void shoot(){
       
        if(Greenfoot.isKeyDown("space"))          
        {   countShoot++;
            if(countShoot == 1)
                getWorld().addObject(new Bullet(),getX(),getY()-30);
        }  
        else
            countShoot = 0;   
    }
}
