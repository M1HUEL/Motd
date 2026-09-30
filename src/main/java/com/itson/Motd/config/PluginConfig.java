package com.itson.Motd.config;

import org.bukkit.plugin.java.JavaPlugin;

public final class PluginConfig {

  private final JavaPlugin plugin;
  private String line1;
  private String line2;

  public PluginConfig(JavaPlugin plugin) {
    this.plugin = plugin;
    reload();
  }

  public void reload() {
    plugin.reloadConfig();
    line1 = plugin.getConfig().getString("line-1", "");
    line2 = plugin.getConfig().getString("line-2", "");
  }

  public String getLine1() {
    return line1;
  }

  public String getLine2() {
    return line2;
  }
}
