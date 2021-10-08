package com.husky.events.commands.util;

import com.husky.events.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class AvatarCommand extends Command {


    public AvatarCommand() {
        super("avatar", new String[]{"avatar", "av", "pfp"});
    }

    @Override
    public void executeCommand(Message message) {
        Member member = message.getMember();
        if(message.getMentionedMembers().size() > 0)
            member = message.getMentionedMembers(message.getGuild()).get(0);
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(member.getNickname() + "'s Avatar");
        embed.setImage(member.getUser().getAvatarUrl() + "?size=1024");
        message.replyEmbeds(embed.build()).queue();
    }
}
