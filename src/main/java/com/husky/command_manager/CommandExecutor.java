package com.husky.command_manager;

import com.husky.command.Command;
import com.husky.command.util.PingCommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor extends ListenerAdapter {

    private CommandManager commandManger;

    public CommandExecutor(){
        List<Command> commands= new ArrayList<>();
        commands.add(new PingCommand());
        commandManger = new CommandManager(commands);
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        if(event.getMessage().getContentRaw().startsWith(CommandManager.PREFIX)){
            String cmd = event.getMessage().getContentRaw().split("\\s+")[0].substring(1);
            String mainCommand = commandManger.getMainFromAlias(cmd);//works
            //check beyond this point
            if(mainCommand == null){//hashmaps return null if key doesnt exist :)
                System.out.println("Invalid command, skipping");
                return;
            }

            commandManger.getCommand(mainCommand).executeCommand(event.getMessage());
        }

    }
}
