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
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.MediaException;

/**
 *first menu of the game in which the player chooses his first intentions.
 * @author class3
 */
public class MyMenuCanvas extends Canvas {

    /**
     * one of the images used for the display of selection illusion.
     */
    private Image menuImg1;
    /**
     * one of the images used for the display of selection illusion.
     */
    private Image menuImg2;
    /**
     * one of the images used for the display of selection illusion.
     */
    private Image menuImg3;
    /**
     * the current displayed image on screen.
     */
    private Image currentImg;
    /**
     * index which is given for every image.
     */
    private int currentImgIndx;
    /**
     * if next screen should be instCanvas-true,else-false.
     */
    private boolean goToInst;
    /**
     * if next screen should be myModeMenuCanvas-true,else-false.
     */
    private boolean goToGame;
    /**
     * if next screen should be the best scores form-true,else-false.
     */
    private boolean goToScores;
    /**
     * midlet object of the game.
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
     * constructor.
     */
    public MyMenuCanvas() {

        setFullScreenMode(true);
        goToInst = false;
        goToGame = false;
        goToScores = false;

        init();

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
            menuImg1 = Image.createImage("/Pics/menu1.png");
            menuImg2 = Image.createImage("/Pics/menu2.png");
            menuImg3 = Image.createImage("/Pics/menu3.png");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        currentImgIndx = 1;
        currentImg = menuImg1;

    }
/**
 * sets the midlet object.
 * @param midlet 
 */
    public void setMidlet(OCMIDLet midlet) {
        this.midlet = midlet;
    }
    /**
     * closes the threads and objects in the class
     */
    public void closeAll() {

        menuImg1 = null;
        menuImg2 = null;
        menuImg3 = null;
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
                    goToInst = true;
                    break;
                case 2:
                    goToGame = true;
                    break;
                case 3:
                    goToScores = true;
                    break;
            }

            closeAll();
            if (goToInst) {
                midlet.switchDisplayable(null, midlet.getInstCanvas());
            } else {
                if (goToGame) {
                    midlet.switchDisplayable(null, midlet.getMyModeMenuCanvas());

                } else {
                    if (goToScores) {
                        midlet.switchDisplayable(null, midlet.getTop_scores_frm());
                    }
                }

            }
            return;
        }

        switch (gameCode) {
            case Canvas.DOWN:
                if (currentImgIndx == 1) {
                    currentImgIndx = 2;
                    currentImg = menuImg2;
                } else {
                    if (currentImgIndx == 2) {
                        currentImgIndx = 3;
                        currentImg = menuImg3;

                    } else {
                        if (currentImgIndx == 3) {
                            currentImgIndx = 1;
                            currentImg = menuImg1;
                        }
                    }
                }

                break;
            case Canvas.UP:

                if (currentImgIndx == 1) {
                    currentImgIndx = 3;
                    currentImg = menuImg3;
                } else {
                    if (currentImgIndx == 2) {
                        currentImgIndx = 1;
                        currentImg = menuImg1;

                    } else {
                        if (currentImgIndx == 3) {
                            currentImgIndx = 2;
                            currentImg = menuImg2;
                        }
                    }
                }
                break;
        }


        repaint();
    }
}
