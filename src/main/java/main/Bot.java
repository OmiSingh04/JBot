package main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import com.husky.util.PingEvent;
import com.husky.Commands.shop.ShopEvent;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    public static String SERVER_PREFIX = "?";
    public static void main(String [] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(args[0])
                .addEventListeners(new ShopEvent())
                .addEventListeners(new PingEvent())
                .build();

    }
}


