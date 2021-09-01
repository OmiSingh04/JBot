package com.husky.events.commands.command_manager;


import com.husky.events.commands.ButtonCommand;
import com.husky.events.commands.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandManager {

    public static String PREFIX = "?";
    public HashMap<String, Command> commands;
    public HashMap<List<String>, String> aliasMain;
    public List<Command> commandList;
    public List<ButtonCommand> buttonCommandList;

    public CommandManager(List<Command> commandList){
        this.commandList = commandList;
        this.buttonCommandList = new ArrayList<>();
        aliasMain = new HashMap<>();
        commands = new HashMap<>();
        for(Command command : commandList){
            aliasMain.put(command.getAliases(), command.getMain());
            commands.put(command.getMain(), command);
        }
        for(Command command :  commandList)
            if(command instanceof ButtonCommand) {
                buttonCommandList.add((ButtonCommand) command);
            }
    }


    public String getMainFromAlias(String alias){
        for(List<String> i : this.aliasMain.keySet()) {
            for(String j : i){
                if(j.equals(alias)) {
                    return aliasMain.get(i);
                }
            }
        }
        return null;
    }
    public Command getCommand(String command){
        return commands.get(command);
    }

}