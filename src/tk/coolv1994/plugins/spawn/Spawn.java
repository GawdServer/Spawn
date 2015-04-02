package tk.coolv1994.plugins.spawn;

import tk.coolv1994.gawdserver.plugin.Plugin;

import java.io.*;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Spawn implements Plugin {
    public static String coords = "0 64 0";

    @Override
    public void startup() {
        File configFile = new File("./plugins/Spawn/coordinates.txt");
        if (!configFile.exists())
        {
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
            } catch (IOException e) {
                System.out.println("Error creating default Spawn coordinates.");
            }
        }
        else
        {
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
            } catch (IOException e) {
                System.out.println("Error loading Spawn coordinates.");
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void shutdown() {
    }
}
