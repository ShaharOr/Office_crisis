package gameCode;

import gameCode.MyMediaPlayer;
import hello.OCMIDLet;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.MediaException;

/**
 * a game canvas which runs an animation of pictures which declare the player a
 * winner
 *
 * @author class3
 */
public class WinCanvas extends GameCanvas implements Runnable {

    /**
     * the image which will be used to enter images to an Image vector
     */
    private Image img;
    /**
     * the vector which contains all the images
     */
    private Vector imgVector;
    /**
     * the certain index in the vector
     */
    private int currentImgIndx;
    /**
     * graphics object
     */
    private Graphics g;
    /**
     * the thread which runs class to show the images one after another Allows
     * to create a number of processes at the same time
     */
    private Thread myThread;
    /**
     * If the thread runs it is true, if not false.
     */
    private boolean isRunning;
    /**
     * midlet object for the class.
     */
    private OCMIDLet midlet;
    /**
     * if the thread finished running the action it was supposed to run-
     * true,else- false.
     */
    private boolean isFinished;
    /**
     * media player to run sound affects for the class
     */
    private MyMediaPlayer mp;

    /**
     * constructor.
     */
    public WinCanvas() {
        super(true);

        setFullScreenMode(true);


        init();

        startThread();


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
     * initializes all the parameters needed for the class.
     */
    public void init() {


        isFinished = false;


        g = getGraphics();
        try {
            mp = new MyMediaPlayer("/Sound/WIN.mp3");
            mp.setVolume(100);
            mp.setLoopCount(1);
            mp.play();


        } catch (IOException ex) {
            ex.printStackTrace();

        } catch (MediaException ex) {
            ex.printStackTrace();
        }


        this.setImgVector(new Vector());



        int i = 1;
        while (i <= 3) {
            try {
                String imgIndex = Integer.toString(i);
                img = Image.createImage("/Pics/gameWin" + imgIndex + ".png");
                getImgVector().addElement(getImg());

                //g.drawImage(img, 0, 0, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            i++;

        }
        System.out.println("vector size: " + imgVector.size());
        try {
            img = Image.createImage("/Pics/gameWin1.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        g.drawImage(img, 0, 0, Graphics.TOP | Graphics.LEFT);




    }

    /**
     * closes the threads and objects in the class
     */
    public void closeAll() {
        imgVector = null;

        stopThread();
        g = null;
        isFinished = true;
        myThread = null;
        img = null;
        mp.close();
        midlet.switchDisplayable(null, midlet.getSaveNameFrm());
    }

    /**
     * stops the thread
     */
    public void stopThread() {
        this.setIsRunning(false);
        this.setMyThread(null);
    }

    /**
     * starts the thread
     */
    public void startThread() {
        if (getMyThread() == null) {
            setMyThread(new Thread(this));
            this.setIsRunning(true);
            this.getMyThread().start();

        }
    }

    /**
     * method which runs the action of the class. prints on screen one picture
     * after another from the vector of images.
     */
    public void run() {

        int vectorIndex = 0;
        while (isRunning) {


            if (vectorIndex < imgVector.size()) {



                img = (Image) (imgVector.elementAt(vectorIndex));
                g.drawImage(img, 0, 0, Graphics.TOP | Graphics.LEFT);
                System.out.println(vectorIndex);



                vectorIndex++;






            } else {
                try {

                    Thread.sleep(5800);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }


                closeAll();


            }
            try {
                System.out.println("now");
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }


            flushGraphics();

        }
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
     * @return the g
     */
    public Graphics getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(Graphics g) {
        this.g = g;
    }

    /**
     * @return the myThread
     */
    public Thread getMyThread() {
        return myThread;
    }

    /**
     * @param myThread the myThread to set
     */
    public void setMyThread(Thread myThread) {
        this.myThread = myThread;
    }

    /**
     * @return the isRunning
     */
    public boolean isIsRunning() {
        return isRunning;
    }

    /**
     * @param isRunning the isRunning to set
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
