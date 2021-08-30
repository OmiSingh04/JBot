package com.husky.Commands;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Command extends ListenerAdapter {
    private static String name;
    private static List<String[]> aliases;
    public Command(String name, List<String[]> aliases){
        this.name = name;
        this.aliases = aliases;
    }
}
