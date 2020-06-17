/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import hello.OCMIDLet;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * a canvas which shows images which represent the instructions for the game
 *
 * @author user
 */
public class InstCanvas extends Canvas {

    /**
     * the image which will be used to enter images to an Image vector.
     */
    private Image img;
    /**
     * the vector which contains all the images.
     */
    private Vector imgVector;
    /**
     * the certain index in the vector.
     */
    private int currentImgIndx;
    /**
     * if the thread finished running the action it was supposed to run-
     * true,else- false.
     */
    private boolean isFinished;
    /**
     * the current image which is shown from all the images in the vector.
     */
    private Image currentImage;
    /**
     * a midlet object for the class to use.
     */
    private OCMIDLet midlet;

    /**
     * constructor.
     */
    public InstCanvas() {


        setFullScreenMode(true);
        isFinished = false;



        init();


    }

    /**
     * sets the midlet object
     *
     * @param midlet
     */
    public void setMidlet(OCMIDLet midlet) {
        this.midlet = midlet;
    }

    /**
     * initializes all the parameters needed for the class
     */
    public void init() {



        this.setImgVector(new Vector());


        int i = 1;
        while (i <= 9) {
            try {
                String imgIndex = Integer.toString(i);
                setImg(Image.createImage("/Pics/inst" + imgIndex + ".png"));
                getImgVector().addElement(getImg());
                //g.drawImage(img, 0, 0, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            i++;

        }
        currentImage = (Image) imgVector.elementAt(0);
        currentImgIndx = 0;

    }

    /**
     * closes the objects in the class
     */
    public void closeAll() {
        img = null;
        imgVector = null;
        currentImage = null;
        currentImgIndx = 0;


    }

    /**
     * Paint the graphics on the canvas.
     *
     * @param g
     */
    protected void paint(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, Graphics.TOP | Graphics.LEFT);
        }
    }
/**
 * this method recieves the keyCode and makes changes in the canvas according to it.
 * @param keyCode 
 */
    protected void keyPressed(int keyCode) {

        int gameCode = this.getGameAction(keyCode);
        if (gameCode == Canvas.DOWN) {
            closeAll();
            midlet.switchDisplayable(null, midlet.getMyMenuCanvas());
            return;
        }

        switch (gameCode) {
            case Canvas.RIGHT:
                if (currentImgIndx < 9) {
                    if (currentImgIndx < imgVector.size() - 1) {
                        currentImgIndx++;
                        currentImage = (Image) imgVector.elementAt(currentImgIndx);

                    }
                }

                break;
            case Canvas.LEFT:
                if (currentImgIndx > 0) {
                    currentImgIndx--;
                    currentImage = (Image) imgVector.elementAt(currentImgIndx);

                }


                break;
        }


        repaint();

    }

    /**
     * @return the img
     */
    public Image getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * @return the imgVector
     */
    public Vector getImgVector() {
        return imgVector;
    }

    /**
     * @param imgVector the imgVector to set
     */
    public void setImgVector(Vector imgVector) {
        this.imgVector = imgVector;
    }

    /**
     * @return the currentImgIndx
     */
    public int getCurrentImgIndx() {
        return currentImgIndx;
    }

    /**
     * @param currentImgIndx the currentImgIndx to set
     */
    public void setCurrentImgIndx(int currentImgIndx) {
        this.currentImgIndx = currentImgIndx;
    }
}
