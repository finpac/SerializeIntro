/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class SchuelerBL implements Serializable{
    private ArrayList<Schueler> klasse = new ArrayList();
    
    public void add(Schueler s)
    {
        klasse.add(s);
    }
    
    public void save(File f) throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
        for(Schueler s : klasse)
        {
            oos.writeObject(s.getName());
            oos.writeObject(";");
            oos.writeObject(s.getBirthday().toString());
        }
        oos.flush();
    }
    
    public void load(File f)throws Exception
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        
        Object s = null;
        while((s = ois.readObject()) != null)
        {
            
            try{
            add((Schueler) s);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        ois.close();
    }
    
    public static void main(String[] args) {
        Schueler s1 = new Schueler("Hans", LocalDate.of(2000, Month.APRIL, 21 ));
        Schueler s2 = new Schueler("Sara", LocalDate.of(1999, Month.NOVEMBER, 9));
        
        SchuelerBL bl = new SchuelerBL();
        bl.add(s1);
        bl.add(s2);
        
        File f = new File("./data.bin");
        try{
            bl.save(f);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
}
