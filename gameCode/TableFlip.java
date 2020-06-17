/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;

/**
 * a timerTask responsible for the the flip motion of the desk
 *
 * @author wolfsonstudents
 */
public class TableFlip extends TimerTask
{
/**
 * the desk on which the task affects
 */
    private Desk desk;
    /**
     * frame sequence for the desk to go through to preform the flip
     */
    protected int[] flipSeq;
    /**
     * If the Timer task runs-true, else-false.
     */
    private boolean isRunning;
    /**
     *the index of the last frame of the flipSeq.
     */
    protected int finalStage;
     /**
     * a index in the array of the flipSeq.
     */
    protected int currentStage;
    /**
     * layer manager for the task to use.
     */
    protected LayerManager lm;
/**
 * constructor.
 * @param desk
 * @param lm 
 */
    public TableFlip(Desk desk, LayerManager lm)
    {
        this.desk = desk;
        this.flipSeq = desk.getFlipSeq();
        finalStage = flipSeq.length;
        currentStage = 0;
        desk.setFrameSequence(flipSeq);
        this.lm = lm;
    }
 /**
     * starts the task.
     */
    public void startMe()
    {
        desk.isFliped = true;

        this.isRunning = true;
    }
/**
 * stops the task 
 */
    public void stopMe()
    {

        isRunning = false;

        System.out.println("finished flip");

        this.cancel();
        desk.destroy();

    }
/**
 * pauses the task
 */
    public void pauseMe()
    {
        isRunning = false;
    }
/**
 * runs the task,
 * sets a different frame from sequence and moves the desk a bit to create the illusion of a flip. 
 */
    public void run()
    {

        if (isRunning)
        {
            int d = 3;
            for (int i = 0; i < lm.getSize(); i++)
            {
                if (lm.getLayerAt(i) instanceof Rival)
                {
                    if (desk.collidesWith((Rival) (lm.getLayerAt(i)), true))
                    {
                        ((Rival) (lm.getLayerAt(i))).attacked(10, GameCanvas.RIGHT_PRESSED);
                    }
                }
            }

            if (currentStage < finalStage - 1)
            {
                if (currentStage < finalStage / 2)
                {
                    desk.move(d, -d);
                }
                if (currentStage > finalStage / 2)
                {
                    desk.move(d, d);
                }
                desk.nextFrame();
                currentStage++;


            }
            else
            {
                desk.move(0, 2);

                isRunning = false;
                stopMe();
            }
        }

    }
}
