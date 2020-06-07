package me.insanely.version.example.common.base;

import org.jetbrains.annotations.NotNull;

public interface VersionModule {

    void configure(@NotNull VersionProviderRegistry registry);

}