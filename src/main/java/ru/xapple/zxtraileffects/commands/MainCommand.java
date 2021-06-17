package ru.xapple.zxtraileffects.commands;

import com.google.common.collect.Maps;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.lib.Messaging;

import java.util.Map;

/**
 * Created by Egorka on 09.10.2015.
 */
public class MainCommand implements CommandExecutor {

    private Map<String, CommandExecutor> subCommandMap = Maps.newHashMap();

    public MainCommand() {
        subCommandMap.put("cloud", new CloudsCommand());
        subCommandMap.put("smoke", new SmokeCommand());
        subCommandMap.put("smoke2", new Smoke2Command());
        subCommandMap.put("fire", new FireCommand());
        subCommandMap.put("fire2", new Fire2Command());
        subCommandMap.put("ender", new EnderCommand());
        subCommandMap.put("heart", new HeartsCommand());
        subCommandMap.put("diamond", new DiamondCommand());
        subCommandMap.put("star", new StarCommand());
        subCommandMap.put("flower", new FlowerCommand());
        subCommandMap.put("disco", new DiscoCommand());
        subCommandMap.put("blood", new BloodCommand());
        subCommandMap.put("crit", new CritCommand());
        subCommandMap.put("magma", new MagmaCommand());
        subCommandMap.put("letter", new LettersCommand());
        subCommandMap.put("happy", new HappyCommand());
        subCommandMap.put("anger", new AngerCommand());
        subCommandMap.put("music", new MusicCommand());
        subCommandMap.put("magic", new MagicCommand());
        subCommandMap.put("sweat", new SweatCommand());
        subCommandMap.put("spark", new SparkCommand());
        subCommandMap.put("crumb", new CrumbCommand());
        subCommandMap.put("off", new OffCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(new Messaging.MessageFormatter().format("error.player-only"));
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            //printHelp(player, label);
            return true;
        }

        String subCommandName = args[0].toLowerCase();
        if (!subCommandMap.containsKey(subCommandName)) {
            //printHelp(player, label);
            return true;
        }

        CommandExecutor subCommand = subCommandMap.get(subCommandName);
        if (!hasPermission(player, subCommand)) {
            player.sendMessage(new Messaging.MessageFormatter().format("error.insufficient-permissions"));
            return true;
        }

        return subCommand.onCommand(sender, command, label, args);

    }

    private boolean hasPermission(Player bukkitPlayer, CommandExecutor cmd) {
        CommandPermissions permissions = cmd.getClass().getAnnotation(CommandPermissions.class);
        if (permissions == null) {
            return true;
        }

        for (String permission : permissions.value()) {
            if (bukkitPlayer.hasPermission(permission)) {
                return true;
            }
        }

        return false;
    }



    }
