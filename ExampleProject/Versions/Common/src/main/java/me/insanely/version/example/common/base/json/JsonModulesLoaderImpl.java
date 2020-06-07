package me.insanely.version.example.common.base.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.insanely.version.example.common.base.MinecraftVersion;
import me.insanely.version.example.common.base.VersionModule;
import me.insanely.version.example.common.base.VersionProviderRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public class JsonModulesLoaderImpl implements JsonModulesLoader {

    @NotNull private final DefaultJsonModuleClassLoader defaultClassLoader = new DefaultJsonModuleClassLoader();

    @Override
    public void load(@NotNull VersionProviderRegistry registry, @NotNull MinecraftVersion version, @NotNull ObjectMapper objectMapper, @NotNull InputStream jsonInputStream)
            throws IllegalArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        JsonVersionModule[] modulesArray = objectMapper.readValue(jsonInputStream, JsonVersionModule[].class);
        for (JsonVersionModule jsonModule : modulesArray) {
            if (jsonModule.getVersion() == version) {
                if (jsonModule.getLoaderClassPath() == null) {
                    VersionModule versionModule = this.defaultClassLoader.loadFromClass(Class.forName(jsonModule.getClassPath()));
                    versionModule.configure(registry);
                } else {
                    if (Class.forName(jsonModule.getLoaderClassPath()) != JsonModuleClassLoader.class) {
                        throw new IllegalArgumentException(jsonModule.getLoaderClassPath() + " is not a class loader");
                    }
                    JsonModuleClassLoader classLoader = (JsonModuleClassLoader) Class.forName(jsonModule.getLoaderClassPath()).newInstance();
                    VersionModule versionModule = classLoader.loadFromClass(Class.forName(jsonModule.getClassPath()));
                    versionModule.configure(registry);
                }
            }
        }
    }
}