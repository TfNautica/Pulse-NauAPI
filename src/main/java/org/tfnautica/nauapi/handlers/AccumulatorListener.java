package org.tfnautica.nauapi.handlers;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;
import org.tfnautica.nauapi.utill.Battery;

public class AccumulatorListener implements Listener {
    public static JavaPlugin plugin = NauAPI.instance;

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().toString().contains("RIGHT_CLICK")) {
            ItemStack item = event.getItem();
            if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(Battery.energyKey, PersistentDataType.INTEGER)) {
                int energy = Battery.getBatteryEnergy(item);

                if (energy > 0) {
                    energy--;
                    Battery.setBatteryEnergy(item, energy);
                } else {
                    event.getPlayer().sendMessage("§cАккумулятор пуст!");
                }
            }
        }
    }
}
