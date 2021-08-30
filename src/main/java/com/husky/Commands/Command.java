package com.husky.Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Command extends ListenerAdapter {
    private static String commandName;
    private static List<String[]> aliases;
    public Command(String name, List<String[]> aliases){
        this.commandName = name;
        this.aliases = aliases;
    }

    public void execute(GuildMessageReceivedEvent event){
        if(event.getMessage().getContentRaw().startsWith(CommandManger.PREFIX)){
            String command = CommandManger.commands(event.getMessage().getContentRaw().substring(1, ));
        }

    }
}
