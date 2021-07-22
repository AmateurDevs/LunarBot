package tech.nevets.lunarbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import tech.nevets.lunarbot.commands.games.CoinCmd;
import tech.nevets.lunarbot.commands.games.DiceCmd;
import tech.nevets.lunarbot.commands.wiki.InfoCmd;
import tech.nevets.lunarbot.commands.games.PingCmd;
import tech.nevets.lunarbot.config.Config;
import tech.nevets.lunarbot.config.ConfigHandler;
import tech.nevets.lunarbot.config.ConfigUtils;
import tech.nevets.lunarbot.webserver.WebAPI;
import tech.nevets.lunarbot.webserver.WebGenerator;

import java.io.File;

public class Bot {

    public static void main(String[] args) throws Exception {
        String configPath = ConfigHandler.configPath.toString();
        File file = new File(configPath);

        if (!file.exists()) {
            ConfigUtils.createConfig();
        }

        ConfigHandler handler = ConfigHandler.getInstance();
        Config config = handler.getConfig();
        String prefix = config.getPrefix();
        String botToken = config.getBotToken();

        JDA jda = JDABuilder.createDefault(botToken)
                .setActivity(Activity.competing("being the very best"))
                .addEventListeners(new InfoCmd())
                .addEventListeners(new PingCmd())
                .addEventListeners(new DiceCmd())
                .addEventListeners(new CoinCmd())
                .build();
        jda.awaitReady();
        System.out.println("Finished Building Bot!");

        WebAPI.main(null);
        WebGenerator.generator(null);

    }
}