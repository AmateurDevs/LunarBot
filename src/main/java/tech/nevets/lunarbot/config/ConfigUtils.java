package tech.nevets.lunarbot.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigUtils {

    public static void createConfig() {

        System.out.println("Attemption to create file...");

        try {
            File config = new File("config.yml");

            if (config.createNewFile()) {
                System.out.println(config.getName() + " has been successfully created!");
            } else {
                System.out.println(config.getName() + " already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("config.yml");
            writer.write("prefix: \"!\"\nbotToken: \"BOTTOKEN\"");
            writer.close();
            System.out.println("Successfully wrote to config.yml");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to config.yml");
            e.printStackTrace();
        }
    }
}
