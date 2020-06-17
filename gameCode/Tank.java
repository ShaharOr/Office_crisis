/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

/**
 * an item of a tank to use in the game.
 * @author user
 */
public class Tank extends Item
{
/**
 * a frame Sequence for the tank to use when driving
 */
    private int[] tankSeq;
    /**
     * timer task that causes the tank to preform a ride
     */
    private TankMoveTT tt;
/**
 * constructor.
 */
    public Tank(GameDesign gd, int x) throws IOException
    {

        super(gd.getTank(), x);
        this.setPosition(x, 0);
        this.tankSeq = gd.tankseq;


    }
/**
 * a method that makes the tank start driving.
 * @param worker
 * @param lm 
 */
    public void activate(Worker worker, LayerManager lm)
    {
        worker.setPosition(this.getX() + 20, this.getY());
        setFrameSequence(getTankSeq());
        setTt(new TankMoveTT(this, lm, worker));
        this.setVisible(true);

        ((TankMoveTT) getTt()).startMe();

        timer.scheduleAtFixedRate(getTt(), 0, 100);
    }

    /**
     * @return the tankSeq
     */
    public int[] getTankSeq()
    {
        return tankSeq;
    }

    /**
     * @param tankSeq the tankSeq to set
     */
    public void setTankSeq(int[] tankSeq)
    {
        this.tankSeq = tankSeq;
    }

    /**
     * @return the tt
     */
    public TankMoveTT getTt()
    {
        return tt;
    }

    /**
     * @param tt the tt to set
     */
    public void setTt(TankMoveTT tt)
    {
        this.tt = tt;
    }
}
