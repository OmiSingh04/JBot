package com.github.husky.command.user;


import com.github.husky.database.DataClass;
import com.github.husky.database.DatabaseHandler;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Users {
    public static void registerUser(long uid, MessageChannel channel){
    	DataClass data = new DataClass(uid);
        channel.sendMessage(DatabaseHandler.insertData(data)).queue();
    }
    public static void registerUser(long uid){
    	DataClass data = new DataClass(uid);
        DatabaseHandler.insertData(data);
    }
    public static void alterUserData(long uid, int value)
    {
            DataClass data = new DataClass(uid, value);
            DatabaseHandler.alterData(data);
    }
    public static void getUserData(long uid, MessageChannel channel) {
    	DataClass data = new DataClass(uid);
    	DataClass result = DatabaseHandler.getUser(data);
    	channel.sendMessage("Your money: "+result.getMoney()).queue();
    }
}
