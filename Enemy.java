import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
public class Enemy
{
    public int healthPoints, x, y, width, height, speed;
    volatile int direction;
    public SpaceInvadersPanel panel;
    ImageIcon image;
    static File sound;
    
    public Enemy(int x, int y, int width, int height, int healthPoints, int speed, SpaceInvadersPanel panel)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.direction = 1;
        this.panel = panel;
        try {
            this.sound = Classes.getSound("invaderHit");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void draw(Graphics g)
    {
        
    }

    public void hit()
    {
        makeSound();
        this.healthPoints -= 5;
        if(this.healthPoints <= 0)
        {
            SpaceInvadersPanel.enemies.remove(this);
        }
    }

    public static void makeSound()
    {
        Classes.sound(sound);
    }
}
