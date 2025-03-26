package dev.jwall64.mdcfg.mc.api;

import net.minecraft.server.MinecraftServer;
import dev.jwall64.mdcfg.mc.impl.ServerSQLManagerImpl;
import dev.jwall64.mdcfg.sql.PresetRegistry;

public interface ServerSQLManager {

    static PresetRegistry getPresetRegistry(MinecraftServer server) {
        return ServerSQLManagerImpl.getPresetRegistry(server);
    }

}
