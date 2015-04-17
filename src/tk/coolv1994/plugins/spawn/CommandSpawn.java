package tk.coolv1994.plugins.spawn;

import tk.coolv1994.gawdapi.Gawd;
import tk.coolv1994.gawdapi.events.Command;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandSpawn implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        Gawd.sendCommand("tp " + player + " " + Spawn.coords);
    }
}
