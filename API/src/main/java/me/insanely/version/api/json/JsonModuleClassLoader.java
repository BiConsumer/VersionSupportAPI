package me.insanely.version.api.json;

import me.insanely.version.api.VersionModule;
import org.jetbrains.annotations.NotNull;

public interface JsonModuleClassLoader {

    @NotNull VersionModule loadFromClass(@NotNull Class<?> clazz) throws IllegalArgumentException, IllegalAccessException, InstantiationException;

}