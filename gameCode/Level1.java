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
 * the level 1 gameCanvas of the game.
 *
 * @author class3
 */
public class Level1 extends LevelCanvas {

    public static boolean isDisplayed = false;

    /**
     * constructor.
     *
     * @param mode
     * @throws IOException
     */
    public Level1(boolean mode) throws IOException {


        setFullScreenMode(true);


        screenWidth = getWidth();
        screenHeight = getHeight();
        x = 0;
        y = 0;
        g = getGraphics();
        isDisplayed = true;
        finalCountDown = 61;
        this.mode = mode;




        init();

        startThread();



    }

    /**
     * calls a method which closes all the threads and objects of the level,
     * sets the current score of the game in the midlet and switches with the
     * next level.
     */
    public void finishLevel() {

        midlet.setGameCurrentScore(midlet.getGameCurrentScore() + gameScore);
        shouldEndLevel = true;
        this.setIsFinished(true);
        closeAll();

        Level2 level2 = midlet.getLevel2();
        midlet.switchDisplayable(null, level2);








    }

    /**
     * initializes all the parameters needed for the class
     */
    public void init() throws IOException {

        gd = new GameDesign();
        lm = new LayerManager();
        worker = new Worker(gd.getWorker(), gd);

        shotUpgrade = new ShotUpgrade(gd.getBullett(), gd, 1500, lm);

        ammo_str = new String();
        score_str = new String();



        floor = gd.getGameFloor();

        lifeMng = new LifeMng();
        isFinished = false;

        tank = new Tank(gd, 600);



        elv = new Elevator(gd.getElevator(), gd, floor.getWidth() - 200);
        elv.gravity(floor);

        lm.insert(floor, 0);

        try {

            mpStart = new MyMediaPlayer("/Sound/Level1.mp3");
            mpStart.setVolume(50);

            mpStart.setLoopCount(1);
            mpStart.play();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }

        try {
            img_office1 = Image.createImage("/Pics/office1.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        boss = new Boss1(gd.getBoss_1(), gd, floor.getWidth()-1000, gd.bossWalkSeq, gd.bossAttaclSeq);
        boss.setIsFalling(true);

        shouldEndLevel = false;



        try {

            startImg1 = Image.createImage("/Pics/level1Start1.png");
            startImg2 = Image.createImage("/Pics/level1Start2.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }



        int desk_x = 400;
        int rival_x = 500;
        if (mode == true) {
            for (int i = 0; i < 5; i++) {

                rival = new Rival(gd.getRival(), gd, rival_x);

                rival.setIsFalling(true);
                lm.append(rival);

                rival_x += 400;

            }
        }
        if (mode == false) {
            for (int i = 0; i < 13; i++) {


                rival = new Rival(gd.getRival(), gd, rival_x);

                rival.setIsFalling(true);
                lm.append(rival);

                rival_x += 100;

            }

        }


        lm.append(worker);

        for (int i = 0; i < 3; i++) {


            desk = new Desk(gd.getDesks(), desk_x, gd.flipSeq);

            lm.append(desk);
            desk_x += 600;
            desk.gravity(floor);
        }
        int stapler_x = 200;




        lm.append(boss);

        tank.gravity(floor);
        shotUpgrade.gravity(floor);
        // lm.append(shotUpgrade);
        lm.append(elv);


        timer = new Timer();
        rival_x = 0;
        desk_x = 0;
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

                        mpStart = new MyMediaPlayer("/Sound/HilikPortzelEightBit.mp3");
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
                if (!worker.isDead) {

                    worker.reactTodir(keyState, lm);
                }


                if (!worker.collidesWith(floor, true) && !worker.isIsJumping() && !worker.collidesWith(desk, true)) {

                    worker.startGravity(gd.SeqFall);

                }
                if (worker.isFalling) {
                    worker.checkGravity(lm);
                }

                elv.checkCollisionWithWorker(worker, lm);

                if (!boss.isDead) {

                    if (boss.isFalling) {
                        boss.startGravity(gd.bossWalkSeq);


                        boss.checkRivalGravity(lm);
                    }

                    boss.checkAttackRange(worker, lm);
                    if (boss.getX() + boss.getWidth() + 20 >= floor.getWidth()) {
                        boss.move(-50, 0);
                    }




                }
                checkIfWorkerFallen();

                for (int i = 0; i < lm.getSize(); i++) {
                    if (lm.getLayerAt(i) instanceof Rival) {
                        rival = (Rival) lm.getLayerAt(i);


                        if (rival.isFalling) {
                            rival.startGravity(gd.RivalSeq);

                            rival.checkRivalGravity(lm);
                        }
                        if (!rival.isDead) {
                            rival.checkAttackRange(worker, lm);
                            if (!rival.goingToAttack) {
                                rival.walk(lm);
                            }

                            rival.drawHealth(g, x, y, null, lm);
                            if (!rival.collidesWith(floor, true)) {
                                rival.setIsFalling(true);
                            }
                        }

                    }

                }




                if (countDownTimer % 10 == 0) {
                    finalCountDown--;
                }
                countDownTimer++;

                drawAll();

                checkIfOutOfTime();
                if (!shouldEndLevel) {
                    checkIfWorkerDead();
                }

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
