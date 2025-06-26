package org.tfnautica.nauapi;

import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.command.nauapi_Compeleter;
import org.tfnautica.nauapi.command.nauapi_Executor;
import org.tfnautica.nauapi.handlers.AccumulatorListener;
import org.tfnautica.nauapi.util.recipes;

public final class NauAPI extends JavaPlugin {

    public static JavaPlugin instance;
    @Override
    public void onEnable() {
        //saveDefaultConfig();
        instance = this;
        //getCommand("nauapi").setExecutor(new nauapi_Executor());
        //getCommand("nauapi").setTabCompleter(new nauapi_Compeleter());
        //getServer().getPluginManager().registerEvents(new AccumulatorListener(), this);

        getServer().addRecipe(recipes.base_battery());
        getServer().addRecipe(recipes.advanced_battery());
        getServer().addRecipe(recipes.ultimate_battery());

    }

    @Override
    public void onDisable() {

    }
}
