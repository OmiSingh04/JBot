package com.husky.command_manager;


import com.husky.command.Command;

import java.util.HashMap;
import java.util.List;

public class CommandManager {

    public static String PREFIX = "?";
    public HashMap<String, Command> commands;
    public HashMap<List<String>, String> aliasMain;
    private List<Command> commandList;

    public CommandManager(List<Command> commandList){
        this.commandList = commandList;
        aliasMain = new HashMap<>();
        commands = new HashMap<>();
        for(Command command : commandList){
            aliasMain.put(command.getAliases(), command.getMain());
            commands.put(command.getMain(), command);
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