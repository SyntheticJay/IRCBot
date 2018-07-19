package me.jay;

import me.jay.logger.Logger;
import me.jay.logic.Bot;
import me.jay.logic.command.CommandHandler;

import java.util.Scanner;

/**
 * @author Jay, 2018
 */
public class Main {
    public static Main instance = new Main();

    public String ip, channel, name;
    public Bot bot;

    public final CommandHandler handler = new CommandHandler();

    public void init() {
        try {
            Scanner s = new Scanner(System.in);

            Logger.input("IP: ");
            this.ip = s.next();

            Logger.input("Channel: ");
            this.channel = s.next();

            //I don't know if this matters but i've added it anyway.
            if(!this.channel.startsWith("#")) {
                this.channel = "#" + this.channel;
            }

            Logger.input("Name: ");
            this.name = s.next();

            this.bot = new Bot();
            handler.init();
            bot.connect(this.ip, this.channel);
            Runtime.getRuntime().addShutdownHook(new Thread(this::onShutdown));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onShutdown() {
        try {
            //shutdown logic here, might not do until json configuration is done.
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        instance.init();
    }
}
