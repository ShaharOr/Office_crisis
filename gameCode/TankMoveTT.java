/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;

/**
 * a timerTask for the tank and worker which performs the tank ride- an
 * automatic movement of the tank and worker to certain distance.
 *
 * @author user
 */
public class TankMoveTT extends TimerTask {

    /**
     * If the Timer task runs-true, else-false.
     */
    private boolean isRunning;
    /**
     * the tank on which the task affects.
     */
    private Tank tank;
    /**
     * the horizonal distance the task moves the tank each time it repeats itself.
     */
    private int dx;
    /**
     * the horizonal distance the tank has moved since the task first call.
     */
    private int dist;
    /**
     * layer manager for the task to use.
     */
    private LayerManager lm;
    /**
     * if the tank is visible-true,else-false.
     */
    private boolean vis;
    /**
     * worker for the task to affect.
     */
    private Worker worker;

    /**
     * constructor.
     *
     * @param tank
     * @param lm
     * @param worker
     */
    public TankMoveTT(Tank tank, LayerManager lm, Worker worker) {
        this.tank = tank;
        this.lm = lm;
        dist = 0;
        vis = true;
        dx = 10;
        this.worker = worker;
    }

    /**
     * starts the task.
     */
    public void startMe() {
        this.isRunning = true;
        worker.onTank = true;


    }

    /**
     * stops the tasks.
     */
    public void stopMe() {
        isRunning = false;
        worker.onTank = false;

        lm.remove(tank);



        this.cancel();
    }

    /**
     * pauses the task.
     */
    public void pauseMe() {
        isRunning = false;
    }

    /**
     * runs the task. attaches the worker to the tank so they can move together
     * to a final distance. afterwards the tank will flicker and disappear.
     */
    public void run() {
        if (isRunning) {
            if (dist < 900) {
                tank.move(dx, 0);
                tank.nextFrame();
                worker.move(dx, 0);

                for (int i = 0; i < lm.getSize(); i++) {
                    if (lm.getLayerAt(i) instanceof Rival) {
                        if (tank.collidesWith((Rival) (lm.getLayerAt(i)), true)) {
                            ((Rival) (lm.getLayerAt(i))).attacked(100, GameCanvas.RIGHT_PRESSED);
                            ((Rival) (lm.getLayerAt(i))).move(15, 0);

                        }
                    }
                    if (lm.getLayerAt(i) instanceof Desk) {
                        if (tank.collidesWith((Desk) (lm.getLayerAt(i)), true)) {
                            ((Desk) (lm.getLayerAt(i))).flip(lm);
                        }
                    }
                }
            }
            dist += dx;
            if (dist >= 900) {
                tank.setVisible(vis);
                if (vis == true) {
                    vis = false;
                } else {
                    vis = true;
                }
            }
            if (dist >= 1050) {
                this.stopMe();
            }


        }

    }
}
