/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;

/**
 *this class is a timer task for the final boss to use when attacking
 * @author user
 */
public class CEOAttackTT extends TimerTask
{
/**
 * If the Timer task runs it is true, if not false
 */
    protected boolean isRunning;
    /**
     *  a boss for the task to effect
     */
    private Boss1 boss;
    /**
     * a worker for the boss to interact with
     */
    private Worker worker;
    /**
     * a layer manager for the task to use
     */
    private LayerManager lm;
    /**
     * if the task has started-false, if finished-true
     */
    private boolean attacked;
   
    /**
     * the sequence of frames which the boss uses for this attack
     */
    private int[] seq;
    /**
     * the last sequence of frames which the boss used before entering this task
     */
    private int[] prevSeq;
    /**
     * counts the amount of times the task repeated itself while the boss collided with the worker
     */
    private int collissionTimer = 0;
/**
 * constructor
 * @param boss
 * @param worker
 * @param lm
 * @param CEOAttackSeq
 * @param gd 
 */
    public CEOAttackTT(Boss1 boss, Worker worker, LayerManager lm, int[] CEOAttackSeq, GameDesign gd)
    {
        this.boss = boss;
        this.worker = worker;
        this.lm = lm;
        this.attacked = false;
     
        this.seq = CEOAttackSeq;
        this.prevSeq = gd.CEOWalkSeq;


    }
/**
 * starts the task
 */
    public void startMe()
    {

        this.isRunning = true;
        boss.setFrameSequence(seq);
        boss.setFrame(0);
    }
/**
 * ends the task.
 */
    public void stopMe()
    {

        isRunning = false;
        boss.goingToAttack = false;
        this.attacked = false;
        boss.setTt(null);
        // boss.setFrameSequence(prevSeq);
        this.cancel();
        System.out.println("should return to nothing");
        boss.specialAttacking = false;

    }
/**
 * pauses the task.
 */
    public void pauseMe()
    {
        isRunning = false;
    }
/**
 * runs the task- makes the boss to perform the attack and harms the worker
 */
    public void run()
    {

        if (isRunning)
        {
          
            if (worker.getX() + worker.getWidth() - 15 <= boss.getX())
            {
                boss.setFrameSequence(seq);
                boss.move(-8, 0);

            }
            if (boss.collidesWith(worker, true))
            {
            
                worker.attacked(10, GameCanvas.LEFT_PRESSED);
                collissionTimer++;
            }
            System.out.println(collissionTimer);
            if (collissionTimer == 4)
            {

                boss.nextFrame();
            }
            if (collissionTimer >= 5)
            {
                this.stopMe();
            }





        }

    }
}