package carbon.game;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Hashtable;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * A bunch of useful methods for Carbon.
 * 
 * @author Jonathan Redeker
 */
public final class GameUtil {
    
    public GameUtil() {

    }

    /**
     * Gets the optimal display mode for the user's setup.
     * 
     * @param NORMAL_WIDTH     The normal width of the game
     * @param NORMAL_HEIGHT    The normal height of the game
     * @param enableFullscreen Enable or disable fullscreen
     * 
     * @return Returns the optimal display mode for the user
     * @throws SuboptimalDeviceModeException
     * 
     * @author Jonathan Redeker
     */
    public final static Hashtable<String, Integer> getDisplayMode(int NORMAL_WIDTH,
                                                                  int NORMAL_HEIGHT,
                                                                  boolean enableFullscreen)
        throws LWJGLException, SuboptimalDeviceModeException {

        DisplayMode[] displayModes = Display.getAvailableDisplayModes();
        DecimalFormat tenth = new DecimalFormat("#.##");

        int biggestMode = 0;
        int productOfBiggestMode = 0;
        int colourDepth = 1;
        int bitsPerPixel = 0;

        while (colourDepth <= 5) {

            for (DisplayMode displayMode : displayModes) {

                if (displayMode.getWidth() * displayMode.getWidth() > productOfBiggestMode
                    && displayMode.getBitsPerPixel() == Math.pow(2, colourDepth)) {

                    biggestMode = Arrays.asList(displayModes).indexOf(displayMode);
                    productOfBiggestMode = displayMode.getWidth() * displayMode.getWidth();
                    bitsPerPixel = displayMode.getBitsPerPixel();

                }

            }

            colourDepth++;

        }

        if (bitsPerPixel < 8) throw new SuboptimalDeviceModeException();

        Hashtable<String, Integer> displayMode = new Hashtable<String, Integer>();
        displayMode.put("height", displayModes[biggestMode].getHeight());
        displayMode.put("width", displayModes[biggestMode].getWidth());

        if ((tenth.format(displayMode.get("width") / (double) displayMode.get("height"))
            .equals(tenth.format(NORMAL_WIDTH / (double) NORMAL_HEIGHT)))
            && enableFullscreen == true) {

            displayMode.put("fullscreen", 1);

        } else {

            displayMode.put("fullscreen", 0);

        }

        return displayMode;

    }

}