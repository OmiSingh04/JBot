package com.husky.Commands.test;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class TestCommandsEvent{
    public static void say(SlashCommandEvent event){
        event.reply("Hello there");
    }
}