package carbon;

import java.util.Hashtable;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

import carbon.util.CarbonException;
import carbon.util.CarbonUtil;
import carbon.util.Settings;

/**
 * The entry class to the game.
 * 
 * @author Jonathan Redeker
 */
public final class Carbon {

    private Carbon() {
    }

    /**
     * Start the game.
     * 
     * @param args The arguments of the program.
     * @throws LWJGLException
     * @throws CarbonException
     * 
     * @author Jonathan Redeker
     */
    public static void main(String[] args) throws SlickException, LWJGLException, CarbonException {

        Settings settings = new Settings("settings.json");
        Game game = new Game(settings);
        ScalableGame scaledGame = new ScalableGame(game, 
                                                   settings.getNormalWidth(),
                                                   settings.getNormalHeight(),
                                                   true);
        AppGameContainer carbon = new AppGameContainer(scaledGame);
        Hashtable<String, Integer> displayMode;

        displayMode = CarbonUtil.getDisplayMode(settings.getNormalWidth(),
                                                settings.getNormalHeight(),
                                                settings.fullscreen);

        if (settings.debugMode) {
            displayMode.put("width", 1360);
            displayMode.put("height", 768);
            displayMode.put("fullscreen", 0);
        }

        carbon.setDisplayMode(displayMode.get("width"),
                              displayMode.get("height"),
                              displayMode.get("fullscreen") != 0);
        carbon.setTargetFrameRate(60);
        carbon.setVSync(true);
        carbon.getAlwaysRender();
        carbon.start();

    }

}
