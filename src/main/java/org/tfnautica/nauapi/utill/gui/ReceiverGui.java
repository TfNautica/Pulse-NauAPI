package org.tfnautica.nauapi.utill.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;

public class ReceiverGui implements InventoryHolder {
    public static JavaPlugin plugin = NauAPI.instance;

    private final Inventory inventory;

    public ReceiverGui() {
        this.inventory = plugin.getServer().createInventory(this, 9);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
