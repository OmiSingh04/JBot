package com.github.husky.command;

import java.awt.Color;

import com.github.husky.Constant;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
public class ErrorHandler {
	public static void execute(Exception e, MessageReceivedEvent event) {
		if(event.getAuthor().getIdLong()==Constant.DEVELOPER_ID[0]) {
			EmbedBuilder embed = new EmbedBuilder()
								.setTitle("Error")
								.addBlankField(false)
								.setColor(Color.RED)
								.addField("error here:", e.toString(), true);
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
		}else {
			event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle("Some kind of Error")
					.setColor(Color.RED)
					.build())
			.queue();
		}
	}
	public static void execute(Exception e, SlashCommandInteractionEvent event) {
		
	}
}
