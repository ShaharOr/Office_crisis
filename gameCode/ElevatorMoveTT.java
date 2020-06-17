/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;

/**
 * a timerTask which causes the elevator object to perform closing or opening
 * motion.
 *
 * @author user
 */
public class ElevatorMoveTT extends TimerTask {

    /**
     *the elevator object for the task to affect.
     */
    private Elevator elv;
    /**
     *If the Timer task runs-true, else-false.
     */
    protected boolean isRunning;
    /**
     *length of the array of the elevator Sequence.
     */
    private int length;
    /**
     *the index of the current showing frame of the elevator moving sequence in it's array.
     */
    private int i;
/**
 * constructor
 * @param elv 
 */
    public ElevatorMoveTT(Elevator elv) {
        this.elv = elv;
        this.length = elv.getFrameSequenceLength();
        i = 1;


    }
/**
 * starts the task.
 */
    public void startMe() {
        this.isRunning = true;
        elv.isMoving = true;


    }
/**
 * stops the task, and sets the elevator state according to the task action.
 */
    public void stopMe() {
        this.isRunning = false;
        elv.isMoving = false;



        elv.setTt(null);

        if (elv.getFrameSequenceLength() == (elv.getOpenSeq()).length) {
            elv.isOpen = true;
            elv.isClose = false;
        }
        if (elv.getFrameSequenceLength() == (elv.getCloseSeq()).length) {
            elv.isClose = true;
            elv.isOpen = false;
        }

        this.cancel();

    }
/**
 * runs the task by moving the frames of the moving sequence
 */
    public void run() {
        if (isRunning) {
            if (i < length) {
                elv.nextFrame();
                i++;
            } else {
                stopMe();
            }
        }
    }
}
