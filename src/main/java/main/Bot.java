package main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import com.husky.util.PingEvent;
import com.husky.Commands.ShopEvent;

import javax.security.auth.login.LoginException;


public class Bot implements EventListener {
    public static String SERVER_PREFIX = "?";
    public static void main(String [] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(args[0]).addEventListeners(new Bot()).setActivity(Activity.playing("Type "+SERVER_PREFIXx+"ping")).build();
        jda.addEventListener(new PingEvent());
        jda.addEventListener(new ShopEvent());
    }


    @Override
    public void onEvent(GenericEvent event){
        if(event instanceof ReadyEvent){
            System.out.println("API is ready!");
        }
    }
}
