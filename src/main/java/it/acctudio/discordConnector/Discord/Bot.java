package it.acctudio.discordConnector.Discord;

import it.acctudio.discordConnector.DiscordConnector;
import it.acctudio.discordConnector.interaction.SlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.context.annotation.Bean;


public class Bot {

    private JDA jda;
    private DiscordConnector plugin;

    public Bot(SlashCommandHandler slashCommandHandler, DiscordConnector plugin) {
        try {
            JDA jda = JDABuilder.createDefault("TWÓJ_TOKEN")
                    .enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .enableCache(CacheFlag.EMOJI, CacheFlag.VOICE_STATE)
                    .addEventListeners(slashCommandHandler)
                    .build();
            jda.awaitReady();

        } catch (InterruptedException e) {
            throw new RuntimeException("Błąd uruchamiania JDA", e);
        }
    }

    @Bean
    public JDA getBot() {
        return jda;
    }

    public DiscordConnector getPlugin() {
        return plugin;
    }
}
