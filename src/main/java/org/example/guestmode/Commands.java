package org.example.guestmode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{
    private final GuestModePlugin plugin;

    public Commands(GuestModePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && args.length == 1) {
            Player target = plugin.getServer().getPlayer(args[0]);
            if (target != null) {
                plugin.disableGuestMode(target);
                sender.sendMessage("Гостевой режим снят с игрока " + target.getName());
                return true;
            }
        }

        return false;
    }
}
