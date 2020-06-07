package me.insanely.version.example.common.base;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface VersionProvider<T> {

    @NotNull Class<T> getApiInterface();

    @NotNull Map<MinecraftVersion, T> getImplementations();

    @NotNull T getImplementation(@NotNull MinecraftVersion minecraftVersion) throws IllegalArgumentException;

    void registerVersion(@NotNull MinecraftVersion minecraftVersion, @NotNull T implementation);

    boolean hasRegisteredVersion(@NotNull MinecraftVersion minecraftVersion);

}