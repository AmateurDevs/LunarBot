package tech.nevets.lunarbot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import tech.nevets.lunarbot.Config;
import tech.nevets.lunarbot.commands.games.CoinCmd;
import tech.nevets.lunarbot.commands.games.DiceCmd;
import tech.nevets.lunarbot.commands.games.PingCmd;
import tech.nevets.lunarbot.commands.wiki.InfoCmd;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManager {
    protected final List<ICommand> commands = new ArrayList<>();

    public CommandManager() {
        addCommand(new CoinCmd());
        addCommand(new DiceCmd());
        addCommand(new PingCmd());
        addCommand(new InfoCmd());
    }

    private void addCommand(ICommand cmd) {
        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));

        if (nameFound) {
            throw new IllegalArgumentException("A command with this name is already present");
        }

        commands.add(cmd);
    }

    @Nullable
    private ICommand getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (ICommand cmd : this.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;
    }

    public void handle(GuildMessageReceivedEvent event) {
        String prefix = Config.getPrefix();

        String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(prefix), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd !=null) {
            event.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(event, args);

            cmd.handle(ctx);
        }
    }
}
