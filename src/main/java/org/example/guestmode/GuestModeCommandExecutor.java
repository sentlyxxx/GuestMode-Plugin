package org.example.guestmode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuestModeCommandExecutor implements CommandExecutor {
    private final GuestModePlugin plugin;

    public GuestModeCommandExecutor(GuestModePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("guestmode.command")) {
                boolean guestModeEnabled = plugin.getConfig().getBoolean("guest-mode-enabled");
                if (guestModeEnabled) {
                    plugin.getConfig().set("guest-mode-enabled", false);
                    player.sendMessage("Гостевой режим выключен.");
                } else {
                    plugin.getConfig().set("guest-mode-enabled", true);
                    player.sendMessage("Гостевой режим включен.");
                }
                plugin.saveConfig();
            } else {
                player.sendMessage("У вас нет прав для использования этой команды.");
            }
        }
        return true;
    }
}
