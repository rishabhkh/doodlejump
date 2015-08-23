import greenfoot.*;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{   
    public static final int NUMBER_OF_NEW_PLATFORMS = 1;
    public static final int WORLD_WIDTH = 500;
    public static final int WORLD_HEIGHT = 600; 
    
    public Jumper jumper;
    public Score score;
    
    public Background()
    {    
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);        
        prepare();        
    }

    public void act()
    {
        if(jumper.freezeFlag&&(Greenfoot.getRandomNumber(100)<20))
            createPlatforms(NUMBER_OF_NEW_PLATFORMS);
        createMonster();
    }
    
    public void createPlatforms(int n){
        int random = Greenfoot.getRandomNumber(100);
        for(int i=1;i<=n;i++)
        {   
            if(random<85)
                addObject(new SimplePlatform(), Greenfoot.getRandomNumber(WORLD_WIDTH), Greenfoot.getRandomNumber(40)-20); 
            else if (random<90)
                addObject(new SpringPlatform(), Greenfoot.getRandomNumber(WORLD_WIDTH), Greenfoot.getRandomNumber(40)-20);
            else if(random<95)
                addObject(new BrittlePlatform(), Greenfoot.getRandomNumber(WORLD_WIDTH), Greenfoot.getRandomNumber(40)-20);
            else
                addObject(new MovingPlatform(), Greenfoot.getRandomNumber(WORLD_WIDTH), Greenfoot.getRandomNumber(40)-20);
        }
    }      

    public void createMonster(){
        if(Greenfoot.getRandomNumber(1000)<5)
            addObject(new Bat(), Greenfoot.getRandomNumber(WORLD_WIDTH), 0);
    }   
       
    private void prepare()
    {
        SimplePlatform simpleplatform = new SimplePlatform();
        addObject(simpleplatform, 160, 459);
        SimplePlatform simpleplatform2 = new SimplePlatform();
        addObject(simpleplatform2, 299, 399);
        SimplePlatform simpleplatform3 = new SimplePlatform();
        addObject(simpleplatform3, 109, 350);
        SimplePlatform simpleplatform4 = new SimplePlatform();
        addObject(simpleplatform4, 285, 298);
        SimplePlatform simpleplatform5 = new SimplePlatform();
        addObject(simpleplatform5, 137, 226);
        SimplePlatform simpleplatform6 = new SimplePlatform();
        addObject(simpleplatform6, 301, 164);
        jumper = new Jumper();
        addObject(jumper, 164, 432);
        score = new Score();
        addObject(score, 129, 64);
    }
}
