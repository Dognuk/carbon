package carbon.game;

/**
 * The user's setup does not meet the requirments to run the game.
 * 
 * @author Jonathan Redeker
 */
public class SuboptimalDeviceModeException extends Exception {

    public SuboptimalDeviceModeException() {

        super("The user's device mode does not meet the requirments to run Carbon.");

    }

}