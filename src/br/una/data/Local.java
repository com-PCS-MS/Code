package br.una.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Local {
    
    JSONParser parser = new JSONParser();
    
    public int getUsuarioId1(){     
        int id = 0;
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("/br/una/data/local.json"));            
            
            for (Object o : array)
            {
              JSONObject obj = (JSONObject) o;

               id = (int) obj.get("jogador1id");
            }
                        
            return id;                                   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int getUsuarioId2(){     
        int id = 0;
        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("/br/una/data/local.json"));            
            
            for (Object o : array)
            {
              JSONObject obj = (JSONObject) o;

               id = (int) obj.get("jogador2id");
            }
                        
            return id;                                   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void setUsuarioId1(int id){
    
    }
    
}
