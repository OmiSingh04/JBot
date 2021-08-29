package main;

import com.husky.Commands.test.TestCommandsEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import com.husky.util.PingEvent;
import com.husky.Commands.ShopEvent;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    public static String SERVER_PREFIX = "?";
    public static void main(String [] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(args[0])
                .addEventListeners(new ShopEvent())
                .addEventListeners(new PingEvent())
                .addEventListeners(new Bot())
                .build();

        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(new CommandData("say", "To Say something"));
        commands.queue();
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event){
        switch(event.getName()){
            case "say": TestCommandsEvent.say(event); break;
        }
    }
}


