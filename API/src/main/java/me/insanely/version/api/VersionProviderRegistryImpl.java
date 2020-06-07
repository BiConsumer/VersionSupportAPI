package me.insanely.version.api;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VersionProviderRegistryImpl implements VersionProviderRegistry {

    @NotNull private Map<Class<?>, VersionProvider<?>> versionProviders;

    VersionProviderRegistryImpl() {
        this.versionProviders = new HashMap<>();
    }

    @Override
    public <T> void registerVersionProvider(Class<T> apiInterface, @NotNull MinecraftVersion version, T implementation) {
        this.versionProviders.computeIfAbsent(apiInterface, k -> new VersionProviderImpl<>(apiInterface));
        this.getVersionProvider(apiInterface).registerVersion(version, implementation);
    }

    @Override
    public <T> boolean hasRegisteredVersionProvider(@NotNull Class<T> apiInterface) {
        return this.versionProviders.containsKey(apiInterface);
    }

    @Override
    public @NotNull <T> VersionProvider<T> getVersionProvider(Class<T> apiInterface) throws IllegalArgumentException {
        if (this.versionProviders.get(apiInterface) == null) {
            throw new IllegalArgumentException("Api interface " + apiInterface.getName() + " is not registered");
        }
        return (VersionProvider<T>) this.versionProviders.get(apiInterface);
    }
}