import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;


public class Player extends Thread
{
    int x, y, width, height, dir = 0, healthPoints = 15;
    SpaceInvadersPanel panel;
    ImageIcon image;

    public Player(SpaceInvadersPanel panel)
    {
        this.x = 200;
        this.y = 600;
        this.width = 30;
        this.height = 45;
        this.panel = panel;
        try {
            image = Classes.getImage("player");
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

    public void draw(Graphics g) throws UnknownHostException, ClassNotFoundException, IOException
    {
        g.setColor(Color.RED);
        //g.fillRect(this.x, this.y, this.width, this.height);
        //ImageIcon image = new ImageIcon("Assets/Spaceship.png");
        //ImageIcon image = Classes.getImage("player");
        g.drawImage(image.getImage(), this.x, this.y, this.width, this.height, null);
    }

    public void run()
    {
        while(true)
        {
            setX(this.x + dir);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("x:" + this.x + "\ndir:" + dir);
            panel.repaint();
            
        }
    }

    public void hit()
    {
        this.healthPoints -= 5;
        if(this.healthPoints <= 0)
        {
            //JOptionPane.showMessageDialog(null, "hi");
            SpaceInvadersPanel.endDialog(); 
        }
        makeSound();
        System.out.println("hit");
    }

    public void setX(int x)
    {
        if(x >= 0 && x <= this.panel.getWidth() - this.width)
            this.x = x;
    }
    public static void makeSound()
    {
        Classes.sound("Assets/ShipHit.wav");
    }
}
