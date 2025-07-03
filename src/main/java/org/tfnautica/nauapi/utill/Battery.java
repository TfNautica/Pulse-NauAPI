package org.tfnautica.nauapi.utill;

// import com.nexomc.nexo.api.NexoItems;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
    public static final NamespacedKey temperatureKey = new NamespacedKey(plugin, "temperature");
    public static final NamespacedKey statusKey = new NamespacedKey(plugin, "status");

    static class base_battery {
        public static String type = "base";
        public static int max_energy = 100;
        public static int max_output = 15;
        public static String type_name = "базовый";

    }
    static class advanced_battery {
        public static String type = "advanced";
        public static int max_energy = 500;
        public static int max_output = 100;
        public static String type_name = "улучшенный";

    }
    static class ultimate_battery {
        public static String type = "ultimate";
        public static int max_energy = 1000;
        public static int max_output = 250;
        public static String type_name = "ультимейт";

    }

    public static ItemStack get_battery_item(Material material, String type) {
        ItemStack accumulator = new ItemStack(material);
        //ItemStack accumulator = NexoItems.itemFromId("t").build();

        ItemMeta meta = accumulator.getItemMeta();
        meta.setMaxStackSize(1);

        if(type.equalsIgnoreCase("base")) {
            int max_energy = base_battery.max_energy;
            int max_output = base_battery.max_output;


            meta.setDisplayName("§7Аккумулятор");


            meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyOutputKey, PersistentDataType.INTEGER, max_output);
            meta.getPersistentDataContainer().set(typeKey, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(energyTypeKey, PersistentDataType.STRING, "FE");
            meta.getPersistentDataContainer().set(temperatureKey, PersistentDataType.INTEGER, 28);
            meta.getPersistentDataContainer().set(statusKey, PersistentDataType.STRING, "Active");
            accumulator.setItemMeta(meta);
            updateLore(accumulator);
        } else if(type.equalsIgnoreCase("advanced")) {
            int max_energy = advanced_battery.max_energy;
            int max_output = advanced_battery.max_output;


            meta.setDisplayName("§eАккумулятор");


            meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyOutputKey, PersistentDataType.INTEGER, max_output);
            meta.getPersistentDataContainer().set(typeKey, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(energyTypeKey, PersistentDataType.STRING, "FE");
            meta.getPersistentDataContainer().set(temperatureKey, PersistentDataType.INTEGER, 28);
            meta.getPersistentDataContainer().set(statusKey, PersistentDataType.STRING, "Active");

            accumulator.setItemMeta(meta);
            updateLore(accumulator);
        } else if(type.equalsIgnoreCase("ultimate")) {
            int max_energy = ultimate_battery.max_energy;
            int max_output = ultimate_battery.max_output;


            meta.setDisplayName("§dАккумулятор");
            meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyKey, PersistentDataType.INTEGER, max_energy);
            meta.getPersistentDataContainer().set(maxEnergyOutputKey, PersistentDataType.INTEGER, max_output);
            meta.getPersistentDataContainer().set(typeKey, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(energyTypeKey, PersistentDataType.STRING, "FE");
            meta.getPersistentDataContainer().set(temperatureKey, PersistentDataType.INTEGER, 28);
            meta.getPersistentDataContainer().set(statusKey, PersistentDataType.STRING, "Active");

            accumulator.setItemMeta(meta);
            updateLore(accumulator);
        }

        return accumulator;
    }

    public static Integer getTemperature(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().get(temperatureKey, PersistentDataType.INTEGER);
    }

    public static void setTemperature(ItemStack item, int temp) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(temperatureKey, PersistentDataType.INTEGER, temp);
        item.setItemMeta(meta);
        updateLore(item);
    }

    public static String getStatus(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().get(statusKey, PersistentDataType.STRING);
    }

    public static void setStatus(ItemStack item, String status) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(statusKey, PersistentDataType.STRING, status);
        item.setItemMeta(meta);
        updateLore(item);
    }

    public static Integer getBatteryEnergy(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().get(energyKey, PersistentDataType.INTEGER);
    }

    public static void setBatteryEnergy(ItemStack item, int energy) {

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, energy);
        item.setItemMeta(meta);
        updateLore(item);
    }

    public static void updateLore(ItemStack item) {

        ItemMeta meta = item.getItemMeta();

        String type = getBatteryType(item);
        String status = getStatus(item);
        Integer temp = getTemperature(item);
        Integer energy = getBatteryEnergy(item);
        Integer maxEnergy = getBatteryMaxEnergy(item);



        meta.getPersistentDataContainer().set(energyKey, PersistentDataType.INTEGER, energy);
        meta.setLore(List.of(
                getEnergyLore(type, energy, maxEnergy),
                getTypeLore(type),
                gettemperatureLore(type, temp),
                getStatusLore(type, status)
        ));
    }


    public static Integer getBatteryMaxEnergy(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().get(maxEnergyKey, PersistentDataType.INTEGER);
    }

    public static Integer getBatteryMaxOutputEnergy(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().get(maxEnergyOutputKey, PersistentDataType.INTEGER);
    }

    public static String getBatteryType(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().get(typeKey, PersistentDataType.STRING);
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

    public static String getStatusLore(String type, String status) {

        if (type.equalsIgnoreCase("base")) {
            return "§7Статус: " + status;
        } else if (type.equalsIgnoreCase("advanced")) {
            return "§eСтатус: " + status;
        } else if (type.equalsIgnoreCase("ultimate")) {
            return "§dСтатус: " + status;
        }
        return "";
    }

    public static String gettemperatureLore(String type, Integer temperature) {

        if (type.equalsIgnoreCase("base")) {
            return "§7Температура: " + temperature;
        } else if (type.equalsIgnoreCase("advanced")) {
            return "§eТемпература: " + temperature;
        } else if (type.equalsIgnoreCase("ultimate")) {
            return "§dТемпература: " + temperature;
        }
        return "";
    }


}
