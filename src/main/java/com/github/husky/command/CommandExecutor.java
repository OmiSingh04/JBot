package com.github.husky.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import com.github.husky.command.ping.Ping;
import com.github.husky.command.user.Users;
import com.github.husky.command.hello.Hello;

public class CommandExecutor{
    
    public static void execute(String name, MessageReceivedEvent event){
        Message msg = event.getMessage();
        MessageChannel channel = msg.getChannel();
        EmbedBuilder embed = new EmbedBuilder().setFooter("Requested by "+event.getAuthor().getAsTag(),event.getAuthor().getAvatarUrl());
        switch(name){
            case "ping": Ping.getPing(channel, embed, event);
                         break;
            case "hello": Hello.sendHello(channel, embed);
                         break;
            case "register": Users.registerUser(msg.getAuthor().getIdLong(), channel, embed);
                             break;
                             
            case "money": Users.getUserData(msg.getAuthor().getIdLong(), channel, embed);
            				break;
            default: channel.sendMessage("No such command exist").queue();
        }
    
    }
    public static void execute(String name, SlashCommandInteractionEvent event){
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder().setFooter("Requested by "+event.getUser().getAsTag(), event.getUser().getAvatarUrl());
        switch(name){
            case "ping": Ping.getPing(channel, embed, event);
                         break;
            case "hello": Hello.sendHello(channel, embed);
                         break;
            case "feed" : break;
            default: channel.sendMessage("No such command exist").queue();
        }
    
    }

}
