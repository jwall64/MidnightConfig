package dev.jwall64.mdcfg.mc.api;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import dev.jwall64.mdcfg.ConfigObject;
import dev.jwall64.mdcfg.serializer.ConfigContext;
import dev.jwall64.mdcfg.serializer.DelegatedContext;
import dev.jwall64.mdcfg.serializer.SerializeContext;

/**
 * A SerializeContext which contains information about Minecraft registries
 * @param <T> The type of context
 */
public class RegistryContext<T> extends DelegatedContext<T, RegistryAccess> {

    public RegistryContext(SerializeContext<T> delegate, RegistryAccess value) {
        super(delegate, value);
    }

    public static RegistryContext<ConfigObject> forServer(MinecraftServer server) {
        return new RegistryContext<>(ConfigContext.INSTANCE, server.registryAccess());
    }

}
