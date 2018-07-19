package me.jay.logic.command;

//you could categorise the commands in logic of the packages aswell if you want to.
import me.jay.logic.command.commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay, 2018
 */
public class CommandHandler {
    private List<Command> commands = new ArrayList<>();

    public void init() {
        try {
            addCommand(new CMDHelp());

            addCommand(new CMDPing());
            addCommand(new CMDHello());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public Command getCommand(String name) {
        for(Command c : commands) {
            if(c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    //might remove
    public Command getCommand(Class<? extends Command>clazz) {
        for(Command c : commands) {
            if(c.getClass() == clazz) {
                return c;
            }
        }
        return null;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
