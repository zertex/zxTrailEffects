package ru.xapple.zxtraileffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.Messaging;

@CommandDescription("Show disco trail")
@CommandPermissions("zxtraileffects.disco")

public class DiscoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equalsIgnoreCase("disco")) {
            Functions.removePlayerEffect(player);
            Functions.addPlayerEffect(player, "disco");
            player.sendMessage(new Messaging.MessageFormatter().format("trails.disco"));
        }
        else {
            player.sendMessage("Use: /trail disco");
        }
        return true;
    }
}
