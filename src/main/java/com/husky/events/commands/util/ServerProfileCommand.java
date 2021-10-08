package com.husky.events.commands.util;

import com.husky.events.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

public class ServerProfileCommand extends Command {
    public ServerProfileCommand() {
        super("serverpfp", new String[]{"serverpfp", "serverav", "serveravatar"});
    }

    @Override
    public void executeCommand(Message message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Server Pfp");
        embed.setImage(message.getGuild().getIconUrl() + "?size=1024");
        embed.setFooter(message.getMember().getNickname(), message.getAuthor().getAvatarUrl());
        message.replyEmbeds(embed.build()).queue();
    }
}
