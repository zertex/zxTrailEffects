package ru.xapple.zxtraileffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.Messaging;

@CommandDescription("Show fire2 trail")
@CommandPermissions("zxtraileffects.fire2")

public class Fire2Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equalsIgnoreCase("fire2")) {
            Functions.removePlayerEffect(player);
            Functions.addPlayerEffect(player, "fire2");
            player.sendMessage(new Messaging.MessageFormatter().format("trails.fire2"));
        }
        else {
            player.sendMessage("Use: /trail fire2");
        }
        return true;
    }
}
