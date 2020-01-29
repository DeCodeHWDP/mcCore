package pl.gr4ss.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.gr4ss.core.cmds.IncognitoCmd;
import pl.gr4ss.core.listeners.JoinListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        cmds();
        listeners();
    }
    private void listeners() {
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
    }
    private void cmds() {
        new IncognitoCmd().register();
    }
}
