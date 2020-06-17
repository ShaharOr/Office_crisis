/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreUtils;

import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotFoundException;

/**
 * this class is responsible for the saving of data in the game
 * @author student
 */
public class RecordStoreMng
{
/**
 * the name of the wanted recordStore.
 */
    private static String RSName = "PlayerScores";

    
    /**
     * Adding new data to ResordStore
     * @param name String with new name to add
     * @return ID of added record. If no record was added returns -1
     */
    public static int saveData(byte[] data)
    {
        try
        {
            deleteRS();
        }
        catch (RecordStoreException ex)
        {
            ex.printStackTrace();
        }
        
        RecordStore rs = null;
        int id = -1;
        try
        {
            rs = RecordStore.openRecordStore(RSName, true);
            id = rs.addRecord(data, 0, data.length);
        }
        catch (RecordStoreException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.closeRecordStore();
                }
                catch (RecordStoreException ex)
                {
                    ex.printStackTrace();
                }
                
            }
        }
        
        return id;

    }
    
    /**
     * gets the data from the recordStore
     * @return 
     */
    public static byte[] getData()
    {
        byte[] data = null;
        
        RecordStore rs=null;
        try {
            rs=RecordStore.openRecordStore(RSName, false);//יש מצב שבו אם נפתח רקורד סטור ולא ניצור חדש תזרק חריגה
         data=rs.getRecord(1);
        }
        catch(RecordStoreNotFoundException ex)
        {
            return null;
        }
        
        catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.closeRecordStore();
                }
                catch (RecordStoreException ex)
                {
                    ex.printStackTrace();
                }
                
            }
        }
               
        
        return data;
    }
    /**
     * deletes the recordStore.
     * @throws RecordStoreException 
     */
    private static void deleteRS() throws RecordStoreException
    {
        RecordStore rs = null;
        
        rs = RecordStore.openRecordStore(RSName, true);
        rs.closeRecordStore();
        
        RecordStore.deleteRecordStore(RSName);
        
    }
}
