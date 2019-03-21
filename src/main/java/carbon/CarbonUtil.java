package carbon;

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
public final class CarbonUtil {
    
    public CarbonUtil() {

    }

    /**
     * Gets the optimal display mode for the user's setup.
     * 
     * @param NORMAL_WIDTH     The normal width of the game
     * @param NORMAL_HEIGHT    The normal height of the game
     * @param FULLSCREEN       Fullscreen if true
     * 
     * @return Returns the optimal display mode for the user
     * @throws CarbonException
     * 
     * @author Jonathan Redeker
     */
    public final static Hashtable<String, Integer> getDisplayMode(final int NORMAL_WIDTH,
                                                                  final int NORMAL_HEIGHT,
                                                                  final boolean FULLSCREEN)
        throws LWJGLException, CarbonException {

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

        if (bitsPerPixel < 8) {
            throw new CarbonException("The user's display mode does not "
                                     +"meet the requirments to run Carbon.");
        }

        Hashtable<String, Integer> displayMode = new Hashtable<String, Integer>();
        displayMode.put("height", displayModes[biggestMode].getHeight());
        displayMode.put("width", displayModes[biggestMode].getWidth());

        if ((tenth.format(displayMode.get("width") / (double) displayMode.get("height"))
            .equals(tenth.format(NORMAL_WIDTH / (double) NORMAL_HEIGHT)))
            && FULLSCREEN == true) {

            displayMode.put("fullscreen", 1);

        } else {

            displayMode.put("fullscreen", 0);

        }

        return displayMode;

    }

}