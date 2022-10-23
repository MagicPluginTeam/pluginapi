package io.github.magicpluginteam.pluginapi.test;

import io.github.magicpluginteam.pluginapi.Plugin;
import io.github.magicpluginteam.pluginapi.yaml.Yaml;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class YamlTestCode extends TestCodeBase {
    public YamlTestCode(Plugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onJoin(PlayerChatEvent event) {
        Player player = event.getPlayer();
        long before = System.currentTimeMillis();
        Yaml yaml = new Yaml(new File(plugin.getDataFolder(), "config.yml"));
        long after = System.currentTimeMillis();

        System.out.println(yaml.getIntValue());
        ItemStack item = yaml.getItem();
        player.getInventory().addItem(item);
    }
}
