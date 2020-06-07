package me.insanely.version.example.common.base.json;

import me.insanely.version.example.common.base.VersionModule;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;

public interface JsonModuleClassLoader {

    @NotNull VersionModule loadFromClass(@NotNull Class<?> clazz) throws IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;

}