/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import TopTenUltils.PlayerScore;
import TopTenUltils.PlayerScoresMng;
import gameCode.CEOStartCanvas;
import gameCode.DeathCanvas;

import gameCode.InstCanvas;
import gameCode.Level1;
import gameCode.Level2;
import gameCode.Level3;
import gameCode.Level4;


import gameCode.MyMenuCanvas;
import gameCode.MyModeMenuCanvas;
import gameCode.StartCanvas;
import gameCode.TimeOutCanvas;
import gameCode.WinCanvas;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * This class define the features and functions of the game's screens.
 *
 * @author user
 */
public class OCMIDLet extends MIDlet implements ItemCommandListener {

    /**
     * if the main thread is not running-true, else-false.
     */
    private boolean midletPaused = false;
    /**
     * the level of the Game
     */
    private int gcanvasLevel = 1;
    /**
     * the current score which the player achieved while playing.
     */
    private int gameCurrentScore = 0;
    /**
     * difficulty level of the game- true: easy , false: extreme.
     */
    private boolean mode = true;
    /**
     * the level object of level1, which will be used as displayable.
     */
    private Level1 level1;
    /**
     * the level object of level2, which will be used as displayable.
     */
    private Level2 level2;
    /**
     * the level object of level3, which will be used as displayable.
     */
    private Level3 level3;
    /**
     * the level object of level4, which will be used as displayable.
     */
    private Level4 level4;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private InstCanvas instCanvas;
    private StartCanvas startCanvas;
    private Form top_scores_frm;
    private StringItem topScoresTitle;
    private StringItem backToMenuBtn;
    private StringItem toSaveNameCmd;
    private CEOStartCanvas ceoStartCanvas;
    private WinCanvas winCanvas;
    private DeathCanvas deathCanvas;
    private TimeOutCanvas timeOutCanvas;
    private MyModeMenuCanvas myModeMenuCanvas;
    private MyMenuCanvas myMenuCanvas;
    private Form SaveNameFrm;
    private TextField enterNameField;
    private StringItem stringItem3;
    private StringItem toScores;
    private StringItem confirmString;
    private StringItem stringItem4;
    private Command cmdSave;
    private Command cmdSave1;
    private Command cmd_go_to_topScores;
    private Command cmd_goToScores;
    private Command backToMenuFromScoreCMD;
    private Command toScoresCmd;
    private Command BackToNameCmd;
    private Command toScores1;
    private Command SaveNameCmd;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The OCMIDLet constructor.
     */
    public OCMIDLet() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the
     * <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getStartCanvas());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The
     * <code>display</code> instance is taken from
     * <code>getDisplay</code> method. This method is used by all actions in the
     * design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display;
     * if <code>null</code>, then <code>nextDisplayable</code> is set
     * immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch

    }//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: instCanvas ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initialized instance of instCanvas component.
     *
     * @return the initialized component instance
     */
    public InstCanvas getInstCanvas() {
        if (instCanvas == null) {//GEN-END:|16-getter|0|16-preInit
            myMenuCanvas = null;
            instCanvas = new InstCanvas();//GEN-BEGIN:|16-getter|1|16-postInit
            instCanvas.setTitle("instCanvas");//GEN-END:|16-getter|1|16-postInit
            instCanvas.setMidlet(this);
        }//GEN-BEGIN:|16-getter|2|
        return instCanvas;
    }
//</editor-fold>//GEN-END:|16-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: startCanvas ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initialized instance of startCanvas component.
     *
     * @return the initialized component instance
     */
    public StartCanvas getStartCanvas() {
        if (startCanvas == null) {//GEN-END:|19-getter|0|19-preInit
            myMenuCanvas = null;
            startCanvas = new StartCanvas();//GEN-BEGIN:|19-getter|1|19-postInit
            startCanvas.setTitle("startCanvas");//GEN-END:|19-getter|1|19-postInit
            startCanvas.setMidlet(this);
            // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return startCanvas;
    }
//</editor-fold>//GEN-END:|19-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Items ">//GEN-BEGIN:|8-itemCommandAction|0|8-preItemCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular item.
     *
     * @param command the Command that was invoked
     * @param displayable the Item where the command was invoked
     */
    public void commandAction(Command command, Item item) {//GEN-END:|8-itemCommandAction|0|8-preItemCommandAction
        // write pre-action user code here
        if (item == backToMenuBtn) {//GEN-BEGIN:|8-itemCommandAction|1|61-preAction
            if (command == backToMenuFromScoreCMD) {//GEN-END:|8-itemCommandAction|1|61-preAction
                myMenuCanvas = null;
                topScoresTitle = null;
                backToMenuBtn = null;
                toSaveNameCmd = null;
                top_scores_frm = null;
                switchDisplayable(null, getMyMenuCanvas());//GEN-LINE:|8-itemCommandAction|2|61-postAction
                // write post-action user code here
            }//GEN-BEGIN:|8-itemCommandAction|3|89-preAction
        } else if (item == stringItem3) {
            if (command == SaveNameCmd) {//GEN-END:|8-itemCommandAction|3|89-preAction
                // write pre-action user code here

                if (confirmString.getText() == null) {
                    confirmString.setText("");
                }
                try {
                    String name = getEnterNameField().getString();

                    int score = getGameCurrentScore();
                    if (!name.equals("")) {

                        if (confirmString.getText().equals("name successfully saved") || confirmString.getText().equals("already saved")) {
                            confirmString.setText("already saved");
                        } else {
                            PlayerScoresMng.saveDataToRS(name, score);
                            System.out.println("name" + name + "  score " + score);
                         //   gameCurrentScore = 0;
                            confirmString.setText("name successfully saved");
                        }
                    } else {
                        confirmString.setText("no name inserted");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();


                }

//GEN-LINE:|8-itemCommandAction|4|89-postAction
                // write post-action user code here
            } else if (command == cmdSave1) {//GEN-LINE:|8-itemCommandAction|5|90-preAction
                // write pre-action user code here
//GEN-LINE:|8-itemCommandAction|6|90-postAction
                // write post-action user code here
            }//GEN-BEGIN:|8-itemCommandAction|7|74-preAction
        } else if (item == toSaveNameCmd) {
            if (command == BackToNameCmd) {//GEN-END:|8-itemCommandAction|7|74-preAction
                // write pre-action user code here


                switchDisplayable(null, getSaveNameFrm());//GEN-LINE:|8-itemCommandAction|8|74-postAction
                // write post-action user code here
            }//GEN-BEGIN:|8-itemCommandAction|9|86-preAction
        } else if (item == toScores) {
            if (command == toScores1) {//GEN-END:|8-itemCommandAction|9|86-preAction
                // write pre-action user code here
                stringItem4 = null;
                enterNameField = null;
                stringItem3 = null;
                toScores = null;
                confirmString = null;

                SaveNameFrm = null;
                deathCanvas = null;
                winCanvas = null;
                timeOutCanvas = null;
                switchDisplayable(null, getTop_scores_frm());//GEN-LINE:|8-itemCommandAction|10|86-postAction
                // write post-action user code here
            }//GEN-BEGIN:|8-itemCommandAction|11|8-postItemCommandAction
        }//GEN-END:|8-itemCommandAction|11|8-postItemCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|8-itemCommandAction|12|
//</editor-fold>//GEN-END:|8-itemCommandAction|12|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdSave ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initialized instance of cmdSave component.
     *
     * @return the initialized component instance
     */
    public Command getCmdSave() {
        if (cmdSave == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
            cmdSave = new Command("Item", Command.ITEM, 0);//GEN-LINE:|23-getter|1|23-postInit
            // write post-init user code here
        }//GEN-BEGIN:|23-getter|2|
        return cmdSave;
    }
//</editor-fold>//GEN-END:|23-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdSave1 ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initialized instance of cmdSave1 component.
     *
     * @return the initialized component instance
     */
    public Command getCmdSave1() {
        if (cmdSave1 == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            cmdSave1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return cmdSave1;
    }
//</editor-fold>//GEN-END:|26-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmd_go_to_topScores ">//GEN-BEGIN:|35-getter|0|35-preInit
    /**
     * Returns an initialized instance of cmd_go_to_topScores component.
     *
     * @return the initialized component instance
     */
    public Command getCmd_go_to_topScores() {
        if (cmd_go_to_topScores == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
            cmd_go_to_topScores = new Command("Item", Command.ITEM, 0);//GEN-LINE:|35-getter|1|35-postInit
            // write post-init user code here
        }//GEN-BEGIN:|35-getter|2|
        return cmd_go_to_topScores;
    }
//</editor-fold>//GEN-END:|35-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: ceoStartCanvas ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initialized instance of ceoStartCanvas component.
     *
     * @return the initialized component instance
     */
    public CEOStartCanvas getCeoStartCanvas() {
        if (ceoStartCanvas == null) {//GEN-END:|41-getter|0|41-preInit

            level3 = null;

            ceoStartCanvas = new CEOStartCanvas();//GEN-BEGIN:|41-getter|1|41-postInit
            ceoStartCanvas.setTitle("ceoStartCanvas");//GEN-END:|41-getter|1|41-postInit
            ceoStartCanvas.setMidlet(this);
        }//GEN-BEGIN:|41-getter|2|
        return ceoStartCanvas;
    }
//</editor-fold>//GEN-END:|41-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: top_scores_frm ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initialized instance of top_scores_frm component.
     *
     * @return the initialized component instance
     */
    public Form getTop_scores_frm() {
        if (top_scores_frm == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here

            top_scores_frm = new Form("", new Item[]{getTopScoresTitle(), getBackToMenuBtn(), getToSaveNameCmd()});//GEN-LINE:|43-getter|1|43-postInit
            try {
                Vector vecPS = PlayerScoresMng.getDataFromRS();
                String str = "\n";
                for (int i = 0; i < vecPS.size(); i++) {
                    PlayerScore ps = (PlayerScore) vecPS.elementAt(i);
                    str += ps.toString() + "\n";
                }
                getTopScoresTitle().setText(str);
            } catch (IOException ex) {
                ex.printStackTrace();
                getTopScoresTitle().setText("ERROR: the data is not valid");

            }
        }//GEN-BEGIN:|43-getter|2|
        return top_scores_frm;
    }
//</editor-fold>//GEN-END:|43-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: topScoresTitle ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initialized instance of topScoresTitle component.
     *
     * @return the initialized component instance
     */
    public StringItem getTopScoresTitle() {
        if (topScoresTitle == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            topScoresTitle = new StringItem("10 Top Scores ", null);//GEN-LINE:|44-getter|1|44-postInit

        }//GEN-BEGIN:|44-getter|2|
        return topScoresTitle;
    }
//</editor-fold>//GEN-END:|44-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmd_goToScores ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initialized instance of cmd_goToScores component.
     *
     * @return the initialized component instance
     */
    public Command getCmd_goToScores() {
        if (cmd_goToScores == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            cmd_goToScores = new Command("Item", Command.ITEM, 0);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return cmd_goToScores;
    }
//</editor-fold>//GEN-END:|49-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: deathCanvas ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initialized instance of deathCanvas component.
     *
     * @return the initialized component instance
     */
    public DeathCanvas getDeathCanvas() {
        if (deathCanvas == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            level1 = null;
            level2 = null;
            level3 = null;
            level4 = null;
            deathCanvas = new DeathCanvas();//GEN-BEGIN:|52-getter|1|52-postInit
            deathCanvas.setTitle("deathCanvas");//GEN-END:|52-getter|1|52-postInit
            // write post-init user code here
            deathCanvas.setMidlet(this);
        }//GEN-BEGIN:|52-getter|2|
        return deathCanvas;
    }
//</editor-fold>//GEN-END:|52-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: winCanvas ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initialized instance of winCanvas component.
     *
     * @return the initialized component instance
     */
    public WinCanvas getWinCanvas() {
        if (winCanvas == null) {//GEN-END:|53-getter|0|53-preInit
            level4 = null;
            winCanvas = new WinCanvas();//GEN-BEGIN:|53-getter|1|53-postInit
            winCanvas.setTitle("winCanvas");//GEN-END:|53-getter|1|53-postInit
            winCanvas.setMidlet(this);
        }//GEN-BEGIN:|53-getter|2|
        return winCanvas;
    }
//</editor-fold>//GEN-END:|53-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: timeOutCanvas ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initialized instance of timeOutCanvas component.
     *
     * @return the initialized component instance
     */
    public TimeOutCanvas getTimeOutCanvas() {
        if (timeOutCanvas == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            level1 = null;
            level2 = null;
            level3 = null;
            level4 = null;
            timeOutCanvas = new TimeOutCanvas();//GEN-BEGIN:|58-getter|1|58-postInit
            timeOutCanvas.setTitle("timeOutCanvas");//GEN-END:|58-getter|1|58-postInit
            timeOutCanvas.setMidlet(this);
        }//GEN-BEGIN:|58-getter|2|
        return timeOutCanvas;
    }
//</editor-fold>//GEN-END:|58-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backToMenuBtn ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initialized instance of backToMenuBtn component.
     *
     * @return the initialized component instance
     */
    public StringItem getBackToMenuBtn() {
        if (backToMenuBtn == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            backToMenuBtn = new StringItem("", "Back To Menu", Item.BUTTON);//GEN-BEGIN:|59-getter|1|59-postInit
            backToMenuBtn.addCommand(getBackToMenuFromScoreCMD());
            backToMenuBtn.setItemCommandListener(this);
            backToMenuBtn.setDefaultCommand(getBackToMenuFromScoreCMD());//GEN-END:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return backToMenuBtn;
    }
//</editor-fold>//GEN-END:|59-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backToMenuFromScoreCMD ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initialized instance of backToMenuFromScoreCMD component.
     *
     * @return the initialized component instance
     */
    public Command getBackToMenuFromScoreCMD() {
        if (backToMenuFromScoreCMD == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            backToMenuFromScoreCMD = new Command("Item", Command.ITEM, 0);//GEN-LINE:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return backToMenuFromScoreCMD;
    }
//</editor-fold>//GEN-END:|60-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: myModeMenuCanvas ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initialized instance of myModeMenuCanvas component.
     *
     * @return the initialized component instance
     */
    public MyModeMenuCanvas getMyModeMenuCanvas() {
        if (myModeMenuCanvas == null) {//GEN-END:|70-getter|0|70-preInit
            myMenuCanvas = null;
            myModeMenuCanvas = new MyModeMenuCanvas();//GEN-BEGIN:|70-getter|1|70-postInit
            myModeMenuCanvas.setTitle("myModeMenuCanvas");//GEN-END:|70-getter|1|70-postInit
            myModeMenuCanvas.setMidlet(this);
        }//GEN-BEGIN:|70-getter|2|
        return myModeMenuCanvas;
    }
//</editor-fold>//GEN-END:|70-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: myMenuCanvas ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initialized instance of myMenuCanvas component.
     *
     * @return the initialized component instance
     */
    public MyMenuCanvas getMyMenuCanvas() {
        if (myMenuCanvas == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            myMenuCanvas = new MyMenuCanvas();//GEN-BEGIN:|71-getter|1|71-postInit
            myMenuCanvas.setTitle("myMenuCanvas");//GEN-END:|71-getter|1|71-postInit
            myMenuCanvas.setMidlet(this);
        }//GEN-BEGIN:|71-getter|2|
        return myMenuCanvas;
    }
//</editor-fold>//GEN-END:|71-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: toSaveNameCmd ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initialized instance of toSaveNameCmd component.
     *
     * @return the initialized component instance
     */
    public StringItem getToSaveNameCmd() {
        if (toSaveNameCmd == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            toSaveNameCmd = new StringItem("", "to save name", Item.BUTTON);//GEN-BEGIN:|72-getter|1|72-postInit
            toSaveNameCmd.addCommand(getBackToNameCmd());
            toSaveNameCmd.setItemCommandListener(this);
            toSaveNameCmd.setDefaultCommand(getBackToNameCmd());//GEN-END:|72-getter|1|72-postInit
            // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return toSaveNameCmd;
    }
//</editor-fold>//GEN-END:|72-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: BackToNameCmd ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initialized instance of BackToNameCmd component.
     *
     * @return the initialized component instance
     */
    public Command getBackToNameCmd() {
        if (BackToNameCmd == null) {//GEN-END:|73-getter|0|73-preInit
            // write pre-init user code here
            BackToNameCmd = new Command("Item", Command.ITEM, 0);//GEN-LINE:|73-getter|1|73-postInit
            // write post-init user code here
        }//GEN-BEGIN:|73-getter|2|
        return BackToNameCmd;
    }
//</editor-fold>//GEN-END:|73-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: SaveNameFrm ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initialized instance of SaveNameFrm component.
     *
     * @return the initialized component instance
     */
    public Form getSaveNameFrm() {
        if (SaveNameFrm == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
           
            topScoresTitle = null;
            backToMenuBtn = null;
            toSaveNameCmd = null;
            top_scores_frm = null;
            SaveNameFrm = new Form("form", new Item[]{getStringItem4(), getEnterNameField(), getStringItem3(), getToScores(), getConfirmString()});//GEN-LINE:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return SaveNameFrm;
    }
//</editor-fold>//GEN-END:|76-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: enterNameField ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initialized instance of enterNameField component.
     *
     * @return the initialized component instance
     */
    public TextField getEnterNameField() {
        if (enterNameField == null) {//GEN-END:|77-getter|0|77-preInit
            // write pre-init user code here
            enterNameField = new TextField("enter Name here", "(Anonymous player)", 32, TextField.ANY);//GEN-LINE:|77-getter|1|77-postInit
            // write post-init user code here
        }//GEN-BEGIN:|77-getter|2|
        return enterNameField;
    }
//</editor-fold>//GEN-END:|77-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|78-getter|0|78-preInit
    /**
     * Returns an initialized instance of stringItem3 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {//GEN-END:|78-getter|0|78-preInit
            // write pre-init user code here
            stringItem3 = new StringItem("", "save", Item.BUTTON);//GEN-BEGIN:|78-getter|1|78-postInit
            stringItem3.addCommand(getSaveNameCmd());
            stringItem3.addCommand(getCmdSave1());
            stringItem3.setItemCommandListener(this);
            stringItem3.setDefaultCommand(getSaveNameCmd());//GEN-END:|78-getter|1|78-postInit
            // write post-init user code here
        }//GEN-BEGIN:|78-getter|2|
        return stringItem3;
    }
//</editor-fold>//GEN-END:|78-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: toScoresCmd ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initialized instance of toScoresCmd component.
     *
     * @return the initialized component instance
     */
    public Command getToScoresCmd() {
        if (toScoresCmd == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            toScoresCmd = new Command("Item", Command.ITEM, 0);//GEN-LINE:|79-getter|1|79-postInit
            // write post-init user code here
        }//GEN-BEGIN:|79-getter|2|
        return toScoresCmd;
    }
//</editor-fold>//GEN-END:|79-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: toScores ">//GEN-BEGIN:|84-getter|0|84-preInit
    /**
     * Returns an initialized instance of toScores component.
     *
     * @return the initialized component instance
     */
    public StringItem getToScores() {
        if (toScores == null) {//GEN-END:|84-getter|0|84-preInit
            // write pre-init user code here
            toScores = new StringItem("", "watch top scores", Item.BUTTON);//GEN-BEGIN:|84-getter|1|84-postInit
            toScores.addCommand(getToScores1());
            toScores.setItemCommandListener(this);
            toScores.setDefaultCommand(getToScores1());//GEN-END:|84-getter|1|84-postInit
            // write post-init user code here
        }//GEN-BEGIN:|84-getter|2|
        return toScores;
    }
//</editor-fold>//GEN-END:|84-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: toScores1 ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initialized instance of toScores1 component.
     *
     * @return the initialized component instance
     */
    public Command getToScores1() {
        if (toScores1 == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            toScores1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|85-getter|1|85-postInit
            // write post-init user code here
        }//GEN-BEGIN:|85-getter|2|
        return toScores1;
    }
//</editor-fold>//GEN-END:|85-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: SaveNameCmd ">//GEN-BEGIN:|88-getter|0|88-preInit
    /**
     * Returns an initialized instance of SaveNameCmd component.
     *
     * @return the initialized component instance
     */
    public Command getSaveNameCmd() {
        if (SaveNameCmd == null) {//GEN-END:|88-getter|0|88-preInit
            // write pre-init user code here
            SaveNameCmd = new Command("Item", Command.ITEM, 0);//GEN-LINE:|88-getter|1|88-postInit
            // write post-init user code here
        }//GEN-BEGIN:|88-getter|2|
        return SaveNameCmd;
    }
//</editor-fold>//GEN-END:|88-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|92-getter|0|92-preInit
    /**
     * Returns an initialized instance of stringItem4 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            stringItem4 = new StringItem("please enter your name", "so your score might be saved");//GEN-LINE:|92-getter|1|92-postInit
            // write post-init user code here
        }//GEN-BEGIN:|92-getter|2|
        return stringItem4;
    }
//</editor-fold>//GEN-END:|92-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: confirmString ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initialized instance of confirmString component.
     *
     * @return the initialized component instance
     */
    public StringItem getConfirmString() {
        if (confirmString == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            confirmString = new StringItem("", null);//GEN-LINE:|93-getter|1|93-postInit
            System.out.println("did This");
            // write post-init user code here
        }//GEN-BEGIN:|93-getter|2|
        return confirmString;
    }
//</editor-fold>//GEN-END:|93-getter|2|

    /**
     *
     * @return the level1
     */
    public Level1 getLevel1() {
        if (level1 == null) {
            try {
                myModeMenuCanvas = null;
                level1 = new Level1(mode);
                level1.setTitle("level1");
                level1.setMidlet(this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return level1;
    }

    /**
     *
     * @return the level2
     */
    public Level2 getLevel2() {
        if (level2 == null) {
            level1 = null;
            try {
                level2 = new Level2(mode);
                level2.setTitle("level2");
                level2.setMidlet(this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return level2;
    }

    /**
     *
     * @return the level3
     */
    public Level3 getLevel3() {
        if (level3 == null) {
            level2 = null;
            try {
                level3 = new Level3(mode);
                level3.setTitle("level3");
                level3.setMidlet(this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return level3;
    }

    /**
     *
     * @return the level4
     */
    public Level4 getLevel4() {
        if (level4 == null) {
            try {
                level4 = new Level4(mode);
                level4.setTitle("level4");
                level4.setMidlet(this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return level4;
    }

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    /**
     * @return the gcanvasLevel
     */
    /**
     * @return the gameFinalScore
     */
    public int getGameCurrentScore() {
        return gameCurrentScore;
    }

    /**
     * @param gameFinalScore the gameFinalScore to set
     */
    public void setGameCurrentScore(int gameFinalScore) {
        this.gameCurrentScore = gameFinalScore;
    }

    /**
     * @return the mode
     */
    public boolean getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(boolean mode) {
        this.mode = mode;
    }
}
