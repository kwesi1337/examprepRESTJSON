/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author josephawwal
 */
public class RandomGenerator {
    
    
    public static String getData(int num, String inputStr){
        
        List<String> stringArray = new ArrayList();
        
        try (Scanner scan = new Scanner(inputStr)){
            
            scan.useDelimiter(",");
            
            while(scan.hasNext()){
                
                stringArray.add(scan.next());
            }
        }
        
        JsonArray entities = new JsonArray();
        for (int i = 0; i < num; i++){
            
            JsonObject person = new JsonObject();
            for (int j = 0; j < stringArray.size(); j++){
                
                person.addProperty(stringArray.get(j), RandomStringUtils.random(5, "ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ"));
                
            }
            
            entities.add(person);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(entities);
        return jsonStr;
        
        
    }
}
