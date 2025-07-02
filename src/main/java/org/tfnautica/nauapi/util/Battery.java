package org.tfnautica.nauapi.util;

import com.nexomc.nexo.api.NexoItems;
import com.nexomc.nexo.items.ItemTemplate;
import com.nexomc.nexo.items.NexoMeta;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;

import java.util.List;


public class Battery {
    public static JavaPlugin plugin = NauAPI.instance;
    public static final NamespacedKey energyKey = new NamespacedKey(plugin, "batteryEnergy");
    public static final NamespacedKey maxEnergyKey = new NamespacedKey(plugin, "maxEnergy");
    public static final NamespacedKey maxEnergyOutputKey = new NamespacedKey(plugin, "maxOutputEnergy");
    public static final NamespacedKey typeKey = new NamespacedKey(plugin, "batteryType");
    public static final NamespacedKey energyTypeKey = new NamespacedKey(plugin, "energyType");

    class base_battery {
        public static String type = "base";
        public static int max_energy = 100;
        public static int max_output = 15;
        public static String type_name = "базовый";

    }
    class advanced_battery {
        public static String type = "advanced";
        public static int max_energy = 500;
        public static int max_output = 100;
        public static String type_name = "улучшенный";

    }
    class ultimate_battery {
        public static String type = "ultimate";
        public static int max_energy = 1000;
        public static int max_output = 250;
        public static String type_name = "ультимейт";

    }

    public static ItemStack get_battery_item(Material material, String type) {
        // ItemStack accumulator = new ItemStack(material);
        ItemStack accumulator = NexoItems.itemFromId("t").build();

        ItemMeta meta = accumulator.getItemMeta();


        if(type.equalsIgnoreCase("base")) {
            int max_energy = base_battery.max_energy;
            int max_output = base_battery.max_output;


            meta.setDisplayName("§7Аккумулятор");

            meta.setLore(List.of(getEnergyLore(type, max_energy, max_energy), getTypeLore(type)));
            meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyOutputKey, PersistentDataType.INTEGER, max_output);
            meta.getPersistentDataContainer().set(typeKey, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(energyTypeKey, PersistentDataType.STRING, "FE");

            accumulator.setItemMeta(meta);
        } else if(type.equalsIgnoreCase("advanced")) {
            int max_energy = advanced_battery.max_energy;
            int max_output = advanced_battery.max_output;


            meta.setDisplayName("§eАккумулятор");

            meta.setLore(List.of(getEnergyLore(type, max_energy, max_energy), getTypeLore(type)));
            meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyOutputKey, PersistentDataType.INTEGER, max_output);
            meta.getPersistentDataContainer().set(typeKey, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(energyTypeKey, PersistentDataType.STRING, "FE");

            accumulator.setItemMeta(meta);
        } else if(type.equalsIgnoreCase("ultimate")) {
            int max_energy = ultimate_battery.max_energy;
            int max_output = ultimate_battery.max_output;


            meta.setDisplayName("§dАккумулятор");

            meta.setLore(List.of(getEnergyLore(type, max_energy, max_energy), getTypeLore(type)));
            meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyOutputKey, PersistentDataType.INTEGER, max_output);
            meta.getPersistentDataContainer().set(typeKey, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(energyTypeKey, PersistentDataType.STRING, "FE");

            accumulator.setItemMeta(meta);
        }

        return accumulator;
    }

    public static int getBatteryEnergy(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        int type = meta.getPersistentDataContainer().get(energyKey, PersistentDataType.INTEGER);
        return type;
    }

    public static void setBatteryEnergy(ItemStack item, int energy) {

        int max_energy = 0;
        ItemMeta meta = item.getItemMeta();
        String type = getBatteryType(item);

        if (type.equalsIgnoreCase("base")) {
            max_energy = base_battery.max_energy;
        } else if (type.equalsIgnoreCase("advanced")) {
            max_energy = advanced_battery.max_energy;
        } else if (type.equalsIgnoreCase("ultimate")) {
            max_energy = ultimate_battery.max_energy;
        }


        meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, energy);
        meta.setLore(List.of(getEnergyLore(type, energy, max_energy), getTypeLore(type)));

        item.setItemMeta(meta);
    }


    public static int getBatteryMaxEnergy(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        int type = meta.getPersistentDataContainer().get(maxEnergyKey, PersistentDataType.INTEGER);
        return type;
    }

    public static int getBatteryMaxOutputEnergy(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        int type = meta.getPersistentDataContainer().get(maxEnergyOutputKey, PersistentDataType.INTEGER);
        return type;
    }

    public static String getBatteryType(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        String type = meta.getPersistentDataContainer().get(typeKey, PersistentDataType.STRING);
        return type;
    }

    public static String getEnergyLore(String type, int energy, int max_energy) {
        if (type.equalsIgnoreCase("base")) {
            return "§7Заряд: " + energy + " / " + base_battery.max_energy;
        } else if (type.equalsIgnoreCase("advanced")) {
            return "§eЗаряд: " + energy + " / " + advanced_battery.max_energy;
        } else if (type.equalsIgnoreCase("ultimate")) {
            return "§dЗаряд: " + energy + " / " + ultimate_battery.max_energy;
        }
        return "";
    }
    public static String getTypeLore(String type) {

        if (type.equalsIgnoreCase("base")) {
            return "§7Тип: " + base_battery.type_name;
        } else if (type.equalsIgnoreCase("advanced")) {
            return "§eТип: " + advanced_battery.type_name;
        } else if (type.equalsIgnoreCase("ultimate")) {
            return "§dТип: " + ultimate_battery.type_name;
        }
        return "";
    }



}
