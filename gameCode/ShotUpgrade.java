/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

/**
 * this class creates and manages a bonus object which makes the bullets turn into lazer shots.
 *
 * @author user
 */
public class ShotUpgrade extends Bonus {

    /**
     * Contains all the sequence of the sprites in the game.
     */
    private GameDesign gd;
    /**
     * A facility for threads to schedule tasks for future execution in a
     * background thread.
     */
    private int timer;

    /**
     * constructor
     * @param s
     * @param gd
     * @param x
     * @param lm
     * @throws IOException 
     */
    public ShotUpgrade(Sprite s, GameDesign gd, int x, LayerManager lm) throws IOException {
        super(gd.getShotBonus(), x, lm);
        this.gd = gd;
        timer = 0;


        




    }

    public void giveSignificancy() {
    }
/**
 * manages the movement of the object
 */
    public void movement() {
        if (timer == 3) {
            this.nextFrame();
            timer = 0;
        }


        timer++;


    }

    /**
     * @return the gd
     */
    public GameDesign getGd() {
        return gd;
    }

    /**
     * @param gd the gd to set
     */
    public void setGd(GameDesign gd) {
        this.gd = gd;
    }
    /**
     * @return the tt
     */
}
