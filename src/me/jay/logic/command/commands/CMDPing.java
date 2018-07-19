package me.jay.logic.command.commands;

import me.jay.logic.command.Command;

/**
 * @author Jay, 2018
 */
public class CMDPing extends Command {
    public CMDPing() {
        super("ping", "Ping!", "ping", CommandType.NORMAL);
    }

    @Override
    public void onExecute(String[] args) {
        sendMessage("Pong.");
    }
}
