package com.husky;

import com.husky.command_manager.CommandExecutor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    public static String SERVER_PREFIX = "?";
    public static void main(String [] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(args[0])
                .addEventListeners(new CommandExecutor()).build();
    }
}


