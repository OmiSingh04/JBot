package com.husky.Commands;

import com.husky.bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Shop extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Shop");
        embed.addField("Food", "5 treats", false);
        embed.addField("Boosts", "100 treats",false);
        if(e.getMessage().getContentRaw().equalsIgnoreCase(bot.prefix+"shop")){
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }
}
