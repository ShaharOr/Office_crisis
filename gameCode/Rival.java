/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 * this class deals with the creation and managment of the rivals.
 *
 * @author class3
 */
public class Rival extends Worker {

    /**
     * frame sequence for the rival to use.
     */
    protected int[] rivalSeq;
    /**
     * frame sequence for the rival to use.
     */
    protected int[] rivalAttackSeq;
    /**
     * increases with every step the rival takes.
     */
    protected int stepCount;
    /**
     * if the rival is in a going toward an attack mode.
     */
    protected boolean goingToAttack;
    /**
     * increases every time the the rival is repeating its attack task.
     */
    protected int attackTimer;
    /**
     * increases every time the rival is being attacked.
     */
    protected int attackedTimer;

    /**
     * constructor
     *
     * @param rival
     * @param gd
     * @param x
     * @throws IOException
     */
    public Rival(Sprite rival, GameDesign gd, int x) throws IOException {
        super(rival, gd);
        this.setPosition(x, 0);
        this.rivalSeq = gd.RivalSeq;
        this.rivalAttackSeq = gd.RivalAttackSeq;
        this.stepCount = 0;
        goingToAttack = false;
        this.attackTimer = 0;
        this.attackedTimer = 0;
        gravited = false;

        currentDir = GameCanvas.RIGHT_PRESSED;

    }

    /**
     * manages the walking pattern of the rival
     *
     * @param lm
     */
    public void walk(LayerManager lm) {
        if (!isDead) {
            if (stepCount == 52) {
                if (this.currentDir == GameCanvas.LEFT_PRESSED) {
                    this.currentDir = GameCanvas.RIGHT_PRESSED;
                } else {
                    if (this.currentDir == GameCanvas.RIGHT_PRESSED) {
                        this.currentDir = GameCanvas.LEFT_PRESSED;
                    }
                    stepCount = 0;
                }
            }
            if (currentDir == GameCanvas.RIGHT_PRESSED && stepCount % 4 == 0 && !goingToAttack && !isAttacking && !isFalling) {

                this.goRight(lm);

                if (stepCount >= 2) {
                    this.prevDir = currentDir;
                }

            }
            if (currentDir == GameCanvas.LEFT_PRESSED && stepCount % 4 == 0 && !goingToAttack && !isAttacking && !isFalling) {

                this.goLeft(lm);


                if (stepCount >= 2) {
                    this.prevDir = currentDir;
                }

            }
            stepCount++;

        }
    }

    /**
     * checks if the rival should start going for an attack and if so, manages
     * the attack processes.
     *
     * @param worker
     * @param lm
     */
    public void checkAttackRange(Worker worker, LayerManager lm) {
        if (!isDead) {
            if (worker.getX() + worker.getWidth() + 70 >= this.getX() && this.getX() + this.getWidth() + 70 >= worker.getX() && worker.getY() + 10 >= this.getY() && worker.getY() - 10 <= this.getY()) {
                if (worker.getX() + worker.getWidth() + 50 >= this.getX()) {
                    if (worker.getX() + 19 <= this.getX()) {
                        this.goingToAttack = true;
                        this.goLeft(lm);


                    }


                    attack();




                }
                if (this.getX() + this.getWidth() + 70 >= worker.getX()) {
                    if (this.getX() + this.getWidth() - 20 <= worker.getX()) {
                        this.goingToAttack = true;
                        this.goRight(lm);


                    }



                    attack();

                }

                if (this.collidesWith(worker,false) && isAttacking == true && attackTimer == 3) {

                    worker.attacked(10, this.getCurrentDir());
                    attackTimer = 0;
                    System.out.println("shold be attacked");
                }
                attackTimer++;
                if (attackTimer >= 20) {
                    attackTimer = 0;
                }

            }

            if (worker.isAttacking && this.collidesWith(worker, true)) {
                if (attackedTimer == 3) {
                    this.attacked(34, worker.getCurrentDir());
                    attackedTimer = 0;
                }
                attackedTimer++;
                if (attackedTimer >= 20) {
                    attackedTimer = 0;
                }
            }
        }
        goingToAttack = false;
    }

    /**
     * checks if the gravity which is working on the rival should be stopped.
     *
     * @param lm
     */
    public void checkRivalGravity(LayerManager lm) {
        if (!isDead && gravited == false) {

            TiledLayer floor = (TiledLayer) lm.getLayerAt(0);
            if (this.collidesWith(floor, true)) {

                while (this.collidesWith(floor, true)) {
                    this.move(0, -1);
                }
                this.move(0, 1);
                stopGravity(rivalSeq);


            }



            boolean flag = false;
            for (int i = 0; i < lm.getSize(); i++) {
                if ((lm.getLayerAt(i) instanceof Desk)) {
                    if (this.collidesWith((Desk) lm.getLayerAt(i), true)) {
                        desk = (Desk) lm.getLayerAt(i);
                        flag = true;
                    }
                }
            }
            if (flag) {

                while (this.collidesWith(desk, true)) {
                    this.move(0, -1);
                }
                this.move(0, 2);



                stopGravity(rivalSeq);

                this.setIsFalling(false);

            }




        }
    }
}
