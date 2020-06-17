/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TopTenUltils;

/**
 *this class creates objects which can help saving the player's name and score at the end of the game.
 * @author student
 */
public class PlayerScore
{
    /**
     * a string which represents the name of the player. 
     */
    private String name;
     /**
     * a number which represents the score of the player. 
     */
    private int score;
/**
 * constructor.
 */
    public PlayerScore(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    /**
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the score.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public String toString()
    {
        String str = this.name + " " + this.score; 
        return str;
    }
}
