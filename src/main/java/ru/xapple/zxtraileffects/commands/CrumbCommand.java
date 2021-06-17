package ru.xapple.zxtraileffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.Messaging;

@CommandDescription("Show crumb trail")
@CommandPermissions("zxtraileffects.crumb")

public class CrumbCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equalsIgnoreCase("crumb")) {
            Functions.removePlayerEffect(player);
            Functions.addPlayerEffect(player, "crumb");
            player.sendMessage(new Messaging.MessageFormatter().format("trails.crumb"));
        }
        else {
            player.sendMessage("Use: /trail crumb");
        }
        return true;
    }
}
