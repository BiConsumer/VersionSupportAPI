package me.insanely.version.example;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface ActionBarMessager {

    void sendActionBar(@NotNull Player player, @NotNull String message);

}