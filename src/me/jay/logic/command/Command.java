package me.jay.logic.command;

import me.jay.Main;

/**
 * @author Jay, 2018
 *
 * I could use annotations here but I was told by a friend that It could slow it down due to reflections, but I miught still use it as it's an IRC bot, not that much
 * of a heavily handler.
 *
 * TODO: Annotations.
 */
public abstract class Command {
    private String name, desc, usage;
    private CommandType type;

    //IRC channel/server info
    public String cmdSender;
    public int uses;

    public Command(String name, String desc, String usage, CommandType type) {
        this.name = name;
        this.desc = desc;
        this.usage = usage;
        this.type = type;
    }

    public Command(String name, String usage, CommandType type) {
        this.name = name;
        this.usage = name;
        this.type = type;
    }

    public void sendMessage(String s) {
        Main.instance.bot.sendMessage(Main.instance.channel, s);
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getUsage() {
        return Main.instance.name + " " + usage;
    }

    public CommandType getType() {
        return type;
    }

    public abstract void onExecute(String[] args);

    public enum CommandType {
        NORMAL,
        FUN,
        MEME
    }
}
