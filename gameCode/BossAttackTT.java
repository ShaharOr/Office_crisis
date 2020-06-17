/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;

/**
 *this class is a timer task for the boss to use when attacking
 * @author user
 */
public class BossAttackTT extends TimerTask {

    /**
     * If the Timer task runs it is true, if not false
     */
    protected boolean isRunning;
    /**
     * a boss for the task to effect
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
 * constructor
 */
    public BossAttackTT(Boss1 boss, Worker worker, LayerManager lm) {
        this.boss = boss;
        this.worker = worker;
        this.lm = lm;
        this.attacked = false;
      


    }
/**
 * start method for the task
 */
    public void startMe() {

        this.isRunning = true;
    }
/**
 * method which stops the task
 */
    public void stopMe() {

        isRunning = false;
        boss.goingToAttack = false;
        this.attacked = false;
        boss.setTt(null);
        this.cancel();

    }
/*
 * 
 * method which pauses the task
 */
    public void pauseMe() {
        isRunning = false;
    }
/**
 * runs the task- makes the boss attack and harms the worker if necessary
 */
    public void run() {

        if (isRunning) {
            if (worker.getX() + worker.getWidth() - 20 <= boss.getX() && !attacked) {
                boss.goLeft(lm);
            }
            if (worker.getX() + worker.getWidth() - 20 >= boss.getX() && !boss.isAttacking && attacked == false) {
                boss.attack();
                attacked = true;
                if (boss.collidesWith(worker, false)) {
                    worker.attacked(20, GameCanvas.LEFT_PRESSED);
                }
            }
            if (attacked && !boss.isAttacking) {
               
                this.stopMe();

            }




        }

    }
}