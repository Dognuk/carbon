package carbon;

import java.util.Hashtable;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

/**
 * The entry class to the game.
 * 
 * @author Jonathan Redeker
 */
public final class Carbon {
    
    // TO-DO: Create gamesettings.json and CarbonUtil.loadGameSettings to load them
    private final static String GAME_NAME = "Carbon";
    private final static String GAME_VERSION = "0.1-alpha";
    private final static String GAME_TITLE = GAME_NAME + " " + GAME_VERSION;
    private final static int NORMAL_WIDTH = 1920;
    private final static int NORMAL_HEIGHT = 1080;
    private final static boolean FULLSCREEN = true;

    public static int debug_height = 720;
    public static int debug_width = 1280;

    private Carbon(Game game) {
    }

    /**
     * Start the game
     * 
     * @param args The arguments of the program.
     * @throws LWJGLException
     * @throws CarbonException
     * 
     * @author Jonathan Redeker
     */
    public static void main(String[] args) throws SlickException, LWJGLException, CarbonException {

        Game game = new Game(GAME_TITLE);
        ScalableGame scaledGame = new ScalableGame(game, 
                                                   NORMAL_WIDTH,
                                                   NORMAL_HEIGHT,
                                                   true);
        AppGameContainer carbon = new AppGameContainer(scaledGame);
        Hashtable<String, Integer> displayMode = CarbonUtil.getDisplayMode(NORMAL_HEIGHT,
                                                                         NORMAL_WIDTH,
                                                                         FULLSCREEN);

        carbon.setDisplayMode(debug_width,
                              debug_height,
                              displayMode.get("fullscreen") != 0);
        carbon.setTargetFrameRate(60);
        carbon.setVSync(true);
        carbon.getAlwaysRender();
        carbon.start();

    }

}
