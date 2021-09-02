package com.husky.events.commands.util;

import com.husky.events.commands.ButtonCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;

import java.util.ArrayList;
import java.util.List;

public class ProgressCommand extends ButtonCommand {
    public ProgressCommand(){super("progress", new String[]{"progress","lvl","prog", "p"});}
    @Override
    public void executeCommand(Message message) {
        EmbedBuilder embed = new EmbedBuilder().setTitle("**Progress**");
        List<Button> button = new ArrayList<>();
        button.add(0, Button.of(ButtonStyle.SUCCESS, "success", Emoji.fromEmote("jojo_think", 797798040635047936L, false)));
        embed.addField("**Name:-**", message.getAuthor().getName(), false);
        embed.addField("**Progress:-**", "Not valid for now", true); //progress bar will be added
        embed.addField("**Treats:-**", "Not valid for now", true);
        embed.addField("**Boosts:-**","Not valid of now", true);
        embed.setThumbnail(message.getAuthor().getAvatarUrl());
        message.replyEmbeds(embed.build())
                .setActionRow(
                        button
                ).queue();
    }

    @Override
    public void executeButton(ButtonClickEvent event) {
        if(event.getComponentId().equals("success")){
                event.getMessage().delete().queue();
        }
    }
}
