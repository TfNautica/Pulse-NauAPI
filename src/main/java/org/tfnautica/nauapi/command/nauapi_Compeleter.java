package org.tfnautica.nauapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tfnautica.nauapi.NauAPI;

import java.util.List;

public class nauapi_Compeleter implements TabCompleter {

    public static JavaPlugin plugin = NauAPI.instance;
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if(args.length == 1) {
            return List.of("reload", "help");
        }
        return null;
    }
}
