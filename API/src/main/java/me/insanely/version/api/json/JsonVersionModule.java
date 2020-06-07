package me.insanely.version.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import me.insanely.version.api.MinecraftVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;

@Getter
public class JsonVersionModule {

    @NotNull private MinecraftVersion version;

    @JsonProperty("class_path")
    @NotNull private String classPath;

    @JsonProperty("loader_class_path")
    @Nullable private String loaderClassPath;

    @ConstructorProperties({"version", "class_path", "loader_class_path"})
    public JsonVersionModule(@NotNull MinecraftVersion version, @NotNull String classPath, @Nullable String loaderClassPath) {
        this.version = version;
        this.classPath = classPath;
        this.loaderClassPath = loaderClassPath;
    }
}