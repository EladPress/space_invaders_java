import java.awt.*;
import javax.swing.*;

public class Player extends Thread
{
    int x, y, width, height, dir = 0, healthPoints = 15;
    SpaceInvadersPanel panel;

    public Player(SpaceInvadersPanel panel)
    {
        this.x = 200;
        this.y = 600;
        this.width = 30;
        this.height = 45;
        this.panel = panel;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        //g.fillRect(this.x, this.y, this.width, this.height);
        ImageIcon image = new ImageIcon("Assets/Spaceship.png");
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
