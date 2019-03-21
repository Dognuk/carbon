package carbon.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public final class Menu extends BasicGameState {

    private static Shape circle = null;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        circle = new Rectangle(0, 0, 300, 1900);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        
        g.draw(circle);
        // /g.drawString("testestestesteest", 100, 100);

    }

    @Override
    public int getID() {
        return 0x00;
    }

    
} 