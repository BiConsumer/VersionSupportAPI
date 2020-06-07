package me.insanely.version.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface VersionProvider<T> {

    @NotNull Class<T> getApiInterface();

    @NotNull Map<MinecraftVersion, T> getImplementations();

    @NotNull T getImplementation(@NotNull MinecraftVersion minecraftVersion) throws IllegalArgumentException;

    void registerVersion(@NotNull MinecraftVersion minecraftVersion, T implementation);

    boolean hasRegisteredVersion(@NotNull MinecraftVersion minecraftVersion);

}