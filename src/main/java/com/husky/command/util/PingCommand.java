package com.husky.command.util;

import com.husky.command.Command;
import net.dv8tion.jda.api.entities.Message;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping", new String[]{"ping", "p"});
    }

    @Override
    public void executeCommand(Message message) {
            long time = System.currentTimeMillis();
            message.getChannel().sendMessage("Pong!").queue(response /* => Message */ -> {
                response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
            });

    }
}
