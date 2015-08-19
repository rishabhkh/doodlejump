import greenfoot.*;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    Jumper jumper;
    private int NUMBER_OF_NEW_PLATFORMS=3;
    private boolean justCrossed = true;
    
    
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        prepare();
    }

    public void act()
    {
        if(jumper.upFlag && (jumper.getY()<Platform.CUT_OFF))
        {
            //if(justCrossed)
           // { 
               //if(Greenfoot.getRandomNumber(100)<50)
               //createPlatforms(4);
             //   justCrossed = false;
          //  }
        }       
     //   else
       //     justCrossed = true;
      
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     * 
     */
    public void createPlatforms(int n){
        for(int i=1;i<=n;i++)
            addObject(new Platform(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(40)-20)  ;  
    }
      

    private void prepare()
    {
        jumper = new Jumper();
        addObject(jumper, 23, 373);             

        Platform platform = new Platform();
        addObject(platform, 66, 331);
        Platform platform2 = new Platform();
        addObject(platform2, 160, 263);
        Platform platform3 = new Platform();
        addObject(platform3, 548, 183);
        Platform platform4 = new Platform();
        addObject(platform4, 420, 322);
        Platform platform5 = new Platform();
        addObject(platform5, 371, 153);
        platform.setLocation(85, 520);
        platform2.setLocation(201, 361);
        platform4.setLocation(363, 477);
        platform5.setLocation(383, 282);
        platform3.setLocation(667, 235);
        jumper.setLocation(80, 479);
    }
}
