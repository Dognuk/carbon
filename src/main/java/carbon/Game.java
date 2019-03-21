package carbon;

import carbon.state.*;
import carbon.util.Settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

    public static Settings settings;

    public Game(Settings s) {

        super(s.getGameTitle());
        settings = s;

    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {

        this.addState(new Test(settings));

    }

}