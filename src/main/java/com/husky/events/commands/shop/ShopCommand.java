package com.husky.events.commands.shop;

import com.husky.events.commands.ButtonCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;

public class ShopCommand extends ButtonCommand {
    public ShopCommand() {
        super("shop", new String[]{"shop", "sh", "s"});
    }

    @Override
    public void executeCommand(Message message){
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Shop")
                .addField("Food", "5 Treats", false)
                .addField("Boosts", "100 Treats", false);

        message.replyEmbeds(embed.build())
                .setActionRow(
                    Button.of(ButtonStyle.PRIMARY, "Food", "5 Treats"),
                    Button.of(ButtonStyle.PRIMARY, "Boost", "100 Treats")
                )
                .queue();
    }

    @Override
    public void executeButton(ButtonClickEvent event){
        if(event.getComponentId().equals("Food")){
            EmbedBuilder embed = new EmbedBuilder()
                    .addField("**Purchased**", "Food has been purchased",true)
                    .setFooter(event.getUser().getName(), event.getUser().getAvatarUrl());
            event.replyEmbeds(embed.build())
                    .queue();
        }else if(event.getComponentId().equals("Boost")){
            EmbedBuilder embed = new EmbedBuilder()
                    .addField("**Purchased**", "Boost has been purchased", true)
                    .setFooter(event.getUser().getName(), event.getUser().getAvatarUrl());
            event.replyEmbeds(embed.build())
                    .queue();
        }
    }

}
