import java.net.*;
import javax.swing.ImageIcon;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException
    {
        while(true)
        {
            try (ServerSocket ss = new ServerSocket(7999)) {
                System.out.println("Listening...");
                Socket s = ss.accept();

                System.out.println("client connected");

                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String request = bf.readLine();

                Object object = new ImageIcon();
                //image = new File(request);
                switch(request){
                    case "player":
                    object = new ImageIcon("Assets/Spaceship.png");
                    break;
                    case "squid":
                    object = new ImageIcon("Assets/squid1.png");
                    break;
                    case "crab":
                    object = new ImageIcon("Assets/Crab1.png");
                    break;
                    case "octopus":
                    object = new ImageIcon("Assets/Octopus1.png");
                    break;
                    case "shipHit":
                    object = new File("Assets/ShipHit.wav");
                    break;


                    default:

                }

                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                System.out.println(request);
                out.writeObject(object);
                out.flush();
            }
        }
    }
}
