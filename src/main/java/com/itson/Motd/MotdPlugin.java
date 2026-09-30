package com.itson.Motd;

import com.itson.Motd.config.PluginConfig;
import com.itson.Motd.listener.ServerListPingListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MotdPlugin extends JavaPlugin {

  private PluginConfig pluginConfig;

  @Override
  public void onEnable() {
    saveDefaultConfig();
    pluginConfig = new PluginConfig(this);
    getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
    getLogger().info("Motd has been enabled.");
  }

  @Override
  public void onDisable() {
    getLogger().info("Motd has been disabled.");
  }

  public PluginConfig getPluginConfig() {
    return pluginConfig;
  }
}
