package com.itson.Motd;

import com.itson.Motd.command.MotdCommand;
import com.itson.Motd.config.MotdConfig;
import com.itson.Motd.listener.ServerListPingListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MotdPlugin extends JavaPlugin {

  private MotdConfig motdConfig;

  @Override
  public void onEnable() {
    saveDefaultConfig();
    motdConfig = new MotdConfig(this);
    getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
    MotdCommand motdCommand = new MotdCommand(this);
    getCommand("motd").setExecutor(motdCommand);
    getCommand("motd").setTabCompleter(motdCommand);
    getLogger().info("Motd v" + getPluginMeta().getVersion() + " enabled.");
  }

  @Override
  public void onDisable() {
    getLogger().info("Motd has been disabled.");
  }

  public MotdConfig getMotdConfig() {
    return motdConfig;
  }
}
