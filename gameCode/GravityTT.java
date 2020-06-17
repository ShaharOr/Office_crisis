/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.TimerTask;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 * This timer task is responsible of the gravity of the GameSprite it is given.
 *
 * @author class3
 */
public class GravityTT extends TimerTask {

    /**
     * If the Timer task runs it is true, if not false.
     */
    private boolean isRunning;
    /**
     * the sprite that the gravity works on.
     */
    private GameSprite sprite;
    /**
     * vertical distance of movement.
     */
    private int dy;

    /**
     * The constructor of the gravity.
     *
     * @param sprite
     *
     */
    public GravityTT(GameSprite sprite) {
        this.sprite = sprite;

        dy = 0;
    }

    /**
     * Start the gravity.
     */
    public void startMe(int[] seq) {
        this.isRunning = true;
        sprite.setFrameSequence(seq);
        sprite.gravited = false;



    }

    /**
     * Stop the gravity.
     */
    public void stopMe(int[] seq) {
        isRunning = false;
        System.out.println("gravity Stoped");
        sprite.gravited = true;

        sprite.setFrameSequence(seq);
        this.cancel();
    }

    /**
     * Pause the gravity.
     */
    public void pauseMe() {
        isRunning = false;

    }

    /**
     * while task is not stopped and sprite is not dead, move the sprite down
     * with acceleration.
     */
    public void run() {
        if (isRunning) {

            if (!sprite.isDead) {
                dy += 2;
                sprite.move(0, dy);
                sprite.nextFrame();
            }


        }

    }
}
