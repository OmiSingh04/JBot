package com.husky.events.commands.command_manager;

import com.husky.events.commands.ButtonCommand;
import com.husky.events.commands.Command;
import com.husky.events.commands.SlashCommand;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class CommandExecutor extends ListenerAdapter {

    private CommandManager commandManager;

    public CommandExecutor(List<Command> commands){
        commandManager = new CommandManager(commands);
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        if(event.getMessage().getContentRaw().startsWith(CommandManager.PREFIX)){
            String cmd = event.getMessage().getContentRaw().split("\\s+")[0].substring(1);
            String mainCommand = commandManager.getMainFromAlias(cmd);//works
            //check beyond this point
            if(mainCommand == null){//hashmaps return null if key doesnt exist :)
                System.out.println("Invalid command, skipping");
                return;
            }

            commandManager.getCommand(mainCommand).executeCommand(event.getMessage());
        }

    }

    @Override
    public void onButtonClick(ButtonClickEvent event){
        for(ButtonCommand command: commandManager.buttonCommandList)
            command.executeButton(event);
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event){
        for(SlashCommand command: commandManager.slashCommandsList)
            command.executeSlash(event);
    }
}
