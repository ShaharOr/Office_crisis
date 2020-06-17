/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameCode;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * this class ontains all the sequence of the sprites and the sprites and layers in the game .
 * @author class3
 */
public class GameDesign
{

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image man2;
    private Image floor;
    private Image man;
    private Sprite Worker;
    public int SeqWalkDelay = 200;
    public int[] SeqWalk = {0, 1, 0, 2};
    public int SeqStaplerWalkDelay = 200;
    public int[] SeqStaplerWalk = {3, 4, 5, 3};
    public int SeqJumpDelay = 200;
    public int[] SeqJump = {6};
    public int SeqFallDelay = 200;
    public int[] SeqFall = {7, 8};
    public int SeqAttackDelay = 200;
    public int[] SeqAttack = {9, 0};
    private Image bob;
    private Sprite Rival;
    public int RivalSeqDelay = 200;
    public int[] RivalSeq = {0, 1, 0, 2};
    public int RivalAttackSeqDelay = 200;
    public int[] RivalAttackSeq = {3};
    private Sprite desks;
    public int flipSeqDelay = 90;
    public int[] flipSeq = {1, 2, 3, 4, 5, 6, 7};
    public int stillSeqDelay = 200;
    public int[] stillSeq = {0};
    private Image desk;
    private Image stapler;
    private Image Staplerpic;
    private Image bullet;
    private Sprite bullett;
    public int seqBulletShotDelay = 130;
    public int[] seqBulletShot = {7, 8};
    public int seqBulletExplodeDelay = 130;
    public int[] seqBulletExplode = {1, 1};
    public int seqBulletPrepareDelay = 130;
    public int[] seqBulletPrepare = {2, 3, 4, 3, 2, 3, 4, 5, 6};
    public int seqBulletPinDelay = 130;
    public int[] seqBulletPin = {0};
    private Image Tanks;
    private Sprite tank;
    public int tankseqDelay = 200;
    public int[] tankseq = {0, 1};
    private Sprite shotBonus;
    public int shotBonusseq001Delay = 200;
    public int[] shotBonusseq001 = {1, 2, 0, 3, 4, 0, 3, 4, 2};
    private Image shotBonu;
    private TiledLayer GameFloor;
    private Sprite elevator;
    public int ElevatCloseSeqDelay = 200;
    public int[] ElevatCloseSeq = {4, 3, 2, 1, 0, 0};
    public int ElevatOpenSeqDelay = 200;
    public int[] ElevatOpenSeq = {0, 1, 2, 3, 4};
    private Image elevate;
    private Sprite boss_1;
    public int bossAttaclSeqDelay = 200;
    public int[] bossAttaclSeq = {0, 0, 3};
    public int bossWalkSeqDelay = 200;
    public int[] bossWalkSeq = {3, 2, 3, 1};
    private Image boss1;
    private Sprite StaplerSprite;
    public int StaplerSpriteseq001Delay = 200;
    public int[] StaplerSpriteseq001 = {0, 0, 0};
    private Image ceoBoss;
    private Image boss2;
    private Sprite Boss_2;
    public int Boss2WalkSeqDelay = 200;
    public int[] Boss2WalkSeq = {3, 2, 3, 1};
    public int Boss2AttackSeqDelay = 200;
    public int[] Boss2AttackSeq = {0, 0, 3};
    private Sprite CEO_sprite;
    public int CEOWalkSeqDelay = 200;
    public int[] CEOWalkSeq = {3, 2, 3, 1};
    public int CEOAttackSeqDelay = 200;
    public int[] CEOAttackSeq = {0, 0, 3};
    public int CEOSpecialAttackSeqDelay = 200;
    public int[] CEOSpecialAttackSeq = {4, 3};
    private Sprite boss3_sprite;
    public int boss3_walkSeqDelay = 200;
    public int[] boss3_walkSeq = {3, 2, 3, 1};
    public int boss3_attackSeqDelay = 200;
    public int[] boss3_attackSeq = {0, 0, 3};
    private Image floor4;
    private Image boss3;
    private TiledLayer floorLevel4;
//</editor-fold>//GEN-END:|fields|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
    public Image getMan2() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (man2 == null) {//GEN-END:|1-getter|0|1-preInit
            // write pre-init user code here
            man2 = Image.createImage("/Pics/man.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
        // write post-init user code here
        return this.man2;//GEN-BEGIN:|1-getter|2|
    }//GEN-END:|1-getter|2|

    public Image getFloor() throws java.io.IOException {//GEN-BEGIN:|8-getter|0|8-preInit
        if (floor == null) {//GEN-END:|8-getter|0|8-preInit
            // write pre-init user code here
            floor = Image.createImage("/Pics/floor.png");//GEN-BEGIN:|8-getter|1|8-postInit
        }//GEN-END:|8-getter|1|8-postInit
        // write post-init user code here
        return this.floor;//GEN-BEGIN:|8-getter|2|
    }//GEN-END:|8-getter|2|

    public Image getMan() throws java.io.IOException {//GEN-BEGIN:|10-getter|0|10-preInit
        if (man == null) {//GEN-END:|10-getter|0|10-preInit
            // write pre-init user code here
            man = Image.createImage("/Pics/man.png");//GEN-BEGIN:|10-getter|1|10-postInit
        }//GEN-END:|10-getter|1|10-postInit
        // write post-init user code here
        return this.man;//GEN-BEGIN:|10-getter|2|
    }//GEN-END:|10-getter|2|

    public Sprite getWorker() throws java.io.IOException {//GEN-BEGIN:|11-getter|0|11-preInit
        if (Worker == null) {//GEN-END:|11-getter|0|11-preInit
            // write pre-init user code here
            Worker = new Sprite(getMan(), 50, 89);//GEN-BEGIN:|11-getter|1|11-postInit
            Worker.setFrameSequence(SeqWalk);//GEN-END:|11-getter|1|11-postInit
            // write post-init user code here
        }//GEN-BEGIN:|11-getter|2|
        return Worker;
    }//GEN-END:|11-getter|2|

    public Image getBob() throws java.io.IOException {//GEN-BEGIN:|19-getter|0|19-preInit
        if (bob == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            bob = Image.createImage("/Pics/bob.png");//GEN-BEGIN:|19-getter|1|19-postInit
        }//GEN-END:|19-getter|1|19-postInit
        // write post-init user code here
        return this.bob;//GEN-BEGIN:|19-getter|2|
    }//GEN-END:|19-getter|2|

    public Sprite getRival() throws java.io.IOException {//GEN-BEGIN:|20-getter|0|20-preInit
        if (Rival == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            Rival = new Sprite(getBob(), 50, 88);//GEN-BEGIN:|20-getter|1|20-postInit
            Rival.setFrameSequence(RivalSeq);//GEN-END:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return Rival;
    }//GEN-END:|20-getter|2|

    public Image getDesk() throws java.io.IOException {//GEN-BEGIN:|22-getter|0|22-preInit
        if (desk == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            desk = Image.createImage("/Pics/desk.png");//GEN-BEGIN:|22-getter|1|22-postInit
        }//GEN-END:|22-getter|1|22-postInit
        // write post-init user code here
        return this.desk;//GEN-BEGIN:|22-getter|2|
    }//GEN-END:|22-getter|2|

    public Sprite getDesks() throws java.io.IOException {//GEN-BEGIN:|23-getter|0|23-preInit
        if (desks == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
            desks = new Sprite(getDesk(), 116, 74);//GEN-BEGIN:|23-getter|1|23-postInit
            desks.setFrameSequence(stillSeq);//GEN-END:|23-getter|1|23-postInit
            // write post-init user code here
        }//GEN-BEGIN:|23-getter|2|
        return desks;
    }//GEN-END:|23-getter|2|

    public Image getStapler() throws java.io.IOException {//GEN-BEGIN:|26-getter|0|26-preInit
        if (stapler == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            stapler = Image.createImage("/Pics/Staplerpic.png");//GEN-BEGIN:|26-getter|1|26-postInit
        }//GEN-END:|26-getter|1|26-postInit
        // write post-init user code here
        return this.stapler;//GEN-BEGIN:|26-getter|2|
    }//GEN-END:|26-getter|2|

    public Image getStaplerpic() throws java.io.IOException {//GEN-BEGIN:|29-getter|0|29-preInit
        if (Staplerpic == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            Staplerpic = Image.createImage("/Pics/Staplerpic.png");//GEN-BEGIN:|29-getter|1|29-postInit
        }//GEN-END:|29-getter|1|29-postInit
        // write post-init user code here
        return this.Staplerpic;//GEN-BEGIN:|29-getter|2|
    }//GEN-END:|29-getter|2|

    public Image getBullet() throws java.io.IOException {//GEN-BEGIN:|38-getter|0|38-preInit
        if (bullet == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            bullet = Image.createImage("/Pics/bullet.png");//GEN-BEGIN:|38-getter|1|38-postInit
        }//GEN-END:|38-getter|1|38-postInit
        // write post-init user code here
        return this.bullet;//GEN-BEGIN:|38-getter|2|
    }//GEN-END:|38-getter|2|

    public Sprite getBullett() throws java.io.IOException {//GEN-BEGIN:|39-getter|0|39-preInit
        if (bullett == null) {//GEN-END:|39-getter|0|39-preInit
            // write pre-init user code here
            bullett = new Sprite(getBullet(), 50, 40);//GEN-BEGIN:|39-getter|1|39-postInit
            bullett.setFrameSequence(seqBulletPrepare);//GEN-END:|39-getter|1|39-postInit
            // write post-init user code here
        }//GEN-BEGIN:|39-getter|2|
        return bullett;
    }//GEN-END:|39-getter|2|

    public Image getTanks() throws java.io.IOException {//GEN-BEGIN:|44-getter|0|44-preInit
        if (Tanks == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            Tanks = Image.createImage("/Pics/Tanks.png");//GEN-BEGIN:|44-getter|1|44-postInit
        }//GEN-END:|44-getter|1|44-postInit
        // write post-init user code here
        return this.Tanks;//GEN-BEGIN:|44-getter|2|
    }//GEN-END:|44-getter|2|

    public Sprite getTank() throws java.io.IOException {//GEN-BEGIN:|45-getter|0|45-preInit
        if (tank == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            tank = new Sprite(getTanks(), 100, 100);//GEN-BEGIN:|45-getter|1|45-postInit
            tank.setFrameSequence(tankseq);//GEN-END:|45-getter|1|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return tank;
    }//GEN-END:|45-getter|2|

    public TiledLayer getGameFloor() throws java.io.IOException {//GEN-BEGIN:|48-getter|0|48-preInit
        if (GameFloor == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            GameFloor = new TiledLayer(74, 23, getFloor(), 40, 25);//GEN-BEGIN:|48-getter|1|48-midInit
            int[][] tiles = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 2, 3, 4, 5, 6, 8, 9, 10, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 2, 3, 4, 5, 6, 7, 8},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };//GEN-END:|48-getter|1|48-midInit
            // write mid-init user code here
            for (int row = 0; row < 23; row++) {//GEN-BEGIN:|48-getter|2|48-postInit
                for (int col = 0; col < 74; col++) {
                    GameFloor.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|48-getter|2|48-postInit
        // write post-init user code here
        return GameFloor;//GEN-BEGIN:|48-getter|3|
    }//GEN-END:|48-getter|3|

    public Image getShotBonu() throws java.io.IOException {//GEN-BEGIN:|49-getter|0|49-preInit
        if (shotBonu == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            shotBonu = Image.createImage("/Pics/shotBonu.png");//GEN-BEGIN:|49-getter|1|49-postInit
        }//GEN-END:|49-getter|1|49-postInit
        // write post-init user code here
        return this.shotBonu;//GEN-BEGIN:|49-getter|2|
    }//GEN-END:|49-getter|2|

    public Sprite getShotBonus() throws java.io.IOException {//GEN-BEGIN:|50-getter|0|50-preInit
        if (shotBonus == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            shotBonus = new Sprite(getShotBonu(), 40, 50);//GEN-BEGIN:|50-getter|1|50-postInit
            shotBonus.setFrameSequence(shotBonusseq001);//GEN-END:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return shotBonus;
    }//GEN-END:|50-getter|2|

    public Image getElevate() throws java.io.IOException {//GEN-BEGIN:|52-getter|0|52-preInit
        if (elevate == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            elevate = Image.createImage("/Pics/elevate.png");//GEN-BEGIN:|52-getter|1|52-postInit
        }//GEN-END:|52-getter|1|52-postInit
        // write post-init user code here
        return this.elevate;//GEN-BEGIN:|52-getter|2|
    }//GEN-END:|52-getter|2|

    public Sprite getElevator() throws java.io.IOException {//GEN-BEGIN:|53-getter|0|53-preInit
        if (elevator == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            elevator = new Sprite(getElevate(), 81, 150);//GEN-BEGIN:|53-getter|1|53-postInit
            elevator.setFrameSequence(ElevatOpenSeq);//GEN-END:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return elevator;
    }//GEN-END:|53-getter|2|

    public Sprite getStaplerSprite() throws java.io.IOException {//GEN-BEGIN:|56-getter|0|56-preInit
        if (StaplerSprite == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            StaplerSprite = new Sprite(getStaplerpic(), 54, 36);//GEN-BEGIN:|56-getter|1|56-postInit
            StaplerSprite.setFrameSequence(StaplerSpriteseq001);//GEN-END:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return StaplerSprite;
    }//GEN-END:|56-getter|2|

    public Image getBoss1() throws java.io.IOException {//GEN-BEGIN:|58-getter|0|58-preInit
        if (boss1 == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            boss1 = Image.createImage("/Pics/boss1.png");//GEN-BEGIN:|58-getter|1|58-postInit
        }//GEN-END:|58-getter|1|58-postInit
        // write post-init user code here
        return this.boss1;//GEN-BEGIN:|58-getter|2|
    }//GEN-END:|58-getter|2|

    public Sprite getBoss_1() throws java.io.IOException {//GEN-BEGIN:|59-getter|0|59-preInit
        if (boss_1 == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            boss_1 = new Sprite(getBoss1(), 100, 158);//GEN-BEGIN:|59-getter|1|59-postInit
            boss_1.setFrameSequence(bossWalkSeq);//GEN-END:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return boss_1;
    }//GEN-END:|59-getter|2|

    public Image getCeoBoss() throws java.io.IOException {//GEN-BEGIN:|62-getter|0|62-preInit
        if (ceoBoss == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            ceoBoss = Image.createImage("/Pics/ceoBoss.png");//GEN-BEGIN:|62-getter|1|62-postInit
        }//GEN-END:|62-getter|1|62-postInit
        // write post-init user code here
        return this.ceoBoss;//GEN-BEGIN:|62-getter|2|
    }//GEN-END:|62-getter|2|

    public Sprite getCEO_sprite() throws java.io.IOException {//GEN-BEGIN:|67-getter|0|67-preInit
        if (CEO_sprite == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            CEO_sprite = new Sprite(getCeoBoss(), 100, 158);//GEN-BEGIN:|67-getter|1|67-postInit
            CEO_sprite.setFrameSequence(CEOWalkSeq);//GEN-END:|67-getter|1|67-postInit
            // write post-init user code here
        }//GEN-BEGIN:|67-getter|2|
        return CEO_sprite;
    }//GEN-END:|67-getter|2|

    public Image getBoss2() throws java.io.IOException {//GEN-BEGIN:|70-getter|0|70-preInit
        if (boss2 == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            boss2 = Image.createImage("/Pics/boss2.png");//GEN-BEGIN:|70-getter|1|70-postInit
        }//GEN-END:|70-getter|1|70-postInit
        // write post-init user code here
        return this.boss2;//GEN-BEGIN:|70-getter|2|
    }//GEN-END:|70-getter|2|

    public Sprite getBoss_2() throws java.io.IOException {//GEN-BEGIN:|71-getter|0|71-preInit
        if (Boss_2 == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            Boss_2 = new Sprite(getBoss2(), 100, 162);//GEN-BEGIN:|71-getter|1|71-postInit
            Boss_2.setFrameSequence(Boss2WalkSeq);//GEN-END:|71-getter|1|71-postInit
            // write post-init user code here
        }//GEN-BEGIN:|71-getter|2|
        return Boss_2;
    }//GEN-END:|71-getter|2|

    public Image getBoss3() throws java.io.IOException {//GEN-BEGIN:|75-getter|0|75-preInit
        if (boss3 == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            boss3 = Image.createImage("/Pics/boss3.png");//GEN-BEGIN:|75-getter|1|75-postInit
        }//GEN-END:|75-getter|1|75-postInit
        // write post-init user code here
        return this.boss3;//GEN-BEGIN:|75-getter|2|
    }//GEN-END:|75-getter|2|

    public Sprite getBoss3_sprite() throws java.io.IOException {//GEN-BEGIN:|76-getter|0|76-preInit
        if (boss3_sprite == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            boss3_sprite = new Sprite(getBoss3(), 100, 158);//GEN-BEGIN:|76-getter|1|76-postInit
            boss3_sprite.setFrameSequence(boss3_walkSeq);//GEN-END:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return boss3_sprite;
    }//GEN-END:|76-getter|2|

    public Image getFloor4() throws java.io.IOException {//GEN-BEGIN:|79-getter|0|79-preInit
        if (floor4 == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            floor4 = Image.createImage("/Pics/floor4.png");//GEN-BEGIN:|79-getter|1|79-postInit
        }//GEN-END:|79-getter|1|79-postInit
        // write post-init user code here
        return this.floor4;//GEN-BEGIN:|79-getter|2|
    }//GEN-END:|79-getter|2|

    public TiledLayer getFloorLevel4() throws java.io.IOException {//GEN-BEGIN:|82-getter|0|82-preInit
        if (floorLevel4 == null) {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            floorLevel4 = new TiledLayer(52, 20, getFloor4(), 57, 28);//GEN-BEGIN:|82-getter|1|82-midInit
            int[][] tiles = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };//GEN-END:|82-getter|1|82-midInit
            // write mid-init user code here
            for (int row = 0; row < 20; row++) {//GEN-BEGIN:|82-getter|2|82-postInit
                for (int col = 0; col < 52; col++) {
                    floorLevel4.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|82-getter|2|82-postInit
        // write post-init user code here
        return floorLevel4;//GEN-BEGIN:|82-getter|3|
    }//GEN-END:|82-getter|3|
}
