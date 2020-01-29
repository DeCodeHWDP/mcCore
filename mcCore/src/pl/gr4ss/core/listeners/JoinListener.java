package pl.gr4ss.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.gr4ss.core.managers.UserManager;
import pl.gr4ss.core.object.User;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e){
        final Player p = e.getPlayer();
        final User u = UserManager.getUser(p.getName());
        if (u == null) {
            UserManager.createrUser(p.getName());
        }
    }

}
