package com.itson.Motd.listener;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.itson.Motd.MotdPlugin;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class ServerListPingListener implements Listener {

  private final MotdPlugin plugin;

  public ServerListPingListener(MotdPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onServerListPing(PaperServerListPingEvent event) {
    String motd = plugin.getMotdConfig().getMotd();
    if (!motd.isBlank()) {
      event.motd(MiniMessage.miniMessage().deserialize(motd));
    }
  }
}
