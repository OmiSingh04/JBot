package com.github.husky.command.user;


import com.github.husky.database.DataClass;
import com.github.husky.database.DatabaseHandler;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Users {
    public static void registerUser(long uid, MessageChannel channel){
    	DataClass data = new DataClass(uid);
        channel.sendMessage(DatabaseHandler.insertData( DatabaseHandler.makeConnection(),data)).queue();
    }
    public static void alterUserData(long uid, int value)
    {
            DataClass data = new DataClass(uid, value);
            DatabaseHandler.alterData(DatabaseHandler.makeConnection(),data);
    }
}
