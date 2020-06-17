/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.Timer;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 * this class creates and manages some of the actions for all the items in the
 * game
 *
 * @author class3
 */
public class Item extends Sprite {

    /**
     * A facility for threads to schedule tasks for future execution in a
     * background thread.
     */
    protected Timer timer;
/**
 * constructor
 * @param s
 * @param x 
 */
    public Item(Sprite s, int x) {
        super(s);
        this.setPosition(x, 20);
        this.timer = new Timer();

    }
/**
 * makes the item to attach into the floor
 * @param floor 
 */
    public void gravity(TiledLayer floor) {

        while (!this.collidesWith(floor, true)) {
            this.move(0, 1);

        }

    }
/**
 * draws the item into the canvas of the level.
 * @param g 
 */
    public void drawItem(Graphics g) {
        super.paint(g);
    }
}