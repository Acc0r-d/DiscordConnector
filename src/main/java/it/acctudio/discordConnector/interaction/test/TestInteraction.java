package it.acctudio.discordConnector.interaction.test;

import it.acctudio.discordConnector.interaction.SlashInteraction;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.springframework.stereotype.Component;

@Component
public class TestInteraction implements SlashInteraction {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage("test");
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public void autoComplete(CommandAutoCompleteInteractionEvent event) {

    }

    @Override
    public CommandData getCommand() {
        return Commands.slash(getName(), "test");
    }
}
