package pl.gr4ss.core.api;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.gr4ss.core.utils.Utils;

public abstract class CommandAPI extends Command {
    private String name;
    private String description;
    private String usage;
    private String permission;
    private List<String> aliases;
    private boolean player;

    public CommandAPI(String name, boolean player, String permission, String description, String usage, String... aliases) {
        super(name, description, usage, Arrays.asList(aliases));
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.permission = permission;
        this.aliases = Arrays.asList(aliases);
        this.player = player;
    }

    public boolean execute(CommandSender sender, String command, String[] args) {
        if (this.isPlayer() && !(sender instanceof Player)) {
            return Utils.sendMessage(sender, "&8>> &cTa komenda ma uzycie tylko w grze!");
        } else {
            return this.getPermission() != null && !sender.hasPermission(this.getPermission()) ? Utils.sendMessage(sender, "&8>> &9Nie masz uprawnien! &f(" + this.getPermission() + ")") : this.exe(sender, command, args);
        }
    }

    public abstract boolean exe(CommandSender var1, String var2, String[] var3);

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUsage() {
        return this.usage;
    }

    public String getPermission() {
        return this.permission;
    }

    public List<String> getAliases() {
        return this.aliases;
    }

    public boolean isPlayer() {
        return this.player;
    }

    public boolean setName(String name) {
        this.name = name;
        return this.player;
    }

    public CommandAPI setDescription(String description) {
        this.description = description;
        return this;
    }

    public CommandAPI setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public CommandAPI setAliases(List<String> aliases) {
        this.aliases = aliases;
        return this;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void register() {
        try {
            if (this.getName() == null) {
                return;
            }

            Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            CommandMap cmap = (CommandMap)f.get(Bukkit.getServer());
            cmap.register(this.getName(), this);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}

