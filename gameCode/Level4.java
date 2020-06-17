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
 * the level 4 gameCanvas of the game.
 *
 * @author class3
 */
public class Level4 extends LevelCanvas {

    /**
     * @return the isFinished
     */
    public static boolean running;

    public Level4(boolean mode) throws IOException {


        setFullScreenMode(true);



        screenWidth = getWidth();
        screenHeight = getHeight();
        x = 0;
        y = 0;
        g = getGraphics();
        finalCountDown = 91;

        running = true;


        init();

        startThread();



    }

    /**
     * calls a method which closes all the threads and objects of the level,
     * sets the current score of the game in the midlet and switches with the
     * win Canvas.
     */
    public void finishLevel() {

        midlet.setGameCurrentScore(midlet.getGameCurrentScore() + gameScore);

        closeAll();
        midlet.switchDisplayable(null, midlet.getWinCanvas());


    }

   

    /**
     * initializes all the parameters needed for the class
     */
    public void init() throws IOException {

        gd = new GameDesign();
        lm = new LayerManager();
        worker = new Worker(gd.getWorker(), gd);

        ammo_str = new String();
        score_str = new String();

        floor = gd.getFloorLevel4();

        lifeMng = new LifeMng();
        isFinished = false;

        tank = new Tank(gd, 600);

        isFinished = false;
        shouldEndLevel = false;


        elv = new Elevator(gd.getElevator(), gd, floor.getWidth() - 200);


        lm.insert(floor, 0);

        try {

            mpStart = new MyMediaPlayer("/Sound/Level4.mp3");
            mpStart.setVolume(50);

            mpStart.setLoopCount(1);
            mpStart.play();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }

        try {
            img_office1 = Image.createImage("/Pics/office4.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        lm.append(worker);


        try {

            startImg1 = Image.createImage("/Pics/level4Start1.png");
            startImg2 = Image.createImage("/Pics/level4Start2.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }





        boss = null;
        boss = new Boss1(gd.getCEO_sprite(), gd, 800, gd.CEOWalkSeq, gd.CEOAttackSeq);
        boss.setHealth(boss.getHealth() * 3);


        lm.append(boss);


        int stapler_x = 200;

        for (int i = 0; i < 5; i++) {
            stapler = new Stapler(gd.getStaplerSprite(), stapler_x);
            lm.append(stapler);
            stapler.gravity(floor);
            stapler_x += 100;

        }


        boss.setIsFalling(true);


        timer = new Timer();

        stapler_x = 0;


    }

    /**
     * runs the main thread of the level so at first there will be a animation
     * introduction to the level and then the level itself with all the
     * controlling options of the player by getting the keys state and making
     * the worker react to them, also, makes all the objects and characters to
     * function.
     */
    public void run() {
        int startTimerCount = 0;
        int CEOSpecialAttcakTimer = 0;
        while (isRunning) {

            if (startTimerCount < 12) {

                if (startTimerCount % 2 == 0) {
                    g.drawImage(startImg1, screenWidth / 5, screenHeight / 3, Graphics.TOP | Graphics.LEFT);
                }
                if (startTimerCount % 2 != 0) {
                    g.drawImage(startImg2, screenWidth / 5, screenHeight / 3, Graphics.TOP | Graphics.LEFT);
                }
                flushGraphics();



                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (startTimerCount == 11) {

                    mpStart.close();


                    try {


                        mpStart = new MyMediaPlayer("/Sound/in the hall of the mountain king.mp3");
                        mpStart.setVolume(50);

                        mpStart.setLoopCount(-1);
                        mpStart.play();




                    } catch (MediaException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                startTimerCount++;

            } else {




                adjustViewScreen();

                int keyState = getKeyStates();
                if (worker != null) {
                    worker.reactTodir(keyState, lm);
                }

                if (!worker.collidesWith(floor, true) && !worker.isIsJumping()) {

                    worker.startGravity(gd.SeqFall);

                }
                if (worker.isFalling) {
                    worker.checkGravity(lm);
                }
                elv.checkCollisionWithWorker(worker, lm);

                if (!boss.isDead) {


                    if (CEOSpecialAttcakTimer % 61 == 0) {
                        boss.setTt(null);
                        boss.SpecialAttack(worker, lm);

                    } else {
                        if (!boss.specialAttacking) {
                            if (boss.isFalling) {
                                boss.startGravity(gd.bossWalkSeq);

                                boss.checkRivalGravity(lm);
                            }

                            boss.checkAttackRange(worker, lm);
                        }
                    }
                    CEOSpecialAttcakTimer++;




                }
                checkIfWorkerFallen();



                if (countDownTimer % 10 == 0) {
                    finalCountDown--;
                }
                drawAll();
                countDownTimer++;
                checkIfWorkerDead();


                if (!shouldEndLevel) {
                    checkIfOutOfTime();
                }

                try {
                    if (!shouldEndLevel) {
                        checkIfFinished(isFinished);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}
