/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;

/**
 * a timer Task which manages the self destruction of the desk.
 *
 * @author class3
 */
public class DeskDestroy extends TimerTask {

    /**
     *a desk object for the task to effect.
     */
    private Desk desk;
    /**
     *a sequence of frames which the task uses.
     */
    protected int[] flipSeq;
    /**
     * If the Timer task runs-true, else-false.
     */
    private boolean isRunning;
    /**
     *the index of the last frame of the flipSeq.
     */
    protected int finalStage;
    /**
     *counts the amount of times the task has repeated itself.
     */
    protected int timer = 0;
/**
 * constructor
 * @param desk 
 */
    public DeskDestroy(Desk desk) {


        this.desk = desk;
        this.flipSeq = desk.getFlipSeq();
        finalStage = flipSeq.length;

        desk.setFrameSequence(flipSeq);
        desk.setFrame(6);

    }
    /**
     * starts the task.
     */
    public void startMe() {

        this.isRunning = true;

    }
/**
 * stops the task.
 * erases the destroyed desk.
 * 
 */
    public void stopMe() {

        isRunning = false;
      
        desk.setVisible(false);

        desk = null;

        this.cancel();

    }
/**
 * pauses the task.
 */
    public void pauseMe() {
        isRunning = false;
    }
/**
 * this method makes the desk flicker for several times then vanish
 */
    public void run() {

        if (isRunning) {

            if (timer >= 2 && timer < 14) {
                if (timer % 2 == 0) {
                    desk.setVisible(false);
                    //   desk.move(500, 0);
                    System.out.println("Invisible ..... " + timer);

                }
                if (timer % 2 == 1) {
                    desk.setVisible(true);
                    //    desk.move(-500, 0);
                    System.out.println("Visible ......." + timer);

                }

            }
            timer++;
            if (timer == 14) {
                isRunning = false;
                stopMe();


            }

        } else {
            stopMe();
        }

    }
}
