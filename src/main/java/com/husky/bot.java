package com.husky;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import com.husky.Event.MessageListener;
import com.husky.Commands.Shop;

import javax.security.auth.login.LoginException;


public class bot implements EventListener {
    public static String prefix = "?";
    public static void main(String [] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(args[0]).addEventListeners(new bot()).setActivity(Activity.playing("Type "+prefix+"ping")).build();
        jda.addEventListener(new MessageListener());
        jda.addEventListener(new Shop());
    }


    @Override
    public void onEvent(GenericEvent event){
        if(event instanceof ReadyEvent){
            System.out.println("API is ready!");
        }
    }
}
