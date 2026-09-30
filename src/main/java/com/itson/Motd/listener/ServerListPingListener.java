package com.itson.Motd.listener;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.itson.Motd.MotdPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class ServerListPingListener implements Listener {

  private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.legacyAmpersand();

  private final MotdPlugin plugin;

  public ServerListPingListener(MotdPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onServerListPing(PaperServerListPingEvent event) {
    Component motd = LEGACY.deserialize(plugin.getPluginConfig().getLine1());
    String line2 = plugin.getPluginConfig().getLine2();
    if (!line2.isBlank()) {
      motd = motd.appendNewline().append(LEGACY.deserialize(line2));
    }
    event.motd(motd);
  }
}
