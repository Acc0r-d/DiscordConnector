package it.acctudio.discordConnector;

import it.acctudio.discordConnector.interaction.SlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bot {



    @Bean
    public JDA jda(SlashCommandHandler sch){
        JDA jda = JDABuilder
                .createDefault("MTA3MDc2MDA3Mzc0MTIwNTU4NA.G4PYf9.6HewuV5ScYLSNid81D9sF_YZKiG0k_EFIF-GVQ")
                .enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                .enableCache(CacheFlag.EMOJI, CacheFlag.VOICE_STATE)
                .addEventListeners(sch)
                .build();
        try {
            jda.awaitReady();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return jda;

    }

}
