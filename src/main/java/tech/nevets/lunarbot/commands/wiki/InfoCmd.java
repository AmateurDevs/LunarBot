package tech.nevets.lunarbot.commands.wiki;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.nevets.lunarbot.config.ConfigHandler;

import java.io.FileNotFoundException;

public class InfoCmd extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        Message message = e.getMessage();
        String content = message.getContentRaw();
        String prefix = null;
        try { prefix = ConfigHandler.getInstance().getConfig().getPrefix(); } catch (FileNotFoundException fileNotFoundException) { fileNotFoundException.printStackTrace();}

        if (content.equalsIgnoreCase(prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("📚・LunarBot・📚");
            info.setDescription("Lunarbot cuz y not");
            info.setFooter("LunarBot: Created by nevetS & 5gi", "https://cdn.discordapp.com/icons/855918593497759754/a_978a67a83330554987cd7521f638fea8.gif?size=4096");
            info.setColor(0x2a2ea3);

            e.getChannel().sendTyping().queue();
            e.getChannel().sendMessage(info.build()).queue();
        }
    }
}
