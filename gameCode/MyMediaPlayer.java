/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

/**
 * This class define the features and functions of the media player.
 *
 * @author user.
 */
public class MyMediaPlayer
{
/**
 * control the rendering of time based media data.
 */
    private Player p;
   /**
    * manipulating the audio volume of the player.
    */
    private VolumeControl vc;
/**
 * constructor
 * @param filePath
 * @throws IOException
 * @throws MediaException 
 */
    public MyMediaPlayer(String filePath) throws IOException, MediaException
    {
        InputStream is = getClass().getResourceAsStream(filePath);
        if (is != null)
        {
            p = Manager.createPlayer(is, "audio/mp3");

            p.realize();
            p.prefetch();
        }

    }
/**
 * sets the number of times the player will repeat itself.
 * @param num 
 */
    public void setLoopCount(int num)
    {
        p.setLoopCount(num);
    }
/**
 * sets the volume level of the player
 * @param level 
 */
    public void setVolume(int level)
    {
        VolumeControl vc = (VolumeControl) p.getControl("VolumeControl");
        vc.setLevel(level);

    }
/**
 * plays the sound of the player.
 * @throws MediaException 
 */
    public void play() throws MediaException
    {

        if (p != null && p.getState() == Player.PREFETCHED)//check if the player is ready
        {
            p.start();

        }
    }
/**
 * stops the player.
 * @throws MediaException 
 */
    public void stop() throws MediaException
    {
        if (p.getState() == Player.STARTED)//check if the player is playing
        {
            p.stop();
        }
    }
/**
 * closes the player.
 */
    public void close()
    {//closes the player
        if (p != null)
        {
            p.deallocate();
            p.close();

        }
    }
}