/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TopTenUltils;

import StoreUtils.RecordStoreMng;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

/**
 *this class manages the playerScores objects and its features so they could be saved to recordStore
 * properly.
 * @author student
 */
public class PlayerScoresMng
{
/**
 * a vector of player score which will become the only record in the record store of the game.
 */
    private static Vector vecPS = new Vector();
    /**
     * constructor.
     * @param name
     * @param score
     * @return
     * @throws IOException 
     */
    public static boolean saveDataToRS(String name, int score) throws IOException
    {
        getDataFromRS();
        addPSToVec(name, score);
        byte[] data = toByteArr();
        
        return RecordStoreMng.saveData(data)==1;
    }
     /**
      * enters the data from the RS into the vector.
      * @return
      * @throws IOException 
      */
    public static Vector getDataFromRS() throws IOException
    {
        byte[] data = RecordStoreMng.getData();
        fromByteArr(data);
        return vecPS;
    }

    /**
     * this method enters a PlayerScore to the RS 
     * Should be added according to the required order (top 10 scores).
     * @param name
     * @param score 
     */
   private static void addPSToVec(String name, int score){
    
       
        PlayerScore ps = new PlayerScore(name, score);
        if(vecPS.size()!=0)
        {
            int index=0;
            int i=0;
            boolean flag=true;
            while(i<vecPS.size()&&flag==true)
            {
                 if(((PlayerScore)(vecPS.elementAt(i))).getScore()<score)
                 {
                     index=i;
                     flag=false;
                 }
                 i++;
            }
            int tempIndex=index;
            System.out.println("index:"+index);
            if(flag==false){
            Vector TempVec=new Vector();
            for(int j=index;j<vecPS.size();j++)
            {
                 TempVec.addElement(vecPS.elementAt(j));
               
            }
             System.out.println("index:"+index);
             int times=vecPS.size();
            for(int k=index;k<times;k++)
            {
                 vecPS.removeElementAt(index);
                 System.out.println("do");
            }
            
            
            
            System.out.println("PS vec");
              for(int j=0;j<vecPS.size();j++)
            {
                System.out.println(((PlayerScore)(vecPS.elementAt(j))).getScore());
              
            }
           
            System.out.println("temp vec");
             for(int j=0;j<TempVec.size();j++)
            {
                System.out.println(((PlayerScore)(TempVec.elementAt(j))).getScore());
              
            }
             
             
           vecPS.addElement(ps);
           
           
            for(int j=0;j<TempVec.size();j++)
            {
                vecPS.addElement(TempVec.elementAt(j));
            }
            
            
            
            }
            if(flag==true)
            {
                vecPS.addElement(ps);
            }
            

            }   
        else{
            vecPS.addElement(ps);
        }
        if(vecPS.size()>10)
        {
            vecPS.removeElementAt(10);
        }
        
        
    }
/**
 * this method inserts a PlayerScore to vector in no order.
 * @param name
 * @param score 
 */
   private static void addPSToVec_NotInOrder(String name, int score){
       PlayerScore ps=new PlayerScore(name, score);
       vecPS.addElement(ps);
       
   }
   
/**
 * this method takes the data in the vector and creates a byte array from it,
 * based on the assumption that all the relevant data is already in vector, ready for saving.
 */ 
    private static byte[] toByteArr() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(vecPS.size());

        for (int i = 0; i < vecPS.size(); i++)
        {
            PlayerScore ps = (PlayerScore) vecPS.elementAt(i);
            dos.writeUTF(ps.getName());
            dos.writeInt(ps.getScore());
        }

        byte[] data = baos.toByteArray();

        baos.flush();
        baos.close();

        dos.flush();
        dos.close();

        return data;

    }
/**
 * this method is given a byte array and converts it into PlayerScores in the vector.
 * @param data
 * @throws IOException 
 */
    private static void fromByteArr(byte[] data) throws IOException
    {//יוצאת מנקודת הנחה שיש את כל המידע בצורה של מערך של בייטים והיא רוצה לקרוא את המידה לשים אותו בוקטור
        vecPS.removeAllElements();
        if(data!=null){
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);

        int n = dis.readInt();

        for (int i = 0; i < n; i++)
        {
            String name = dis.readUTF();
            int score = dis.readInt();
           addPSToVec_NotInOrder(name, score);
        }
        
        bais.close();     
        dis.close();
        }
     
        
    }
}
