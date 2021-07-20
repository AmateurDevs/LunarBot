package org.sugarcanemc.wikifaqbot.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.sugarcanemc.wikifaqbot.config.ConfigHandler;

import java.io.FileNotFoundException;

public class PingCmd extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        Message message = e.getMessage();
        String content = message.getContentRaw();
        String prefix = null;
        try { prefix = ConfigHandler.getInstance().getConfig().getPrefix(); } catch (FileNotFoundException fileNotFoundException) { fileNotFoundException.printStackTrace(); }

        if (content.equalsIgnoreCase(prefix + "ping")) {
            MessageChannel channel = e.getChannel();
            channel.sendTyping().queue();
            channel.sendMessage("Pong!").queue();
        }
    }
}