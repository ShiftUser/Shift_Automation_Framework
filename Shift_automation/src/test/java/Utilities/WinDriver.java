package Utilities;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

public interface WinDriver {

    public static void start() //This function starts your winappdriver
    {
        try
        {
            Desktop desktop = Desktop.getDesktop();

            File file = new File(Constants.winAppDriverPath);

            /* Check if there is support for Desktop or not */
            if(!Desktop.isDesktopSupported())
            {
                System.out.println("not supported");
                return;
            }

            if (file.exists())
            {
                System.out.println("Open WinAppDriver.exe\n");
                desktop.open(file);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Encountered Exception\n");
            throw new RuntimeException(e);
        }
    }

    public static void stop() {//This function stops your winappdriver
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("taskkill ", "/f", "/IM", "WinAppDriver.exe");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}