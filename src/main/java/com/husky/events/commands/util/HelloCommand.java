package com.husky.events.commands.util;

import com.husky.events.commands.command_manager.ButtonCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.Button;

public class HelloCommand extends ButtonCommand {//something which provides both

    public HelloCommand() {
        super("hello", new String[]{"hi", "hello"});
    }

    @Override
    public void executeCommand(Message message) {//embed to be sent
        EmbedBuilder embed = new EmbedBuilder();
        String name = message.getAuthor().getName();
        embed.setTitle("WASSUP DUDE")
                .addField("Hello", name, false);
        message.replyEmbeds(embed.build()).setActionRow(
                Button.primary("hi", "HI!")
        ).queue();
    }

    @Override
    public void executeButton(ButtonClickEvent event) {
        if (event.getComponentId().equals("hi")) {
            event.getChannel().sendMessage("Hello!").queue();
        }
    }
}
