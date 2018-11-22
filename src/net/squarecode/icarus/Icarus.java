package net.squarecode.icarus;

import net.squarecode.icarus.logger.IcarusLogger;
import net.squarecode.icarus.manager.ConfigManager;
import net.squarecode.icarus.manager.ModuleManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright © SquareCode 2018
 * created on: 22.11.2018 / 13:17
 * Project: Icarus
 */
public class Icarus extends JavaPlugin {

    private static Icarus instance;

    public static Icarus getInstance() {
        return instance;
    }

    private IcarusLogger icarusLogger;
    private ConfigManager configManager;
    private ModuleManager moduleManager;

    public void onEnable() {
        Icarus.instance = this;

        this.icarusLogger = new IcarusLogger();
        this.configManager = new ConfigManager();
        this.moduleManager = new ModuleManager();

        if (!this.isProtocolLibInstalled()) {
            this.icarusLogger.warning("ProtocolLib is not installed.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

    }

    private boolean isProtocolLibInstalled() {
        return Bukkit.getPluginManager().getPlugin("ProtocolLib") != null && Bukkit.getPluginManager().getPlugin("ProtocolLib").isEnabled();
    }

    public IcarusLogger getIcarusLogger() {
        return icarusLogger;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
