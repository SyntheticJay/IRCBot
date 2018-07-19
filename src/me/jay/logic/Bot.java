package me.jay.logic;

import me.jay.Main;
import me.jay.logger.Logger;
import me.jay.logic.command.Command;
import org.jibble.pircbot.PircBot;

/**
 * @author Jay, 2018
 */
public class Bot extends PircBot {
    public Bot() {
        this.setName(Main.instance.name);
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        String[] split = message.split(" ");

        //TODO: prefixing.
        if(split[0].equalsIgnoreCase(getName())) {
            //mentioned name
            //so grab command with the name
            Command command = Main.instance.handler.getCommand(split[1]);
            if(command != null) {
                command.cmdSender = sender;
                //if command is not equal to nothing, then execute the abstract statement.
                command.onExecute(split);
                command.uses++;
            }
        }
    }

    @Override
    protected void onConnect() {
        Logger.info("Connected without fail.");
    }

    @Override
    protected void onDisconnect() {
        Logger.info("Disconnected from IRC server.");
    }

    @Override
    protected void onKick(String channel, String kickerNick, String kickerLogin, String kickerHostname, String recipientNick, String reason) {
        Logger.info("I was kicked from " + channel + " by " + kickerNick + " (" + kickerHostname + " | " + kickerLogin + ") for " + reason + ".");
    }

    public void connect(String ip, String channel) {
        try {
            //i could use this in an instance but it might want to be changable.
            connect(ip, 6667);
            joinChannel(channel);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
