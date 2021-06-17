package ru.xapple.zxtraileffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.Messaging;

@CommandDescription("Show spark trail")
@CommandPermissions("zxtraileffects.spark")

public class SparkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equalsIgnoreCase("spark")) {
            Functions.removePlayerEffect(player);
            Functions.addPlayerEffect(player, "spark");
            player.sendMessage(new Messaging.MessageFormatter().format("trails.spark"));
        }
        else {
            player.sendMessage("Use: /trail spark");
        }
        return true;
    }
}
