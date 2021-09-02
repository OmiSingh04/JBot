package com.husky.events.commands.shop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemIdGenerator {
    public static String path = "./src/main/java/com/husky/events/commands/shop/shopItems.json";
    public static int IdGenerator(String itemName){
        int id=0;
        for(int i = 0; i<itemName.length(); i++){
            id=id+(int)itemName.charAt(i);
        }
        return id;
    }
    public static void setId(){
        try(FileReader fr = new FileReader(path))
        {
            Object jobs = new JSONParser().parse(fr);
            JSONArray items = (JSONArray) jobs;
            for (Object o : items) {
                JSONObject item = (JSONObject) o;
                item.put("item_id", IdGenerator(item.get("name").toString()));
            }
            FileWriter file = new FileWriter(path);
            file.write(items.toJSONString());
            file.flush();

        }catch(IOException | ParseException e){
            e.printStackTrace();
        }
    }
    public static List getName(){
        List<String> Name = new ArrayList<>();
        try(FileReader fr = new FileReader(path)){
            JSONArray items = (JSONArray) new JSONParser().parse(fr);
            int i = 0;
            for(Object item : items){
                JSONObject itemize = (JSONObject) item;
                Name.add(itemize.get("name").toString());
            }
        }catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return Name;
    }
    public static List getPrice(){
        List<String> Price = new ArrayList<>();
        try(FileReader fr = new FileReader(path)){
            JSONArray items = (JSONArray) new JSONParser().parse(fr);
            int i = 0;
            for(Object item : items){
                JSONObject itemize = (JSONObject) item;
                Price.add(itemize.get("price").toString());
            }
        }catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return Price;
    }

}
