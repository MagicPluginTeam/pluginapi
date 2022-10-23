package io.github.magicpluginteam.pluginapi.test;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class TestCodeBase implements Listener {

    protected final Plugin plugin;

    public TestCodeBase(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

}
