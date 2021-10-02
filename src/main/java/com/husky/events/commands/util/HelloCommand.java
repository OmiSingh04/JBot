package com.husky.events.commands.util;

import com.husky.events.commands.ButtonCommand;
import com.husky.events.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.ButtonStyle;

public class HelloCommand extends Command {//something which provides both

    public HelloCommand() {
        super("hello", new String[]{"hi", "hello"});
    }

    @Override
    public void executeCommand(Message message) {//embed to be sent
       message.getChannel().sendMessage("Woof!").queue();
    }
}
