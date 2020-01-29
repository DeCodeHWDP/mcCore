package pl.gr4ss.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import pl.gr4ss.core.api.CommandAPI;
import pl.gr4ss.core.managers.UserManager;
import pl.gr4ss.core.object.User;
import pl.gr4ss.core.utils.Utils;

public class IncognitoCmd extends CommandAPI {
    public IncognitoCmd() {
        super("incognito", true, "core.cmd.incognito", "", "/incognito", new String());
    }
    @Override
    public boolean exe(final CommandSender sender, final String s, final String[] args) {
        final Player p = (Player) sender;
        final User u = UserManager.getUser(p.getName());
        if(args.length == 1){
             if(args[0].equalsIgnoreCase("on")){
                 if(u.getIncognito() == false){
                     final Scoreboard sc = Bukkit.getScoreboardManager().getNewScoreboard();
                     final Objective o = sc.registerNewObjective("", "");
                     o.setDisplaySlot(DisplaySlot.BELOW_NAME);
                     o.setDisplayName("&k12kj43n53kj15k3");
                     p.setScoreboard(sc);
                     u.setIncognito(true);
                     Utils.sendMessage(p, "&8>> &9Pomyslnie wlaczono &fINCOGNITO");
                 } else {
                     Utils.sendMessage(p, "&8>> &9Masz juz wlaczone &fINCOGNITO");
                     return true;
                 }
             }
            if(args[0].equalsIgnoreCase("off")){
                if(u.getIncognito() == true){
                    final Scoreboard sc = Bukkit.getScoreboardManager().getNewScoreboard();
                    final Objective o = sc.registerNewObjective("", "dummy");
                    o.setDisplaySlot(DisplaySlot.BELOW_NAME);
                    o.setDisplayName("&k12kj43n53kj");
                    p.getScoreboard().clearSlot(DisplaySlot.BELOW_NAME);
                    u.setIncognito(false);
                    Utils.sendMessage(p, "&8>> &9Pomyslnie wylaczono &fINCOGNITO");
                } else {
                    Utils.sendMessage(p, "&8>> &9Masz juz wylaczone &fINCOGNITO");
                    return true;
                }
            }
        } else {
            Utils.sendMessage(p, "&8>> &9Poprawne uzycie &f/incognito <ON/OFF>");
            return true;
        }
        return false;
    }
}
