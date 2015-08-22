import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public int score;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Score()
    {
        score = 0;
        setImage(new GreenfootImage(200,30));
        update();
    }
    //String score = "Score : 0";
    public void addScore() 
    {
        score++;
        update();
    }
    public void update()
    { 
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.BLACK);
        img.drawString("Score:  " + score,4,20);
    }
}
