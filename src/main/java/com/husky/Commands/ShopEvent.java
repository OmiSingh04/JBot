package com.husky.Commands;

import main.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ShopEvent extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        if(e.getMessage().getContentRaw().equalsIgnoreCase(Bot.SERVER_PREFIX+"shop")){
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Shop");
            embed.addField("Food", "5 treats", false);
            embed.addField("Boosts", "100 treats",false);
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }
}
