package tk.coolv1994.plugins.spawn;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.launcher.Launch;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandSpawn implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        Launch.sendCommand("tp " + player + " " + Spawn.coords);
    }
}
