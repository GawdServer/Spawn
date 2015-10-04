package io.github.gawdserver.spawn;

import io.github.gawdserver.api.Server;
import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandSpawn implements Command {
    @Override
    public void playerCommand(String player, String[] args) {
        Server.sendCommand(String.format("tp %s %s", player, Spawn.coords));
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        if (args.length == 0) {
            Chat.sendMessage(Sender.CONSOLE.name(), "Use: !spawn <player>");
            return;
        }
        Server.sendCommand(String.format("tp %s %s", args[0], Spawn.coords));
    }
}
