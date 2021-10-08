package com.husky.events.commands.util;

import com.husky.events.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

public class AvatarCommand extends Command {


    public AvatarCommand() {
        super("avatar", new String[]{"avatar", "av", "pfp"});
    }

    @Override
    public void executeCommand(Message message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(message.getMember().getNickname() + "'s Avatar");
        embed.setImage(message.getAuthor().getAvatarUrl() + "?size=1024");
        message.replyEmbeds(embed.build()).queue();
    }
}
