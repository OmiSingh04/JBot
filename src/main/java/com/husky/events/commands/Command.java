package com.husky.events.commands;

import net.dv8tion.jda.api.entities.Message;

import java.util.List;

public abstract class Command {

    protected String main;
    protected List<String> aliases;
    public Command(String main, String[] aliases){
        this.main = main;
        this.aliases = List.of(aliases);
    }

    public abstract void executeCommand(Message message);

    public String getMain(){
        return this.main;
    }
    public List<String> getAliases(){
        return this.aliases;
    }
}
