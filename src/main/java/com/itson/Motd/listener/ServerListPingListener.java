package com.itson.Motd.listener;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.itson.Motd.MotdPlugin;
import net.kyori.adventure.text.Component;
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
    MiniMessage miniMessage = MiniMessage.miniMessage();
    Component motd = miniMessage.deserialize(plugin.getPluginConfig().getLine1());
    String line2 = plugin.getPluginConfig().getLine2();
    if (!line2.isBlank()) {
      motd = motd.appendNewline().append(miniMessage.deserialize(line2));
    }
    event.motd(motd);
  }
}
