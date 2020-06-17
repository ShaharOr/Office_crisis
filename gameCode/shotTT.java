/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javacard.framework.TransactionException;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.media.MediaException;

/**
 * a timer task for the bullet to perform so it will cause an illusion of a
 * shot.
 *
 * @author user
 */
public class shotTT extends TimerTask {

    /**
     * If the Timer task runs-true, else-false.
     */
    private boolean isRunning;
    /**
     * a bullet for the task to affect.
     */
    private Bullets blt;
    /**
     * the horizonal distance the task moves the bullet each time it repeats itself.
     */
    private int dx;
    /**
     * a worker for the task to use.
     */
    private Worker worker;
    /**
     * layer manager for the task to use.
     */
    protected LayerManager lm;
/**
 * constructor.
 * @param blt
 * @param worker
 * @param lm 
 */
    public shotTT(Bullets blt, Worker worker, LayerManager lm) {
        this.blt = blt;
        this.lm = lm;
        dx = 5;


        this.worker = worker;
        if (worker.getCurrentDir() == GameCanvas.LEFT_PRESSED) {

            dx = -5;
            blt.move(-(worker.getWidth()), 0);
        }

    }
/**
 * starts the task. decreases ammo of the worker.
 */
    public void startMe() {
        this.isRunning = true;
        blt.isShooting = true;
        worker.ammo--;


    }
/**
 * stops the task and sets the appropriate state for the bullet(vanishes) and the worker(no longer attacking).
 */
    public void stopMe() {
        isRunning = false;

     
        blt.isShooting = false;
        lm.remove(blt);
        worker.isAttacking = false;
        blt = null;
        worker.blt = null;



        System.out.println("stoped bullet");

        this.cancel();
    }
/**
 * pauses the task.
 */
    public void pauseMe() {
        isRunning = false;
    }
/**
 * runs the task, moves the bullet and checks collision with rivals and causes damage according to it.
 */
    public void run() {
        if (isRunning) {
            worker.isAttacking = true;
            for (int i = 0; i < lm.getSize(); i++) {
                if (lm.getLayerAt(i) instanceof Rival) {
                    if (blt.collidesWith((Rival) (lm.getLayerAt(i)), true)) {
                        ((Rival) (lm.getLayerAt(i))).attacked(10, worker.getCurrentDir());

                        this.stopMe();
                    }
                }
            }


            blt.move(dx, 0);
            blt.nextFrame();
            if (blt.getX() > worker.getX() + worker.getWidth() + 150 || blt.getX() < worker.getX() - 150) {
                this.stopMe();
            }


        }

    }
}
