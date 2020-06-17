/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * a timerTask responsible for the jump movement of the worker
 *
 * @author wolfsonstudents
 */
public class JumpTask extends TimerTask {

    /**
     * If the Timer task runs it is true, if not false
     */
    private boolean isRunning;
    /**
     * the worker on which the task will affect
     */
    private Worker sprite;
    /**
     * the vertical distance which the worker moves each time the task is
     * repeated.
     */
    private int dy;
    /**
     * the last direction in which the worker went before the jump
     */
    int dir_for_jump;

    /**
     * constructor
     *
     * @param sprite
     */
    public JumpTask(Worker sprite) {
        this.sprite = sprite;


        dy = -30;



    }

    /**
     * starts the task.
     */
    public void startMe() {

        this.isRunning = true;
    }

    /**
     * stops the tasks and returns the worker to its previous state.
     */
    public void stopMe() {

        sprite.setIsJumping(false);
        sprite.isFalling = true;
        isRunning = false;
        sprite.stopJump();
        this.cancel();
    }

    /**
     * pauses the task.
     */
    public void pauseMe() {
        isRunning = false;
    }

    /**
     * runs the tasks by moving the sprite a decreasing amount of vertical
     * distance.
     */
    public void run() {

        if (isRunning) {
            if (dy <= 0) {
                sprite.move(0, dy);
                dy += 4;

            } else {
                isRunning = false;
                stopMe();
            }
        }
    }
}
