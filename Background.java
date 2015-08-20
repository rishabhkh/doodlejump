import greenfoot.*;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    public static int worldWidth = 300;
    public static int worldHeight = 550; 
    
    Jumper jumper;
    private int NUMBER_OF_NEW_PLATFORMS=1;
    

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidth, worldHeight, 1); 
        prepare();
    }

    public void act()
    {
        if(jumper.freezeFlag&&(Greenfoot.getRandomNumber(100)<20))
            createPlatforms(NUMBER_OF_NEW_PLATFORMS);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     * 
     */
    public void createPlatforms(int n){
        for(int i=1;i<=n;i++)
            addObject(new SimplePlatform(), Greenfoot.getRandomNumber(worldWidth), Greenfoot.getRandomNumber(40)-20);  
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
    }
}
