package com.husky.events.commands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public abstract class SlashCommand extends Command{

    public SlashCommand(String main, String[] aliases) {
        super(main, aliases);
    }

    public abstract void executeSlash(SlashCommandEvent event);
}
