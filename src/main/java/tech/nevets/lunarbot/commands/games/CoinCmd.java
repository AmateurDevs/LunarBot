package tech.nevets.lunarbot.commands.games;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.nevets.lunarbot.Config;
import tech.nevets.lunarbot.commands.CommandContext;
import tech.nevets.lunarbot.commands.ICommand;

import java.util.Random;

public class CoindCmd implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();

        Random rand = new Random();
        int upperbound = 2;
        MessageChannel channel = jda.getChannel;

        int i = rand.nextInt(upperbound);
        if (i == 0) {
            channel.sendTyping().queue();
            channel.sendMessage("The coin landed on **heads**").queue();
        } else {
            channel.sendTyping().queue();
            channel.sendMessage("The coin landed on **tails**").queue();
        }
    }

    @Override
    public String getName() {
        return "coinflip";
    }
}

/**
public class CoinCmd extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        Message message = e.getMessage();
        String content = message.getContentRaw();
        String prefix = Config.getPrefix();

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
**/