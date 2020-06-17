/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *a class which creates and manages the desks of the game.
 * @author user
 */
public class Desk extends Item
{
/**
 * a sequence of frames used for the flip motion.
 */
    protected int[] flipSeq;
    /**
     * the index of the last frame of the flipSeq.
     */
    protected int finalStage;
    /**
     * a index in the array of the flipSeq.
     */
    protected int currentStage;
    /**
     * timer Task for the class to use when flipping.
     */
    protected TableFlip flip;
    /**
     * timer Task for the class to use when the destroying .
     */
    protected DeskDestroy destroy;
    /**
     * if desk finished flip-true, else-false.
     */
    protected boolean isFliped;
    
/**
 * constructor
 * @param s
 * @param x
 * @param flipSeq 
 */
    public Desk(Sprite s, int x, int[] flipSeq)
    {
        super(s, x);


        this.flipSeq = flipSeq;
        finalStage = flipSeq.length;
        currentStage = 0;
        this.isFliped = false;
       

    }
    /**
     * method which causes the desk to start flip task
     * @param lm 
     */
    public void flip(LayerManager lm)
    {

        if (!this.isFliped)
        {

            setFlip(new TableFlip(this, lm));
            ((TableFlip) getFlip()).startMe();
            timer.scheduleAtFixedRate(getFlip(), 0, 80);
        }

    }
/**
 * method which causes the desk to start destroy task
 */
    public void destroy()
    {
        setDestroy(new DeskDestroy(this));
        ((DeskDestroy) getDestroy()).startMe();
        timer.scheduleAtFixedRate(getDestroy(), 0, 120);

    }

    /**
     * @return the x
     */
    public void setX(int x)
    {
        this.setX(x);
    }

    /**
     * @param y the y to set
     */
    public void setY(int y)
    {
        this.setY(y);
    }

    /**
     * @return the gravity
     */
    /**
     * @param gravity the gravity to set
     */
    /**
     * @return the flipSeq
     */
    public int[] getFlipSeq()
    {
        return flipSeq;
    }

    /**
     * @param flipSeq the flipSeq to set
     */
    public void setFlipSeq(int[] flipSeq)
    {
        this.flipSeq = flipSeq;
    }

    /**
     * @return the finalStage
     */
    public int getFinalStage()
    {
        return finalStage;
    }

    /**
     * @param finalStage the finalStage to set
     */
    public void setFinalStage(int finalStage)
    {
        this.finalStage = finalStage;
    }

    /**
     * @return the currentStage
     */
    public int getCurrentStage()
    {
        return currentStage;
    }

    /**
     * @param currentStage the currentStage to set
     */
    public void setCurrentStage(int currentStage)
    {
        this.currentStage = currentStage;
    }

    /**
     * @return the flip
     */
    public TableFlip getFlip()
    {
        return flip;
    }

    /**
     * @param flip the flip to set
     */
    public void setFlip(TableFlip flip)
    {
        this.flip = flip;
    }

    /**
     * @return the destroy
     */
    public DeskDestroy getDestroy()
    {
        return destroy;
    }

    /**
     * @param destroy the destroy to set
     */
    public void setDestroy(DeskDestroy destroy)
    {
        this.destroy = destroy;
    }
}
