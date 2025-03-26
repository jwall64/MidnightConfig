package dev.jwall64.mdcfg.mc.impl;

import dev.jwall64.mdcfg.sql.PresetRegistry;

import java.nio.file.Path;

public interface ServerExtension {

    Path getConfigFolder();

    PresetRegistry getPresetRegistry();

    void setPresetRegistry(PresetRegistry presetRegistry);

}
