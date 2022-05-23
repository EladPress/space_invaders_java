import java.awt.*;

import javax.swing.ImageIcon;
public class Enemy
{
    public int healthPoints, x, y, width, height, speed;
    volatile int direction;
    public SpaceInvadersPanel panel;
    ImageIcon image;
    
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
        Classes.sound("Assets/InvaderHit.wav");
    }
}
