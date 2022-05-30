import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

//import javax.swing.JOptionPane;

public class Shot extends Thread
{
    public int x, y, width, height, power, direction, speed;
    SpaceInvadersPanel panel;
    static File sound;
    
    public Shot(SpaceInvadersPanel panel)
    {
        this.x = 100;
        this.y = 600;
        this.width = 5;
        this.height = 10;
        this.power = 5;
        this.panel = panel;
        this.direction = 1;
        this.speed = 1;
        try {
            sound = Classes.getSound("shipBullet");
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

    public Shot(int x, int y, int width, int height, int power, SpaceInvadersPanel panel)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.power = power;
        this.panel = panel;
        this.direction = 1;
        this.speed = 1;
        try {
            sound = Classes.getSound("shipBullet");
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
    public Shot(int x, int y, int power, SpaceInvadersPanel panel)
    {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.power = power;
        this.panel = panel;
        this.direction = 1;
        this.speed = 1;
        try {
            sound = Classes.getSound("shipBullet");
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
		g.setColor(Color.black);
		g.fillOval(x-width/2, y-width/2, width, height);
	}

    public void run()
    {
        
        boolean bool = false;
        while(this.y > -50 && !bool)
        {

            this.y-=this.direction;
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {}

           

            for(int i = 0; i < SpaceInvadersPanel.enemies.size(); i++)
            {
                if(hit(SpaceInvadersPanel.enemies.get(i)))
                {
                    SpaceInvadersPanel.enemies.get(i).hit();
                    SpaceInvadersPanel.shots.remove(this);
                    bool = true;
                }

            }
            for(int i = 0; i < SpaceInvadersPanel.enemyShots.size(); i++)
            {
                if(intercept(SpaceInvadersPanel.enemyShots.get(i)))
                {
                    SpaceInvadersPanel.enemyShots.remove(SpaceInvadersPanel.enemyShots.get(i));
                    SpaceInvadersPanel.enemyShots.remove(this);
                    bool = true;
                }
            }
            panel.repaint();
        }
        SpaceInvadersPanel.shots.remove(this);
        
    }

    public boolean hit(Enemy enemy)
    {
        Rectangle rect = new Rectangle(enemy.x, enemy.y, enemy.width, enemy.height);
        Rectangle rect2 = new Rectangle(this.x, this.y, this.width, this.height);

        return rect.intersects(rect2);
    }

    public boolean intercept(EnemyShot enemyShot)
    {
        Rectangle rect = new Rectangle(enemyShot.x, enemyShot.y, enemyShot.width, enemyShot.height);
        Rectangle rect2 = new Rectangle(this.x, this.y, this.width, this.height);

        return rect.intersects(rect2);
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public static void makeSound()
    {
        Classes.sound(sound);
    }

}

