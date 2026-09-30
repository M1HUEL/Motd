package com.itson.Motd.command;

import com.itson.Motd.MotdPlugin;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class MotdCommand implements CommandExecutor {

  private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

  private final MotdPlugin plugin;

  public MotdCommand(MotdPlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    if (args.length != 1 || !args[0].equalsIgnoreCase("reload")) {
      sender.sendMessage(MINI_MESSAGE.deserialize("<red>Usage: /motd reload"));
      return true;
    }
    plugin.getPluginConfig().reload();
    sender.sendMessage(MINI_MESSAGE.deserialize("<green>Motd configuration reloaded."));
    return true;
  }
}
