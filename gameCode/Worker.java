/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import javax.microedition.media.MediaException;

/**
 * this class creates and manages the worker- the hero of the game, and his
 * actions according to his interactions with other objects and sprites.
 *
 * @author class3
 */
public class Worker extends GameSprite {

    /**
     * a frame sequence for the worker to use while walking.
     */
    protected int[] seqWalk;
    /**
     * a frame sequence for the worker to use while jumping.
     */
    protected int[] seqJump;
    /**
     * a frame sequence for the worker to use while falling.
     */
    protected int[] seqFall;
    /**
     * a frame sequence for the worker to use while walking with a stapler-ready
     * to shoot.
     */
    protected int[] seqStaplerWalk;
    /**
     * a frame sequence for the worker to use while attacking.
     */
    protected int[] SeqAttack;
    /**
     * the distance the worker pass with each step- walking movement.
     */
    protected int step;
    /**
     * the last direction the worker walked in.
     */
    protected int prevDir;
    /**
     * the current direction the worker walked in.
     */
    protected int currentDir;
    /**
     * if worker is jumping/going up-true, else-false.
     */
    protected boolean isJumping;
    /**
     * if worker is has picked up a stapler and has not ran out of ammo -true,
     * else-false.
     */
    private boolean staplered;
    /**
     * /**
     * Contains all the sequence of the sprites in the game.
     */
    protected GameDesign gd;
    /**
     * a Bullets object for the worker to use when shooting.
     */
    protected Bullets blt;
    /**
     * number of shots left for the worker to perform.
     */
    protected int ammo;
    /**
     * if worker is in the process of an attack-true, else-false.
     */
    protected boolean isAttacking;
    /**
     * if worker is in the process of riding a tank object-true, else-false.
     */
    protected boolean onTank;
    /**
     * a desk object for the worker to use while checking collisions.
     */
    protected Desk desk;
    /**
     * amount of damage the worker can take before he losses one life.
     */
    protected int health;
    /**
     * the score the worker gains through his activity in the levels of the
     * game.
     */
    protected int score;
    /**
     * if the worker has taken a shotUpgrade and has not yet ran out of
     * ammo-true,else-false.
     */
    protected boolean speacialShoot;
    /**
     * if worker's bullet is in the process of lazer shot-true,else-false.
     */
    protected boolean LazerShooting;
    /**
     * elevator object for the worker to check collision with.
     */
    protected Elevator elv;
    /**
     * a Boss1 object for the worker to interact with.
     */
    protected Boss1 boss1;
    /**
     * a tiled layer representing the floor of the level for the worker to
     * interact with.
     */
    private TiledLayer floor;
    /**
     * media player to run sound affects for the class
     */
    protected MyMediaPlayer mp;
    /**
     * increases each time the worker performs a shot so the shots could be
     * inspected and controlled.
     */
    private int shotTimer;
    /**
     * a rival for the worker to interact with.
     */
    protected Rival rival;

    /**
     * constructor.
     *
     * @param s
     * @param step
     * @param x
     * @param y
     * @param seqRight
     * @param seqLeft
     * @throws IOException
     */
    public Worker(Sprite worker, GameDesign gd) throws IOException {


        super(worker, 50, 50);


        this.step = 10;
        setPosition(x, y);
        this.gd = gd;
        this.seqWalk = gd.SeqWalk;
        this.seqJump = gd.SeqJump;
        this.seqFall = gd.SeqFall;
        this.seqStaplerWalk = gd.SeqStaplerWalk;
        this.SeqAttack = gd.SeqAttack;
        this.ammo = 0;
        this.health = 100;
        this.score = 0;
        this.shotTimer = 0;

        isFalling = false;
        isJumping = false;
        staplered = false;
        isAttacking = false;
        onTank = false;
        speacialShoot = false;
        LazerShooting = false;

        prevDir = -1;




    }

    /**
     * Check if collides with floor or / and desk or and others, in order to
     * decide when the gravity should stop take its effect on worker.
     */
    public void checkGravity(LayerManager lm) {

        for (int i = 0; i < lm.getSize(); i++) {
            if (lm.getLayerAt(i) instanceof TiledLayer) {
                floor = (TiledLayer) lm.getLayerAt(i);

            }

        }
        if (this.collidesWith(floor, true)) {
            while (this.collidesWith(floor, true)) {
                this.move(0, -1);
                System.out.println("stop nowwwwwww");


            }

            if (staplered == true) {
                stopGravity(seqStaplerWalk);
            } else {
                stopGravity(seqWalk);
            }
            this.setIsFalling(false);


        }

        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < lm.getSize(); i++) {
            if ((lm.getLayerAt(i) instanceof Desk)) {
                if (this.collidesWith((Desk) lm.getLayerAt(i), true)) {
                    desk = (Desk) lm.getLayerAt(i);
                    flag1 = true;
                }
            }

            if ((lm.getLayerAt(i) instanceof Rival) && (lm.getLayerAt(i) instanceof Boss1) == false && this instanceof Boss1 == false) {
                if (this.collidesWith((Rival) lm.getLayerAt(i), true)) {
                    rival = (Rival) lm.getLayerAt(i);
                    flag2 = true;
                }
            }
        }
        if (flag1) {


            while (this.collidesWith(desk, true)) {
                this.move(0, -1);
            }
            this.move(0, 2);


            if (staplered == true) {
                stopGravity(seqStaplerWalk);
            } else {
                stopGravity(seqWalk);
            }
            this.setIsFalling(false);

        }
        if (flag2) {

            if (!rival.isDead && this.getY() + this.getHeight() / 2 <= rival.getY()) {
                while (this.collidesWith(rival, true)) {
                    this.move(0, -1);
                }
                this.move(0, 2);
                rival.attacked(70, currentDir);


                if (staplered == true) {
                    stopGravity(seqStaplerWalk);
                } else {
                    stopGravity(seqWalk);
                }
                startJump();
            }

        }

        this.defineCollisionRectangle(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * this method makes the worker to start jumping.
     */
    public void startJump() {
        if (myMoveTask == null) {
            setIsJumping(true);
            setFrameSequence(getSeqJump());
            myMoveTask = new JumpTask(this);
            ((JumpTask) myMoveTask).startMe();
            timer.scheduleAtFixedRate(getMyMoveTask(), 0, 50);
        }
    }

    /**
     * makes the worker stop from any movement he does(not just jump).
     */
    public void stopJump() {
        myMoveTask = null;
    }

    /**
     * decide which action should be taken according to the given dir.
     *
     * @param dir- a keys state given by the player.
     * @param lm
     */
    public void reactTodir(int dir, LayerManager lm) {
        if (!isDead && !onTank) {


            if (dir == GameCanvas.RIGHT_PRESSED || dir == GameCanvas.LEFT_PRESSED) {
                setCurrentDir(dir);
            }

            switch (dir) {
                case GameCanvas.FIRE_PRESSED:
                    fire(lm);


                    break;

                case GameCanvas.FIRE_PRESSED + GameCanvas.LEFT_PRESSED:

                    goLeft(lm);
                    fire(lm);

                    break;
                case GameCanvas.FIRE_PRESSED + GameCanvas.RIGHT_PRESSED:

                    goRight(lm);
                    fire(lm);

                    break;



                case GameCanvas.LEFT_PRESSED:
                    goLeft(lm);


                    break;
                case GameCanvas.RIGHT_PRESSED:
                    goRight(lm);


                    break;

                case GameCanvas.UP_PRESSED:
                    if (!isFalling && !isJumping) {
                        startJump();
                    }

                    break;


                case GameCanvas.DOWN_PRESSED:
                    down(lm);

                    break;


                case (GameCanvas.DOWN_PRESSED + GameCanvas.LEFT_PRESSED):
                    goLeft(lm);
                    down(lm);

                    break;
                case (GameCanvas.DOWN_PRESSED + GameCanvas.RIGHT_PRESSED):
                    goRight(lm);
                    down(lm);

                    break;
                case (GameCanvas.UP_PRESSED + GameCanvas.LEFT_PRESSED):
                    if (!isFalling && !isJumping) {
                        startJump();
                    }
                    goLeft(lm);
                    break;
                case (GameCanvas.UP_PRESSED + GameCanvas.RIGHT_PRESSED):
                    if (!isFalling && !isJumping) {
                        startJump();
                    }
                    goRight(lm);
                    break;


            }


        }
    }

    /**
     * decide what action should be made if the key which was pressed was fire
     * key.
     *
     * @param lm
     */
    public void fire(LayerManager lm) {
        boolean flag = false;
        for (int i = 0; i < lm.getSize(); i++) {
            if ((lm.getLayerAt(i) instanceof Desk)) {
                if (this.collidesWith((Desk) lm.getLayerAt(i), true)) {
                    desk = (Desk) lm.getLayerAt(i);
                    flag = true;
                }
            }
            if (lm.getLayerAt(i) instanceof Elevator) {
                elv = (Elevator) lm.getLayerAt(i);
                if (this.collidesWith(elv, true) && !isAttacking) {
                    elv.close();
                    elv.stayClosed = true;
                    staplered = false;


                    if (Level1.isDisplayed) {
                        System.out.println("1");
                        Level1.isFinished = true;
                    }
                    if (Level2.isDisplayed) {
                        System.out.println("2");
                        Level2.setIsFinished(true);
                    }
                    if (Level3.isDisplayed) {
                        System.out.println("3");
                        Level3.setIsFinished(true);
                    }





                }




            }
            if (lm.getLayerAt(i) instanceof TiledLayer) {
                floor = (TiledLayer) (lm.getLayerAt(i));
            }
        }





        if (flag && currentDir == GameCanvas.RIGHT_PRESSED) {

            desk.flip(lm);


        }


        if (staplered && !flag) {

            if (getAmmo() > 0) {

                shoot(lm);

            }


        }
        if (!flag && !staplered && !isAttacking && !this.collidesWith(elv, true) && !isFalling && !isFalling && this.collidesWith(floor, true)) {

            attack();
        }



    }

    /**
     * this method makes the worker to start in attack movement.
     */
    public void attack() {
        if (myMoveTask == null) {


            setMyMoveTask(new AttackTT(this));


            ((AttackTT) getMyMoveTask()).startMe();

            timer.scheduleAtFixedRate(getMyMoveTask(), 0, 100);

        }


    }

    /**
     * decide what action should be made if the key which was pressed was down
     * key.
     *
     * @param lm
     */
    public void down(LayerManager lm) {

        boolean hasPicked = false;
        for (int i = 0; i < lm.getSize(); i++) {

            System.out.println(lm.getSize());

            if (lm.getLayerAt(i) instanceof Tank) {

                if (hasPicked == false) {
                    if (this.collidesWith((Tank) lm.getLayerAt(i), true)) {
                        Tank tank = (Tank) lm.getLayerAt(i);
                        lm.remove(this);
                        lm.append(this);

                        for (int j = 0; j < lm.getSize(); j++) {
                            if (lm.getLayerAt(j) instanceof Elevator) {
                                Elevator elv=(Elevator)lm.getLayerAt(j);
                                lm.remove(elv);
                                lm.append(elv);

                            }
                        }



                        tank.activate(this, lm);
                        hasPicked = true;

                    }
                }
            }
            if (hasPicked == false) {
                if (lm.getLayerAt(i) instanceof ShotUpgrade) {

                    if (this.collidesWith((ShotUpgrade) lm.getLayerAt(i), true)) {
                        ((ShotUpgrade) lm.getLayerAt(i)).pickUp();
                        this.staplered = true;
                        this.speacialShoot = true;
                        ammo = 10;
                        hasPicked = true;
                    }

                }
            }
            if (hasPicked == false) {
                if (lm.getLayerAt(i) instanceof Stapler) {


                    if (this.collidesWith((Stapler) lm.getLayerAt(i), true)) {
                        System.out.println(this.collidesWith((Stapler) lm.getLayerAt(i), true));
                        ammo += 30;
                        lm.remove((Stapler) lm.getLayerAt(i));

                        this.setFrameSequence(seqStaplerWalk);
                        setStaplered(true);
                        hasPicked = true;
                    }
                }
            }


        }
        System.out.println(hasPicked);
    }

    /**
     * this method is making the worker to perform a shoot.
     *
     * @param lm
     */
    public void shoot(LayerManager lm) {


        if (!LazerShooting) {
            if (shotTimer % 2 == 0) {

                try {
                    this.blt = null;


                    blt = new Bullets(gd.getBullett(), gd, this.getX() + 40, this.getY());
                    if (this.currentDir == GameCanvas.LEFT_PRESSED) {
                        blt.setTransform(TRANS_MIRROR);
                        blt.move(15, 0);

                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


                if (!speacialShoot) {



                    blt.setFrameSequence(blt.getRegSeq());
                    lm.append(blt);
                    blt.regularShot(this, lm);
                    if (getAmmo() == 0) {
                        this.setFrameSequence(seqWalk);
                        setStaplered(false);
                    }

                }
                if (speacialShoot) {
                    if (!LazerShooting) {

                        try {
                            mp = new MyMediaPlayer("/Sound/lazerShot.mp3");
                            mp.setVolume(90);
                            mp.setLoopCount(1);
                            mp.play();

                        } catch (MediaException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }



                        // blt.setFrameSequence(blt.getPreSeq());
                        lm.append(blt);
                        blt.lazerShot(this, lm);
                        if (getAmmo() == 0) {
                            this.setFrameSequence(seqStaplerWalk);
                            this.speacialShoot = false;
                            ammo = 40;
                            setStaplered(true);
                        }

                    }
                }
            }
        }
        blt = null;
        shotTimer++;
    }

    /**
     * this method makes the worker to go right and react to sprites and objects
     * in his way.
     *
     * @param lm
     */
    public void goRight(LayerManager lm) {
        if (!isDead) {
            boolean flag1 = false;
            boolean flag2 = false;
            if (prevDir == GameCanvas.LEFT_PRESSED) {
                this.move(-50, 0);
                if (staplered == true) {
                    this.setFrameSequence(seqStaplerWalk);
                } else {
                    this.setFrameSequence(getSeqWalk());
                }
                this.setTransform(TRANS_NONE);

            }
            this.setCurrentDir(GameCanvas.RIGHT_PRESSED);
            this.move(step, 0);
            this.nextFrame();

            setPrevDir(GameCanvas.RIGHT_PRESSED);
            this.defineCollisionRectangle(0, 2, this.getWidth() - 2, this.getHeight() - 15);
            for (int i = 0; i < lm.getSize(); i++) {
                if ((lm.getLayerAt(i) instanceof Desk)) {
                    if (this.collidesWith((Desk) lm.getLayerAt(i), true)) {
                        desk = (Desk) lm.getLayerAt(i);
                        flag1 = true;
                    }
                }
                if (this instanceof Rival == false) {
                    if ((lm.getLayerAt(i) instanceof Rival)) {
                        if (this.collidesWith((Rival) lm.getLayerAt(i), true)) {
                            rival = (Rival) lm.getLayerAt(i);
                            flag2 = true;
                        }
                    }
                }


                if (!(this instanceof Boss1)) {
                    if ((lm.getLayerAt(i)) instanceof Boss1) {
                        this.boss1 = (Boss1) (lm.getLayerAt(i));
                        if ((this.getX() + this.getWidth() >= boss1.getX() + boss1.getWidth() / 3) && !boss1.isDead) {
                            this.move(-getStep(), 0);
                            int dx = 0;
                            while (!(this.getX() + this.getWidth() >= boss1.getX() + boss1.getWidth() / 3)) {
                                dx++;
                                this.move(dx, 0);
                            }
                        }
                    }

                }

            }
            if (flag2) {
                this.move(-getStep(), 0);
                int dx = 0;
                while (!this.collidesWith(rival, true)) {
                    dx++;
                    this.move(dx, 0);
                }

            }
            if (flag1) {
                this.move(-getStep(), 0);
                int dx = 0;
                while (!this.collidesWith(desk, true)) {
                    dx++;
                    this.move(dx, 0);
                }

            }
            flag1 = false;
            this.defineCollisionRectangle(0, 0, this.getWidth(), this.getHeight());
        }
    }

    /**
     * this method makes the worker to go left and react to sprites and objects
     * in his way.
     *
     * @param lm
     */
    protected void goLeft(LayerManager lm) {
        if (!isDead) {
            boolean flag1 = false;
            boolean flag2 = false;
            if (prevDir != GameCanvas.LEFT_PRESSED) {
                this.move(50, 0);
                if (staplered == true) {
                    this.setFrameSequence(seqStaplerWalk);
                } else {
                    this.setFrameSequence(getSeqWalk());
                }
                if (!(this instanceof Boss1)) {
                    this.setTransform(TRANS_MIRROR);
                }
            }
            this.setCurrentDir(GameCanvas.LEFT_PRESSED);
            this.move(-step, 0);
            this.nextFrame();
            setPrevDir(GameCanvas.LEFT_PRESSED);
            this.defineCollisionRectangle(0, 2, this.getWidth() - 2, this.getHeight() - 15);
            for (int i = 0; i < lm.getSize(); i++) {
                if ((lm.getLayerAt(i) instanceof Desk)) {
                    if (this.collidesWith((Desk) lm.getLayerAt(i), true)) {
                        desk = (Desk) lm.getLayerAt(i);
                        flag1 = true;
                    }
                }
                if (this instanceof Rival == false) {
                    if ((lm.getLayerAt(i) instanceof Rival)) {
                        if (this.collidesWith((Rival) lm.getLayerAt(i), true)) {
                            rival = (Rival) lm.getLayerAt(i);
                            flag2 = true;
                        }
                    }

                }
            }
            if (flag1) {
                this.move(getStep(), 0);
                int dx = 0;
                while (!this.collidesWith(desk, true)) {
                    dx++;
                    this.move(-dx, 0);
                }

            }
            if (flag2) {
                this.move(getStep(), 0);
                int dx = 0;
                while (!this.collidesWith(rival, true)) {
                    dx++;
                    this.move(-dx, 0);
                }

            }


            flag2 = false;
            flag1 = false;
            this.defineCollisionRectangle(0, 0, this.getWidth(), this.getHeight());
        }
    }

    /**
     * makes the worker react to attack-damages his health and makes him move in
     * the attack direction.
     *
     * @param damage
     * @param attackDir
     */
    public void attacked(int damage, int attackDir) {

        this.setHealth(this.getHealth() - damage);
        if ((this instanceof Boss1) == false) {
            if (attackDir == GameCanvas.LEFT_PRESSED) {
                this.move(-3, 0);

            }
            if (attackDir == GameCanvas.RIGHT_PRESSED) {
                this.move(3, 0);

            }
        }

    }

    /**
     * this method draws the health line of the worker above his head.
     *
     * @param g
     * @param screenXChange
     * @param screenYChange
     * @param lifeMng
     * @param lm
     */
    public void drawHealth(Graphics g, int screenXChange, int screenYChange, LifeMng lifeMng, LayerManager lm) {

        if (!isDead) {

            int x = this.getX();

            int y = this.getY();

            if (getHealth() >= 35) {
                g.setColor(0x5FFB17);

            }
            if (getHealth() < 35) {
                g.setColor(0xF62217);
            }
            for (int i = 0; i < getHealth(); i++) {
                if (i % 3 == 0) {

                    g.drawRect(x + 5 + (i / 4) - screenXChange, y - 10 - screenYChange, 1, 5);

                }
            }
            if (this.getHealth() <= 0) {

                if (!(this instanceof Rival)) {
                    lifeMng.decrease();
                    if (lifeMng.v.size() == 0) {
                        this.die(lm);
                    }
                    this.setHealth(100);
                } else {

                    this.die(lm);

                }
            }

        }
    }

    /**
     * @return the seqLeft
     */
    public int getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * @return the prevDir
     */
    public int getPrevDir() {
        return prevDir;
    }

    /**
     * @param prevDir the prevDir to set
     */
    public void setPrevDir(int prevDir) {
        this.prevDir = prevDir;
    }

    /**
     * @return the isWalking
     */
    public boolean isWalking() {
        return isIsFalling();
    }

    /**
     * @return the seqUpJumpLeft
     */
    /**
     * @return the currentDir
     */
    public int getCurrentDir() {
        return currentDir;
    }

    /**
     * @param currentDir the currentDir to set
     */
    public void setCurrentDir(int currentDir) {
        this.currentDir = currentDir;
    }

    /**
     * @return the seqWalk
     */
    public int[] getSeqWalk() {
        return seqWalk;
    }

    /**
     * @return the seqJump
     */
    public int[] getSeqJump() {
        return seqJump;
    }

    /**
     * @return the seqFall
     */
    public int[] getSeqFall() {
        return seqFall;
    }

    /**
     * @return the seqStaplerWalk
     */
    public int[] getSeqStaplerWalk() {
        return seqStaplerWalk;
    }

    /**
     * @return the isJumping
     */
    public boolean isIsJumping() {
        return isJumping;
    }

    /**
     * @param isJumping the isJumping to set
     */
    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    /**
     * @return the ammo
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * @return the SeqAttack
     */
    public int[] getSeqAttack() {
        return SeqAttack;
    }

    /**
     * @return the isAttacking
     */
    public boolean isIsAttacking() {
        return isAttacking;
    }

    /**
     * @param isAttacking the isAttacking to set
     */
    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @param staplered the staplered to set
     */
    public void setStaplered(boolean staplered) {
        this.staplered = staplered;
    }

    /**
     * @param speacialShoot the speacialShoot to set
     */
    public void setSpeacialShoot(boolean speacialShoot) {
        this.speacialShoot = speacialShoot;
    }
    /**
     * @param worker the worker to set
     */
}
