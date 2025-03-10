package it.acctudio.discordConnector.interaction;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Component
public class SlashCommandHandler extends ListenerAdapter {
    private final Map<String, SlashInteraction> interactionMap = new TreeMap<>();

    public SlashCommandHandler(Set<SlashInteraction> slashInteractions) {
        slashInteractions.forEach(mi -> {interactionMap.put(mi.getName(), mi);});
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        SlashInteraction slashInteraction = interactionMap.get(event.getName());

        if (slashInteraction != null) {
            slashInteraction.execute(event);
        }
    }

    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        SlashInteraction slashInteraction = interactionMap.get(event.getName());

        if (slashInteraction != null) {
            slashInteraction.autoComplete(event);
        }
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        interactionMap.forEach((k, i) -> event.getGuild().upsertCommand(i.getCommand()).queue());
    }
}
