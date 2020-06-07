package me.insanely.version.api.json;

import me.insanely.version.api.VersionModule;
import org.jetbrains.annotations.NotNull;

public class DefaultJsonModuleClassLoader implements JsonModuleClassLoader {

    @Override
    public @NotNull VersionModule loadFromClass(@NotNull Class<?> clazz) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
        if (!VersionModule.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(clazz.getName() + " is not a module");
        }
        return (VersionModule) clazz.newInstance();
    }
}