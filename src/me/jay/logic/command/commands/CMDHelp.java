package me.jay.logic.command.commands;

import me.jay.Main;
import me.jay.logic.command.Command;

/**
 * @author Jay, 2018
 *
 * TODO: Utilize command types.
 */
public class CMDHelp extends Command {
    public CMDHelp() {
        super("help", "Help!.", "help", CommandType.NORMAL);
    }

    @Override
    public void onExecute(String[] args) {
        sendMessage("Commands (" + Main.instance.handler.getCommands().size() + "):");
        for(Command c : Main.instance.handler.getCommands()) {
            sendMessage(c.getName() + " | " + c.getDesc() + " | " + c.getUsage());
        }
    }
}
