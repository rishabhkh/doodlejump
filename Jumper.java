import greenfoot.*;
import java.util.*;
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
        //score_doodle();
        IsGameOver();
        if(isTouching(SpringPlatform.class)&&!upFlag)
        {  // jumpHeight = platform.getY()-400;
            jumpFlag = false;
            countYSpeed=0;            
            ySpeed = 60;
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
            setImage("doodleR.png");
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
                    score_doodle();
                    
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
            setImage("doodleS.png");
        }  
        else
        {    countShoot = 0;
            setImage("doodleR.png");
        }
    }
    public void IsGameOver(){
        //boolean gameo= false
        if (isTouching(Monster.class) || getY() >590)
        {
            World w = getWorld();
            Greenfoot.playSound("fall.wav");
            w.addObject(new GameOver(),w.getWidth()/2,w.getHeight()/2);
           // w.addObject(new Jumper(),w.getWidth()/2,w.getHeight()/2);
            //k.gamever();
            Greenfoot.stop();
            //gameo = true;
            //return gameo;
        }
    }
    public void score_doodle(){
        World w = getWorld();
        List <Score> s = w.getObjects(Score.class); 
        Score s1 = s.get(0);
        int presentscore = s1.score;
        s1.addScore();
//         if(getY() == 200){
//             while(s1.score < presentscore + 20){
//                 
//                 s1.addScore();
//                 s1.update();
//             }
//         }
    }
}
