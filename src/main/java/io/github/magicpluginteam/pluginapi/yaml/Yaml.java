package io.github.magicpluginteam.pluginapi.yaml;

import io.github.magicpluginteam.serialize.field.YamlField;
import io.github.magicpluginteam.serialize.field.YamlFieldInjector;
import io.github.magicpluginteam.serialize.serialize.SerializableInteger;
import io.github.magicpluginteam.serialize.serialize.SerializableItemStack;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class Yaml {

    @YamlField(serializable = SerializableItemStack.class)
    private ItemStack item;

    @YamlField(serializable = SerializableInteger.class)
    private int intValue;

    public ItemStack getItem() {
        return item;
    }

    public int getIntValue() {
        return intValue;
    }

    public Yaml(File file) {
        YamlFieldInjector.inject(this, file);
    }

}
