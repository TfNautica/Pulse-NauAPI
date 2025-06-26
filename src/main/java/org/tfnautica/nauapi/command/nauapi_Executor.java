package org.tfnautica.nauapi.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.tfnautica.nauapi.NauAPI;
import org.tfnautica.nauapi.util.Battery;

public class nauapi_Executor implements CommandExecutor {

    public static JavaPlugin plugin = NauAPI.instance;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        player.getInventory().addItem(Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "base"));
        player.getInventory().addItem(Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "advanced"));
        player.getInventory().addItem(Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "ultimate"));
        return true;
    }
}
