package io.github.magicpluginteam.pluginapi.utils;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class ClassUtils {

    public static List<String> getJarFiles(Class<?> clazz) {
        try {
            var file = new File(clazz.getProtectionDomain().getCodeSource().getLocation().toURI());
            return new JarFile(file).stream().filter(ZipEntry::isDirectory).map(JarEntry::getRealName).toList();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new AssertionError("Error occurred while get jar files");
        }
    }

    public static void loadJarFilesToFolder(JavaPlugin plugin, boolean force, List<String> include, List<String> exclude) {
        File[] files = plugin.getDataFolder().listFiles();
        if (files == null || files.length == 0) {
            getJarFiles(plugin.getClass()).stream()
                    .filter(it -> include.stream().filter(it::endsWith).findFirst().orElse(null) != null && !exclude.contains(it))
                    .filter(it -> force || !new File(plugin.getDataFolder(), it).exists())
                    .forEach(it -> plugin.saveResource(it, false));
        }
    }

}
