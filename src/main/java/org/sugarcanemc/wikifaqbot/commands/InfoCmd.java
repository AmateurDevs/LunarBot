package org.sugarcanemc.wikifaqbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.sugarcanemc.wikifaqbot.config.ConfigHandler;

import java.io.FileNotFoundException;

public class InfoCmd extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        Message message = e.getMessage();
        String content = message.getContentRaw();
        String prefix = null;
        try { prefix = ConfigHandler.getInstance().getConfig().getPrefix(); } catch (FileNotFoundException fileNotFoundException) { fileNotFoundException.printStackTrace();}

        if (content.equalsIgnoreCase(prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("📚・Information・📚");
            info.setDescription("Information about Sugarcane");
            info.addField("Creator", "nevetS-718", false);
            info.setFooter("SugarcaneMC", "https://cdn.discordapp.com/icons/855918593497759754/a_978a67a83330554987cd7521f638fea8.gif?size=4096");
            info.setColor(0x73fc03);

            e.getChannel().sendTyping().queue();
            e.getChannel().sendMessage(info.build()).queue();
        }
    }
}
