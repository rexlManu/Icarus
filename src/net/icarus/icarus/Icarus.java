package net.icarus.icarus;

import net.icarus.api.API;
import net.icarus.manager.ConfigManager;
import net.icarus.manager.ModuleManager;
import net.icarus.types.TYPE;
import net.icarus.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright © SquareCode 2018
 * created on: 22.11.2018 / 13:17
 * Project: Icarus
 */
public class Icarus extends JavaPlugin {

    private static Icarus instance;

    public void onEnable() {
        new API().setInstance();
        new Utils().setInstance();
        new ConfigManager().setInstance();
        new ModuleManager().setInstance();

        try {
            API.getInstance().onStart();
        } catch (Exception error) {
            Utils.getInstance().cosoleMessage(TYPE.ERROR, error.getMessage());
        }
    }

    public static Icarus getInstance() {
        return instance;
    }
}
