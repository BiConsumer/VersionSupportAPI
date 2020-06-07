package me.insanely.version.example.v1_8_R3;

import me.insanely.version.example.common.ActionBarMessager;
import me.insanely.version.example.common.base.MinecraftVersion;
import me.insanely.version.example.common.base.VersionModule;
import me.insanely.version.example.common.base.VersionProviderRegistry;
import org.jetbrains.annotations.NotNull;

public class Module_v1_8_R3 implements VersionModule {

    @Override
    public void configure(@NotNull VersionProviderRegistry registry) {
        registry.registerVersionProvider(ActionBarMessager.class, MinecraftVersion.v1_8_R3, new ActionBarMessager_v1_8_R3());
    }
}