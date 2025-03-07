package it.acctudio.discordConnector;

import it.acctudio.discordConnector.interaction.SlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


public final class DiscordConnector extends JavaPlugin {
    private AnnotationConfigApplicationContext spring;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            spring = new AnnotationConfigApplicationContext();
            spring.scan("it.acctudio.discordConnector");
            spring.refresh();

        }
        catch (Exception e) {
            getLogger().severe("Błąd podczas uruchamiania bota Discord: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
