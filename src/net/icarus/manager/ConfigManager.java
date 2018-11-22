package net.icarus.manager;


import net.icarus.icarus.Icarus;
import net.icarus.types.TYPE;
import net.icarus.utils.Utils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Copyright © SquareCode 2018
 * created on: 22.11.2018 / 13:32
 * Project: Icarus
 */
public class ConfigManager {

    private static ConfigManager instance;
    public File configfile;
    public YamlConfiguration configfileconf;
    public File valuesfile;
    public YamlConfiguration valuesfileconf;

    public void setInstance() {
        instance = this;
    }

    public static ConfigManager getInstance() {
        return instance;
    }

    public void configFile() {
        File file = new File("plugins/Icarus/config.yml");
        if(!file.exists()) {
            Icarus.getInstance().saveDefaultConfig();
            Utils.getInstance().cosoleMessage(TYPE.ERROR, "Cant find ConfigYML. Create one...");
        } else {
            Utils.getInstance().cosoleMessage(TYPE.MESSAGE, "Loading ConfigYML...");
        }
        configfile = file;
        configfileconf = YamlConfiguration.loadConfiguration(file);
    }

    public void valuesFile() {
        File file = new File("plugins/Icarus/values.yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException error) {
                Utils.getInstance().cosoleMessage(TYPE.ERROR, error.getMessage());
            }
            Utils.getInstance().cosoleMessage(TYPE.ERROR, "Cant find ValuesYML. Create one...");
        } else {
            Utils.getInstance().cosoleMessage(TYPE.MESSAGE, "Loading ValuesYML...");
        }
        valuesfile = file;
        valuesfileconf = YamlConfiguration.loadConfiguration(file);
    }
}
