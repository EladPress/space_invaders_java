import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Classes 
{
    static void sound(String path)
    {
        File borgir = new File(path);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(borgir));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
