package com.husky.events.commands;

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;

public abstract class ButtonCommand extends Command {

    public ButtonCommand(String main, String[] aliases) {
        super(main, aliases);
    }

    public abstract void executeButton(ButtonClickEvent event);
}
