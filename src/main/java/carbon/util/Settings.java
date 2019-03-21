package carbon.util;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * This loads the game settings.
 * 
 * @author Jonathan Redeker
 */
public final class Settings {

    private static String gameName;
    private static String gameVersion;
    private static String gameTitle;
    private static int normalWidth;
    private static int normalHeight;

    public boolean fullscreen;
    public boolean debugMode;

    /**
     * Load and parse the settings JSON file. If successful, then intialize Setting's attributes.
     */
    public Settings(String fileName) {

        try {

            Object settingsParsed = new JSONParser().parse(new FileReader(fileName));
            JSONObject settingsJSON = (JSONObject) settingsParsed;

            gameName = (String) settingsJSON.get("game name");
            gameVersion = (String) settingsJSON.get("game version");
            normalWidth = (int)(long) settingsJSON.get("width");
            normalHeight = (int)(long) settingsJSON.get("height");
            this.fullscreen = (boolean) settingsJSON.get("fullscreen");
            this.debugMode = (boolean) settingsJSON.get("debug mode");

            gameTitle = gameName + " " + gameVersion;
        
        } catch (IOException | ParseException e) {

            e.printStackTrace();
        
        }

    }

    /**
     * @return The game's name.
     */
    public String getGameName() {

        return gameName;

    }
    
    /**
     * @return The game's version.
     */
    public String getGameVersion() {

        return gameVersion;

    }

    /**
     * @return The game's window title.
     */
    public String getGameTitle() {

        return gameTitle;

    }

    /**
     * @return The normal width of the game.
     */
    public int getNormalWidth() {

        return normalWidth;

    }

    /**
     * @return The normal height of the game.
     */
    public int getNormalHeight() {

        return normalHeight;

    }

}