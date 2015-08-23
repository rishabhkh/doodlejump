import greenfoot.*;
import java.util.*;
public class Jumper extends Actor
{
    private static final int GRAVITY = 1;
    private static final int INITIAL_JUMP_SPEED = 22;
    private static final int YSMOOTH_FACTOR = 1;
    private static final int XSMOOTH_FACTOR = 1;
    private static final int HORIZONTAL_SPEED = 10;
    public static final int BOUNDARY = Background.WORLD_HEIGHT/2;  

    public int ySpeed;
    private int xSpeed;    

    public boolean jumpFlag;
    private boolean lFlag;
    private boolean rFlag; 
    public boolean upFlag;
    public boolean freezeFlag;
    public int countYSpeed;
    private int countXSpeed;
    private int countShoot;
    private Score s1;

    public Jumper(){
        ySpeed = INITIAL_JUMP_SPEED;
        xSpeed = HORIZONTAL_SPEED;        
    }        

    public void act()
    {   shoot();
        checkAndMoveLeft();
        checkAndMoveRight();
        jump();                
        isGameOver();
        checkAtEdge();       
    }

    public void checkAtEdge()
    {
        if(getX()<10)
        {
            setLocation(Background.WORLD_WIDTH-10,getY());
        }
        else if(getX()>Background.WORLD_WIDTH-10)
        {
            setLocation(10,getY());
            
        }

    }
    
    public void checkAndMoveLeft(){        
        if(Greenfoot.isKeyDown("Left"))
        {   lFlag = true;
            rFlag=false;
            xSpeed=HORIZONTAL_SPEED;
            setLocation(getX() - xSpeed , getY());
            setImage("doodleL.png");
        }   
        else if(lFlag && xSpeed>0)
        {   setImage("doodleL.png");
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
            setImage("doodleR.png");
        } 
        else if(rFlag && xSpeed>0)
        {   setImage("doodleR.png");
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
            {   Greenfoot.playSound("jump.mp3");     
                jumpFlag = true;
                upFlag = true;
            }
            else if(upFlag&&jumpFlag)
            {   
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
                if(getY() >= (Background.WORLD_HEIGHT-10))
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
            
            Platform p = (Platform)getOneIntersectingObject(Platform.class);
            if(p!=null&&!upFlag&&p.shouldJumpFlag)
            {  
                jumpFlag = false;
                countYSpeed=0;            
                ySpeed = INITIAL_JUMP_SPEED;
            }
        }
        else
        {   scoreDoodle();
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
            {    getWorld().addObject(new Bullet(),getX(),getY()-30);
                 setImage("doodleS.png");
                 Greenfoot.playSound("shoot.mp3");
            }            
        }  
        else        
        {   
            if(countShoot!=0)
                setImage("doodleL.png");
            countShoot = 0;            
        }
    }
    public void isGameOver(){        
        if (isTouching(Monster.class) || getY() >=590)
        {
            World w = getWorld();
            Greenfoot.playSound("fall.wav");
            w.addObject(new GameOver(s1.score),w.getWidth()/2,w.getHeight()/2);           
            Greenfoot.stop();            
        }
    }
    public void scoreDoodle(){
        World w = getWorld();       
        s1 = ((Background)getWorld()).score;        
        s1.addScore();
    }
}
