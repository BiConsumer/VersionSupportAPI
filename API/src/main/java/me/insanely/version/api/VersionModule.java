package me.insanely.version.api;

import org.jetbrains.annotations.NotNull;

public interface VersionModule {

    void configure(@NotNull VersionProviderRegistry registry);

}