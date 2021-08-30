package com.husky.Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashMap;

public class CommandManger {
    public static HashMap<String, Command> commands= new HashMap<>();

    public void execute(GuildMessageReceivedEvent event){

    }
}
