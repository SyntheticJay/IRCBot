package me.jay.logic.command.commands;

import me.jay.logic.command.Command;

/**
 * @author Jay, 2018
 */
public class CMDHello extends Command {
    public CMDHello() {
        super("hello", "Greet's the user!", "hello", CommandType.NORMAL);
    }

    @Override
    public void onExecute(String[] args) {
        sendMessage("Hi, " + cmdSender + "!");
    }
}
