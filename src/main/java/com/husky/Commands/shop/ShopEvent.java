package com.husky.Commands.shop;

import net.dv8tion.jda.api.EmbedBuilder;

public class ShopEvent{
    public EmbedBuilder createMenu(){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Shop")
                .addField("Foods", "5 treats", false)
                .addField("Boosts", "100 treats", false);
        return embed;
    }
}
