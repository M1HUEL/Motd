package com.itson.Motd;

import org.bukkit.plugin.java.JavaPlugin;

public final class MotdPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("Motd has been enabled.");
  }

  @Override
  public void onDisable() {
    getLogger().info("Motd has been disabled.");
  }
}
