import java.util.*;

public class MoveEnemies extends Thread
{
    public int direction;
    public ArrayList<Enemy> enemies;
    public SpaceInvadersPanel panel;

    public MoveEnemies(ArrayList<Enemy> enemies, SpaceInvadersPanel panel)
    {
        this.enemies = enemies;
        this.direction = 1;
        this.panel = panel;
    }

    public void run()
    {
        
        while(true)
        {
            this.direction = this.changeDir(this.direction);
            for(int i = 0; i < this.enemies.size(); i++)
            {
                this.enemies.get(i).x += direction;
                if((new Random()).nextInt(10000) == 0)
                {
                    SquidShot shot = new SquidShot(this.enemies.get(i).x, this.enemies.get(i).y, 5, this.panel);
                    SpaceInvadersPanel.enemyShots.add(shot);
                    shot.start();

                }

            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {}
            this.panel.repaint();
        }
        
    }

    public int changeDir(int dir)
    {
        //System.out.println(this.enemies.size());
        for(int i = 0; i < this.enemies.size(); i++)
        {
            if(this.enemies.get(i).x < 0)
                return 1;
            if((this.enemies.get(i).x + this.enemies.get(i).width) > 600)
                return -1;
        }
        return dir;
    }
}
