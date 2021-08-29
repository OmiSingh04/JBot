package com.husky.util;

import main.Bot;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if (msg[0].equals(Bot.SERVER_PREFIX + "ping")) {
            long time = System.currentTimeMillis();
            event.getChannel().sendMessage("Pong!").queue(response /* => Message */ -> {
                response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
            });
        }

    }
}
