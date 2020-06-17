/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

/**
 *this class can generate items which will be used as bonuses for the game
 * @author user
 */
public abstract class Bonus extends Item
{
/**
 * layer manager for the class.
 */
    protected LayerManager lm;
/**
 * constructor
 * @param s- sprite for the bonus.
 * @param x-the initial horizonal.
 * @param lm - layer manager for the class.
 */
    public Bonus(Sprite s, int x, LayerManager lm)
    {
        super(s, x);
        this.lm = lm;

    }
/**
 * does the action of picking up the object.
 */
    public void pickUp()
    {
        lm.remove(this);
        giveSignificancy();
    }
/**
 * after being picked up, the bonus gives his characteristics to the worker.
 */
    abstract void giveSignificancy();
}
