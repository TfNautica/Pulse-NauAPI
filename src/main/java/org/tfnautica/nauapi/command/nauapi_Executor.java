package org.tfnautica.nauapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.tfnautica.nauapi.NauAPI;

import static org.tfnautica.nauapi.utill.message.*;

public class nauapi_Executor implements CommandExecutor {

    public static JavaPlugin plugin = NauAPI.instance;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if(args.length == 1) {
            String arg = args[0];
            if( arg.equalsIgnoreCase("reload") ) {
                if(sender.hasPermission("nauapi.commands.reload")) {
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    sender.sendMessage(done_message("Конфигурация плагина успешно перезагружена"));
                } else {
                    sender.sendMessage(error_message("У вас недостаточно прав!"));
                }
            } else if (arg.equalsIgnoreCase("help")) {
                if(sender.hasPermission("nauapi.commands.help")) {
                    sender.sendMessage(done_message("Выполнена команда /nauapi help"));
                } else {
                    sender.sendMessage(error_message("У вас недостаточно прав!"));
                }
            } else {
                sender.sendMessage(error_message("Неизвестные аргументы команды!"));

            }
        } else {
            sender.sendMessage(error_message("Вы не указали аргументы команды!"));
            sender.sendMessage(warn_message("Используйте: /nauapi <help | reload>"));
        }

//        player.getInventory().addItem(Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "base"));
//        player.getInventory().addItem(Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "advanced"));
//        player.getInventory().addItem(Battery.get_battery_item(Material.MINER_POTTERY_SHERD, "ultimate"));

        return true;
    }
}
