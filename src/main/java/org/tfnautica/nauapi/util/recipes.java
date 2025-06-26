package org.tfnautica.nauapi.util;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;

public class recipes {

    public static JavaPlugin plugin = NauAPI.instance;
    public static ShapedRecipe base_battery() {

        NamespacedKey key = new NamespacedKey(plugin, "BaseBattery");

        ItemStack item = Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "base");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" A ", "BCB", "BCB");

        recipe.setIngredient('A', Material.COPPER_INGOT);
        recipe.setIngredient('B', Material.IRON_INGOT);
        recipe.setIngredient('C', Material.REDSTONE);

        return recipe;
    }
    public static ShapedRecipe advanced_battery() {

        NamespacedKey key = new NamespacedKey(plugin, "AdvancedBattery");

        ItemStack item = Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "advanced");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("ABA", "CAC", "ABA");

        recipe.setIngredient('A', Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "base"));
        recipe.setIngredient('B', Material.COPPER_INGOT);
        recipe.setIngredient('C', Material.REDSTONE);

        return recipe;
    }
    public static ShapedRecipe ultimate_battery() {

        NamespacedKey key = new NamespacedKey(plugin, "UltimateBattery");

        ItemStack item = Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "ultimate");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("ABA", "CAC", "ABA");

        recipe.setIngredient('C', Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "advanced"));
        recipe.setIngredient('B', Material.REDSTONE_BLOCK);
        recipe.setIngredient('A', Material.COPPER_INGOT);

        return recipe;
    }

}
