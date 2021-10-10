package com.husky.events.commands.util;

import com.husky.events.commands.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;

public class HelloCommand extends SlashCommand {//something which provides both

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
    public void executeSlash(SlashCommandEvent event){
        if(event.getCommandString().substring(1).equalsIgnoreCase("hello"))
            event.reply("Hello"+" "+event.getUser().getName()).queue();
    }
}
