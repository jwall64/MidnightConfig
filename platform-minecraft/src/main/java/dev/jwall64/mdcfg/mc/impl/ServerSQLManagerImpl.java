package dev.jwall64.mdcfg.mc.impl;

import net.minecraft.server.MinecraftServer;
import dev.jwall64.mdcfg.sql.PresetRegistry;

public class ServerSQLManagerImpl {

    public static PresetRegistry getPresetRegistry(MinecraftServer server) {
        return ((ServerExtension) server).getPresetRegistry();
    }

}
