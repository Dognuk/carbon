package carbon.state;

import org.newdawn.slick.state.BasicGameState;

import carbon.util.Settings;

/**
 * The base of every game state.
 * 
 * @author Jonathan Redeker
 */
abstract class GameState extends BasicGameState {

    protected static Settings settings;

    protected GameState(Settings s) {
        
        settings = s;

    }

}