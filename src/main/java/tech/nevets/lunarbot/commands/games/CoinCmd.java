package tech.nevets.lunarbot.commands.games;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.nevets.lunarbot.config.ConfigHandler;

import java.io.FileNotFoundException;
import java.util.Random;

public class CoinCmd extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        Message message = e.getMessage();
        String content = message.getContentRaw();
        String prefix = null;
        try { prefix = ConfigHandler.getInstance().getConfig().getPrefix(); } catch (FileNotFoundException fileNotFoundException) { fileNotFoundException.printStackTrace(); }

        if (content.equalsIgnoreCase(prefix + "coinflip")) {
            Random rand = new Random();
            int upperbound = 2;
            MessageChannel channel = e.getChannel();

            int i = rand.nextInt(upperbound);
            if (i == 0) {
                channel.sendTyping().queue();
                channel.sendMessage("The coin landed on **heads**").queue();
            } else {
                channel.sendTyping().queue();
                channel.sendMessage("The coin landed on **tails**").queue();
            }
            System.out.println(i);
        }
    }
}