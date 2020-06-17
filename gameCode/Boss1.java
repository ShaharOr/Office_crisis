/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import java.io.IOException;
import java.util.TimerTask;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

/**
 * this class creates and manages the boss sprite
 *
 * @author user
 */
public class Boss1 extends Rival {

    /**
     * a distance which if the worker enters, the boss start his attack.
     * processes
     */
    private int attack_dist;
    /**
     * the TimerTask that manages the boss' movement.
     */
    private TimerTask tt;
    /**
     * sequences of frames which the boss use.
     */
    private int[] walkSeq, attackSeq;
    /**
     * if the boss is the ceo he can special attack, if he is in the process of
     * special attack- true, else-false.
     */
    protected boolean specialAttacking;

    /**
     * constructor
     *
     * @param boss-the sprite of the boss.
     * @param gd-game design for the boss to use.
     * @param x-the intial horizonal parameter in which the boss will be
     * intialized
     * @param walkSeq- walk sequence of frames.
     * @param attackSeq-attack sequence of frames.
     * @throws IOException
     */
    public Boss1(Sprite boss, GameDesign gd, int x, int[] walkSeq, int[] attackSeq) throws IOException {
        super(boss, gd, x);
        this.attack_dist = 60;
        this.setHealth(200);
        this.goingToAttack = false;

        isDead = false;
        specialAttacking = false;
        this.walkSeq = walkSeq;
        this.attackSeq = attackSeq;

    }

    /**
     * this method checks if the boss needs to attack and if so manages the
     * attack
     *
     * @param worker-the worker which the boss interacts with
     * @param lm - layer manager for the boss to use
     */
    public void checkAttackRange(Worker worker, LayerManager lm) {
        if (!isDead) {
            if (worker.getX() + worker.getWidth() + getAttack_dist() >= this.getX()) {
                if (!goingToAttack) {
                    this.goingToAttack = true;
                    bossAttack(worker, lm);

                }
            }
            if (worker.isAttacking && this.collidesWith(worker, true)) {
                if (attackedTimer == 3) {
                  this.attacked(35, worker.getCurrentDir());
                    attackedTimer = 0;
                }
                attackedTimer++;
                if (attackedTimer >= 20) {
                    attackedTimer = 0;
                }
            }
        }
    }

    /**
     *this method makes the boss to attack
     * @param worker-the worker which the boss interacts with
     * @param lm - layer manager for the boss to use
     */
    public void bossAttack(Worker worker, LayerManager lm) {
        if (getTt() == null) {



            setTt(new BossAttackTT(this, worker, lm));


            ((BossAttackTT) getTt()).startMe();

            timer.scheduleAtFixedRate(getTt(), 0, 350);

        }



    }
/**
 * if necessary, makes the boss to perform a special attack
 @param worker-the worker which the boss interacts with.
 * @param lm - layer manager for the boss to use
 */
    public void SpecialAttack(Worker worker, LayerManager lm) {
        if (getTt() == null) {
            specialAttacking = true;

            if (worker.getX() + worker.getWidth() + 400 >= this.getX()) {
                System.out.println("special attack nowwwww");
                setTt(new CEOAttackTT(this, worker, lm, gd.CEOSpecialAttackSeq, gd));


                ((CEOAttackTT) getTt()).startMe();

                timer.scheduleAtFixedRate(getTt(), 0, 50);

            }
        }
    }

    /**
     * @return the attack_dist
     */
    public int getAttack_dist() {
        return attack_dist;
    }

    /**
     * @param attack_dist the attack_dist to set
     */
    public void setAttack_dist(int attack_dist) {
        this.attack_dist = attack_dist;
    }

    /**
     * @return the tt
     */
    public TimerTask getTt() {
        return tt;
    }

    /**
     * @param tt the tt to set
     */
    public void setTt(TimerTask tt) {
        this.tt = tt;
    }

    /**
     * @return the walkSeq
     */
    public int[] getWalkSeq() {
        return walkSeq;
    }

    /**
     * @param walkSeq the walkSeq to set
     */
    public void setWalkSeq(int[] walkSeq) {
        this.walkSeq = walkSeq;
    }

    /**
     * @return the attackSeq
     */
    public int[] getAttackSeq() {
        return attackSeq;
    }

    /**
     * @param attackSeq the attackSeq to set
     */
    public void setAttackSeq(int[] attackSeq) {
        this.attackSeq = attackSeq;
    }
}
