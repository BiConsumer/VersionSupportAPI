package me.insanely.version.example.common.base;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface VersionProviderRegistry {

    @NotNull Map<Class<?>, VersionProvider<?>> getVersionProviders();

    <T> void registerVersionProvider(@NotNull Class<T> apiInterface, @NotNull MinecraftVersion version, @NotNull T implementation);

    <T> boolean hasRegisteredVersionProvider(@NotNull Class<T> apiInterface);

    @NotNull <T> VersionProvider<T> getVersionProvider(@NotNull Class<T> apiInterface) throws IllegalArgumentException;

    default void installModule(@NotNull VersionModule module) {
        module.configure(this);
    }

    @NotNull static VersionProviderRegistry createRegistry() {
        return new VersionProviderRegistryImpl();
    }
}