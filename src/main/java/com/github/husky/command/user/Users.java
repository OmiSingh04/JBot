package com.github.husky.command.user;


import com.github.husky.database.DataClass;
import com.github.husky.database.DatabaseHandler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

public class Users {
    public static void registerUser(long uid, MessageChannel channel, EmbedBuilder embed){
    	DataClass data = new DataClass(uid);
    	embed.setTitle("Registration Status");
    	embed.addField("Status:", DatabaseHandler.insertData(data),false);
    	channel.sendMessageEmbeds(embed.build()).queue();
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
    public static void getUserData(long uid, MessageChannel channel, EmbedBuilder embed) {
    	DataClass data = new DataClass(uid);
    	embed.setTitle("Money").addField("Your Money:-", ""+DatabaseHandler.getUser(data).getMoney(),false);
    	channel.sendMessageEmbeds(embed.build()).queue();
    }
}
