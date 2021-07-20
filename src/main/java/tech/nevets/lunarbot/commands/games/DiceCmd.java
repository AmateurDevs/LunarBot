package tech.nevets.lunarbot.commands.games;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.nevets.lunarbot.config.ConfigHandler;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiceCmd extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        Message message = e.getMessage();
        String content = message.getContentRaw();
        String prefix = null;
        try { prefix = ConfigHandler.getInstance().getConfig().getPrefix(); } catch (FileNotFoundException fileNotFoundException) { fileNotFoundException.printStackTrace(); }

        if (content.equalsIgnoreCase(prefix + "dice")) {
            Random rand = ThreadLocalRandom.current();
            MessageChannel channel = e.getChannel();

            int roll = rand.nextInt(6) + 1;
            channel.sendTyping().queue();
            channel.sendMessage("Your roll: " + roll).queue();
        }
    }
}
