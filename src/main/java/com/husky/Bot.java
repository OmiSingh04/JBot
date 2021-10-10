package com.husky;

import com.husky.events.commands.Command;
import com.husky.events.commands.SlashCommand;
import com.husky.events.commands.command_manager.CommandExecutor;
import com.husky.events.commands.shop.ShopCommand;
import com.husky.events.commands.util.HelloCommand;
import com.husky.events.commands.util.PingCommand;
import com.husky.events.commands.util.ProgressCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends ListenerAdapter {
    public static JDA jda;
    public static void main(String [] args) throws LoginException {
        List<Command> commands = new ArrayList<>();
        commands.add(new PingCommand());
        commands.add(new HelloCommand());
        commands.add(new ShopCommand());
        commands.add(new ProgressCommand());
        Bot.jda = JDABuilder.createDefault(args[0])
                .addEventListeners(new CommandExecutor(commands)).build();

        for(Command cmd : commands){
            if(cmd instanceof SlashCommand){
                Bot.jda.upsertCommand(cmd.getMain(), ".com");
            }
        }
    }
}