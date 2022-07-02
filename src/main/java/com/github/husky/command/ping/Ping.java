package com.github.husky.command.ping;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.Color;

public class Ping {
    public static void getPing(MessageChannel channel, EmbedBuilder embed, MessageReceivedEvent event){
        long time = System.currentTimeMillis();
        channel.sendMessageEmbeds(embed.setTitle("Ping").addField("Pong!"," ", false).build())
        .queue(response -> {
        	response.editMessageEmbeds(
        			new EmbedBuilder()
        			.setTitle("Ping")
        			.addField("Pong! "," "+(System.currentTimeMillis()-time),true)
        			.setFooter("Requested by "+event.getAuthor().getAsTag(), event.getAuthor().getAvatarUrl())
					.setColor(Color.lightGray)
        			.build()
        			).queue();
        
//        	"Pong!, %d ms", System.currentTimeMillis()-time
        });
    }
    public static void getPing(MessageChannel channel, EmbedBuilder embed, SlashCommandInteractionEvent  event){
        long time = System.currentTimeMillis();
        channel.sendMessageEmbeds(embed.setTitle("Ping").addField("Pong!"," ", false).build())
        .queue(response -> {
        	response.editMessageEmbeds(
        			new EmbedBuilder()
        			.setTitle("Ping")
        			.addField("Pong! "," "+(System.currentTimeMillis()-time), false)
        			.setFooter("Requested by "+event.getUser().getAsTag(), event.getUser().getAvatarUrl())
        			.build()
        			).queue();
        
//        	"Pong!, %d ms", System.currentTimeMillis()-time
        });
    }
}
