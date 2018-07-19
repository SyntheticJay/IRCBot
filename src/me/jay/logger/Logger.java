package me.jay.logger;

/**
 * @author Jay, 2018
 *
 * This should be accessed through the main class's instance but it's staticly acccessed for now.
 */
public class Logger {

    public static void raw(String s) {
        System.out.println(s);
    }

    public static void info(String s) {
        System.out.println(LoggerType.INFO.getPrefix() + " " + s);
    }

    public static void log(String s, LoggerType type) {
        System.out.println(type.getPrefix() + " " + s);
    }

    public static void input(String prefix) {
        System.out.print(LoggerType.INFO.getPrefix() + " " + prefix);
    }

    public enum LoggerType {
        INFO("[*]"),
        ERROR("[!]");

        private String prefix;

        LoggerType(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }
}
