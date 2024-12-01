package me.example.guestmode;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuestModeCommand implements CommandExecutor {
    private final GuestModePlugin plugin;

    public GuestModeCommand(GuestModePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.addAttachment(plugin).setPermission("guestmode.restriction", false);
                    player.sendMessage("Guest mode disabled for " + target.getName());
                    target.sendMessage("Guest mode has been removed.");
                    return true;
                }
            }
        }
        return false;
    }
}
