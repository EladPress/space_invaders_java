
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.*;
//git test git test
import java.util.*;
public class SpaceInvadersPanel extends JPanel
{
    public static SpaceInvadersPanel panel;
    public Shot shot;
    public static Player player;
    public long milis = 0;
    public Graphics graphics;
    public static ArrayList<Shot> shots = new ArrayList<Shot>();
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static MoveEnemies moveEnemies;
    public Image playerImage;
    public static Stopwatch stopwatch;
    public static JFrame f;

    public static ArrayList<EnemyShot> enemyShots = new ArrayList<EnemyShot>();

    public SpaceInvadersPanel()
    {
        setBackground(Color.white);
        shot = new Shot(this);
        player = new Player(this);
        
        setFocusable(true);
        
        addKeyListener(new KL());
        player.start();
        
        stopwatch = new Stopwatch();
        stopwatch.start(); 

        for(int i = 0; i < 10; i++)
        {
            enemies.add(new Squid(50 * i + 50, 100, this));
            
        }
        for(int i = 0; i < 10; i++)
        {
            enemies.add(new Squid(50 * i + 50, 150, this));
        }
        for(int i = 0; i < 10; i++)
        {
            enemies.add(new Crab(50 * i + 50, 200, this));
        }
        for(int i = 0; i < 10; i++)
        {
            enemies.add(new Octopus(50 * i + 50, 250, this));
        }
        
        moveEnemies = new MoveEnemies(enemies, this);
        moveEnemies.start();    
    }

    

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //shot.draw(g);
        player.draw(g);
        
        if(!shots.isEmpty())
        {
            for(int i = 0; i < shots.size(); i++)
            {
                shots.get(i).draw(g);
            }
        }

        if(!enemies.isEmpty())
        {
            for(int i = 0; i < enemies.size(); i++)
            {
                enemies.get(i).draw(g);
            }
        }
        
        if(!enemyShots.isEmpty())
        {
            for(int i = 0; i < enemyShots.size(); i++)
            {
                enemyShots.get(i).draw(g);
            }
        }
        
        g.drawImage(playerImage, 200, 600, 100, 100, null);

    }

    public static void main(String[] args)
    {
        f = new JFrame("SpaceInvadersV0.1");
		panel = new SpaceInvadersPanel();
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,700);
		f.setResizable(false);
		f.setVisible(true);	
        f.setFocusable(false);

        
    }

    class KL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e)
        {
            
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                if(stopwatch.hundredthes > 25)
                {
                    Shot shot1 = new Shot(player.x + (player.width)/2, 600, 5, 10, 10, panel);
                    Shot.makeSound();
                    shots.add(shot1);
                    shot1.start();
                    stopwatch.reset();
                    stopwatch.start();
                }
                panel.repaint();
                
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                player.dir = 1;

            }
            if(e.getKeyCode() == KeyEvent.VK_A)
                player.dir = -1;
        }

        
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A)
                player.dir = 0;
        }
        
    }

    public static void endDialog()
    {
        if(JOptionPane.showConfirmDialog(null, "would you like to play again?", "Game over, play time: ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		{
			f.dispose();
			main(null);
		}
		else
		{
			System.exit(0);
		}
    }

    
    
    public static void println()
    {
        System.out.println();
    }
    public static void print(String str)
    {
        System.out.print(str);
    }
    public static void println(String str)
    {
        System.out.println(str);
    }
    
}