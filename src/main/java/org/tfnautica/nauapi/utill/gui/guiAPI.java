package org.tfnautica.nauapi.utill.gui;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;

import java.util.HashMap;

public class guiAPI implements Listener {

    public static JavaPlugin plugin = NauAPI.instance;
    private final HashMap<Location, Inventory> blockInventories = new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Location location = event.getBlock().getLocation();
        Inventory inventory = plugin.getServer().createInventory(null, 27, "Инвентарь блока");
        blockInventories.put(location, inventory);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Location location = event.getBlock().getLocation();
        Inventory inventory = blockInventories.remove(location);
        if (inventory != null) {
            // Выпадение предметов из инвентаря
            for (var item : inventory.getContents()) {
                if (item != null) {
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), item);
                }
            }
        }
    }
}
