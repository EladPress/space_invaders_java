import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.net.*;
import java.io.*;

public class Classes 
{
    static void sound(File borgir)
    {
        //File borgir = new File(path);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(borgir));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon getImage(String request) throws UnknownHostException, IOException, ClassNotFoundException
    {
        Socket s = new Socket("localhost", 7999);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(request);
        pr.flush();

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        
        ImageIcon image = (ImageIcon) in.readObject();

        System.out.println("server: " + image.toString());
        s.close();
        return image;
    }

    public static File getSound(String request)  throws UnknownHostException, IOException, ClassNotFoundException
    {
        Socket s = new Socket("localhost", 7999);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(request);
        pr.flush();

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());

        File sound = (File) in.readObject();

        System.out.println("server: " + sound.toString());
        s.close();
        return sound;
    }
}
