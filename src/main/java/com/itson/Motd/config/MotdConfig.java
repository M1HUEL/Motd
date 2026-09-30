package com.itson.Motd.config;

import org.bukkit.plugin.java.JavaPlugin;

public final class MotdConfig {

  private final JavaPlugin plugin;
  private String motd;

  public MotdConfig(JavaPlugin plugin) {
    this.plugin = plugin;
    reload();
  }

  public void reload() {
    plugin.reloadConfig();
    motd = plugin.getConfig().getString("motd", "");
  }

  public String getMotd() {
    return motd;
  }
}
