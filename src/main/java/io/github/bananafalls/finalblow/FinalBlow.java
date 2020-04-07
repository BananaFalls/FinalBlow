package io.github.bananafalls.finalblow;

import io.github.bananafalls.finalblow.commands.Reload;
import io.github.bananafalls.finalblow.listeners.OnBossKill;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FinalBlow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new OnBossKill(), this);
        this.getCommand("finalblow").setExecutor(new Reload());

        this.saveDefaultConfig();

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "FinalBlow Enabled! Created by BananaFalls.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
