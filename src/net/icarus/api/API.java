package net.icarus.api;

import net.icarus.manager.ConfigManager;
import net.icarus.manager.ModuleManager;
import net.icarus.types.TYPE;
import net.icarus.utils.Utils;

/**
 * Copyright © SquareCode 2018
 * created on: 22.11.2018 / 13:18
 * Project: Icarus
 */
public class API {

    private static API instance;

    public void setInstance() {
        instance = this;
    }

    public String consolePrefix = "§8| §6INFO §8|  ";
    public String errorPrefix = "§8| §6ERROR §8|  ";
    public String debugPrefix = "§8| §6DEBUG §8|  ";
    public String enablePrefix = "§8| §6ENABLE §8|  ";
    public String disablePrefix = "§8| §6DISABLE §8|  ";

    public static API getInstance() {
        return instance;
    }

    public void onStart() {
        Utils.getInstance().cosoleMessage(TYPE.BALKEN, "");
        Utils.getInstance().cosoleMessage(TYPE.NULL, "");
        Utils.getInstance().cosoleMessage(TYPE.MESSAGE, "§7Trying to load Icarus...");
        ConfigManager.getInstance().configFile();
        ConfigManager.getInstance().valuesFile();
        ModuleManager.instance.loadModules();
        Utils.getInstance().checkProtocolLib();
    }
}
