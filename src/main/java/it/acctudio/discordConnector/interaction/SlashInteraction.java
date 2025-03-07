package it.acctudio.discordConnector.interaction;

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public interface SlashInteraction {
    void execute(SlashCommandInteractionEvent event);
    String getName();
    void autoComplete(CommandAutoCompleteInteractionEvent event);
    CommandData getCommand();
}
