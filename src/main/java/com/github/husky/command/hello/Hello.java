package com.github.husky.command.hello;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

public class Hello {
    public static void sendHello(MessageChannel channel, EmbedBuilder embed){
        channel.sendMessageEmbeds(
        		embed.setTitle("Hello world!").build())
        .queue();
    }
}
