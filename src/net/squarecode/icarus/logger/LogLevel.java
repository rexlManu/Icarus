package net.squarecode.icarus.logger;

public enum LogLevel {

    DEBUG("Debug", 99),
    INFO("Info", 1),
    ERROR("Error", 2),
    WARNING("Warning", 3);

    private String prefix;
    private int level;

    LogLevel(String prefix, int level) {
        this.prefix = prefix;
        this.level = level;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getLevel() {
        return level;
    }
}
