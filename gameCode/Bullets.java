/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.media.MediaException;

/**
 *this class creates and manages them 
 * @author user
 */
public class Bullets extends Item
{
/**
 * a sequence of frames for the preparation mode
 */
    private int[] preSeq;
    /**
     * a sequence of frames for the shoot mode
     */
    private int[] shootSeq;
    /**
     * if bullet is in process of shooting-true, else-false 
     */
    protected boolean isShooting;
    /**
     * a sequence of frames for the bullet to use while shooting
     */
    private int[] regSeq;
   /**
    * sprite of the bullet
    */
    private Sprite s;
    /**
     * timer task for the bullets to use
     */
    private TimerTask tt;
/**
 * constructor
 * @param s
 * @param gd
 * @param x
 * @param y 
 */
    public Bullets(Sprite s, GameDesign gd, int x, int y)
    {
        super(s, x);
        this.preSeq = gd.seqBulletPrepare;
        this.regSeq = gd.seqBulletPin;
        this.shootSeq = gd.seqBulletShot;
      
        this.tt = null;
        this.setPosition(x, y + 10);



    }
/**
 * method which makes the bullet to perform a regular shoot
 * @param worker
 * @param lm 
 */
    public void regularShot(Worker worker, LayerManager lm)
    {
        if (getTt() == null)
        {



            setFrameSequence(getRegSeq());
            setTt(new shotTT(this, worker, lm));
            this.setVisible(true);

            ((shotTT) getTt()).startMe();

            timer.scheduleAtFixedRate(getTt(), 0, 20);

        }


    }
/**
 * if necessary, method which makes the bullet to perform a lazer shoot
 * @param worker
 * @param lm 
 */
    public void lazerShot(Worker worker, LayerManager lm)
    {
        if (getTt() == null && !worker.LazerShooting)
        {

            setFrameSequence(getPreSeq());
            setTt(new LazerShotTT(this, worker, lm));
            this.setVisible(true);

            ((LazerShotTT) getTt()).startMe();

            timer.scheduleAtFixedRate(getTt(), 0, 20);

        }


    }

    /**
     * @return the preSeq
     */
    public int[] getPreSeq()
    {
        return preSeq;
    }

    /**
     * @param preSeq the preSeq to set
     */
    public void setPreSeq(int[] preSeq)
    {
        this.preSeq = preSeq;
    }

    /**
     * @return the shootSeq
     */
    public int[] getShootSeq()
    {
        return shootSeq;
    }

    /**
     * @param shootSeq the shootSeq to set
     */
    public void setShootSeq(int[] shootSeq)
    {
        this.shootSeq = shootSeq;
    }

    /**
     * @return the regSeq
     */
    public int[] getRegSeq()
    {
        return regSeq;
    }

    /**
     * @param regSeq the regSeq to set
     */
    public void setRegSeq(int[] regSeq)
    {
        this.regSeq = regSeq;
    }

    

    /**
     * @return the s
     */
    public Sprite getS()
    {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Sprite s)
    {
        this.s = s;
    }

    /**
     * @return the tt
     */
    public TimerTask getTt()
    {
        return tt;
    }

    /**
     * @param tt the tt to set
     */
    public void setTt(TimerTask tt)
    {
        this.tt = tt;
    }
}
