package me.insanely.version.example.v1_8_R3;

import me.insanely.version.api.MinecraftVersion;
import me.insanely.version.api.VersionModule;
import me.insanely.version.api.VersionProviderRegistry;
import me.insanely.version.example.ActionBarMessager;

public class Module_v1_8_R3 implements VersionModule {

    @Override
    public void configure(VersionProviderRegistry registry) {
        registry.registerVersionProvider(ActionBarMessager.class, MinecraftVersion.v1_8_R3, new ActionBarMessager_v1_8_R3());
    }
}