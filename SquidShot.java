

public class SquidShot extends EnemyShot 
{
    public SquidShot(int x, int y, int width, int height, int power, SpaceInvadersPanel panel)
    {
        super(x, y, width, height, power, panel);
        this.direction = -1;
        this.speed = 5;
    }

    public SquidShot(int x, int y, int power, SpaceInvadersPanel panel)
    {
        super(x, y, power, panel);
        this.direction = -1;
        this.speed = 5;
    }
}
