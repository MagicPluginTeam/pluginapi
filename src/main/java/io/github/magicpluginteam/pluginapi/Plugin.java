package io.github.magicpluginteam.pluginapi;

import io.github.magicpluginteam.lang.PlayerLangSupport;
import io.github.magicpluginteam.pluginapi.test.GuiTestCode;
import io.github.magicpluginteam.pluginapi.test.YamlTestCode;
import io.github.magicpluginteam.pluginapi.utils.ClassUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plugin extends JavaPlugin implements Listener {

    private boolean allowTask = false;
    private final ArrayList<Runnable> disableEvent = new ArrayList<>();

    public void addDisableEvent(Runnable runnable) {
        disableEvent.add(runnable);
    }
    private PlayerLangSupport lang;

    public PlayerLangSupport getLang() {
        return lang;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getScheduler().cancelTasks(this);
        HandlerList.unregisterAll((org.bukkit.plugin.Plugin) this);
        ClassUtils.loadJarFilesToFolder(this, false, Arrays.asList(".yml", ".schem"), List.of("plugin.yml"));
        Bukkit.getPluginManager().registerEvents(this, this);
        allowTask = true;
        GuiTestCode.test(this);
        lang = new PlayerLangSupport(this, "KR");
        new YamlTestCode(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        allowTask = false;
        disableEvent.forEach(Runnable::run);
    }

}
