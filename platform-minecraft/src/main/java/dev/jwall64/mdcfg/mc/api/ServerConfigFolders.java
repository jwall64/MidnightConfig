package dev.jwall64.mdcfg.mc.api;

import net.minecraft.server.MinecraftServer;
import dev.jwall64.mdcfg.codec.FileCodecRegistry;
import dev.jwall64.mdcfg.mc.impl.ServerConfigFoldersImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public interface ServerConfigFolders {

    FileCodecRegistry FILE_CODEC_REGISTRY = new FileCodecRegistry();

    static Path getConfigFolder(MinecraftServer server) {
        return ServerConfigFoldersImpl.getConfigFolder(server);
    }

    static Optional<Path> createConfigFolder(MinecraftServer server, String modName) {
        Path toCreate = ServerConfigFoldersImpl.getConfigFolder(server).resolve(modName);
        try { Files.createDirectories(toCreate.getParent()); } catch (IOException ex) {
            return Optional.empty();
        }
        return Optional.of(toCreate);
    }

    static Path getGlobalConfigFolder() {
        return ServerConfigFoldersImpl.getGlobalConfigFolder();
    }

}
