package me.insanely.version.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.insanely.version.example.common.ActionBarMessager;
import me.insanely.version.example.common.base.MinecraftVersion;
import me.insanely.version.example.common.base.VersionProviderRegistry;
import me.insanely.version.example.common.base.json.JsonModulesLoader;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;

public class ExamplePlugin extends JavaPlugin implements Listener {

    private ActionBarMessager actionBarMessager;

    @Override
    public void onEnable() {
        VersionProviderRegistry versionProviderRegistry = VersionProviderRegistry.createRegistry();
        JsonModulesLoader jsonModulesLoader = JsonModulesLoader.createJsonModulesLoader();
        MinecraftVersion currentVersion = MinecraftVersion.valueOf(getServer().getClass().getPackage().getName().substring(
                (getServer().getClass().getPackage().getName().lastIndexOf('.') + 1)
        ));

        InputStream modulesJsonStream = getClass().getClassLoader().getResourceAsStream("modules.json");
        try {
            jsonModulesLoader.load(versionProviderRegistry, currentVersion, new ObjectMapper(), modulesJsonStream);
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.actionBarMessager = versionProviderRegistry.getVersionProvider(ActionBarMessager.class).getImplementation(currentVersion);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        this.actionBarMessager.sendActionBar(event.getPlayer(), "Example Message");
    }
}