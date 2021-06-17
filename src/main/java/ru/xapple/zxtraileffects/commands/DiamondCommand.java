package ru.xapple.zxtraileffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.Messaging;

@CommandDescription("Show diamonds trail")
@CommandPermissions("zxtraileffects.diamond")

public class DiamondCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equalsIgnoreCase("diamond")) {
            Functions.removePlayerEffect(player);
            Functions.addPlayerEffect(player, "diamond");
            player.sendMessage(new Messaging.MessageFormatter().format("trails.diamond"));
        }
        else {
            player.sendMessage("Use: /trail diamond");
        }
        return true;
    }
}
