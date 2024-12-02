package org.example.guestmode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GuestModePlugin extends JavaPlugin{
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new GuestModeListener(this), this);
        getCommand("guestmode").setExecutor(new GuestModeCommandExecutor(this));
    }

    public void enableGuestMode(Player player) {
        player.setGameMode(GameMode.SURVIVAL);
        player.setInvulnerable(true);
        player.setCanPickupItems(false);
        player.setAllowFlight(true);
        player.setFlying(true);
        player.setHealth(20);
        player.setFoodLevel(20);
    }

    public void disableGuestMode(Player player) {
        player.setInvulnerable(false);
        player.setCanPickupItems(true);
        player.setAllowFlight(false);
        player.setFlying(false);
    }
}
