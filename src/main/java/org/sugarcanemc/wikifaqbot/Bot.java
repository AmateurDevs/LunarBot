package org.sugarcanemc.wikifaqbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.sugarcanemc.wikifaqbot.commands.CoinCmd;
import org.sugarcanemc.wikifaqbot.commands.DiceCmd;
import org.sugarcanemc.wikifaqbot.commands.InfoCmd;
import org.sugarcanemc.wikifaqbot.commands.PingCmd;
import org.sugarcanemc.wikifaqbot.config.Config;
import org.sugarcanemc.wikifaqbot.config.ConfigHandler;
import org.sugarcanemc.wikifaqbot.config.ConfigUtils;

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
    }
}