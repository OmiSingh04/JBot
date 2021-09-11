package com.husky.events.commands;

import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;

public abstract class Command {

    protected String main;
    protected ArrayList<String> aliases;
    public Command(String main, String[] aliases){
        this.main = main;
        this.aliases = new ArrayList<String>();
        for(String s:aliases){
            this.aliases.add(s);
        }
    }

    public abstract void executeCommand(Message message);

    public String getMain(){
        return this.main;
    }
    public ArrayList<String> getAliases(){
        return this.aliases;
    }
}
