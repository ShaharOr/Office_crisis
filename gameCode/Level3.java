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
 *
 * @author class3
 */
public class Level3 extends LevelCanvas {

    public static boolean isDisplayed = false;

    /**
     * @return the isFinished
     */
    public Level3(boolean mode) throws IOException {


        setFullScreenMode(true);

        isDisplayed = true;
        screenWidth = getWidth();
        screenHeight = getHeight();
        x = 0;
        y = 0;
        g = getGraphics();
        finalCountDown = 81;
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

        closeAll();
        midlet.switchDisplayable(null, midlet.getCeoStartCanvas());


    }

    /**
     * initializes all the parameters needed for the class
     */
    public void init() throws IOException {

        gd = new GameDesign();
        lm = new LayerManager();
        worker = new Worker(gd.getWorker(), gd);

        shotUpgrade = new ShotUpgrade(gd.getBullett(), gd, 100, lm);

        ammo_str = new String();
        score_str = new String();

        floor = gd.getGameFloor();

        lifeMng = new LifeMng();
        isFinished = false;

        tank = new Tank(gd, 600);


        isFinished = false;
        shouldEndLevel = false;

        elv = new Elevator(gd.getElevator(), gd, floor.getWidth() - 200);
        elv.gravity(floor);

        lm.insert(floor, 0);

        try {

            mpStart = new MyMediaPlayer("/Sound/Level3.mp3");
            mpStart.setVolume(50);

            mpStart.setLoopCount(1);
            mpStart.play();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }

        try {
            img_office1 = Image.createImage("/Pics/office3.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

      




        try {

            startImg1 = Image.createImage("/Pics/level3Start1.png");
            startImg2 = Image.createImage("/Pics/level3Start2.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }





        lm.append(tank);
        boss = null;
        boss = new Boss1(gd.getBoss3_sprite(), gd, elv.getX() - 700, gd.boss3_walkSeq, gd.boss3_attackSeq);

        boss.setHealth(boss.getHealth() * 2);




        int rival_x = 500;
        if (mode == true) {
            for (int i = 0; i < 7; i++) {

                rival = new Rival(gd.getRival(), gd, rival_x);

                rival.setIsFalling(true);
                lm.append(rival);


                rival_x += 500;

            }
        }

        if (mode == false) {

            for (int i = 0; i < 15; i++) {

                rival = new Rival(gd.getRival(), gd, rival_x);

                rival.setIsFalling(true);
                lm.append(rival);

                rival_x += 200;

            }



        }


        lm.append(elv);
        lm.append(worker);

        int desk_x = 800;


        desk = new Desk(gd.getDesks(), desk_x, gd.flipSeq);

        lm.append(desk);

        desk.gravity(floor);

        int stapler_x = 200;

        for (int i = 0; i < 3; i++) {
            stapler = new Stapler(gd.getStaplerSprite(), stapler_x);
            lm.append(stapler);
            stapler.gravity(floor);
            stapler_x += 100;

        }


        boss.setIsFalling(true);

        lm.append(boss);

        tank.gravity(floor);
        shotUpgrade.gravity(floor);
        lm.append(shotUpgrade);



        timer = new Timer();
        rival_x = 0;
        desk_x = 0;
        //  stapler_x = 0;


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
                    //  mpStart = null;

                    try {

                        mpStart = new MyMediaPlayer("/Sound/Requiem.mp3");
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
                if (worker.isAttacking) {
                    System.out.println("worker is attacking");
                }

                if (!worker.collidesWith(floor, true) && !worker.isIsJumping() && !worker.collidesWith(desk, true)) {

                    worker.startGravity(gd.SeqFall);

                }
                if (worker.isFalling) {
                    worker.checkGravity(lm);
                }
                shotUpgrade.movement();
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
