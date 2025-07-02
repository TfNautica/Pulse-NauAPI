package org.tfnautica.nauapi.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;
import org.tfnautica.nauapi.util.Point;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    public static JavaPlugin plugin = NauAPI.instance;
    private final String config_path = "/plugins/NauAPI/points.yml";
    private static final String points_path = "points";



    public static List<Point> getPointsByPlayer(String player) {

        List<Point> points = new ArrayList<>();

        for(String id : plugin.getConfig().getConfigurationSection("points").getKeys(false)) {

            World world = plugin.getServer().getWorld(plugin.getConfig().getString(String.join(".", "points", id, "world")));
            int x = plugin.getConfig().getInt(String.join(".", "points", id, "X"));
            int y = plugin.getConfig().getInt(String.join(".", "points", id, "Y"));
            int z = plugin.getConfig().getInt(String.join(".", "points", id, "Z"));
            boolean is_activated = plugin.getConfig().getBoolean(String.join(".", "points", id, "is_activated"));
            String owner = plugin.getConfig().getString(String.join(".", "points", id, "owner"));
            if(owner.equals(player)) {
                Point point = new Point(id, new Location(world, x, y, z), owner, is_activated);
                points.add(point);
            }
        }

        return points;
    }

    public static Point getPointByID(String id) {
        World world = plugin.getServer().getWorld(plugin.getConfig().getString(String.join(".", "points", id, "world")));
        int x = plugin.getConfig().getInt(String.join(".", "points", id, "X"));
        int y = plugin.getConfig().getInt(String.join(".", "points", id, "Y"));
        int z = plugin.getConfig().getInt(String.join(".", "points", id, "Z"));
        boolean is_activated = plugin.getConfig().getBoolean(String.join(".", "points", id, "is_activated"));
        String owner = plugin.getConfig().getString(String.join(".", "points", id, "owner"));
        Point point = new Point(id, new Location(world, x, y, z), owner, is_activated);

        return point;
    }

    public static void removePointByID(String id) {
        plugin.getConfig().set(String.join(".", "points", id, "owner"), null);
        plugin.getConfig().set(String.join(".", "points", id, "X"), null);
        plugin.getConfig().set(String.join(".", "points", id, "Y"), null);
        plugin.getConfig().set(String.join(".", "points", id, "Z"), null);
        plugin.getConfig().set(String.join(".", "points", id, "world"), null);
        plugin.getConfig().set(String.join(".", "points", id), null);
        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public static void addPoint(Point point) {
        String id = point.getId();
        String owner = point.getAuthor();
        Integer x = (int) point.getLocation().getX();
        Integer y = (int) point.getLocation().getY();
        Integer z = (int) point.getLocation().getZ();
        String world = point.getLocation().getWorld().getName();
        Boolean is_activated = point.getIs_activated();
        plugin.getConfig().set(String.join(".", "points", id, "owner"), owner);
        plugin.getConfig().set(String.join(".", "points", id, "X"), x);
        plugin.getConfig().set(String.join(".", "points", id, "Y"), y);
        plugin.getConfig().set(String.join(".", "points", id, "Z"), z);
        plugin.getConfig().set(String.join(".", "points", id, "world"), world);
        plugin.getConfig().set(String.join(".", "points", id, "is_activated"), is_activated);
        plugin.saveConfig();
        plugin.reloadConfig();
    }
}
