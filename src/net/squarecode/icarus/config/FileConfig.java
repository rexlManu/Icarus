package net.squarecode.icarus.config;

import net.squarecode.icarus.Icarus;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

public final class FileConfig {

    private File file;
    private FileConfiguration fileConfiguration;
    private String configName;

    public FileConfig(String configName) {
        this.configName = configName;
        this.file = new File(Icarus.getInstance().getDataFolder(), this.configName + ".yml");
    }

    public void load() {
        createFile();
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
        Icarus.getInstance().getIcarusLogger().info(MessageFormat.format("Loading the config \"{0}\"", this.configName));
    }

    private void createFile() {
        if (!file.exists()) {
            try {
                this.file.createNewFile();
                Icarus.getInstance().getIcarusLogger().error(MessageFormat.format("The config file \"{0}\" is created.", this.configName));
            } catch (IOException e) {
                Icarus.getInstance().getIcarusLogger().error(MessageFormat.format("Exception on \"{0}\" config: {1}", this.configName, e.getMessage()));
            }
        }
    }

    public void save() {
        try {
            this.fileConfiguration.save(file);
        } catch (IOException e) {
            Icarus.getInstance().getIcarusLogger().error(MessageFormat.format("Exception on \"{0}\" config: {1}", this.configName, e.getMessage()));
        }
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public File getFile() {
        return file;
    }
}
