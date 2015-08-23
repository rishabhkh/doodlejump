import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
       
    public GameOver(int score){        
        GreenfootImage img = getImage();
        
        img.setColor(Color.BLACK);        
        Font font = new Font("Serif",Font.PLAIN,30);
        img.setFont(font);
        
        img.drawString(score+"",264,406);
    }   
       
}
