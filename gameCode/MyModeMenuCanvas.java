/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import hello.OCMIDLet;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.MediaException;

/**
 * a menu to select a difficulty level of the game.
 *
 * @author class3
 */
public class MyModeMenuCanvas extends Canvas {

    /**
     * one of the images used for the display of selection illusion.
     */
    private Image menuImg1;
    /**
     * one of the images used for the display of selection illusion.
     */
    private Image menuImg2;
    /**
     * the current displayed image on screen.
     */
    private Image currentImg;
    /**
     * index which is given for every image.
     */
    private int currentImgIndx;
    /**
     * midlet object for the menu.
     */
    private OCMIDLet midlet;
    /**
     * if the canvas should end and switch-true,else-false.
     */
    private boolean isFinished;
    /**
     * An object that plays the background music
     */
    private MyMediaPlayer mp;
    /**
     * if the difficulty level chosen is easy-true,else-false.
     */
    private boolean isEasy;
    /**
     * if the difficulty level chosen is extreme-true,else-false.
     */
    private boolean isExtreme;

    /**
     * constructor.
     */
    public MyModeMenuCanvas() {


        setFullScreenMode(true);
        isEasy = false;
        isExtreme = false;


        init();



    }

    /**
     * sets the midlet object.
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
        int i = 1;
        isFinished = false;
        try {
            mp = new MyMediaPlayer("/Sound/Menu_Escape.mp3");
            mp.setVolume(50);
            mp.setLoopCount(-1);
            mp.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }




        try {
            menuImg1 = Image.createImage("/Pics/modeMenu1.png");
            menuImg2 = Image.createImage("/Pics/modeMenu2.png");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        currentImgIndx = 1;
        currentImg = menuImg1;



    }

    /**
     * closes the threads and objects in the class
     */
    public void closeAll() {


        menuImg1 = null;
        menuImg2 = null;

        currentImg = null;

        isFinished = true;


        try {
            mp.stop();
            mp.close();
            mp = null;
        } catch (MediaException ex) {
            ex.printStackTrace();
        }



    }
/**
 * paints the current image on screen
 * @param g 
 */
    protected void paint(Graphics g) {
        if (currentImg != null) {
            g.drawImage(currentImg, 0, 0, Graphics.TOP | Graphics.LEFT);
        }
    }
/**
 * this method recieves the keyCode and makes changes in the canvas according to it.
 * @param keyCode 
 */
    protected void keyPressed(int keyCode) {

        int gameCode = this.getGameAction(keyCode);
        if (gameCode == Canvas.FIRE) {
            switch (currentImgIndx) {
                case 1:
                    midlet.setMode(true);
                    break;
                case 2:
                    midlet.setMode(false);
                    break;

            }

            closeAll();
           midlet.setGameCurrentScore(0);
            midlet.switchDisplayable(null, midlet.getLevel1());
            return;
        }

        switch (gameCode) {
            case Canvas.DOWN:
                if (currentImgIndx == 1) {
                    currentImgIndx = 2;
                    currentImg = menuImg2;
                } else {
                    if (currentImgIndx == 2) {
                        currentImgIndx = 1;
                        currentImg = menuImg1;

                    }

                }

                break;
            case Canvas.UP:

                if (currentImgIndx == 1) {
                    currentImgIndx = 2;
                    currentImg = menuImg2;
                } else {
                    if (currentImgIndx == 2) {
                        currentImgIndx = 1;
                        currentImg = menuImg1;

                    }

                }
                break;
        }


        repaint();

    }
}
