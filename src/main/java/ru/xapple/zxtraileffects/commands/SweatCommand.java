package ru.xapple.zxtraileffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.Messaging;

@CommandDescription("Show sweat trail")
@CommandPermissions("zxtraileffects.sweat")

public class SweatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equalsIgnoreCase("sweat")) {
            Functions.removePlayerEffect(player);
            Functions.addPlayerEffect(player, "sweat");
            player.sendMessage(new Messaging.MessageFormatter().format("trails.sweat"));
        }
        else {
            player.sendMessage("Use: /trail sweat");
        }
        return true;
    }
}
