/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.midlet.MIDlet;

/**
 * a timerTask responsible for the death process of gameSprites
 *
 * @author user
 */
public class DieTT extends TimerTask {

    /**
     * If the Timer task runs-true, else-false.
     */
    public boolean isRunning;
    /**
     * a sprite on which the task will affect.
     */
    protected GameSprite s;
    /**
     * a layer manger for the Task to use.
     */
    protected LayerManager lm;
    /**
     * /**
     *counts the amount of times the task has repeated itself.
     */
      protected int actionTimer;
/**
 * constructor
 * @param s
 * @param lm 
 */
    public DieTT(GameSprite s, LayerManager lm) {
        this.s = s;
        this.lm = lm;
        actionTimer = 0;




    }
/**
 * starts the task, makes the worker's score to rise (for every death the worker gets score).
 */
    public void startMe() {
        this.isRunning = true;

        s.isDead = true;
        for (int i = 0; i < lm.getSize(); i++) {
            if (lm.getLayerAt(i) instanceof Worker) {
                ((Worker) lm.getLayerAt(i)).setScore(((Worker) lm.getLayerAt(i)).getScore() + 50);
            }
           
        }


    }
/**
 * stops the task. if the death if of the ceo- the final boss, the game will finish
 */
    public void stopMe() {
        isRunning = false;



        s.setVisible(false);
        lm.remove(s);

        s.setMyMoveTask(null);


        if (s instanceof Boss1 && Level4.running == true) {

            Level4.isFinished = true;
        }

        s = null;



        this.cancel();
    }
/**
 * pauses the task
 */
    public void pauseMe() {
        isRunning = false;
    }
/**
 * runs the task. makes the sprite to flicker and rise up then vanish
 */
    public void run() {
        if (isRunning) {
            s.setFrame(0);
            if (actionTimer >= 0 && actionTimer < 14) {
                if (actionTimer % 2 == 0) {
                    s.setVisible(false);

                }
                if (actionTimer % 2 == 1) {
                    s.setVisible(true);
                }

                if (actionTimer >= 8) {

                    s.move(0, -30);

                }




            }
            actionTimer++;
            if (actionTimer == 14) {
                isRunning = false;
                stopMe();


            }

        } else {
            stopMe();
        }

    }
}
