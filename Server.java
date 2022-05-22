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

                ImageIcon image = new ImageIcon();

                switch(request){
                    case "player":
                    image = new ImageIcon("Assets/Spaceship.png");
                    break;

                    default:

                }

                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                out.writeObject(image);
                out.flush();
            }
        }
    }
}
