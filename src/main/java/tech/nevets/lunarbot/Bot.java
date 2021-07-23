package tech.nevets.lunarbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import tech.nevets.lunarbot.commands.games.CoinCmd;
import tech.nevets.lunarbot.commands.games.DiceCmd;
import tech.nevets.lunarbot.commands.wiki.InfoCmd;
import tech.nevets.lunarbot.commands.games.PingCmd;
import tech.nevets.lunarbot.webserver.WebAPI;
import tech.nevets.lunarbot.webserver.WebGenerator;

public class Bot {

    public static void main(String[] args) throws Exception {
        Config.loadConfig();
        String token = Config.getToken();

        JDA jda = JDABuilder.createDefault(token)
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