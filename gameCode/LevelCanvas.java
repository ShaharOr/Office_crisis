/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import hello.OCMIDLet;
import java.io.IOException;
import java.util.Timer;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.TiledLayer;
import javax.microedition.media.MediaException;

/**
 * the abstract class which all the levels inherit from and implement the
 * methods of the init ,run and finish.
 *
 * @author class3
 */
public abstract class LevelCanvas extends GameCanvas implements Runnable {

    /**
     * graphics object.
     */
    protected Graphics g;
    /**
     * main thread of the gameCavas, Allows to create a number of processes at
     * the same time.
     *
     */
    protected Thread myThread;
    /**
     * If the main Thread runs it is true, if not false.
     */
    protected boolean isRunning = false;
    /**
     * horizonal parameter.
     */
    protected int x;
    /**
     * vertical parameter.
     */
    protected int y;
    /**
     * the Width of the screen on which the gameCanvas is displayed.
     */
    protected int screenWidth;
    /**
     * the Height of the screen on which the gameCanvas is displayed.
     */
    protected int screenHeight;
    /**
     * the worker character.
     */
    protected Worker worker;
    /**
     * the rival character.
     */
    protected Rival rival;
    /**
     * Contains all the sequence of the sprites in the game.
     */
    protected GameDesign gd;
    /**
     * An object that simplifies the process of rendering the layers that have
     * been added to it.
     */
    static LayerManager lm;
    /**
     * the Tiled Layer of the floor of the levels.
     */
    protected TiledLayer floor;
    /**
     * A facility for threads to schedule tasks for future execution in a
     * background thread.
     */
    static Timer timer;
    /**
     * the background picture of the level
     */
    protected Image img_office1;
    /**
     *
     * The distance that defines how the screen will move with the player.
     */
    protected int gap = 60;
    /**
     * the desk object.
     */
    protected Desk desk;
    /**
     * the stapler object.
     */
    protected Stapler stapler;
    /**
     * the boss enemy at the end of the level.
     */
    protected Boss1 boss;
    /**
     * the life objects Manager which controls all the actions related to the
     * life objects.
     */
    protected LifeMng lifeMng;
    /**
     * the string object which describes the player's ammunition state.
     */
    protected String ammo_str;
    /**
     * the string object which describes the player's score state.
     */
    protected String score_str;
    /**
     * the tank object.
     */
    protected Tank tank;
    /**
     * the shot upgrade object.
     */
    protected ShotUpgrade shotUpgrade;
    /**
     * the elevator object.
     */
    protected Elevator elv;
    /**
     * if the level is or should be ended
     */
    protected static boolean isFinished;
    /**
     * the midlet object .
     */
    protected OCMIDLet midlet;
    /**
     * the media player which perform the background music of the level and the
     * introduction sound effect.
     */
    protected MyMediaPlayer mpStart;
    /**
     * the number of seconds remaining to finish the level.
     */
    protected int finalCountDown;
    /**
     * helps setting the final countdown.
     */
    protected int countDownTimer = 0;
    /**
     * the string object which describes the player's final countdown state.
     */
    protected String countDownString;
    /**
     * an image used for the introduction of the level animation.
     */
    protected Image startImg1;
    /**
     * an image used for the introduction of the level animation.
     */
    protected Image startImg2;
    /**
     * the score of the player.
     */
    protected int gameScore;
    /**
     * true- low difficulty for the level, false-high difficulty of the level.
     */
    protected boolean mode;
    /**
     * true if a change in the level acured which requiers its ending,
     * false-else.
     */
    public static boolean shouldEndLevel;

    /**
     * constructor
     *
     * @throws IOException
     */
    public LevelCanvas() throws IOException {
        super(true);

        setFullScreenMode(true);


        screenWidth = getWidth();
        screenHeight = getHeight();
        x = 0;
        y = 0;
        g = getGraphics();







    }

    /**
     * sets the midlet object of the level.
     *
     * @param midlet
     */
    public void setMidlet(OCMIDLet midlet) {
        this.midlet = midlet;
    }

    /**
     * checks if the isFinished parameter of the level is true and if so it
     * calls a method which finishes the level.
     *
     * @param isFinished
     * @throws IOException
     */
    public void checkIfFinished(boolean isFinished) throws IOException {
        if (isFinished == true) {

            finishLevel();

        }
    }

    /**
     * method which finishes the level, each level in his own way.
     */
    public abstract void finishLevel();

    /**
     * checks if the finalCountDown hit zero, if so, finishes level and switches
     * screens.
     */
    public void checkIfOutOfTime() {
        if (finalCountDown < 0) {
            midlet.setGameCurrentScore(midlet.getGameCurrentScore() + gameScore);
            shouldEndLevel = true;
            closeAll();
            midlet.switchDisplayable(null, midlet.getTimeOutCanvas());
        }
    }

    /**
     * closes the threads and objects in the class
     */
    public void closeAll() {


        for (int i = 0; i < lm.getSize(); i++) {
            if (lm.getLayerAt(i) instanceof GameSprite) {
                GameSprite gs = (GameSprite) lm.getLayerAt(i);
                if (gs.myMoveTask != null) {
                    gs.myMoveTask.cancel();
                }
                gs.myMoveTask = null;
                gs = null;

            }
            if (lm.getLayerAt(i) instanceof Desk) {
                desk = (Desk) lm.getLayerAt(i);
                if (desk.flip != null) {
                    desk.flip.cancel();
                }
                desk.flip = null;
                desk = null;
            }

            if (lm.getLayerAt(i) instanceof Elevator) {
                elv = (Elevator) lm.getLayerAt(i);
                if (elv.tt != null) {
                    elv.tt.cancel();
                }
                elv.tt = null;
                elv = null;

            }
            if (lm.getLayerAt(i) instanceof Bullets) {
                Bullets blt = (Bullets) lm.getLayerAt(i);
                if (blt.getTt() != null) {
                    blt.getTt().cancel();
                }
                blt.setTt(null);

                blt = null;

            }



        }


        g = null;





        worker.blt = null;

        worker.mp = null;


        worker = null;
        rival = null;
        gd = null;
        lm = null;
        floor = null;
        timer.cancel();
        timer = null;
        img_office1 = null;

        desk = null;

        stapler = null;
        boss = null;

        lifeMng = null;

        ammo_str = null;
        score_str = null;
        tank = null;
        shotUpgrade = null;
        elv = null;

        stopThread();



        mpStart.close();

        mpStart = null;


        startImg1 = null;
        startImg2 = null;

        System.out.println("closed all");

    }

    /**
     * initializes all the parameters needed for the level, each inheriting
     * level in his own way.
     *
     */
    public abstract void init() throws IOException;

    public void adjustViewScreen() {
        int dy = 0, dx = 0;
        if (worker != null) {

            if (worker.getX() + worker.getWidth() + worker.getStep() > x + screenWidth - gap) {
                dx = 0;
                while (worker.getX() + worker.getWidth() + worker.getStep() > x + screenWidth - gap + dx) {
                    dx++;
                }
            }
            if (worker.getX() < x + gap) {
                dx = 0;
                while (worker.getX() < x + dx + gap) {
                    dx--;
                }
            }
            if (worker.getY() + worker.getHeight() + worker.getStep() > y + screenHeight - gap) {
                dy = 0;
                while (worker.getY() + worker.getHeight() + worker.getStep() > y + screenHeight - gap + dy) {
                    dy++;
                }

            }

            if (worker.getY() + worker.getStep() < y + gap) {
                dy = 0;
                while (worker.getY() + worker.getStep() - dy < y + gap) {
                    dy--;
                }
            }


            x += dx;
            y += dy;
            lm.setViewWindow(x, y, screenWidth, screenHeight);
        }
    }

    /**
     * stops the main thread of the level.
     */
    public void stopThread() {
        this.isRunning = false;
        this.myThread = null;
    }

    /**
     * starts the main thread of the level.
     */
    public void startThread() {
        if (myThread == null) {

            myThread = new Thread(this);
            this.isRunning = true;
            this.myThread.start();

        }
    }

    /**
     * checks if the worker is dead and if so switches screens with deathCanvas.
     */
    public void checkIfWorkerDead() {
        if (worker.isDead == true) {
            midlet.setGameCurrentScore(midlet.getGameCurrentScore() + gameScore);
            shouldEndLevel = true;
            closeAll();
            midlet.switchDisplayable(null, midlet.getDeathCanvas());
        }
    }

    /**
     * checks if worker fallen out of the floor and acts according to it.
     */
    public void checkIfWorkerFallen() {
        if (worker.getY() > 2000) {
            lifeMng.decrease();
            worker.move(0, -2200);
            worker.setX(30);
        }
    }

    /**
     * runs the main thread of the level, each inheriting level in his own way.
     */
    public abstract void run();

    /**
     * draws All the layers, images, objects and characters of the game.
     */
    public void drawAll() {
        g.setColor(0xffffff);

        g.fillRect(0, 0, screenWidth, screenHeight);
        g.drawImage(img_office1, 0, 0, Graphics.TOP | Graphics.LEFT);
        lifeMng.drawMng(g);
        g.setColor(0xffffff);
        g.fillRect(1, 19, 90, 47);

        g.setColor(0x000000);
        ammo_str = "AMMO: ";
        ammo_str += (worker.getAmmo());
        score_str = "SCORE: ";

        gameScore = worker.getScore() + midlet.getGameCurrentScore();
        score_str += (getGameScore());
        countDownString = "COUNT DOWN: " + getFinalCountDown();
        g.drawString(countDownString, 2, 48, Graphics.TOP | Graphics.LEFT);

        g.drawString(ammo_str, 2, 18, Graphics.TOP | Graphics.LEFT);
        g.drawString(score_str, 2, 32, Graphics.TOP | Graphics.LEFT);


        worker.drawHealth(g, x, y, lifeMng, lm);
        boss.drawHealth(g, x, y, null, lm);
        for (int i = 0; i < lm.getSize(); i++) {
            if (lm.getLayerAt(i) instanceof Rival) {
                rival = (Rival) lm.getLayerAt(i);
                if (!rival.isDead) {
                    rival.drawHealth(g, x, y, null, lm);
                }
            }
        }

        lm.paint(g, 0, 0);

        flushGraphics();

    }

    /**
     *
     * @return if isFinished
     */
    public static boolean isIsFinished() {
        return isFinished;
    }

    /**
     * @param aIsFinished the isFinished to set
     */
    public static void setIsFinished(boolean aIsFinished) {
        isFinished = aIsFinished;
    }

    /**
     * @return the gameScore
     */
    public int getGameScore() {
        return gameScore;
    }

    /**
     * @param gameScore the gameScore to set
     */
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    /**
     * @return the finalCountDown
     */
    public int getFinalCountDown() {
        return finalCountDown;
    }

    /**
     * @param finalCountDown the finalCountDown to set
     */
    public void setFinalCountDown(int finalCountDown) {
        this.finalCountDown = finalCountDown;
    }
}
