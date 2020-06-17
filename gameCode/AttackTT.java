/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.MediaException;

/**
 * this timerTask is responsible for the action of the attack sprite that
 * performs this task will make an attack movement
 *
 * @author user
 */
public class AttackTT extends TimerTask {

    /**
     * If the Timer task runs-true, else-false.
     */
    private boolean isRunning;
    /**
     * the sprite that the task could works.
     */
    private Worker sprite;
    /**
     * the sprite that the task could work on.
     */
    private Rival rival;
    /**
     * counts the times the task repeats itself so it could know when to stop.
     */
    private int timer;
    /**
     * media player for the sound of the attack.
     */
    private MyMediaPlayer mp;

    /**
     *constructor of the task.
     * @param worker
     */
    public AttackTT(Worker worker) {

        if (worker instanceof Rival) {
            this.rival = (Rival) worker;
            this.sprite = rival;
            sprite.setFrameSequence(rival.rivalAttackSeq);
        } else {
            this.sprite = worker;
            worker.setFrameSequence(worker.getSeqAttack());
        }
        timer = 1;

    }
/**
 * starts the task
 * sets the sprite sequence to attack sequence 
 * plays the sound of the attack.
 * 
 */
    public void startMe() {
        this.isRunning = true;
        sprite.setIsAttacking(true);
        if (!(sprite instanceof Rival)) {
            try {
                mp = new MyMediaPlayer("/Sound/hit.mp3");
                mp.setVolume(100);
                mp.setLoopCount(1);
                mp.play();


            } catch (IOException ex) {
                ex.printStackTrace();

            } catch (MediaException ex) {
                ex.printStackTrace();
            }
        }

    }
/**
 * stops the task. 
 */
    public void stopMe() {
        isRunning = false;

        sprite.setIsAttacking(false);
        sprite.setMyMoveTask(null);
        mp.close();
        mp = null;

        this.cancel();
    }
/**
 * pauses the task.
 */
    public void pauseMe() {
        isRunning = false;
    }
/**
 * runs the task, so the sprite will perform attack movement.
 */
    public void run() {
        if (isRunning) {



            if (timer == 5) {
                sprite.setFrameSequence(sprite.seqWalk);
            }
            if (timer == 6) {
                this.stopMe();
            }
            timer++;
        }

    }
}