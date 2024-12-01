package me.example.guestmode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;

public class GuestListener implements Listener {
    private final GuestModePlugin plugin;

    public GuestListener(GuestModePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guestmode.restriction")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            player.setCanPickupItems(false);
            player.setAllowFlight(false);

            TextComponent message = new TextComponent("Пройдите анкету, чтобы зарегистрироваться: ");
            message.setColor(net.md_5.bungee.api.ChatColor.LIGHT_PURPLE);
            TextComponent link = new TextComponent("[Ссылка]");
            link.setColor(net.md_5.bungee.api.ChatColor.WHITE);
            link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://example.com"));

            message.addExtra(link);
            player.spigot().sendMessage(message);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guestmode.restriction")) {
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guestmode.restriction")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guestmode.restriction")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.hasPermission("guestmode.restriction")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (player.hasPermission("guestmode.restriction")) {
                event.setCancelled(true);
            }
        }
    }
}
