package net.squarecode.icarus.logger;

import com.google.common.collect.Lists;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class IcarusLogger {

    private List<String> logs;
    private SimpleDateFormat simpleDateFormat;
    private LogLevel logLevel;

    private IcarusLogger(LogLevel logLevel) {
        this.simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy-hh:mm");
        this.logLevel = logLevel;
        this.logs = Lists.newArrayList();
    }

    public IcarusLogger() {
        this(LogLevel.INFO);
    }

    private void logMessage(LogLevel logLevel, String message) {
        if (logLevel.getLevel() <= this.logLevel.getLevel()) {
            final String finalMessage = MessageFormat.format("[{0} | {1}] {2}", simpleDateFormat.format(new Date()), logLevel.getPrefix(), message);
            System.out.println(finalMessage);
            this.logs.add(finalMessage);
        }
    }

    public void log(String message) {
        this.logMessage(LogLevel.INFO, message);
    }

    public void info(String message) {
        this.logMessage(LogLevel.INFO, message);
    }

    public void warning(String message) {
        this.logMessage(LogLevel.WARNING, message);
    }

    public void error(String message) {
        this.logMessage(LogLevel.ERROR, message);
    }

    public void debug(String message) {
        this.logMessage(LogLevel.DEBUG, message);
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public List<String> getLogs() {
        return logs;
    }
}
