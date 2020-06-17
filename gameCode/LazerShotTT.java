/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.media.MediaException;

/**
 * a timerTask responsible for the action of a lazer shot.
 * @author user
 */
public class LazerShotTT extends TimerTask
{
/**
     * If the Timer task runs it is true, if not false.
     */
    private boolean isRunning;
    /**
     * a bullet on which the task will take effect.
     */
    private Bullets blt;
    /**
     * a horizonal distance which the bullet pass each time the task is repeated.
     */
    private int dx;
    /**
     * a worker which the task will use.
     */
    private Worker worker;
    /**
     * a layer manager which the task will use.
     */
    protected LayerManager lm;
    /**
     * counts the times the task has repeated
     */
    protected int timer;
/**
 * constructor
 * @param blt
 * @param worker
 * @param lm 
 */
    public LazerShotTT(Bullets blt, Worker worker, LayerManager lm)
    {
        this.blt = blt;
        this.lm = lm;
        dx = 5;
        timer = 0;

        this.worker = worker;
        if (worker.getCurrentDir() == GameCanvas.LEFT_PRESSED)
        {

            dx = -5;
            blt.move(-(worker.getWidth()), 0);
        }

    }
/**
 * starts the task, setting the right sequence, and decreases the ammo.
 */
    public void startMe()
    {
        this.isRunning = true;
        worker.LazerShooting = true;
        blt.setFrameSequence(blt.getPreSeq());
        (worker.ammo)--;






    }
/**
 * stops the task and sets the appropriate state for the bullet(vanishes) and the worker(no longer attacking).
 */
    public void stopMe()
    {

        worker.LazerShooting = false;
        isRunning = false;

      
        blt.isShooting = false;
        lm.remove(blt);
        worker.isAttacking = false;
        worker.blt = null;
        blt = null;
        worker.mp.close();


       

        this.cancel();
    }
/**
 * pauses the task.
 */
    public void pauseMe()
    {
        isRunning = false;
    }
/**
 * runs the task to make the bullet do a preparation movement and then shoot.
 */
    public void run()
    {
        if (isRunning)
        {

            if (timer >= 0 && timer < 9)
            {


                blt.nextFrame();
            }
            if (timer == 9)
            {
                blt.setFrameSequence(blt.getShootSeq());



            }
            if (timer >= 10)
            {
                blt.nextFrame();
                blt.move(dx, 0);
            }
            timer++;

            worker.isAttacking = true;
            for (int i = 0; i < lm.getSize(); i++)
            {
                if (lm.getLayerAt(i) instanceof Rival)
                {
                    if (blt.collidesWith((Rival) (lm.getLayerAt(i)), true))
                    {
                        ((Rival) (lm.getLayerAt(i))).attacked(40, worker.getCurrentDir());

                        this.stopMe();
                    }
                }
            }



            if (blt.getX() > worker.getX() + worker.getWidth() + 150 || blt.getX() < worker.getX() - 150)
            {

                this.stopMe();
            }


        }

    }
}
