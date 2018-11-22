package net.squarecode.icarus.manager;

import net.squarecode.icarus.config.FileConfig;

/**
 * Copyright © SquareCode 2018
 * created on: 22.11.2018 / 13:32
 * Project: Icarus
 */
public class ConfigManager {

    private FileConfig valueConfig, globalConfig;

    public ConfigManager() {
        this.valueConfig = createConfig("values");
        this.globalConfig = createConfig("config");

        loadConfigs();
    }

    private void loadConfigs() {
        loadConfig(valueConfig);
        loadConfig(globalConfig);
    }

    private FileConfig createConfig(String configName) {
        return new FileConfig(configName);
    }

    private void loadConfig(FileConfig fileConfig) {
        fileConfig.load();
    }
}
