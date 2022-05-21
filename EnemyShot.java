import java.awt.*;

public class EnemyShot extends Shot
{
    public EnemyShot(int x, int y, int width, int height, int power, SpaceInvadersPanel panel)
    {
        super(x, y, width, height, power, panel);
    }

    public EnemyShot(int x, int y, int power, SpaceInvadersPanel panel)
    {
        super(x, y, power, panel);
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
        Classes.sound("Assets/InvaderBullet.wav");
    }
}
