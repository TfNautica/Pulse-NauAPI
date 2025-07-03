package org.tfnautica.nauapi.handlers;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;

public class ControlPanelListener implements Listener {
    public static JavaPlugin plugin = NauAPI.instance;
    public static final NamespacedKey receiverIdKey = new NamespacedKey(plugin, "receiver_id");

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().toString().contains("RIGHT_CLICK")) {
            ItemStack item = event.getItem();
            if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(receiverIdKey, PersistentDataType.STRING)) {
            }
        }
    }
}
