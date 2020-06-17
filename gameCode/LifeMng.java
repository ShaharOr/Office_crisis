/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

/**
 * manages the life objects which it puts in vector.
 *
 * @author class3
 */
public class LifeMng {

    /**
     * life object.
     */
    protected Life life;
    /**
     *vector of life objects.
     */
    protected Vector v;
    /**
     *the maximum size of the vector.
     */
    protected int max_life_amount;
/**
 * constructor.
 */
    public LifeMng() {

        max_life_amount = 5;
        v = new Vector();
        life = new Life();
        for (int i = 0; i < max_life_amount; i++) {
            v.addElement(life);
        }
    }
/**
 * method which draws the vector's objects on screen
 * @param g 
 */
    public void drawMng(Graphics g) {
        Life life;
        int x = 0;
        for (int i = 0; i < v.size(); i++) {
            life = (Life) v.elementAt(i);
            life.setX(x);
            life.drawMe(g);
            x += life.getWidth();

        }
    }
/**
 * decreases the amount of lives in the vector.
 */
    public void decrease() {
        if (v.size() != 0) {
            int x = v.size();
            v.removeElementAt(x - 1);
        }
    }
}
