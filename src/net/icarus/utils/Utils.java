package net.icarus.utils;


import net.icarus.api.API;
import net.icarus.types.TYPE;
import org.bukkit.Bukkit;

/**
 * Copyright © SquareCode 2018
 * created on: 22.11.2018 / 13:22
 * Project: Icarus
 */
public class Utils {

    private static Utils instance;

    public void setInstance() {
        instance = this;
    }

    public static Utils getInstance() {
        return instance;
    }

    public void cosoleMessage(TYPE type, Object message) {
        if (type.equals(TYPE.MESSAGE)) {
            System.out.println(API.getInstance().consolePrefix+message);
        } else if(type.equals(TYPE.BALKEN)) {
            System.out.println(API.getInstance().consolePrefix+"§8=========================( §6ICARUS §8)=========================");
        } else if(type.equals(TYPE.INFO)) {
            System.out.println(API.getInstance().consolePrefix+"§c"+message);
        } else if(type.equals(TYPE.ERROR)) {
            System.out.println(API.getInstance().errorPrefix+"§cAn error has occured: "+message);
        } else if(type.equals(TYPE.NULL)) {
            System.out.println(API.getInstance().consolePrefix);
        } else if(type.equals(TYPE.DEBUG)) {
            System.out.println(API.getInstance().debugPrefix+"§6&lDEBUG");
        }
    }

    private boolean ProtocolLIBStatus() {
        return Bukkit.getPluginManager().getPlugin("ProtocolLib") != null;
    }

    public void checkProtocolLib() {
        if(ProtocolLIBStatus()) {
            System.out.println(API.getInstance().consolePrefix+"§7Found ProtocolLib!");
        } else {
            System.out.println(API.getInstance().errorPrefix+"§cWARN §7ProtocolLib was not found!");
        }
    }
}
