package tech.nevets.lunarbot;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public class Config {

    private static String prefix;
    private static String token;
    private static String ownerID;
    private static boolean verbose;

    public static void loadConfig() {
        final YamlFile ymlFile = new YamlFile("config.yml");
        try {
            if (!ymlFile.exists()) {
                System.out.println("Configuration file has been created\n");
                ymlFile.createNewFile(true);
            } else {
                System.out.println("config.yml already exists, loading configuration file...\n");
            }
            ymlFile.loadWithComments();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        System.out.println("Adding default values...");
        ymlFile.addDefault("prefix", "!");
        ymlFile.addDefault("token", "BotToken122333444455555666666777777788888888999999999");
        ymlFile.addDefault("verbose", false);

        try {
            ymlFile.save();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        prefix = ymlFile.getString("prefix");
        token = ymlFile.getString("token");
        ownerID = ymlFile.getString("owner-id");
        verbose = ymlFile.getBoolean("verbose");
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getToken() {
        return token;
    }

    public static String getOwnerID() {
        return ownerID;
    }

    public static boolean getVerbose() {
        return verbose;
    }
}
