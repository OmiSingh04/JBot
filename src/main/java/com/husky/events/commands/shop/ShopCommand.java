package com.husky.events.commands.shop;

import com.husky.events.commands.ButtonCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;

import java.util.ArrayList;
import java.util.List;

public class ShopCommand extends ButtonCommand {
    public ShopCommand() {
        super("shop", new String[]{"shop", "sh", "s"});
    }

    @Override
    public void executeCommand(Message message){
        EmbedBuilder embed = new EmbedBuilder().setTitle("Shop");
        ItemIdGenerator.setId();
        List<String> items = ItemIdGenerator.getName();
        List<String> itemPrice = ItemIdGenerator.getPrice();
        
        List<Button> button = new ArrayList<>();
        for(int i = 0; i<items.size(); i++){
            embed.addField(items.get(i), itemPrice.get(i)+" Treats", false);
            button.add(i, Button.of(ButtonStyle.PRIMARY, items.get(i), itemPrice.get(i)+" Treats"));
        }

        message.replyEmbeds(embed.build())
                .setActionRow(
                    button
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
