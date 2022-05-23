import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

public class EnemyShot extends Shot
{
    //static File sound;
    public EnemyShot(int x, int y, int width, int height, int power, SpaceInvadersPanel panel)
    {
        super(x, y, width, height, power, panel);
        try {
            sound = Classes.getSound("invaderBullet");
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

    public EnemyShot(int x, int y, int power, SpaceInvadersPanel panel)
    {
        super(x, y, power, panel);
        try {
            sound = Classes.getSound("invaderBullet");
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

    @Override
    public void run()
    {
        makeSound();
        boolean bool = false;
        while(this.y > -50 && !bool)
        {
            this.y-=this.direction;
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {}

            if(hit(SpaceInvadersPanel.player))
            {
                SpaceInvadersPanel.player.hit();
                bool = true;
            }

            panel.repaint();
        }
        SpaceInvadersPanel.enemyShots.remove(this);
    }

    
    public boolean hit(Player player)
    {
        Rectangle rect = new Rectangle(player.x, player.y, player.width, player.height);
        Rectangle rect2 = new Rectangle(this.x, this.y, this.width, this.height);

        return rect.intersects(rect2);
    }

    public static void makeSound()
    {
        Classes.sound(sound);
    }
}
