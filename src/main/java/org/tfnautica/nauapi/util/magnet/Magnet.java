package org.tfnautica.nauapi.util.magnet;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.tfnautica.nauapi.NauAPI;

public class Magnet {

    public static JavaPlugin plugin = NauAPI.instance;

    private final double ACCELERATION = 0.1;

    private Location location;
    private Integer radius;


    public Magnet(Location loc, Integer rad) {
        this.location = loc;
        this.radius = rad;
    }

    public Magnet() {}

    public Location getLocation() {
        return this.location;
    }
    public void setLocation(Location loc) {
        this.location = loc;
    }
    public Integer getRadius() {
        return this.radius;
    }
    public void setRadius(Integer rad) {
        this.radius = rad;
    }

    public void startMagnetting() {
        Bukkit.getScheduler().runTaskTimer(plugin, new BukkitRunnable() {
            @Override
            public void run() {
                attractEntities(new Location(Bukkit.getWorld("world"), 0, 64, 0));
            }
        }, 0L, 20L);
    }

    private void attractEntities(Location targetLocation) {
        for (Entity entity : targetLocation.getWorld().getEntities()) {
            if (entity instanceof LivingEntity && entity.getLocation().distance(targetLocation) < 50) {
                Vector direction = targetLocation.toVector().subtract(entity.getLocation().toVector()).normalize();
                ((LivingEntity) entity).setVelocity(((LivingEntity) entity).getVelocity().add(direction.multiply(ACCELERATION)));
            }
        }
    }

}
