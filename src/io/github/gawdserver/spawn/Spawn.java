package io.github.gawdserver.spawn;

import io.github.gawdserver.api.plugin.Plugin;
import io.github.gawdserver.api.plugin.PluginDir;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Spawn implements Plugin {
    public static final Logger logger = Logger.getLogger("Spawn");
    public static String coords = "0 64 0";

    private void loadConfig(File configFile) {
        BufferedReader br = null;
        try {
            int x = 0;
            int y = 64;
            int z = 0;
            String currentLine;
            br = new BufferedReader(new FileReader(configFile));
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.startsWith("x="))
                    x = Integer.valueOf(currentLine.substring(2));
                if (currentLine.startsWith("y="))
                    y = Integer.valueOf(currentLine.substring(2));
                if (currentLine.startsWith("z="))
                    z = Integer.valueOf(currentLine.substring(2));
            }
            coords = String.format("%d %d %d", x, y, z);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error loading Spawn coordinates.", ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveDefaultConfig(File configFile) {
        configFile.getParentFile().mkdirs();
        try {
            FileWriter fw = new FileWriter(configFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("# Spawn Coordinates");
            bw.newLine();
            bw.write("x=0");
            bw.newLine();
            bw.write("y=64");
            bw.newLine();
            bw.write("z=0");
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error creating default Spawn coordinates.", ex);
        }
    }

    @Override
    public void startup() {
        File configFile = new File(PluginDir.getPluginDir(), "Spawn/spawn.ini");
        if (configFile.exists()) {
            loadConfig(configFile);
        } else {
            saveDefaultConfig(configFile);
        }
    }

    @Override
    public void shutdown() {
    }
}
