package com.github.husky.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import com.github.husky.command.ping.Ping;
import com.github.husky.command.user.Users;

import java.awt.Color;

import com.github.husky.command.hello.Hello;

public class CommandExecutor{
    
    public static void execute(String name, MessageReceivedEvent event){
        Message msg = event.getMessage();
        MessageChannel channel = msg.getChannel();
        if(!event.getAuthor().isBot()){
            try {
                EmbedBuilder embed = new EmbedBuilder().setFooter("Requested by "+event.getAuthor().getAsTag(),event.getAuthor().getAvatarUrl());
                switch(name){
                    case "ping": Ping.getPing(channel, embed.setColor(Color.BLUE), event);
                                break;
                    case "hello": Hello.sendHello(channel, embed.setColor(Color.MAGENTA), event.getAuthor().getName());
                                break;
                    case "register": Users.registerUser(msg.getAuthor().getIdLong(), channel, embed.setColor(Color.GREEN));
                                    break;    
                    case "money": Users.getUserData(msg.getAuthor().getIdLong(), channel, embed.setColor(Color.GREEN));
                                    break;
                    default: channel.sendMessage("No such command exist").queue();
                }
            }catch(Exception e) {
                e.printStackTrace();
                ErrorHandler.execute(e, event);
            }
        }
    
    }
    public static void execute(String name, SlashCommandInteractionEvent event){
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder().setFooter("Requested by "+event.getUser().getAsTag(), event.getUser().getAvatarUrl());
        switch(name){
            case "ping": Ping.getPing(channel, embed, event);
                         break;
            case "hello": Hello.sendHello(channel, embed, event.getUser().getName());
                         break;
            case "feed" : break;
            default: channel.sendMessage("No such command exist").queue();
        }
    
    }

}
