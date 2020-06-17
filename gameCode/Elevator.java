/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

/**
 * creates and manages the elevator object
 *
 * @author user
 */
public class Elevator extends Item {

    /**
     *a sequence of frames for the class to use when doing an opening motion.
     */
    protected int[] openSeq;
    /**
     *a sequence of frames for the class to use when doing a closing motion.
     */
    protected int[] closeSeq;
    /**
     *TimerTask for the class to use when doing motion.
     */
    protected ElevatorMoveTT tt;
    /**
     *if is doing motion-true, else-false.
     */
    protected boolean isMoving;
    /**
     *if elevator in a closed state-true.else-false.
     */
    protected boolean isClose;
    /**
     *if elevator in a opened state-true.else-false.
     */
    protected boolean isOpen;
    /**
     *if elevator is ordered to stay in closed state-true, else-false.
     */
    protected boolean stayClosed;
/**
 * constructor
 * @param s
 * @param gd
 * @param x
 * @throws IOException 
 */
    public Elevator(Sprite s, GameDesign gd, int x) throws IOException {
        super(gd.getElevator(), x);
        this.openSeq = gd.ElevatOpenSeq;
        this.closeSeq = gd.ElevatCloseSeq;
        this.tt = null;
        isOpen = false;
        isClose = true;
        stayClosed = false;

        isMoving = false;



    }
/**
 * method which makes the elevator to perform opening motion by giving it a timerTask to perform.
 */
    public void open() {


        if (getTt() == null) {


            setFrameSequence(openSeq);
            setTt(new ElevatorMoveTT(this));


            ((ElevatorMoveTT) getTt()).startMe();

            timer.scheduleAtFixedRate(getTt(), 0, 200);

        }



    }
/**
 *  method which makes the elevator to perform closing motion by giving it a timerTask to perform.
 */
    public void close() {


        if (getTt() == null) {
            System.out.println("close elevator");


            setFrameSequence(closeSeq);
            setTt(new ElevatorMoveTT(this));


            ((ElevatorMoveTT) getTt()).startMe();

            timer.scheduleAtFixedRate(getTt(), 0, 200);

        }



    }
/**
 * checks if the elevator collides with worker and move according to it.
 * @param worker
 * @param lm 
 */
    public void checkCollisionWithWorker(Worker worker, LayerManager lm) {
        if (worker.collidesWith(this, true)) {
            if (!isMoving && !isOpen && !stayClosed) {
                this.open();

            }
        }

        if (!worker.collidesWith(this, true)) {
            if (!isClose && !isMoving) {
                this.close();
            }
        }





    }

    /**
     * @return the openSeq
     */
    public int[] getOpenSeq() {
        return openSeq;
    }

    /**
     * @param openSeq the openSeq to set
     */
    public void setOpenSeq(int[] openSeq) {
        this.openSeq = openSeq;
    }

    /**
     * @return the closeSeq
     */
    public int[] getCloseSeq() {
        return closeSeq;
    }

    /**
     * @param closeSeq the closeSeq to set
     */
    public void setCloseSeq(int[] closeSeq) {
        this.closeSeq = closeSeq;
    }

    /**
     * @return the tt
     */
    public TimerTask getTt() {
        return tt;
    }

    /**
     * @param tt the tt to set
     */
    public void setTt(ElevatorMoveTT tt) {
        this.tt = tt;
    }
}
