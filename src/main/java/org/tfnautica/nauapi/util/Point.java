package org.tfnautica.nauapi.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.tfnautica.nauapi.NauAPI;

public class Point {

    public static JavaPlugin plugin = NauAPI.instance;

    private String id;
    private Location location;
    private String author;
    private Boolean is_activated;

    public Point(String id, Location location, String author, Boolean is_activated) {
        this.id = id;
        this.location = location;
        this.author = author;
        this.is_activated = is_activated;
    }

    public Point() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIs_activated() {
        return is_activated;
    }

    public void setIs_activated(Boolean is_activated) {
        this.is_activated = is_activated;
    }
}

