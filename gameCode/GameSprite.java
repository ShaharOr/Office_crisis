/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 * a class which creates and manages some of the actions on the characters used
 * in the game.
 *
 * @author class3
 */
public abstract class GameSprite extends Sprite {

    /**
     * initial horizonal parameter in which the sprite will be set.
     */
    protected int x;
    /**
     * initial vertical parameter in which the sprite will be set.
     */
    protected int y;
    /**
     * if the sprite should or is in the process of falling-true,else-false.
     */
    protected boolean isFalling;
    /**
     * if the sprite is dead-true, else-false.
     */
    protected boolean isDead;
    /**
     * if the sprite has performed a gravity task-true, else false.
     */
    protected boolean gravited;
    /**
     * a timerTask for the sprite to perform in order to perform certain movements
     */
    protected TimerTask myMoveTask;
    /**
     * A facility for threads to schedule tasks for future execution in a
     * background thread.
     */
    public Timer timer;

    public GameSprite(Sprite s, int x, int y) {
        super(s);

        this.x = x;
        this.y = y;
        this.setPosition(x, y);
        this.isFalling = false;
        myMoveTask = null;
        this.gravited = false;
        this.isDead = false;
        this.timer = new Timer();
    }

    public void die(LayerManager lm) {
        myMoveTask = null;
        if (myMoveTask == null) {

            myMoveTask = new DieTT(this, lm);
            ((DieTT) getMyMoveTask()).startMe();
            timer.scheduleAtFixedRate(getMyMoveTask(), 0, 100);
        }
    }

    public void startGravity(int[] seqFall) {
        if (!isDead) {
            if (myMoveTask == null) {
                setIsFalling(true);


                myMoveTask = new GravityTT(this);
                ((GravityTT) getMyMoveTask()).startMe(seqFall);

                timer.scheduleAtFixedRate(getMyMoveTask(), 0, 70);

            }
        }
    }

    /**
     * Check if collides with floor or / and desk or and others....
     */
    public abstract void checkGravity(LayerManager lm);

    /**
     * will be used only if is not jumping
     */
    public void stopGravity(int[] seqWalk) {
        setIsFalling(false);
        if (myMoveTask instanceof GravityTT) {
            ((GravityTT) myMoveTask).stopMe(seqWalk);
            System.out.println("shakakaka");

        } else {
            //System.out.println("The task is " + myMoveTask.getClass().getName());
        }
        myMoveTask = null;
    }

    /**
     * @return the x
     */
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the isFalling
     */
    public boolean isIsFalling() {
        return isFalling;
    }

    /**
     * @param isFalling the isFalling to set
     */
    public void setIsFalling(boolean isFalling) {
        this.isFalling = isFalling;
    }

    /**
     * @return the myMoveTask
     */
    public TimerTask getMyMoveTask() {
        return myMoveTask;
    }

    /**
     * @param myMoveTask the myMoveTask to set
     */
    public void setMyMoveTask(TimerTask myMoveTask) {
        this.myMoveTask = myMoveTask;
    }
}
