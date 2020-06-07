package me.insanely.version.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.insanely.version.api.MinecraftVersion;
import me.insanely.version.api.VersionProviderRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public interface JsonModulesLoader {

    void load(@NotNull VersionProviderRegistry registry, @NotNull MinecraftVersion version, @NotNull ObjectMapper objectMapper, @NotNull InputStream jsonInputStream)
            throws IllegalArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    @NotNull static JsonModulesLoader creatJsonModulesLoader() {
        return new JsonModulesLoaderImpl();
    }

}