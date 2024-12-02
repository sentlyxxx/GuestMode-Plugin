package org.example.guestmode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class GuestModeListener implements Listener {
    private final GuestModePlugin plugin;

    public GuestModeListener(GuestModePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();

        if (!config.contains("players." + player.getUniqueId())) {
            config.set("players." + player.getUniqueId() + ".guest-mode", true);
            player.sendMessage("§5Чтобы получить доступ к серверу, нужно пройти анкету: §nhttp://example.com/anketa");
        } else {
            boolean guestModeEnabled = config.getBoolean("players." + player.getUniqueId() + ".guest-mode");
            if (guestModeEnabled) {
                player.sendMessage("§5Чтобы получить доступ к серверу, нужно пройти анкету: §nhttp://example.com/anketa");
            }
        }

        plugin.saveConfig();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("players." + player.getUniqueId() + ".guest-mode")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("players." + player.getUniqueId() + ".guest-mode")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDamageEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            FileConfiguration config = plugin.getConfig();

            if (config.getBoolean("players." + player.getUniqueId() + ".guest-mode")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("players." + player.getUniqueId() + ".guest-mode")) {
            event.setCancelled(true);
            player.sendMessage("§5Чтобы получить доступ к серверу, нужно пройти анкету: §nhttp://example.com/anketa");
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("players." + player.getUniqueId() + ".guest-mode")) {
        }
    }
}
