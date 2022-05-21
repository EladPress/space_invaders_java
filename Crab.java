import java.awt.Graphics;
import javax.swing.*;


public class Crab extends Enemy
{

    public Crab(int x, int y, SpaceInvadersPanel panel)
    {
        super(x, y, 30, 20, 10, 3, panel);
    }

    public void draw(Graphics g)
    {
        ImageIcon image = new ImageIcon("Assets/Crab1.png");
        g.drawImage(image.getImage(), this.x, this.y, this.width, this.height, null);
    }
}
