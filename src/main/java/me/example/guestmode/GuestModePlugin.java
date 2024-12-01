package me.example.guestmode;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

public class GuestModePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            getServer().getPluginManager().registerEvents(new GuestListener(this), this);
            getLogger().log(Level.INFO, "Плагин GuestModePlugin успешно активирован.");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Не удалось активировать плагин GuestModePlugin.", e);
        }
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Плагин GuestModePlugin отключен.");
    }
}
