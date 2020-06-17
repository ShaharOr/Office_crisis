/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;

/**
 *an object which represent the amount of life remaining for the player.
 * @author class3
 */
public class Life
{
 /**
     * initial horizonal parameter in which the object will be set.
     */
    private int x;
     /**
     * initial vertical parameter in which the object will be set.
     */
    private int y;
    /*
     * the width of the object.
     */
    private int width;
    /*
     * the height of the object.
     */
    private int height;
    /*
     *the image of the objects.  
     */
    private Image img;
/**
 * constructor.
 */
    public Life()
    {
        this.x = 0;
        this.y = 0;
        try
        {
            this.img = Image.createImage("/Pics/life.png");
            this.width = img.getWidth();
            this.height = img.getHeight();

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
/**
 * draws the object.
 * @param g 
 */
    public void drawMe(Graphics g)
    {
        g.drawImage(img, x, y, Graphics.TOP | Graphics.LEFT);
    }

    /**
     * @return the x
     */
    public int getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img)
    {
        this.img = img;
    }
}
