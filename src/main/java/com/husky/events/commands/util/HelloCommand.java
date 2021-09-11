package com.husky.events.commands.util;

import com.husky.events.commands.ButtonCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;

public class HelloCommand extends ButtonCommand {//something which provides both

    public HelloCommand() {
        super("hello", new String[]{"hi", "hello"});
    }

    @Override
    public void executeCommand(Message message) {//embed to be sent
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("WASSUP DUDE")
                .addField("Hello", message.getAuthor().getName(), false);
        message.replyEmbeds(embed.build()).setActionRow(
                Button.of(ButtonStyle.PRIMARY,"hi", "HI!")
        ).queue();
    }

    @Override
    public void executeButton(ButtonClickEvent event) {
        if (event.getComponentId().equals("hi")) {
            event.replyEmbeds(new EmbedBuilder()
                    .addField("Hello", "nice to meet you "+event.getUser().getName(), true)
                    .setFooter(event.getUser().getName(), event.getUser().getAvatarUrl())
                    .build()).queue();
        }
    }
}
