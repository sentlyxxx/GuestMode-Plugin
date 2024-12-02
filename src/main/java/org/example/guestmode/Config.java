package org.example.guestmode;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private final FileConfiguration config;

    public Config(GuestModePlugin plugin) {
        this.config = plugin.getConfig();
    }

    public boolean isGuestModeEnabled() {
        return config.getBoolean("guest-mode-enabled", true);
    }
}
