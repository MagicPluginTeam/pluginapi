package io.github.magicpluginteam.pluginapi.test;

import io.github.magicpluginteam.gui.Gui;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class GuiTestCode implements Listener {

    private final Plugin plugin;

    public GuiTestCode(Plugin plugin) {
        this.plugin = plugin;
    }

    public static void test(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(new GuiTestCode(plugin), plugin);
    }

    public static void testCodeUsage(Plugin plugin, Player player) {
        ItemStack apple = new ItemStack(Material.APPLE);
        Gui.frame(plugin, 6, "Hello")
                .slot(0, 0, apple, event -> event.getWhoClicked().sendMessage("Yo!"))
                .slot(0, 1, event -> event.getWhoClicked().sendMessage("Yeah!"))
                .openInventory(player);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
    }

}
