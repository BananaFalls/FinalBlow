package io.github.bananafalls.finalblow.listeners;

import io.github.bananafalls.finalblow.FinalBlow;
import org.bukkit.Bukkit;
import static org.bukkit.ChatColor.*;

import org.bukkit.Sound;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

import java.text.ParseException;
import java.util.Objects;

public class OnBossKill implements Listener {

    private Plugin plugin = FinalBlow.getPlugin(FinalBlow.class);

    @EventHandler
    public void onBossKill(EntityDeathEvent e){
        Player p = e.getEntity().getKiller(); // TEST IF MOBS KILLED BY OTHER MOBS THROW ERROR

        if(e.getEntity() instanceof EnderDragon){
            DisplayMessage("dragon", p);
        } else if(e.getEntity() instanceof Wither){
            DisplayMessage("wither", p);
        }
    }

    public void DisplayMessage(String boss, Player p){

        String message = plugin.getConfig().getString("death_message");

        if(!message.equalsIgnoreCase("")){
            message = message.replace("%player%", p.getDisplayName());
            if(boss.equalsIgnoreCase("dragon")) {
                message = message.replace("%boss%", Objects.requireNonNull(plugin.getConfig().getString("dragon_name")));
            } else if (boss.equalsIgnoreCase("wither")) {
                message = message.replace("%boss%", Objects.requireNonNull(plugin.getConfig().getString("wither_name")));
            }
            for(Player online : Bukkit.getServer().getOnlinePlayers()){
                online.sendMessage(translateAlternateColorCodes('&', message));
            }
        }





    }

}
